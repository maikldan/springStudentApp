package com.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Student on 2/22/2017.
 */
@Entity
public class Student extends Person{
    private Double calculatescholarship;
    private Boolean deleteStatus;
    private Collection<DisciplineAverage> disciplineAverages;
    private Collection<Mark> marks;
    private Groupp groupp;


    @SuppressWarnings({"JpaAttributeMemberSignatureInspection", "JpaAttributeTypeInspection"})
    @Transient
    public Map<String, Double> getDisciplineAverageMark() {
        HashMap<String, Double> map = new HashMap<>();
        for (Mark mark : marks) {
            String title = mark.getDiscipline().getName();
            map.putIfAbsent(title, marks.stream().filter(mark1 -> mark1.getDiscipline().getName().equals(title))
                    .mapToDouble(Mark::getValue).average().orElse(0.0));
        }
        return map;
    }

    @Basic
    @Column(name = "calculatescholarship", nullable = true, precision = 0)
    public Double getCalculatescholarship() {
        return calculatescholarship;
    }

    public void setCalculatescholarship(Double calculatescholarship) {
        this.calculatescholarship = calculatescholarship;
    }

    @Basic
    @Column(name = "delete_status", nullable = true)
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    @OneToMany(mappedBy = "student")
    public Collection<DisciplineAverage> getDisciplineAverages() {
        return disciplineAverages;
    }

    public void setDisciplineAverages(Collection<DisciplineAverage> disciplineAverages) {
        this.disciplineAverages = disciplineAverages;
    }

    @OneToMany(mappedBy = "student")
    public Collection<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Mark> marks) {
        this.marks = marks;
    }


    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    public Groupp getGroupp() {
        return groupp;
    }

    public void setGroupp(Groupp groupp) {
        this.groupp = groupp;
    }
}
