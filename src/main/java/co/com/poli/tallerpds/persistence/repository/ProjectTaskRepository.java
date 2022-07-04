package co.com.poli.tallerpds.persistence.repository;

import co.com.poli.tallerpds.persistence.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {
}
