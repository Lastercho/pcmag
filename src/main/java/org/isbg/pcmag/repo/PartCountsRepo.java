package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.PartCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartCountsRepo extends JpaRepository<PartCount, Long> {
    List<PartCount> findAllByPartId(Long id);

    void deleteByPartId(Long id);
}
