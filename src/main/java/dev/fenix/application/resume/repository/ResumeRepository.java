package dev.fenix.application.resume.repository;

import dev.fenix.application.resume.model.Resume;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResumeRepository extends PagingAndSortingRepository<Resume,Long> {
    Resume getIconById(Long id);
    Resume getIconByName(String title);
    Resume save(Resume b);
    void delete(Resume b);
}
