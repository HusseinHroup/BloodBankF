package com.Final.BloodBankF.Interfaces;



import com.Final.BloodBankF.Entity.Patients;

import java.util.List;

public interface PatientInter{


    //For Save Object Patient in DataBase


    //For Retirve  single Patient by id

    // Patient ReteirvePatientById(int id );
    //    Patient RetPatientByName(String name);


    // 1) //For retirve all Patient
    /*------------------------------------*/

    //For Retirve  single Donor by id
    //  Donors ReterveDonById(int id );
    // Donors RetDonorsByName(String name);


    Patients saveP(Patients thePatient);

    /////////////Delete by id /////////////
    public void  DeleteByid(int id);

    /*------------------------------------*/
    // 1) //For retirve all Donors
    List<Patients> findall();

    Patients findbyid(int id);

    List<Patients> find_byfirst_name(String name);

    List<Patients> findbylast_namePatients(String name);

    List<Patients> findbyage(int age);

    List<Patients> findbyphone(int phone);

    List<Patients> findbyBloodType(String BloodType);

    List<Patients> findbyGender(String Gender);

   // List<Patient> findbyemail(String email);

    List<Patients> Find_By_Name_Hos(String Hospital);

    List<Patients> Find_By_FirstDate(String Date1);

    List<Patients> Find_By_LastDate(String Date2);


}