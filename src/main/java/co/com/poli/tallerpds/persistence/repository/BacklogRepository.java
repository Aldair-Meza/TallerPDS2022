package co.com.poli.tallerpds.persistence.repository;

import co.com.poli.tallerpds.persistence.entity.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {
}
