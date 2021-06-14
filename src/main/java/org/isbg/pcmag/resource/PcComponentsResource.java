package org.isbg.pcmag.resource;


import org.isbg.pcmag.model.PcComponents;
import org.isbg.pcmag.service.PcComponentsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/PcMagazine/api/pcs/components")
public class PcComponentsResource {

    private final PcComponentsService pcComponentsService;



    public PcComponentsResource(PcComponentsService pcComponentsService) {
        this.pcComponentsService = pcComponentsService;
    }



    @GetMapping()
    public ResponseEntity<List<PcComponents>> getPcComponents (@RequestParam(defaultValue = "0") Integer pageNo,
                                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                                               @RequestParam(defaultValue = "id") String sortBy) {
        List<PcComponents> pcComponents = pcComponentsService.allPcComponentsByPageAndSort(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(pcComponents, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PcComponents>> getAllPcComponents (){
        List<PcComponents> pcs = pcComponentsService.allPcComponents();
        return new ResponseEntity<>(pcs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PcComponents> addPc (@RequestBody PcComponents pcComponents){
        pcComponentsService.addPcComponents(pcComponents);
        return new ResponseEntity<>(pcComponents, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PcComponents> updatePc (@RequestBody PcComponents pcComponents){
        pcComponentsService.updatePcComponents(pcComponents);
        return new ResponseEntity<>(pcComponents, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePcComponents (@PathVariable("id") Long id){
        pcComponentsService.deletePcComponents(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
