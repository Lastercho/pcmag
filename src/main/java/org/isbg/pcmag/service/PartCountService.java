package org.isbg.pcmag.service;

import org.isbg.pcmag.exception.UseNotFoundException;
import org.isbg.pcmag.model.Part;
import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.model.PartType;
import org.isbg.pcmag.repo.PartCountsRepo;
import org.isbg.pcmag.repo.PartTypesRepo;
import org.isbg.pcmag.repo.PartsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartCountService {
    private final PartCountsRepo partCountsRepo;

    @Autowired
    public PartCountService(PartCountsRepo partCountsRepo) {
        this.partCountsRepo = partCountsRepo;
    }


    public List<PartCount> allPartCounts() {return partCountsRepo.findAll();}

    public List<PartCount> AllPartsCountsByPartId(Long id){return  partCountsRepo.findAllByPartId(id);}

    public PartCount addPartCount (PartCount partCount){
        return partCountsRepo.save(partCount);
    }

    public PartCount updatePartCount(PartCount partCount){
        return partCountsRepo.save(partCount);
    }

    public  void deletePartCountByPartId(Long id){
        partCountsRepo.deleteByPartId(id);
    }
}


