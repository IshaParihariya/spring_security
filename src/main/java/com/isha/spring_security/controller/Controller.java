package com.isha.spring_security.controller;

import com.isha.spring_security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller
{
    //to get session id or cookie => HttpServletRequest req
    // => req.getSession().getId();
    @GetMapping("/hello")
    public String greet(HttpServletRequest request)
    {
        return "Hello!! " + request.getSession().getId(); //getting the session id to be printed with the msg
        // CSRF =>cross site request forgery
        //-> an attacker from some malicious
        // uses the session id and request for some action to be done
        // as the user logged in so the session id browser uses it
        // so for this we use tokens
        // also same site strict as defenses

    }//end of greet method

    // tokens are only auto generated for request which may change the data in spring security
    // so get don't need any token

    //post method to do token thing
    //token will be generated for this method
    //tested this on postman
    @PostMapping("/student")
    public String postStudent(@RequestBody Student student) //The JSON data in the request body is
                                                          // converted into a Student object using
                                                          //  @RequestBody
    {
        return "student added : " + "id : "+ student.getId() +" " +" name : "+student.getName();
    }

    //to get the CSRF token here
    @GetMapping("/csrf-token")
            @ResponseBody
            public CsrfToken getToken(CsrfToken token)
    {
        //CsrfToken we dont create this object spring security creates it!
        return token;
    }
}
