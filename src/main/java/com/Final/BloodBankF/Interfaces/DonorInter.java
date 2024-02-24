package com.Final.BloodBankF.Interfaces;



import com.Final.BloodBankF.Entity.Donor;

import java.util.List;
import java.util.Optional;

public interface DonorInter {
    //For Save Object Donor  i
    // n DataBase
    /////////// Save And Update same function /////////////

    public Donor save(Donor theDonor);
    //For Retirve  single Donor by id
    //  Donors ReterveDonById(int id );
    // Donors RetDonorsByName(String name);

    /////////////Delete by id /////////////
   public int DeleteByid(int id);

    /*------------------------------------*/
    // 1) //For retirve all Donors
    List<Donor> findall();
    Donor findbyid(int id);
    List<Donor> find_byfirst_name(String name);
    List<Donor> findbylast_name(String name);
    List<Donor> findbyage(int age);
    List<Donor> findbyphone(int phone);
    List<Donor> findbyBloodType(String BloodType);
    List<Donor> findbyGender(String Gender);
    List<Donor> findbyemail(String email);

    public Optional<Donor> findbypassword (String Pas);
    List<Donor> finOneByEmailAndPassword(String Email , String pass );



}
