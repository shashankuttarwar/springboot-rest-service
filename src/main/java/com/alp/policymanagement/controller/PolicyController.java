/**
 * 
 */
package com.alp.policymanagement.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alp.policymanagement.model.Policy;

/**
 * @author lenovo
 *
 */
@RestController
public class PolicyController {

    @RequestMapping("/policies")
    public Policy list(@RequestParam(value="name", defaultValue="World") String name) {
    	Policy policy = new Policy();
    	policy.setAmount("123");
    	policy.setEndDate(new Date());
    	policy.setName("LIC JEEVAN");
    	policy.setNumber("1111");
    	
    	return policy;
    }
}
