package co.com.poli.tallerpds.service.impl;

import co.com.poli.tallerpds.persistence.entity.Backlog;
import co.com.poli.tallerpds.persistence.repository.BacklogRepository;
import co.com.poli.tallerpds.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacklogServicesImpl implements BacklogService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Override
    public Backlog create(Backlog backlog){
        return backlogRepository.save(backlog);
    }
}
