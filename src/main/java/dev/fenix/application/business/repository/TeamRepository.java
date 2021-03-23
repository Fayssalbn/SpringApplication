package dev.fenix.application.business.repository;


import dev.fenix.application.business.module.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamRepository extends PagingAndSortingRepository<Team,Long> {
    Team getTeamById(Team id);
    Team save(Team team);
    void delete(Team team);
}

