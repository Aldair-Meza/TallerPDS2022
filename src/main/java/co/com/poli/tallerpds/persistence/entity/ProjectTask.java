package co.com.poli.tallerpds.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table (name = "project_tasks")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El campo no puede estar en blanco")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "El campo no puede estar en blanco")
    @Column(name = "summary")
    private String summary;

    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;


    @Column(name = "status")
    private String status;


    @Column(name = "priority")
    @Range(min = 1, max = 5, message = "El campo acepta una prioridad entre 1 y 5")
    private int priority;

    @Range(min = 1,max = 8, message = "El campo acepta un rango de 1 a 8")
    @Min(value = 0L, message = "El valor debe ser positivo")
    @Column(name = "hours")
    private Double hours;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "start_date")
    private Date startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "project_identifier", updatable = false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return id.equals(that.id) && name.equals(that.name) && summary.equals(that.summary) && projectIdentifier.equals(that.projectIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, summary);
    }
}
