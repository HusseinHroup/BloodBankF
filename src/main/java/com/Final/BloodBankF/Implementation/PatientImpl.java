package com.Final.BloodBankF.Implementation;

import com.Final.BloodBankF.Entity.Patients;
import com.Final.BloodBankF.Interfaces.PatientInter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientImpl implements PatientInter {

    // TYPE OF INJECTION

    //this is setter injection
    //through can access the method in interface (save , delete , ... ..)
    //Warning must add Autowirred.

    /*
    private Patient PatientInject;
     For optional Dependencies
    @Autowired
    public void  PatientInject(Patient p){
    PatientInject=p;
    }*/

/*    private Patient PatientInject;
    @Autowired
    //here is inject constructor why ??
    //by this object DonorInject can access the method inside to interface (save , delete , .... )
    public PatientImpl (@Qualifier("patientImpl") Patient P){
        PatientInject = P ;
    }
*/

    //not work if not have @Repository
    @Autowired
    private EntityManager Entity_Manager ;

    public PatientImpl(EntityManager e) {
        Entity_Manager = e;
    }


    @Override
    public Patients saveP(Patients thePatient) {

        Patients patient =  Entity_Manager.merge(thePatient);
        return patient;
    }



    @Override
    public void DeleteByid(int id) {
        //remmeber must find then remove
        Patients d = Entity_Manager.find(Patients.class,id);
        Entity_Manager.remove(d);
    }

//    @Override
    public List<Patients> findall() {
        TypedQuery FindAllPatient = Entity_Manager.createQuery("from Patients ",Patients.class);
        //here please dont remmeber the the typedquery must store in List (NOT EQUAL )
        return FindAllPatient.getResultList();
    };



    @Override
    public Patients findbyid(int id) {
        return Entity_Manager.find(Patients.class,id);
    }

    @Override
    public List<Patients> find_byfirst_name(String name) {
        TypedQuery FindFirst = Entity_Manager.createQuery("from Patients where  First_Name=:name",Patients.class);
        FindFirst.setParameter("name",name);
        //here please dont remmeber the the typedquery must store in List
        return FindFirst.getResultList();

    }

    @Override
    public List<Patients> findbylast_namePatients(String name) {
        TypedQuery FindLast = Entity_Manager.createQuery("from Patients where  Last_Name=:name",Patients.class);
        FindLast.setParameter("name",name);
        //here please dont remmeber the the typedquery must store in List
        return FindLast.getResultList();
    }


    @Override
    public List<Patients> findbyage(int age) {
        TypedQuery ListQueryAge=Entity_Manager.createQuery("from Patients  where Age=:age1",Patients.class);
        ListQueryAge.setParameter("age1",age);
        return ListQueryAge.getResultList();    }

    @Override
    public List<Patients> findbyphone(int phone) {
        TypedQuery ListQueryPhone=Entity_Manager.createQuery("from Patients  where Phone=:phone1",Patients.class);
        ListQueryPhone.setParameter("phone1",phone);
        return ListQueryPhone.getResultList();    }

    @Override
    public List<Patients> findbyBloodType(String BloodType) {
        TypedQuery ListQueryBloodType=Entity_Manager.createQuery("from Patients where Blood_Type=:blood",Patients.class);
        ListQueryBloodType.setParameter("blood",BloodType);
        return ListQueryBloodType.getResultList();    }

    @Override
    public List<Patients> findbyGender(String Gender) {

        TypedQuery ListQueryGender = Entity_Manager.createQuery("from Patients where Gender=:gen",Patients.class);
        ListQueryGender.setParameter("gen",Gender);
        return ListQueryGender.getResultList();
    }


    @Override
    public List<Patients> Find_By_Name_Hos(String Hospital) {
        TypedQuery ListQueryHospital = Entity_Manager.createQuery("from Patients  where Name_Hospital=:Hosp",Patients.class);
        ListQueryHospital.setParameter("Hosp",Hospital);
        return ListQueryHospital.getResultList();
    }

    @Override
    public List<Patients> Find_By_FirstDate(String Date1) {
        TypedQuery ListQueryFDate = Entity_Manager.createQuery("from Patients where First_Date=:FDate",Patients.class);
        ListQueryFDate.setParameter("FDate",Date1);
        return ListQueryFDate.getResultList();
    }

    @Override
    public List<Patients> Find_By_LastDate(String Date2) {
        TypedQuery ListQueryLDate = Entity_Manager.createQuery("from Patients where First_Date=:LDate",Patients.class);
        ListQueryLDate.setParameter("LDate",Date2);
        return ListQueryLDate.getResultList();    }




   /* @Override
    public Patient ReteirvePatientById(int id) {
        return Entity_Manager.find(Patient.class , id);
    }

    @Override
    public Patient RetPatientByName(String name) {
        name.toLowerCase();
        return Entity_Manager.find(Patient.class,name);
    }*/

    /////---------------------///////




}
