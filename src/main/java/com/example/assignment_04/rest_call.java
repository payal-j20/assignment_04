/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment_04;

/**
 *
 * @author shiv
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.apache.derby.client.am.SqlException;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class rest_call {
    
    @Autowired
    user_repo a;
    @Autowired
    tweet_repo tw;
    
    @RequestMapping(method=POST,value="/Create_user")
    public String user(@RequestParam(name="username") String username){
        user_3 ac=new user_3();
        ac.username=username;
        a.save(ac);
        return "{\"user_id\"  : "+ac.user_id+",\"created_timestamp\":"+"\""+ac.created_timestamp+"\"}";
    }
    
    @RequestMapping(method=POST,value="/Create_tweets")
    public String create_tweet(@RequestParam(name="text") String text,@RequestParam(name="user_id")Integer id){
        
        try{
            System.out.println("id "+id);
            tweet ac=new tweet();
            ac.setText(text);
            ac.t=new user_3();
            ac.t.user_id=id;

            tw.save(ac);
            return "{\"tweet_id\"  : "+ac.tweet_id+",\"created_timestamp\":"+"\""+ac.created_timestamp+"\"}";//return "tweet_id : "+ac.tweet_id+",created_timestamp:"+ac.created_timestamp;
        }
        catch(DataIntegrityViolationException e){
            System.out.println("Exceptionn sssss-----------"+e.getLocalizedMessage());
            System.out.println("Exceptionn sssss-----------"+e.getMessage());
            System.out.println("e.getRootCause()"+e.getRootCause());
            if(e.getRootCause().toString().contains("fk98g3mkyw32p9u8aaifl1kf94y")){
                //Foreign key constraint
                System.out.println("Root cause -----------"+e.getRootCause());
                return "User_id doesn't exist";
            }
            else{
            System.out.println("Root cause -----------"+e.getRootCause().toString().contains("FK98G3MKYW32P9U8AAIFL1KF94Y"));
            return "Exception found";
            }
        }
        
        
    }
    @RequestMapping(method=POST,value="/Read_tweets")
    public String read_tweet(String username,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<tweet> t=tw.gettweets(username,date);
        JSONObject all_tweet=new JSONObject();
        all_tweet.put("Count ", t.size());
        for(int i=0;i<t.size();i++){
            JSONObject tweets=new JSONObject();
            tweets.put("text", t.get(i).text);
            tweets.put("tweet_id", t.get(i).tweet_id);
            all_tweet.put(""+i,tweets);
        }
        
        return all_tweet.toString();
    }
    @RequestMapping(method=POST,value="/Delete_tweets")
    public String delete_tweet(@RequestParam(name="username")String username){
        List<tweet> t=tw.gettweets(username);
        List<String> text = t.stream().map(tweet::getText).collect(Collectors.toList());
        List<Integer> tweet_id = t.stream().map(tweet::getTweet_id).collect(Collectors.toList());
        int coun=tw.deleteByUsername(username);
        JSONObject all_tweet=new JSONObject();
        all_tweet.put("No of tweets deleted ", coun);
        for(int i=0;i<text.size();i++){
            JSONObject tweets=new JSONObject();
            tweets.put("text", text.get(i));
            tweets.put("tweet_id", tweet_id.get(i));
            all_tweet.put(""+i,tweets);
        }
        return all_tweet.toString();
    }
    @ExceptionHandler(ConstraintViolationException.class)
    String handle2ConstraintViolationException(ConstraintViolationException e) {
        System.out.println("handle2ConstraintViolationException");
        Set<ConstraintViolation<?>> v = e.getConstraintViolations();
        JSONObject er=new JSONObject();
        for (ConstraintViolation<?> v1 : v) {
            er.put(""+v1.getPropertyPath().toString().substring(v1.getPropertyPath().toString().lastIndexOf(".")+1), v1.getMessage());
        }
     //System.out.println(er.toString());
        return er.toString();
    
  }
     @ExceptionHandler(SqlException.class)
    String handle2SqlException(SqlException e) {
        String ex = e.getLocalizedMessage();
        System.out.println("error"+e.getErrorCode());
        if(e.getErrorCode()==20000){
            return "username must be unique";
        }
        else{
            return "";
        }
        
    
  }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String conflict(DataIntegrityViolationException e) {

        if(e.getMessage().contains("uk_ejtwyvvjnreec627nsksg590m")){
            return "Username must be unique";
        }
        else{
            return"";
        }
            
        
    }
    
}
