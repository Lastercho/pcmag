package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.Part;
import org.isbg.pcmag.model.PartSingleCount;
import org.isbg.pcmag.service.PartService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/parts")
public class PartResource {
    private final PartService partService;

    public PartResource(PartService partService) {
        this.partService = partService;
    }


    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRANIEE','ROLE_USER')")
    public ResponseEntity<List<PartSingleCount>> getParts (@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "id") String sortBy) {
        List<PartSingleCount> parts = partService.allPartsOneCountByPageAndSort(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(parts, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRANIEE')")
    public ResponseEntity<List<Part>> getAllParts (){
        List<Part> parts = partService.allParts();
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRANIEE')")
    public ResponseEntity<Part> getPartById (@PathVariable("id") Long id){
        Part part = partService.findPartById(id);
        return new ResponseEntity<>(part, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Part> addPart (@RequestBody Part part){
        partService.addPart(part);
        return new ResponseEntity<>(part, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Part> updatePart (@RequestBody Part part){
        partService.updatePart(part);
        return new ResponseEntity<>(part, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> deletePart (@PathVariable("id") Long id){
        partService.deletePart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
