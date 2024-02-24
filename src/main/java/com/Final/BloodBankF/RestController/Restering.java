package com.Final.BloodBankF.RestController;

import com.Final.BloodBankF.Entity.Patients;
import com.Final.BloodBankF.Service.ServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patient/Donor")
public class Restering {

    @Autowired
    public Restering(ServiceInter service) {
        Service = service;
    }


    ServiceInter Service ;

//    @PostMapping("save/Donors")
//    public List<Patient> saveDonorDataCom(List<Patient> patientsnew) {
//        return Service.saveDonorDataCom(patientsnew);
//  }

    //here hi my think i best added then put not added in same time
//    @PostMapping("POST/{Patient_id}/Donor/{Donor_id}")
//    public Patients assignDonorToPatient(@PathVariable int Patient_id , @PathVariable  int Donor_id ){
//        return Service.assignDonorToPatientPost(Patient_id,Donor_id);
//    }
/////////
    @PutMapping("/{Patient_id}/Donor/{Donor_id}")
    public Patients assignDonorToPatientPost(@PathVariable int Patient_id , @PathVariable  int Donor_id ) {
        return Service.assignDonorToPatientPut(Patient_id,Donor_id);
    }

    @DeleteMapping("/{PatientId}/Donor/{DonorId}")
    public ResponseEntity<Patients> removeDonorFromPatient(
            @PathVariable int PatientId,
            @PathVariable int DonorId) {

        Patients result = Service.removeDonorFromPatient(PatientId, DonorId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            // Handle case where either patient or donor is not found
            return ResponseEntity.notFound().build();
        }
    }



//
//    @GetMapping("GetP/Donor/{P_id}")
//    public List<Patients> getPatientDetails(@PathVariable int P_id) {
//        return Service.getPatientDetails(P_id);
//    }
//same delete of Patient

    //just for Check not another thing
//    @GetMapping("GetPN/Donor/{P_id}")
//    public Patient getPatientDetailsNew( @PathVariable int P_id) {
//        return Service.getPatientDetailsNew(P_id);
//    }



//    @DeleteMapping("/Delete/{Demp_id}")
//    public ResponseEntity deletePatient (@PathVariable int Demp_id){
//        Service.DeleteCompositPatient(Demp_id);
//        return new ResponseEntity(HttpStatus.OK);
//    }

//
//    @DeleteMapping("/Delete/{D}/DonorFromPatient/{P}")
//    public Donors removePatientFromDonorPOST(@PathVariable  int D,@PathVariable  int P){
//        return Service.removePatientFromDonor(D,P);
//    }



//////////for Donor ///////////
//@PostMapping("/{Donor_id}/Patient/{Patient_id}")
//public Donors assignPatientToDonor(@PathVariable int Donor_id , @PathVariable  int Patient_id ){
//    return Service.assignPatientToDonorPOST(Donor_id,Patient_id);
//}


}
