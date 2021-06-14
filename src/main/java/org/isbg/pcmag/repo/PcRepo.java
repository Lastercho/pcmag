package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PcRepo extends JpaRepository<Pc, Long> {
    Optional<Pc> findPcById(Long id);

    void deletePcById(Long id);
}
