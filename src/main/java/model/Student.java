package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private int studentId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "totalTax")
    private double totalTax;

    @Column(name = "paidTax")
    private double paidTax;

    @Column(name = "remainingTax")
    private double remainingTax = totalTax - paidTax;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, double totalTax, double paidTax) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.totalTax = totalTax;
        this.paidTax = paidTax;
    }

    public int getStudentId() {
        return studentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getPaidTax() {
        return paidTax;
    }

    public void setPaidTax(double paidTax) {
        this.paidTax = paidTax;
    }

    public double getRemainingTax() {
        return remainingTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
