package co.com.poli.tallerpds.service;

import co.com.poli.tallerpds.persistence.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    ProjectTask create(ProjectTask projectTask);

    List<ProjectTask> findByProjectIdentifier(String projectIdetifier);

    double findByProjectIdentifierHours(String projectIdetifier);

    double findByProjectIdentifierHoursDeleted(String projectIdetifier, String status);

    ProjectTask deleteIdAndProjectIdentifier(Long idTask, String projectIdetifier);

}
