package org.isbg.pcmag.service;

import org.isbg.pcmag.model.PartType;
import org.isbg.pcmag.model.PeripheralType;
import org.isbg.pcmag.repo.PartTypesRepo;
import org.isbg.pcmag.repo.PeripheralTypesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeripheralTypeService {
    private final PeripheralTypesRepo peripheralTypeRepo;

    @Autowired
    public PeripheralTypeService(PeripheralTypesRepo peripheralTypesRepo) {
        this.peripheralTypeRepo = peripheralTypesRepo;
    }

    public List<PeripheralType> allPeripheralType() {return peripheralTypeRepo.findAll();}

    public PeripheralType addPeripheralType (PeripheralType peripheralType){
        return peripheralTypeRepo.save(peripheralType);
    }

    public PeripheralType updatePeripheralType(PeripheralType peripheralType){
        return peripheralTypeRepo.save(peripheralType);
    }

    public void deletePeripheralType(Long id){
        peripheralTypeRepo.deleteById(id);
    }
}


