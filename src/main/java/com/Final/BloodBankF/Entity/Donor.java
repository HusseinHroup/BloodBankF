package com.Final.BloodBankF.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name ="donors")
public class Donor {

//    @JsonIgnoreProperties("DonorS")
    @ManyToMany(mappedBy = "DonorS", fetch = FetchType.LAZY) //SharedDonor (defined the  table Patient is the Owner through set<>(name))
    private Set<Patients> PatientS = new HashSet<>();

    @Id
    @Column(name = "donor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Donor_Id;
    @Column(name = "first_name")
//    @JsonProperty("firstName")
    public String First_Name;
    @Column(name = "last_name")
//    @JsonProperty("lastName")
    public String Last_Name;
    @Column(name = "phone")
    public int Phone ;
    @Column(name = "age")
    public int  Age;
    @Column(name = "username")
    public String Username;

    @Column(name="gender")
    public String Gender;
    @Column(name="blood_type")
//    @JsonProperty("blood_type")
    public String Blood_Type;

    @Column(name = "passwordd")
    public String password;



    @Column(name = "counter")
    private Integer counter= 0 ;


    public Donor() {
    }
    public Donor(String First_Name, String Last_Name, int Phone, int Age, String username, String Gender, String Blood_Type ,int counter , String password ) {
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Phone = Phone;
        this.Age = Age;
        this.Username = username;
        this.Gender = Gender;
        this.Blood_Type = Blood_Type;
        this.password=password;
        this.counter=counter;
    }
    @JsonIgnore
    public Set<Patients> getPatientS() {
        return PatientS;
    }
    public void setPatientS(Set<Patients> patientS) {
        PatientS = patientS;
    }
    public int getDonor_id() {
        return Donor_Id;
    }
    public void setDonor_id(int donor_id) {
        this.Donor_Id = donor_id;
    }
    public String getFirst_Name() {
        return First_Name;
    }
    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }
    public String getLast_Name() {
        return Last_Name;
    }
    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }
    public int getPhone() {
        return Phone;
    }
    public void setPhone(int phone) {
        Phone = phone;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public String getBlood_Type() {
        return Blood_Type;
    }
    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCounter() {
        return counter == null ? 0 : counter.intValue();
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }


    @Override
    public String toString() {
        return "Donor{" +
                "donor_id=" + Donor_Id +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Phone=" + Phone +
                ", Age=" + Age +
                ", user name='" + Username + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Blood_Type='" + Blood_Type + '\'' +
                "PatientS"+PatientS.toString()+
                '}';
    }

}

