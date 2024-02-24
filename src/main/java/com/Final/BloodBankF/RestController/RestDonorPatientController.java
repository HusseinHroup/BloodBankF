package com.Final.BloodBankF.RestController;

import com.Final.BloodBankF.Entity.Donor;
import com.Final.BloodBankF.Entity.Patients;
import com.Final.BloodBankF.Login.loginDTO;
import com.Final.BloodBankF.Login.loginMessage;
import com.Final.BloodBankF.Response.LoginResponse;
import com.Final.BloodBankF.Service.ServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestDonorPatientController {

    private ServiceInter ServiceBase;


    @Autowired
    public RestDonorPatientController(ServiceInter don) {
        ServiceBase = don;
    }

    //for save more one Patient in same time



    //------------------ADD,UPDATE MAPPING -------------------//


//    add Donors
  @PostMapping("/Donors")
    public Donor add(@RequestBody Donor DonSa){
        return    ServiceBase.login(DonSa);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginDonor(@RequestBody loginDTO logDon){
        LoginResponse loginResponse = ServiceBase.saveLoginPK(logDon);
        return  ResponseEntity.ok(loginResponse);
    }


    //Add Patient
   @PostMapping("/Patients")
    public Patients addP(@RequestBody Patients PA){
       return   ServiceBase.saveP(PA);
    }

    @PutMapping("/Donors")
    public Donor PutDonor(@RequestBody Donor DonUP){
        Donor NEW= ServiceBase.login(DonUP);
        return NEW;
    }

    @PutMapping("/Patients")
    public Patients PutPatient(@RequestBody Patients PatientUP){
        Patients  Pa=  ServiceBase.saveP(PatientUP);
    return  Pa;
    }


    //------------------Deleting MAPPING -------------------//

    @DeleteMapping("/Donors/Delete/{Delete_id}")
    public void remove(@PathVariable int Delete_id){
        ServiceBase.DeleteByid(Delete_id);
    }


    @DeleteMapping("/Patients/Delete/{Delete_id}")
    public void removePatient(@PathVariable int Delete_id){
         ServiceBase.DeleteByidPatient(Delete_id);
    }

    //------------------GETMAPPING -------------------//

    //firstly we will save the object
    @GetMapping("/Donors/all")
    public List<Donor> findall(){
        return ServiceBase.findall();
    }
    // GetMapping for all Patient
    @GetMapping("/Patients/all")
    public List<Patients> findallPatient(){
        return ServiceBase.findallPatients();
    }

//the problem is be must the variable for Donor_id==@path_variable(Donor_id)
    @GetMapping("/Donors/id/{Donor_id}")
    public Donor Find_By_Id_Donors(@PathVariable int Donor_id ){
        Donor em= ServiceBase.findbyid(Donor_id);
      if(em==null){
          throw new RuntimeException("Donors is not found "+Donor_id);
      }
      return em;
    }

    //findbyid for patient
    @GetMapping("/Patients/id/{Patient_id}")
    public Patients Find_By_Id_Patient(@PathVariable int Patient_id){
        Patients em= ServiceBase.findbyidPatient(Patient_id);

        if(em==null){
            throw new RuntimeException("Donors is not found "+ Patient_id);
        }
        return em;
    }

//Here the problem by the api must change the api when write the first name
    @GetMapping("/Donors/Fname/{Donor_Fname}")
    public List<Donor> Get_all_Donor_By_First_Name(@PathVariable String Donor_Fname ){
        return  ServiceBase.find_byfirst_name(Donor_Fname);
    }

  //////////////The get_all_byFirst_name for Patient

    //Here the problem by the api must change the api when write the first name
    @GetMapping("/Patients/Fname/{Patient_Fname}")
    public List<Patients> Get_all_Patient_By_First_Name(@PathVariable String Patient_Fname ){
        return  ServiceBase.find_byfirst_namePatients(Patient_Fname);
    }

//Here we will get the data according last_name
    @GetMapping("/Donors/Lname/{Donor_Lname}")
    public List<Donor> Get_all_Donor_By_Last_name(@PathVariable String Donor_Lname ){
        return  ServiceBase.findbylast_name(Donor_Lname);
    }

    //Here we will get the data according last_name
    @GetMapping("/Patients/Lname/{Patient_Lname}")
    public List<Patients> Get_all_Donor_By_Last_name_Patient(@PathVariable String Patient_Lname){
        return  ServiceBase.findbylast_namePatients(Patient_Lname);
    }

    @GetMapping("/Donors/Age/{Donor_age}")
    public List<Donor> Get_all_Donor_By_Age(@PathVariable int Donor_age ){
        return  ServiceBase.findbyage(Donor_age);
    }


    @GetMapping("/Patients/Age/{Patient_age}")
    public List<Patients> Get_all_Donor_By_Age_Patient(@PathVariable int Patient_age ){
        return  ServiceBase.findbyagePatients(Patient_age);
    }



    @GetMapping("/Donors/Phone/{Donor_Phone}")
    public List<Donor> Get_all_Donor_By_Phone(@PathVariable int Donor_Phone ){
        return  ServiceBase.findbyphone(Donor_Phone);
    }



    @GetMapping("/Patients/Phone/{Patient_Phone}")
    public List<Patients> Get_all_Donor_By_Phone_Patient(@PathVariable int Patient_Phone){
        return  ServiceBase.findbyphonePatients(Patient_Phone);
    }


    @GetMapping("/Donors/Type/{Donor_Type}")
    public List<Donor> Get_all_Donor_By_Typed(@PathVariable String Donor_Type ){
        return  ServiceBase.findbyBloodType(Donor_Type);
    }


    @GetMapping("/Patients/Type/{Patient_Type}")
    public List<Patients> Get_all_Donor_By_Typed_Patient(@PathVariable String Patient_Type ){
        return  ServiceBase.findbyBloodTypePatients(Patient_Type);
    }

    @GetMapping("/Donors/Gender/{Donor_Gender}")
    public List<Donor> Get_all_Donor_By_Gender(@PathVariable String Donor_Gender ){
        return  ServiceBase.findbyGender(Donor_Gender);
    }


    @GetMapping("/Patients/Gender/{Patient_Gender}")
    public List<Patients> Get_all_Donor_By_Gender_Patient(@PathVariable String Patient_Gender ){
        return  ServiceBase.findbyGenderPatients(Patient_Gender);
    }



    @GetMapping("/Donors/Email/{Donor_Email}")
    public List<Donor> Get_all_Donor_By_Email(@PathVariable String Donor_Email ){
        return  ServiceBase.findbyemail(Donor_Email);
    }


//for name Hospital
    @GetMapping("/Patients/Hospital/{Name_Hospital}")
    public List<Patients> Get_all_Patient_By_Name_Hospital(@PathVariable String Name_Hospital ){
        return  ServiceBase.Find_By_Name_Hos(Name_Hospital);
    }


    @GetMapping("/Patients/Date/{First_Date}")
    public List<Patients> Get_all_Patient_By_First_Date(@PathVariable String First_Date ){
        return  ServiceBase.Find_By_FirstDate(First_Date);
    }

    @GetMapping("/Patients/Date/{Last_Date}")
    public List<Patients> Get_all_Patient_By_Last_Date(@PathVariable String Last_Date ){
        return  ServiceBase.Find_By_LastDate(Last_Date);
    }



    //1- first we can save Patient  through Entity Patient in RestController Main    @PostMapping("/Patients")(addP)
//USE FIRSTLY
    //2- if you get Patient you can use  @GetMapping("/Patients/all") for all for id
    // is(@GetMapping("/Patients/id/{Patient_id}"))

    //Now we will create Donors For Patient (Condition is :- enter the Patient the Donors )

    //Save



}




















    /*
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    private List<Donors> theDonors;
    //for known please focus on
    @PostMapping
    public void loadData(){
        theDonors = new ArrayList<>();
        theDonors.add(new Donors("hussein","omar",0,"A+",12,"@","male"));
        theDonors.add(new Donors("hussein","omar",0,"A+",12,"@","male"));
        theDonors.add(new Donors("hussein","omar",0,"A+",12,"@","male"));
        theDonors.add(new Donors("hussein","omar",0,"A+",12,"@","male"));
    }
*/
