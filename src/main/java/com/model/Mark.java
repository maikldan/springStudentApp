package com.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Time;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Mark {

    private Long markId;
    @NotNull
    @DecimalMin("1.0")
    @DecimalMax("10.0")
    @Column(name = "mark")
    private Double value;
    private Time createdate;
    private Double calculatescholarship;
    private Discipline discipline;
    private Profesor profesor;
    private Student student;

    @Id
    @GeneratedValue
    @Column(name = "mark_id", nullable = false, insertable = false, updatable = false)
    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    @Basic
    @Column(name = "mark", nullable = true, precision = 0)
    public Double getValue() {
        return value;
    }

    public void setValue(Double mark) {
        this.value = mark;
    }

    @Basic
    @Column(name = "createdate", nullable = true)
    public Time getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Time createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "calculatescholarship", nullable = true, precision = 0)
    public Double getCalculatescholarship() {
        return calculatescholarship;
    }

    public void setCalculatescholarship(Double calculatescholarship) {
        this.calculatescholarship = calculatescholarship;
    }

    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id", nullable = false)
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @ManyToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "id", nullable = false)
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
