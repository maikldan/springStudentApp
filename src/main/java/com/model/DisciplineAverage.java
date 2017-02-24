package com.model;

import javax.persistence.*;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
@Table(name = "discipline_average", schema = "public", catalog = "mariusdb")
public class DisciplineAverage {
    private Long disciplineavgId;
    private Double averageMark;
    private Discipline discipline;
    private Student student;

    @Id
    @Column(name = "disciplineavg_id", nullable = false, insertable = false, updatable = false)
    public Long getDisciplineavgId() {
        return disciplineavgId;
    }

    public void setDisciplineavgId(Long disciplineavgId) {
        this.disciplineavgId = disciplineavgId;
    }

    @Basic
    @Column(name = "average_mark", nullable = true, precision = 0)
    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
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
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
