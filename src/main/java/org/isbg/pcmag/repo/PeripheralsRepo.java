package org.isbg.pcmag.repo;


import org.isbg.pcmag.model.Peripheral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeripheralsRepo extends JpaRepository<Peripheral, Long> {

    Optional<Peripheral> findPeripheralById(Long id);

    void deletePeripheralById(Long id);
}
