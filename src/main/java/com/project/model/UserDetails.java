package com.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "UserDetails")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int userId;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Username")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "DOB")
    private String dob;

////    Data data;
//
//    public String getGender(){
//        return gender;
//    }
//
////    public void setGender(String gender){
////        this.gender = data.getResults().get(0).getGender();
////    }
//
//    public String getFullName(){
//        return fullName;
//    }
//
////    public void setFullName(String fullName){
////        this.fullName = data.getResults().get(0).getName().getFirst() +
////                data.getResults().get(0).getName().getLast();
////    }
//
//    public String getEmail(){
//        return email;
//    }
//
////    public void setEmail(String email){
////        this.email = data.getResults().get(0).getEmail();
////    }
//
//    public String getUserName(){
//        return userName;
//    }
//
////    public void setUserName(String userName){
////        this.userName = data.getResults().get(0).getLogin().getUsername();
////    }
//
//    public String getPassword(){
//        return password;
//    }
//
////    public void setPassword(String password){
////        this.password = data.getResults().get(0).getLogin().getPassword();
////    }
//
//    public String getDob(){
//        return dob;
//    }
//
////    public void setDob(String dob){
////        this.dob = data.getResults().get(0).getDob().getDate();
////    }
//
////    @Override
////    public String toString() {
////
////        StringBuilder builder = new StringBuilder();
////
////        builder.append(String.valueOf(userId));
////        builder.append(", ");
////        builder.append(fullName);
////        builder.append(", ");
////        builder.append(gender);
////        builder.append(", ");
////        builder.append(email);
////        builder.append(", ");
////        builder.append(userName);
////        builder.append(", ");
////        builder.append(password);
////        builder.append(", ");
////        builder.append(dob);
////        return builder.toString();
////    }
}
