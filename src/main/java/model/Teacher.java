package model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacherId")
    private int teacherId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "teacherRank")
    private int teacherRank;

    @Column(name = "teacherSalary")
    private double teacherSalary;

    @Column(name = "subjectTaught")
    private String subjectTaught;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, int teacherRank, double teacherSalary, String subjectTeached) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherRank = teacherRank;
        this.teacherSalary = teacherSalary;
        this.subjectTaught = subjectTeached;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(int teacherRank) {
        this.teacherRank = teacherRank;
    }

    public double getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(double teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId);
    }
}
