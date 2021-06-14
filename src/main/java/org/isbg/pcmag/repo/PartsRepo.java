package org.isbg.pcmag.repo;

import org.isbg.pcmag.model.Part;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartsRepo extends JpaRepository<Part, Long>{//, ElasticsearchRepository<Part, Long> {

    Optional<Part> findPartById(Long id);

    void deletePartById(Long id);


}
