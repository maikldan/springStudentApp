//package com.model;
//
//import javax.persistence.*;
//
///**
// * Created by Student on 2/22/2017.
// */
//@Entity
//@Table(name = "avg_semester", schema = "public", catalog = "mariusdb")
//public class AvgSemester {
//    private Integer studentId;
//    private Double avg;
//
//    @Id
//    @Column(name = "id", nullable = true, insertable = false, updatable = false)
//    public Integer getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
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
