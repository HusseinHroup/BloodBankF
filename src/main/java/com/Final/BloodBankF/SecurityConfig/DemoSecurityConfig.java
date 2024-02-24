//package com.Final.BloodBankF.SecurityConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DemoSecurityConfig {
//
////add support for jdbc....no more hardcodeed users :-)
//
////
////@Bean
////public UserDetailsManager userDetailsManager(DataSource dataSource){
////    return new JdbcUserDetailsManager(dataSource);
////}
//
//
////the springboot will not use the user and password in properties
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails HU = User.builder().username("Hussein").password("24680").roles("ADMIN").build();
//        UserDetails HA = User.builder().username("Haneen").password("24680").roles("ADMIN").build();
//        UserDetails AB = User.builder().username("Abdullah").password("24680").roles("ADMIN").build();
//
//        //another user must be Donor And Manager And Patinet (Must Use DataBase)
//        return new InMemoryUserDetailsManager(AB,HA,HU);
//    }
//    @Bean
//    public SecurityFilterChain filterchain (HttpSecurity http) throws  Exception{
//        http.authorizeHttpRequests(configure->configure.requestMatchers((HttpMethod.POST),"/api/Patients").hasRole("ADMIN"));//Just For ADMIN
//        http.authorizeHttpRequests(configure->configure.requestMatchers((HttpMethod.PUT),"/api/Patients").hasRole("ADMIN"));//Just For ADMIN
//        http.authorizeHttpRequests(configure->configure.requestMatchers((HttpMethod.DELETE),"/api/Patients/Delete/{Delete_id}").hasRole("ADMIN"));//Just For ADMIN
////        //here have big Question can be need the get for get gender for specefic id ??
//        //solution using the specefic JPQL
////        http.authorizeHttpRequests(configure->configure.requestMatchers((HttpMethod.POST),"/api/Donors").hasRole("DONOR"))
//// HERE Donor can Get Donor And Patient for can access to the data
////
////use http basic  authentication
//        http.httpBasic(Customizer.withDefaults());
//
//
////disable Cross Site Request Forgery (CSRF)
//        //IN General  , Not Required for stateLess  Rest Apis that Use Post ,Put ,Delete and/or Patch
//        http.csrf(csrf->csrf.disable());
//        return http.build();
//    }
//
//}
//
//
