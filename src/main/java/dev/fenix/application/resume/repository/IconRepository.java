package dev.fenix.application.resume.repository;

import dev.fenix.application.resume.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository<Icon,Integer> {
    Icon getIconById(Integer id);
    Icon getIconByTitle(String title);
    Icon saveIcon(Icon b);
    void deleteIcon(Icon b);
}
