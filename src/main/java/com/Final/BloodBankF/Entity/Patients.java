package com.Final.BloodBankF.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="patient")
public class Patients {

//    @JsonIgnoreProperties("patientS")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    //here the owner side contain the @joincolumn
    //here the  not-owner side contain the @joincolumn
    @JoinTable(name = "Composit_DonorPatient", //here the new join table name is (Composit_DP) , (?????)
            joinColumns = {@JoinColumn(name = "pc_id", referencedColumnName = "patient_id")},
            inverseJoinColumns = {@JoinColumn(name = "dc_id", referencedColumnName = "donor_id")})
    private Set<Donor> DonorS = new HashSet<>();

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Patient_Id;


    @Column(name = "first_name")
//    @JsonProperty("firstName")
    public String First_Name;

    @Column(name = "last_name")
//    @JsonProperty("lastName")
    public String Last_Name;

    @Column(name = "phone")

    public int Phone;

    @Column(name = "age")
    public String Age;


    @Column(name = "gender")
    public String Gender;

    @Column(name = "name_hospital")
//    @JsonProperty("nameHospital")
    public String  Name_Hospital;

    @Column(name = "blood_type")
//    @JsonProperty("bloodType")
    public String Blood_Type;

    @Column(name = "first_date")
//    @JsonProperty("firstDate")
    public String First_Date;

    @Column(name = "last_date")
//    @JsonProperty("lastDate")
    public String Last_Date;

    public Patients( String first_Name, String last_Name, int phone, String age, String gender, String name_Hospital, String blood_Type, String first_Date, String last_Date) {

        First_Name = first_Name;
        Last_Name = last_Name;
        Phone = phone;
        Age = age;
        Gender = gender;
        Name_Hospital = name_Hospital;
        Blood_Type = blood_Type;
        First_Date = first_Date;
        Last_Date = last_Date;

    }

    public Patients() {
    }


//@JsonIgnore
    public Set<Donor> getDonorS() {
        return DonorS;
    }

    public void setDonorS(Set<Donor> donorS) {
        DonorS = donorS;
    }

    public int getPatient_Id() {
        return Patient_Id;
    }

    public void setPatient_Id(int patient_Id) {
        Patient_Id = patient_Id;
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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName_Hospital() {
        return Name_Hospital;
    }

    public void setName_Hospital(String name_Hospital) {
        Name_Hospital = name_Hospital;
    }

    public String getBlood_Type() {
        return Blood_Type;
    }

    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }

    public String getFirst_Date() {
        return First_Date;
    }

    public void setFirst_Date(String first_Date) {
        First_Date = first_Date;
    }

    public String getLast_Date() {
        return Last_Date;
    }

    public void setLast_Date(String last_Date) {
        Last_Date = last_Date;
    }


    @Override
    public String toString() {
        return "Patients {" +
                ", Patient_Id=" + Patient_Id +
                ", First_Name= " + First_Name+ '\'' +
                ", Last_Name= " + Last_Name + '\'' +
                ", Phone= " + Phone +
                ", Age= " + Age + '\'' +
                ", Gender= " + Gender + '\'' +
                ", Name_Hospital= " + Name_Hospital + '\'' +
                ", Blood_Type= " + Blood_Type + '\'' +
                ", First_Date= " + First_Date + '\'' +
                ", Last_Date= " + Last_Date+ '\'' +
               "PatientS:- "+  DonorS.toString() +

                '}';
    }
}
