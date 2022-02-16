/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment_04;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author shiv
 */
@Entity
@Table(name="tweet")
public class tweet {
    //SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
    //Date date=new Date();
    
    
    @Size(min=2,max=140)
    @Column
    String text;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    int tweet_id;
    @Temporal(TemporalType.DATE)
    @Column
    Date created_timestamp=new Date();
    
    @ManyToOne
    @JoinColumn(name="user_id")
    user_3 t;

    public user_3 getT() {
        return t;
    }

    public void setT(user_3 t) {
        this.t = t;
    }
    
    
    

    /*public String getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(String created_timestamp) {
        this.created_timestamp = created_timestamp;
    }*/
    
    
    /*public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }*/

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTweet_id() {
        return tweet_id;
    }
    
   
    
    
}
