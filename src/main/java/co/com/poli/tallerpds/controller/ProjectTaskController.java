package co.com.poli.tallerpds.controller;

import co.com.poli.tallerpds.helper.ResponsesBuilder;
import co.com.poli.tallerpds.model.Response;
import co.com.poli.tallerpds.persistence.entity.ProjectTask;
import co.com.poli.tallerpds.service.impl.ProjectTaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class ProjectTaskController {

    @Autowired
    private ProjectTaskImpl projecttaskService;

    @Autowired
    private ResponsesBuilder builder;

    @PostMapping
    private Response create(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        projecttaskService.create(projectTask);
        return builder.success(projectTask);
    }

    @GetMapping("/project/{projectIdentifier}")
    private Response findByProjectdentifier(@PathVariable("projectIdentifier") String projectIdentifier) {
        List<ProjectTask> projectTasks = projecttaskService.findByProjectIdentifier(projectIdentifier);
        return builder.successFind(projectTasks);
    }

    @GetMapping("/hours/project/{projectIdentifier}")
    private Response findByProjectIdentifierHours(@PathVariable("projectIdentifier") String projectIdentifier){
        double projectTask = projecttaskService.findByProjectIdentifierHours(projectIdentifier);
        return builder.successFind(projectTask);
    }
    @GetMapping("/hours/project{projectIdentifier}/{status}")
    private Response findByProjectIdentifierHoursDeleted(@PathVariable("projectIdentifier")String pojectIdentifier, @PathVariable("status") String status){
        double projectTask = projecttaskService.findByProjectIdentifierHoursDeleted(pojectIdentifier, status);
        return builder.successFind(projectTask);
    }

    @DeleteMapping("/{idTask}/{projectIdentifier}")
    public Response deleteTask(@PathVariable("idTask") Long idTask, @PathVariable("projectIdentifier") String projectIdentifier){
        return builder.successFind(projecttaskService.deleteIdAndProjectIdentifier(idTask, projectIdentifier));
    }

    private List<Map<String, String>> formatMessage(BindingResult result){
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}



