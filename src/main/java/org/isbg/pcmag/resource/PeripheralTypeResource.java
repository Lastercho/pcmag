package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.PartType;
import org.isbg.pcmag.model.PeripheralType;
import org.isbg.pcmag.service.PartTypeService;
import org.isbg.pcmag.service.PeripheralTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/peripherals/types")
public class PeripheralTypeResource {
    private final PeripheralTypeService peripheralTypeService;

    public PeripheralTypeResource(PeripheralTypeService peripheralTypeService) {
        this.peripheralTypeService = peripheralTypeService;}

        @GetMapping
        public ResponseEntity<List<PeripheralType>> getAllPeripheralType (){
            List<PeripheralType> peripheralType = peripheralTypeService.allPeripheralType();
            return new ResponseEntity<>(peripheralType, HttpStatus.OK);
        }
    @PostMapping
    public ResponseEntity<PeripheralType> addPeripheralType (@RequestBody PeripheralType peripheralType){
        peripheralTypeService.addPeripheralType(peripheralType);
        return new ResponseEntity<>(peripheralType, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<PeripheralType> updatePeripheralType (@RequestBody PeripheralType peripheralType){
        peripheralTypeService.updatePeripheralType(peripheralType);
        return new ResponseEntity<>(peripheralType, HttpStatus.CREATED);
    }
    }

