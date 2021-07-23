package com.grophin.courseapis.repos;


import com.grophin.courseapis.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,String> {

    UserDetails findByUsertEmail(String email);
}
