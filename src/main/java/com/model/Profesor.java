package com.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Profesor extends Person{
    private Double salary;
    private Collection<Discipline> disciplinesByProfesorId;
    private Collection<Mark> marksByProfesorId;


    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @OneToMany(mappedBy = "profesor")
    public Collection<Discipline> getDisciplinesByProfesorId() {
        return disciplinesByProfesorId;
    }

    public void setDisciplinesByProfesorId(Collection<Discipline> disciplinesByProfesorId) {
        this.disciplinesByProfesorId = disciplinesByProfesorId;
    }

    @OneToMany(mappedBy = "profesor")
    public Collection<Mark> getMarksByProfesorId() {
        return marksByProfesorId;
    }

    public void setMarksByProfesorId(Collection<Mark> marksByProfesorId) {
        this.marksByProfesorId = marksByProfesorId;
    }

}
