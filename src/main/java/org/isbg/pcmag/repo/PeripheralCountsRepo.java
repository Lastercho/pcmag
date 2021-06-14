package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.PartCount;
import org.isbg.pcmag.model.PeripheralCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeripheralCountsRepo extends JpaRepository<PeripheralCount, Long> {
    List<PeripheralCount> findAllByPeripheralId(Long id);

    void deleteByPeripheralId(Long id);
}
