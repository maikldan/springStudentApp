//package com.model;
//
//
//import javax.persistence.*;
//
///**
// * Created by Student on 2/22/2017.
// */
//@Entity
//@Table(name = "average_mark", schema = "public", catalog = "mariusdb")
//public class AverageMark {
//    private Long studentId;
//    private String firstname;
//    private String lasttname;
//    private String name;
//    private Double avg;
//
//    @Id
//    @Column(name = "id", nullable = true, insertable = false, updatable = false)
//    public Long getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Long studentId) {
//        this.studentId = studentId;
//    }
//
//    @Basic
//    @Column(name = "firstname", nullable = true, length = 34)
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    @Basic
//    @Column(name = "lasttname", nullable = true, length = 34)
//    public String getLasttname() {
//        return lasttname;
//    }
//
//    public void setLasttname(String lasttname) {
//        this.lasttname = lasttname;
//    }
//
//    @Basic
//    @Column(name = "name", nullable = true, length = -1)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "avg", nullable = true, precision = 0)
//    public Double getAvg() {
//        return avg;
//    }
//
//    public void setAvg(Double avg) {
//        this.avg = avg;
//    }
//
//}
