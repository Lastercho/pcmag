package org.isbg.pcmag.resource;

import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.service.PartCountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PcMagazine/api/parts/counts")
public class PartCountResource {
    private final PartCountService partCountService;

    public PartCountResource(PartCountService partCountService) {
        this.partCountService = partCountService;
    }

    @GetMapping
    public ResponseEntity<List<PartCount>> getAllPartCounts() {
        List<PartCount> partCounts = partCountService.allPartCounts();
        return new ResponseEntity<>(partCounts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<PartCount>> getAllPartCountsByPartId(@PathVariable("id") Long id) {
        List<PartCount> partCountsByPartId = partCountService.AllPartsCountsByPartId(id);
        return new ResponseEntity<>(partCountsByPartId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PartCount> addPartCount(@RequestBody PartCount partCount) {
        partCountService.addPartCount(partCount);
        return new ResponseEntity<>(partCount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PartCount> updatePartCount(@RequestBody PartCount partCount) {
        partCountService.updatePartCount(partCount);
        return new ResponseEntity<>(partCount, HttpStatus.CREATED);
    }
}

