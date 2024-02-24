//package com.Project.BloodBank3.ProjectUniversity.Blood.Bank.Entity;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//
//
//    @Embeddable
//    public class donorspatient implements Serializable {
//
//
//
//        @Column(name = "D_id")
//        private int D_id;
//
//        @Column(name = "P_id")
//        private int P_id;
//
//
//        public donorspatient() {
//            System.out.println("welcome to in your shared table ");
//        }
//
//        public donorspatient(int d_id, int p_id) {
//            D_id = d_id;
//            P_id = p_id;
//        }
//
//        public int getD_id() {
//            return D_id;
//        }
//
//        public void setD_id(int d_id) {
//            D_id = d_id;
//        }
//
//        public int getP_id() {
//            return P_id;
//        }
//
//        public void setP_id(int p_id) {
//            P_id = p_id;
//        }
//
//        @Override
//        public String toString() {
//            return "donorspatient{" +
//                    "D_id=" + D_id +
//                    ", P_id=" + P_id +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof com.Project.BloodBank3.ProjectUniversity.Blood.Bank.Entity.donorspatient that)) return false;
//            return getD_id() == that.getD_id() && getP_id() == that.getP_id();
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(getD_id(), getP_id());
//        }
//
//}
