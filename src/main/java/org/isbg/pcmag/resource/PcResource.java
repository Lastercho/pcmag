package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.Pc;
import org.isbg.pcmag.service.PcService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/pcs")
public class PcResource {
    private final PcService pcService;



    public PcResource(PcService pcService) {
        this.pcService = pcService;
    }



    @GetMapping()
    public ResponseEntity<List<Pc>> getPcs (@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "5") Integer pageSize,
                                                           @RequestParam(defaultValue = "id") String sortBy) {
        List<Pc> pc = pcService.allPcByPageAndSort(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(pc, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Pc>> getAllPc (){
        List<Pc> pcs = pcService.allPcs();
        return new ResponseEntity<>(pcs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pc> getPcById (@PathVariable("id") Long id){
        Pc pc = pcService.findPcById(id);
        return new ResponseEntity<>(pc, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pc> addPc (@RequestBody Pc pc){
        pcService.addPc(pc);
        return new ResponseEntity<>(pc, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pc> updatePc (@RequestBody Pc pc){
        pcService.updatePc(pc);
        return new ResponseEntity<>(pc, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePc (@PathVariable("id") Long id){
        pcService.deletePc(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
