/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.assignment_04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author shiv
 */

@Controller
public class controller {
    @RequestMapping("/")
    public String abc(){
        return "newjsp.jsp";
    }
}
