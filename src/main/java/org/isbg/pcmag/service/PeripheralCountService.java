package org.isbg.pcmag.service;


import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.model.PeripheralCount;
import org.isbg.pcmag.repo.PeripheralCountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeripheralCountService {
    private final PeripheralCountsRepo peripheralCountsRepo;

    @Autowired
    public PeripheralCountService(PeripheralCountsRepo peripheralCountsRepo) {
        this.peripheralCountsRepo = peripheralCountsRepo;
    }

    public List<PeripheralCount> allPeripheralCounts() {return peripheralCountsRepo.findAll();}

    public List<PeripheralCount> AllPeripheralsCountsByPeripheralId(Long id){return  peripheralCountsRepo.findAllByPeripheralId(id);}

    public PeripheralCount addPeripheralCount (PeripheralCount peripheralCount){
        return peripheralCountsRepo.save(peripheralCount);
    }

    public PeripheralCount updatePeripheralCount(PeripheralCount peripheralCount){
        return peripheralCountsRepo.save(peripheralCount);
    }

    public void deletePeripheralCount(Long id){
        peripheralCountsRepo.deleteById(id);
    }
}


