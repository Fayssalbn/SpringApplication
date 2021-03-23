package dev.fenix.application.business.repository;

import dev.fenix.application.business.module.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface JobRepository extends PagingAndSortingRepository<Job,Long> {
    Job getJobById(Long id);
    Job save(Job job);
    void delete(Job job);
}

