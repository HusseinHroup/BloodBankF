package com.Final.BloodBankF.Service;

import com.Final.BloodBankF.Entity.Donor;
import com.Final.BloodBankF.Entity.Patients;
import com.Final.BloodBankF.Interfaces.DonorInter;
import com.Final.BloodBankF.Interfaces.PatientInter;
import com.Final.BloodBankF.Login.loginDTO;
import com.Final.BloodBankF.Response.LoginResponse;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServiceImpl implements  ServiceInter {
    private DonorInter DonorsInterface;
    private PatientInter PatientInterface;
    private EntityManager Entity;


    @Autowired
    public ServiceImpl(DonorInter donorsInterface, PatientInter patientInterface  ) {
        DonorsInterface = donorsInterface;
        PatientInterface = patientInterface;
    }


    //Iwant called same name (Not Problem)

//    @Transactional
//    @Override
//    public Donor saveLoginPK(DonorDTO donorDTO) {
//
//        Donor donor =new Donor(
//        donorDTO.getFirst_Name(),
//        donorDTO.getLast_Name(),
//       donorDTO.getPhone(),
//        donorDTO.getAge(),
//        donorDTO.getUsername(),
//        donorDTO.getGender(),
//        donorDTO.getBlood_Type(),
//        this.passwordEncoder.encode(donorDTO.getPassword())
//);
//       return  DonorsInterface.save(donor);
//    }

    //Transactional just in implementation
    @Transactional
    @Override
    public Donor login(Donor theDonor) {
        return DonorsInterface.save(theDonor);
    }




    @Transactional
    @Override
    public Patients saveP(Patients thePatient) {
        return PatientInterface.saveP(thePatient);
    }

    @Transactional
    @Override
    public void DeleteByid(int id) {
        //remmeber must find then remove
        DonorsInterface.DeleteByid(id);
    }

    @Override
    public List<Donor> findall() {
        return DonorsInterface.findall();
    }

    @Override
    public Donor findbyid(int id) {
        return DonorsInterface.findbyid(id);
    }

    @Override
    public List<Donor> find_byfirst_name(String name) {
        return DonorsInterface.find_byfirst_name(name);
    }

    @Override
    public List<Donor> findbylast_name(String name) {
        return DonorsInterface.findbylast_name(name);
    }

    @Override
    public List<Donor> findbyage(int age) {
        return DonorsInterface.findbyage(age);
    }

    @Override
    public List<Donor> findbyphone(int phone) {
        return DonorsInterface.findbyphone(phone);
    }

    @Override
    public List<Donor> findbyBloodType(String BloodType) {
        return DonorsInterface.findbyBloodType(BloodType);
    }

    @Override
    public List<Donor> findbyGender(String Gender) {
        return DonorsInterface.findbyGender(Gender);
    }

    @Override
    public List<Donor> findbyemail(String email) {
        return DonorsInterface.findbyemail(email);
    }

    //here we will connection the Patient in @Service .


    @Transactional
    @Override
    public void DeleteByidPatient(int id) {
        PatientInterface.DeleteByid(id);
    }

    @Override
    public List<Patients> findallPatients() {
        return PatientInterface.findall();
    }

    @Override
    public Patients findbyidPatient(int id) {
        return PatientInterface.findbyid(id);
    }

    @Override
    public List<Patients> find_byfirst_namePatients(String name) {
        return PatientInterface.find_byfirst_name(name);
    }

    @Override
    public List<Patients> findbylast_namePatients(String name1) {
        return PatientInterface.findbylast_namePatients(name1);
    }

    @Override
    public List<Patients> findbyagePatients(int age) {
        return PatientInterface.findbyage(age);
    }

    @Override
    public List<Patients> findbyphonePatients(int phone) {
        return PatientInterface.findbyphone(phone);
    }

    @Override
    public List<Patients> findbyBloodTypePatients(String BloodType) {
        return PatientInterface.findbyBloodType(BloodType);
    }

    @Override
    public List<Patients> findbyGenderPatients(String Gender) {
        return PatientInterface.findbyGender(Gender);
    }

    @Override
    public List<Patients> Find_By_Name_Hos(String Hospital) {
        return PatientInterface.Find_By_Name_Hos(Hospital);
    }

    @Override
    public List<Patients> Find_By_FirstDate(String Date1) {
        return PatientInterface.Find_By_FirstDate(Date1);
    }

    @Override
    public List<Patients> Find_By_LastDate(String Date2) {
        return PatientInterface.Find_By_LastDate(Date2);
    }




//    @Override
//    public List<Patient> saveDonorDataCom(List<Patient> patientsnew) {
//        return PatientCom.saveAll(patientsnew);
//    }
//
//    //for save more one Donor in Patient

//////////////////here is implementation for interface Patient Composit /////////////////////
//    @Override


//


    @Transactional
    public Patients assignDonorToPatientPut( int Patient_id, int Donor_id) {
        Set<Donor> DonorSet = null;
        Patients PatientChanger = PatientInterface.findbyid(Patient_id);
        Donor DonorChanger = DonorsInterface.findbyid(Donor_id);
        DonorChanger.setCounter(DonorChanger.getCounter() +1 );

        DonorSet = PatientChanger.getDonorS();
        DonorSet.add(DonorChanger);
        PatientChanger.setDonorS(DonorSet);
        return  PatientInterface.saveP(PatientChanger);
    }
    @Transactional
    public Patients removeDonorFromPatient(int patientId, int donorId) {
        Set<Donor> donorSet = null;
        Patients patientChanger = PatientInterface.findbyid(patientId);
        Donor donorChanger = DonorsInterface.findbyid(donorId);

        if (patientChanger != null && donorChanger != null) {

            donorSet = patientChanger.getDonorS();
            donorSet.remove(donorChanger);
            patientChanger.setDonorS(donorSet);

            return PatientInterface.saveP(patientChanger);
        } else {
            // Handle case where either patient or donor is not found
            return null;
        }
    }


    @Override
    public LoginResponse saveLoginPK(loginDTO donorDTO) {
        String msg = "";
        Boolean TF;
        List<Donor> Donor1 = DonorsInterface.findbyemail(donorDTO.getEmail());
        if (!Donor1.isEmpty() && Donor1.stream().anyMatch(donor -> donor.getPassword().equals(donorDTO.getPassword()))) {
            Optional<Integer> donorId = Donor1.stream().findFirst().map(Donor::getDonor_id);
            return new LoginResponse("Login Success", true, donorId);
        } else {
            return new LoginResponse("Email or Password Not Correct", false, null);
        }
    }



//****************
//    @Override
//    public loginMessage loginDonor(loginDTO logDon) {
//        return null;
//    }


//    @Transactional
//    public Patients assignDonorToPatientPost( int Patient_id, int Donor_id) {
//        Set<Donor> DonorSet = null;
//        Patients PatientChanger = PatientInterface.findbyid(Patient_id);
//        Donor DonorChanger = DonorsInterface.findbyid(Donor_id);
//        DonorSet = PatientChanger.getDonorS();
//        DonorSet.add(DonorChanger);
//        PatientChanger.setDonorS(DonorSet);
//        return  PatientInterface.saveP(PatientChanger);
//    }
//    @Override
//    public List<Patient> getPatientDetails(int id) {
//        if (id != 0) {
//            return PatientCom.findAllById(Collections.singleton(id));
//        } else {
//            return PatientCom.findAll();
//        }
//    }
////
//    public Patient getPatientDetailsNew(int id) {
//        return  PatientCom.getReferenceById(id);
//    }

//
//    @Override
//    public void DeleteCompositPatient(int empid) {
//        PatientCom.deleteById(empid);
//    }
//
////
////    @Override
////    public Patient assignDonorToPatientPUT(int patientId, int donorId) {
////        List<Donors> DonorsSetPut = null;
////        Patient PatientChanger = PatientCom.findById(patientId).get();
////        Donors DonorChanger = DonorCom.findById(donorId).get();
////        DonorsSetPut = PatientChanger.getSharedDonor();
////        DonorsSetPut.add(DonorChanger);
////        PatientChanger.setSharedDonor(DonorsSetPut);
////        Patient savedPatient = PatientCom.save(PatientChanger);
////        return savedPatient;
////    }
//
//    public Donor removePatientFromDonor(int Donor_id, int Patient_id) {
//        Set<Donor> DonorSet = null;
//        // Retrieve the patient and donor
//        Patients PatientChanger = PatientInterface.findbyid(Patient_id);
//        Donor DonorChanger = DonorsInterface.findbyid(Donor_id);
//
//        // Get the list of shared patients from the donor
//        DonorSet = PatientChanger.getDonorS();
//
//        // Remove the specified patient from the list
//        DonorSet.remove(PatientChanger);
//        // Update the donor's shared patient list
//        PatientChanger.setDonorS(DonorSet);
//        // Save the updated donor
//        Patients savedPatient = DonorsInterface.save(PatientChanger);
//        return savedPatient;
//    }


}
