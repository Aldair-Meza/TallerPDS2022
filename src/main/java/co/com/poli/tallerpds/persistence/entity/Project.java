package co.com.poli.tallerpds.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @NotNull
    @Column (name = "project_name", unique = true)
    @NotBlank(message = "El campo no debe estar en blanco")
    private String projectName;
    @NotNull
    @NotBlank(message = "El campo no debe estar e blanco")
    @Size(min = 5, max = 7, message = "El Campo debe tener minimo 5 caracteres maximo 7")
    @Column (name = "project_identifier", unique = true, updatable = false )
    private String projectIdentifier;
    @NotBlank(message = "El campo no debe estar e blanco")
    @Column (name = "description")
    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column (name = "start_date")
    private Date startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column (name = "end_date")
    private Date endDate;

    @JsonManagedReference
    @OneToOne(mappedBy = "project", cascade = CascadeType.PERSIST)
    @JoinColumn (name = "backlog")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id) && projectName.equals(project.projectName) && projectIdentifier.equals(project.projectIdentifier) && description.equals(project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
