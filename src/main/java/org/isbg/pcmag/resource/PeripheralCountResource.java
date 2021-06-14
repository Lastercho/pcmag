package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.model.PeripheralCount;
import org.isbg.pcmag.service.PartCountService;
import org.isbg.pcmag.service.PeripheralCountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/peripherals/counts")
public class PeripheralCountResource {
    private final PeripheralCountService peripheralCountService;

    public PeripheralCountResource(PeripheralCountService peripheralCountService) {
        this.peripheralCountService = peripheralCountService;}

        @GetMapping
        public ResponseEntity<List<PeripheralCount>> getAllPeripheralCounts (){
            List<PeripheralCount> peripheralCount = peripheralCountService.allPeripheralCounts();
            return new ResponseEntity<>(peripheralCount, HttpStatus.OK);
        }
    @GetMapping("/{id}")
    public ResponseEntity<List<PeripheralCount>> getAllPeripheralCountsByPeripheralId(@PathVariable("id") Long id) {
        List<PeripheralCount> peripheralCountsByPeripheralId = peripheralCountService.AllPeripheralsCountsByPeripheralId(id);
        return new ResponseEntity<>(peripheralCountsByPeripheralId, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PeripheralCount> addPeripheralCount (@RequestBody PeripheralCount peripheralCount){
        peripheralCountService.addPeripheralCount(peripheralCount);
        return new ResponseEntity<>(peripheralCount, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<PeripheralCount> updatePeripheralCount (@RequestBody PeripheralCount peripheralCount){
        peripheralCountService.updatePeripheralCount(peripheralCount);
        return new ResponseEntity<>(peripheralCount, HttpStatus.CREATED);
    }
    }

