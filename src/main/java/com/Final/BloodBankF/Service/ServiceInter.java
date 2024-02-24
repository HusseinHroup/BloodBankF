package com.Final.BloodBankF.Service;

//import com.Project.BloodBank3.ProjectUniversity.Blood.Bank.Entity.donorspatient;

import com.Final.BloodBankF.Entity.Donor;
import com.Final.BloodBankF.Entity.Patients;
import com.Final.BloodBankF.Login.loginDTO;
import com.Final.BloodBankF.Response.LoginResponse;

import java.util.List;

public interface ServiceInter {

    public LoginResponse saveLoginPK(loginDTO donorDTO);

    public Donor login(Donor theDonor);
    Patients saveP(Patients thePatient);

    public void DeleteByid(int id);

    /*------------------------------------*/
    List<Donor> findall();
    Donor findbyid(int id);
    List<Donor> find_byfirst_name(String name);
    List<Donor> findbylast_name(String name);
    List<Donor> findbyage(int age);
    List<Donor> findbyphone(int phone);
    List<Donor> findbyBloodType(String BloodType);
    List<Donor> findbyGender(String Gender);
    List<Donor> findbyemail(String email);


    ///////////////////THIS METHOD FOR PATIENT /////////////////////////

    void  DeleteByidPatient(int id);
    /*------------------------------------*/
    // 1) //For retirve all Donors
    List<Patients> findallPatients();

    Patients findbyidPatient(int id);

    List<Patients> find_byfirst_namePatients(String name1);

    List<Patients> findbylast_namePatients(String name);

    List<Patients> findbyagePatients(int age);

    List<Patients> findbyphonePatients(int phone);

    List<Patients> findbyBloodTypePatients(String BloodType);

    List<Patients> findbyGenderPatients(String Gender);

    List<Patients> Find_By_Name_Hos(String Hospital);

    List<Patients> Find_By_FirstDate(String Date1);

    List<Patients> Find_By_LastDate(String Date2);



/////////////////CompositEntityPatient////////////////////////////
//    public List<Patient> saveDonorDataCom(List<Patient> patientsnew) ;
//
////    public void saveDonorComNew(Donors DonCom);

//    public Patient savePatientComNew(Patient PatCom);
    public Patients assignDonorToPatientPut(int Patient_id, int Donor_id);
//
//      public List<Patient> getPatientDetails(int P_id );
////
//       public Patient getPatientDetailsNew(int id) ;
//
//       void DeleteCompositPatient(int empid);
//
//      Patients assignDonorToPatientPost(int patientId, int donorId);
//
//

    public Patients removeDonorFromPatient(int patientId, int donorId);

//    loginMessage loginDonor(loginDTO logDon);******

////////Composit Entity DONOR///////////////////





    //


}
