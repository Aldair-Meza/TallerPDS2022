package co.com.poli.tallerpds.service;

import co.com.poli.tallerpds.persistence.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project create(Project project);
}
