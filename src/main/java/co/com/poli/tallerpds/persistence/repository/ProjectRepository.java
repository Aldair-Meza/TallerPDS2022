package co.com.poli.tallerpds.persistence.repository;

import co.com.poli.tallerpds.persistence.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
