package dev.fenix.application.person.repository;
import dev.fenix.application.person.module.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamRepository extends PagingAndSortingRepository<Team,Long> {
    Team getTeamById(Long id);
    Team save(Team task);
    void delete(Team task);
}

