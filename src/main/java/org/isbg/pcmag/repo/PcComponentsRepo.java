package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.PcComponents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcComponentsRepo extends JpaRepository<PcComponents, Long> {
}
