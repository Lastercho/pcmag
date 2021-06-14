package org.isbg.pcmag.service;

import org.isbg.pcmag.model.PcComponents;
import org.isbg.pcmag.repo.PcComponentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcComponentsService {

    private final PcComponentsRepo pcComponentsRepo;



    @Autowired
    public PcComponentsService(PcComponentsRepo pcComponentsRepo) {
        this.pcComponentsRepo = pcComponentsRepo;
    }


    public PcComponents addPcComponents(PcComponents pcComponents) {
        return pcComponentsRepo.save(pcComponents);
    }

    public List<PcComponents> allPcComponentsByPageAndSort(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<PcComponents> pagedResult = pcComponentsRepo.findAll(paging);
//        for (PcComponents pcComponents: pagedResult
//        ) {
//            pcComponents.setComponentCount (pcComponents.getPcComponents().stream().count());
//            List<BigDecimal> prices = new ArrayList<>();
//            for (PcComponents comp: pc.getPcComponents()
//            ) {
//                if (comp.getPeripheral() == null){
//                    prices.add(comp.getPart().getPartCounts().stream().findFirst().get().getPricePerUnit());
//                }
//                else{
//                    prices.add(comp.getPeripheral().getPeripheralCount().stream().findFirst().get().getPricePerUnit());
//                }
//            }
//            pc.setPrice(prices.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
//
//        }
        return pagedResult.toList();
    }
    public List<PcComponents> allPcComponents() {
        return pcComponentsRepo.findAll();
    }

    public PcComponents updatePcComponents(PcComponents pcComponents) {
        return pcComponentsRepo.save(pcComponents);
    }

    public void deletePcComponents(Long id) {
    }
}
