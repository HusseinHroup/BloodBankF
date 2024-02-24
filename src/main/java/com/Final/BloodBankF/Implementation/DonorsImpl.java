package com.Final.BloodBankF.Implementation;

import com.Final.BloodBankF.Entity.Donor;
import com.Final.BloodBankF.Interfaces.DonorInter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DonorsImpl implements DonorInter {

    /*  private Patient DonorInject;

      @Autowired //here is inject constructor why ??
      //by this object DonorInject can access the method inside to interface (save , delete , .... )
      public DonorImpl(@Qualifier("donorImpl") Patient D) {
          DonorInject = D;
      }
  */
    private EntityManager Entity_Manager ;

    @Autowired
    public DonorsImpl(EntityManager entity_Manager) {
        Entity_Manager = entity_Manager;
    }
    //this function for add just , But i want to add and update.
//    public void save(Donors p)
//    {
//        Entity_Manager.persist(p);
//    }




//    @Override
//    public Donors ReterveDonById(int id) {
//        return Entity_Manager.find(Donors.class , id );
//
//    }
//    @Override
//    public Donors RetDonorsByName(String name) {
//       //for convert the String to lower case
//        name.toLowerCase();
//        return Entity_Manager.find(Donors.class , name);
//    }


    @Override
    public Donor save(Donor theDonor) {
        Donor dbDonor = Entity_Manager.merge(theDonor);
//        dbDonor.password = "{noop}"+dbDonor.password;
        return dbDonor;
    }

    @Override
    public int DeleteByid(int id) {
        //remmeber must find then remove
        Donor d = Entity_Manager.find(Donor.class,id);
        Entity_Manager.remove(d);
        return id;
    }

    @Override
    public List<Donor> findall() {
        String sql ="";
        TypedQuery<Donor> QueryDon = Entity_Manager.createQuery("from Donor  ",Donor.class);
        List<Donor> ListQueryAll =QueryDon.getResultList();
        return ListQueryAll;
    }

    @Override
    public Donor findbyid(int id){
        return Entity_Manager.find(Donor.class , id);
    }


    //why we write form list  because maybe have more  Donor have same name
    @Override
    public List<Donor> find_byfirst_name(String Fname) {
//        TypedQuery<Donors> QuerName =Entity_Manager.createQuery()
        //when write after =: name (not defined thing determined )
        TypedQuery<Donor> ListQueryFirst_name=Entity_Manager.createQuery(" from Donor  where First_Name=:Fname1",Donor.class);

        //remember the the (name1) must be as a String .

        ListQueryFirst_name.setParameter("Fname1",Fname);

        return ListQueryFirst_name.getResultList();
    }

    @Override
    public List<Donor> findbylast_name(String Lname) {

        TypedQuery ListQueryLast_name=Entity_Manager.createQuery("from Donor  where Last_Name=:Lname1",Donor.class);
        ListQueryLast_name.setParameter("Lname1",Lname);
        return ListQueryLast_name.getResultList();
    }

    @Override
    public List<Donor> findbyage(int age) {
        TypedQuery ListQueryAge=Entity_Manager.createQuery("from Donor  where Age=:age1",Donor.class);
        ListQueryAge.setParameter("age1",age);
        return ListQueryAge.getResultList();
    }

    @Override
    public List<Donor> findbyphone(int phone) {

        TypedQuery ListQueryPhone=Entity_Manager.createQuery("from Donor  where Phone=:phone1",Donor.class);
        ListQueryPhone.setParameter("phone1",phone);
        return ListQueryPhone.getResultList();
    }

    //this is very important
    @Override
    public List<Donor> findbyBloodType(String BloodType) {

        TypedQuery ListQueryBloodType=Entity_Manager.createQuery("from Donor where Blood_Type=:blood",Donor.class);
        ListQueryBloodType.setParameter("blood",BloodType);
        return ListQueryBloodType.getResultList();
    }


    @Override
    public List<Donor> findbyGender(String Gender) {
        TypedQuery ListQueryGender = Entity_Manager.createQuery("from Donor  where Gender=:gen",Donor.class);
        ListQueryGender.setParameter("gen",Gender);
        return ListQueryGender.getResultList();

    }

    @Override
    public List<Donor> findbyemail(String email) {
        TypedQuery ListQueryGender = Entity_Manager.createQuery("from Donor  where Username=:EM",Donor.class);
        ListQueryGender.setParameter("EM",email);
        return ListQueryGender.getResultList();

    }


    @Override
    public Optional<Donor> findbypassword(String pas) {
        TypedQuery ListQueryPass=Entity_Manager.createQuery("from Donor where password=:PS" ,Donor.class );
        ListQueryPass.setParameter("PS",pas);
        return ListQueryPass.getResultList().stream().findFirst();
    }


    @Override
    public List<Donor> finOneByEmailAndPassword(String Email, String pass) {


        TypedQuery ListQueryPass=Entity_Manager.createQuery("from Donor where Username=:EM and password=:PA " ,Donor.class );
        ListQueryPass.setParameter("EM",Email);
        ListQueryPass.setParameter("PA",pass);
        return ListQueryPass.getResultList();
    }



}
