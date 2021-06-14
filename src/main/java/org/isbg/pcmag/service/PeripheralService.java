package org.isbg.pcmag.service;

import org.isbg.pcmag.exception.UseNotFoundException;
import org.isbg.pcmag.model.*;
import org.isbg.pcmag.repo.PeripheralsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeripheralService {
    private final PeripheralsRepo peripheralsRepo;




    @Autowired
    public PeripheralService(PeripheralsRepo peripheralsRepo) {
        this.peripheralsRepo = peripheralsRepo;
    }

    public Peripheral addPeripheral(Peripheral peripheral){
       return peripheralsRepo.save(peripheral);
    }

    public List<Peripheral> allPeripherals(){
        return peripheralsRepo.findAll();
    }
    public Peripheral updatePeripheral(Peripheral peripheral){
        return peripheralsRepo.save(peripheral);
    }

    public Peripheral findPeripheralById(Long id){
        return peripheralsRepo.findPeripheralById(id).orElseThrow(() -> new UseNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePeripheral(Long id){
        peripheralsRepo.deletePeripheralById(id);
    }


    public List<PeripheralSingleCount> allPeripheralsByPageAndSort(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Peripheral> pagedResult = peripheralsRepo.findAll(paging);

        List<PeripheralSingleCount> peripheralsListCut = new ArrayList<>();

        for (Peripheral peripheral : pagedResult
        ) {
            List<PeripheralCount> peripheralCounts = new ArrayList<>();
            PeripheralCount peripheralCount = new PeripheralCount();
            LocalDateTime a = LocalDateTime.MAX;
            for (PeripheralCount count : peripheral.getPeripheralCount()
            ) {
                if (
                        count.getCreatedAt().isBefore(a)
                                &&
                                count.getCount() > 0

                ) {
                    a = count.getCreatedAt();
                    peripheralCount = count;
                }

            }
            PeripheralSingleCount peripheralSingleCount = new PeripheralSingleCount();
            peripheralSingleCount.setId(peripheral.getId());
            peripheralSingleCount.setName(peripheral.getName());
            peripheralSingleCount.setPeripheralType(peripheral.getPeripheralType());
            peripheralSingleCount.setPeripheralCounts(peripheralCount);
            peripheralSingleCount.setCreatedAt(peripheral.getCreatedAt());
            peripheralSingleCount.setUpdatedAt(peripheral.getUpdatedAt());
            peripheralsListCut.add(peripheralSingleCount);


        }
        return  peripheralsListCut;
    }
}
