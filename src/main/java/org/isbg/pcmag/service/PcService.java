package org.isbg.pcmag.service;

import org.isbg.pcmag.exception.UseNotFoundException;
import org.isbg.pcmag.model.Pc;
import org.isbg.pcmag.model.PcComponents;
import org.isbg.pcmag.repo.PcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PcService {

    private final PcRepo pcRepo;



    @Autowired
    public PcService(PcRepo pcRepo) {
        this.pcRepo = pcRepo;
    }


    public Pc addPc(Pc pc) {
        return pcRepo.save(pc);
    }

    public List<Pc> allPcByPageAndSort(Integer pageNo, Integer pageSize, String sortBy) {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

            Page<Pc> pagedResult = pcRepo.findAll(paging);
        for (Pc pc: pagedResult
             ) {
            pc.setComponentCount (pc.getPcComponents().stream().count());
            List<BigDecimal> prices = new ArrayList<>();
            for (PcComponents comp: pc.getPcComponents()
                 ) {
                if (comp.getPeripheral() == null){
                    prices.add(comp.getPart().getPartCounts().stream().findFirst().get().getPricePerUnit());
                }
                else{
                    prices.add(comp.getPeripheral().getPeripheralCount().stream().findFirst().get().getPricePerUnit());
                }
            }
            pc.setPrice(prices.stream().reduce(BigDecimal.ZERO, BigDecimal::add));

        }
            return pagedResult.toList();
    }
    public List<Pc> allPcs() {
        return pcRepo.findAll();
    }

    public Pc updatePc(Pc pc) {
        return pcRepo.save(pc);
    }



    public Pc findPcById(Long id) {
        return pcRepo.findPcById(id).orElseThrow(() -> new UseNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePc(Long id) {


        pcRepo.deletePcById(id);
    }
}
