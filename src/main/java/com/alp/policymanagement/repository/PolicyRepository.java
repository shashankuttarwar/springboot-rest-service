/**
 * 
 */
package com.alp.policymanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alp.policymanagement.model.Policy;
import com.alp.policymanagement.repository.mapper.PolicyMapper;

/**
 * @author lenovo
 *
 */
@Repository
public class PolicyRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public Policy findByNumber(long policyNumber) {
	    return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] {
	    		policyNumber
	        },
	        new PolicyMapper());
	}
	
	public List<Policy> getAllPolicies() {
		List<Policy> policies = jdbcTemplate.query("SELECT * FROM User",
				new PolicyMapper());
		return policies;
	}
	
	public List<Policy> findByNumbers(List<Long> policyNumbers) {
		List<Policy> policies = jdbcTemplate.query("SELECT * FROM User",
				new PolicyMapper());
		return policies;
	}
	
	public String updatePolicy(Policy policy) {
	    String sql = "UPDATE Policy SET ID=?, NAME=? ,NUMBER=?, AMOUNT=?, END_DATE=? WHERE NUMBER=?";
	    jdbcTemplate.update(sql, policy.getId(), policy.getName(), policy.getNumber(),policy.getAmount(),policy.getEndDate());
	    return String.valueOf(policy.getId());
	} 
	
	
}
