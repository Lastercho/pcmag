package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.PartType;
import org.isbg.pcmag.service.PartTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/parts/types")
public class PartTypeResource {
    private final PartTypeService partTypeService;

    public PartTypeResource(PartTypeService partTypeService) {
        this.partTypeService = partTypeService;}

        @GetMapping
        public ResponseEntity<List<PartType>> getAllPartTypes (){
            List<PartType> partsTypes = partTypeService.allPartTypes();
            return new ResponseEntity<>(partsTypes, HttpStatus.OK);
        }
    @PostMapping
    public ResponseEntity<PartType> addPartType (@RequestBody PartType partType){
        partTypeService.addPartType(partType);
        return new ResponseEntity<>(partType, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<PartType> updatePartType (@RequestBody PartType partType){
        partTypeService.updatePartType(partType);
        return new ResponseEntity<>(partType, HttpStatus.CREATED);
    }
    }

