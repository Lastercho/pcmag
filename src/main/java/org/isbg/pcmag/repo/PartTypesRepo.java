package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.Part;
import org.isbg.pcmag.model.PartType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartTypesRepo extends JpaRepository<PartType, Long> {
}
