package org.isbg.pcmag.service;

import org.isbg.pcmag.exception.UseNotFoundException;
import org.isbg.pcmag.model.Part;
import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.model.PartSingleCount;
import org.isbg.pcmag.repo.PartsRepo;
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
public class PartService {
    private final PartsRepo partsRepo;



    @Autowired
    public PartService(PartsRepo partsRepo) {
        this.partsRepo = partsRepo;
    }


    public Part addPart(Part part) {
        // new PartCountService(PartCountsRepo)
        return partsRepo.save(part);
    }

    public List<Part> allParts() {
        return partsRepo.findAll();
    }

    public Part updatePart(Part part) {
        return partsRepo.save(part);
    }



    public Part findPartById(Long id) {
        return partsRepo.findPartById(id).orElseThrow(() -> new UseNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePart(Long id) {


        partsRepo.deletePartById(id);
    }

    public List<PartSingleCount> allPartsOneCountByPageAndSort(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Part> pagedResult = partsRepo.findAll(paging);

        List<PartSingleCount> partsListCut = new ArrayList<>();

        for (Part part : pagedResult
        ) {
            List<PartCount> partCounts = new ArrayList<>();
            PartCount partCount = new PartCount();
            LocalDateTime a = LocalDateTime.MAX;
            for (PartCount count : part.getPartCounts()
            ) {
                if (
                        count.getCreatedAt().isBefore(a)
                                &&
                                count.getCount() > 0

                ) {
                    a = count.getCreatedAt();
                    partCount = count;
                }

            }
            PartSingleCount partSingleCount = new PartSingleCount();
            partSingleCount.setId(part.getId());
            partSingleCount.setName(part.getName());
            partSingleCount.setPartType(part.getPartType());
            partSingleCount.setPartCounts(partCount);
            partSingleCount.setCreatedAt(part.getCreatedAt());
            partSingleCount.setUpdatedAt(part.getUpdatedAt());
            partsListCut.add(partSingleCount);


        }
        return  partsListCut;


    }
    public List<PartSingleCount> allPartsOneCountMultipleIdByPageAndSort(Iterable<Long> ids, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize);



        List<Part> pagedResult = partsRepo.findAllById(ids);

        List<PartSingleCount> partsListCut = new ArrayList<>();

        for (Part part : pagedResult
        ) {
            List<PartCount> partCounts = new ArrayList<>();
            PartCount partCount = new PartCount();
            LocalDateTime a = LocalDateTime.MAX;
            for (PartCount count : part.getPartCounts()
            ) {
                if (
                        count.getCreatedAt().isBefore(a)
                                &&
                                count.getCount() > 0

                ) {
                    a = count.getCreatedAt();
                    partCount = count;
                }

            }
            PartSingleCount partSingleCount = new PartSingleCount();
            partSingleCount.setId(part.getId());
            partSingleCount.setName(part.getName());
            partSingleCount.setPartType(part.getPartType());
            partSingleCount.setPartCounts(partCount);
            partSingleCount.setCreatedAt(part.getCreatedAt());
            partSingleCount.setUpdatedAt(part.getUpdatedAt());
            partsListCut.add(partSingleCount);


        }
        return  partsListCut;


    }
}
