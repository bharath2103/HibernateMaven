package dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedNativeQuery(name = "StudentRegistry.nativeByRollNo", query = "Select * from STUDENT_REGISTRY where ROLL_NO = ?",
resultClass = StudentRegistry.class)
@Table(name = "STUDENT_REGISTRY")
public class StudentRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLL_NO")
    private Integer rollNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DOB")
    private String DOB;

    @Column(name = "GENDER")
    private String gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tamil", column = @Column(name = "TAMIL")),
            @AttributeOverride(name = "english", column = @Column(name = "ENGLISH")),
            @AttributeOverride(name = "mathematics", column = @Column(name = "MATHS")),
            @AttributeOverride(name = "science", column = @Column(name = "SCIENCE")),
            @AttributeOverride(name = "socialScience", column = @Column(name = "SOCIAL")),
    })
    private StudentMarks studentMarks;

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StudentMarks getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(StudentMarks studentMarks) {
        this.studentMarks = studentMarks;
    }
}
