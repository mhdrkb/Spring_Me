package com.mhd.studentinfo.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stu")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1 , max = 50, message = "between 2 to 50 characters")
    private String name;

    @NotNull
    @Column(name = "Email", unique = true, length = 50)
    @Email(message = "Enter a valid Email")
    private String email;

    @NotNull
    @Column(name = "Mobile", unique = true, length = 11)
    private String phone;

    @NotNull
    @Min(value = 20, message = "age must be at least 20")
    private byte age;


    private String gender;
    private String[] courseCompleted;
    private String round;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date lastMOdifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;


    public Student() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }



    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getLastMOdifiedDate() {
        return lastMOdifiedDate;
    }

    public void setLastMOdifiedDate(Date lastMOdifiedDate) {
        this.lastMOdifiedDate = lastMOdifiedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Long fileSize;
    private String fileName;
    private  String filePath;
    private String fileExtesion;

    public Student(@NotNull @Size(min = 1, max = 50, message = "between 2 to 50 characters") String name, @NotNull @Email(message = "Enter a valid Email") String email, @NotNull String phone, @NotNull @Min(value = 20, message = "age must be at least 20") byte age, String gender, String[] courseCompleted, String round, Date regiDate, Date lastMOdifiedDate, Date birthDate, Long fileSize, String fileName, String filePath, String fileExtesion) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.courseCompleted = courseCompleted;
        this.round = round;
        this.regiDate = regiDate;
        this.lastMOdifiedDate = lastMOdifiedDate;
        this.birthDate = birthDate;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtesion = fileExtesion;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtesion() {
        return fileExtesion;
    }

    public void setFileExtesion(String fileExtesion) {
        this.fileExtesion = fileExtesion;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", courseCompleted=" + Arrays.toString(courseCompleted) +
                ", round='" + round + '\'' +
                ", regiDate=" + regiDate +
                ", lastMOdifiedDate=" + lastMOdifiedDate +
                ", birthDate=" + birthDate +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtesion='" + fileExtesion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(gender, student.gender) &&
                Arrays.equals(courseCompleted, student.courseCompleted) &&
                Objects.equals(round, student.round) &&
                Objects.equals(regiDate, student.regiDate) &&
                Objects.equals(lastMOdifiedDate, student.lastMOdifiedDate) &&
                Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(fileSize, student.fileSize) &&
                Objects.equals(fileName, student.fileName) &&
                Objects.equals(filePath, student.filePath) &&
                Objects.equals(fileExtesion, student.fileExtesion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, email, phone, age, gender, round, regiDate, lastMOdifiedDate, birthDate, fileSize, fileName, filePath, fileExtesion);
        result = 31 * result + Arrays.hashCode(courseCompleted);
        return result;
    }

    //in many to many relation we need a 3rd party table

    @ManyToMany(fetch = FetchType.EAGER) //many to many relation ofcourse between table to table not with coulmn
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles; //set used so that it can not be duplicate

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
