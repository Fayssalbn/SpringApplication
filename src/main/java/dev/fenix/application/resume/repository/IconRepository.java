package dev.fenix.application.resume.repository;

import dev.fenix.application.resume.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository<Icon,Long> {
    Icon getIconById(Long id);
    Icon getIconByName(String title);
    Icon save(Icon b);
    void delete(Icon b);
}
