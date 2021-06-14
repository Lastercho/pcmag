package org.isbg.pcmag.service;

import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.model.PartType;
import org.isbg.pcmag.repo.PartCountsRepo;
import org.isbg.pcmag.repo.PartTypesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartTypeService {
    private final PartTypesRepo partTypeRepo;

    @Autowired
    public PartTypeService(PartTypesRepo partTypesRepo) {
        this.partTypeRepo = partTypesRepo;
    }

    public List<PartType> allPartTypes() {return partTypeRepo.findAll();}

    public PartType addPartType (PartType partType){
        return partTypeRepo.save(partType);
    }

    public PartType updatePartType(PartType partType){
        return partTypeRepo.save(partType);
    }

    public void deletePartType(Long id){
        partTypeRepo.deleteById(id);
    }
}


