package com.grophin.courseapis.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "User_Details")
@Data
public class UserDetails implements Serializable {

    @Id
    @Column(name="UserID")
    String userId;

    @Column(name="UserName")
    String userName;

    @Column(name="UserEmail")
    String usertEmail;

    @Column(name="UserContactNo")
    String userContactNo;

    @Column(name = "UserAddress")
    String userAddress;

    @Column(name = "Password")
    String password;

}
