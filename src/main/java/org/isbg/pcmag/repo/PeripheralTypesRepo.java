package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.PartType;
import org.isbg.pcmag.model.PeripheralType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeripheralTypesRepo extends JpaRepository<PeripheralType, Long> {
}
