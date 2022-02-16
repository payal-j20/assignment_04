/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment_04;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author shiv
 */
public interface tweet_repo extends CrudRepository<tweet,Integer> {
    /*@Query("select text from tweet where tweet_id in (select username from user_3 where user_id=1)")
    List<String> findByTweet_id(Integer id);*/
    @Transactional
    @Modifying
    @Query("delete from tweet where user_id in (select user_id from user_3 where USERNAME=?1)")
    int deleteByUsername(String username);
    @Query(value="from tweet where user_id in (select user_id from user_3 where USERNAME=?1) AND CREATED_TIMESTAMP >= ?2")
    List<tweet> gettweets(String username,Date d);
    @Query(value="from tweet where user_id in (select user_id from user_3 where USERNAME=?1)")
    List<tweet> gettweets(String username);
}
