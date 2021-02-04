package dev.fenix.application.resume.repository;

import dev.fenix.application.resume.model.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologieRepository extends JpaRepository<Technologie,Long> {
    Technologie getIconById(Long id);
    Technologie getIconByName(String title);
    Technologie save(Technologie b);
    void delete(Technologie b);
}
