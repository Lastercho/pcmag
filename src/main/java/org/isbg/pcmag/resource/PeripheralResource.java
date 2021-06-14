package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.Part;
import org.isbg.pcmag.model.PartSingleCount;
import org.isbg.pcmag.model.Peripheral;
import org.isbg.pcmag.model.PeripheralSingleCount;
import org.isbg.pcmag.service.PartService;
import org.isbg.pcmag.service.PeripheralService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/peripherals")
public class PeripheralResource {
    private final PeripheralService peripheralService;



    public PeripheralResource(PeripheralService peripheralService) {
        this.peripheralService = peripheralService;
    }


    @GetMapping
    public ResponseEntity<List<PeripheralSingleCount>> getPeripherals (@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "id") String sortBy) {
        List<PeripheralSingleCount> peripherals = peripheralService.allPeripheralsByPageAndSort(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(peripherals, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Peripheral>> getAllPeripherals (){
        List<Peripheral> peripherals = peripheralService.allPeripherals();
        return new ResponseEntity<>(peripherals, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Peripheral> getPeripheralById (@PathVariable("id") Long id){
        Peripheral peripheral = peripheralService.findPeripheralById(id);
        return new ResponseEntity<>(peripheral, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Peripheral> addPeripheral (@RequestBody Peripheral peripheral){
        peripheralService.addPeripheral(peripheral);
        return new ResponseEntity<>(peripheral, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Peripheral> updatePeripheral (@RequestBody Peripheral peripheral){
        peripheralService.updatePeripheral(peripheral);
        return new ResponseEntity<>(peripheral, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePeripheral (@PathVariable("id") Long id){
        peripheralService.deletePeripheral(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
