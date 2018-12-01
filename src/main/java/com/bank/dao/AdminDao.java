package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.dao.AccountDao.ProfileMapper;
import com.bank.dao.AccountDao.UserMapper;
import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Profile;

public class AdminDao  implements IAdminDao{
	
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	    public List<Profile> displayRequests()
	    {
	    	
	    	Profile userDetails = new Profile();
			
			String getProfileQuery="select * from gr13_customers c, gr13_addresses ad, gr13_accounts ac  where c.gc_customer_id = ad.gt_gc_customer_id  and c.gc_customer_id = ac.ga_gc_customer_id and gc_status='pending'"; 

			

	    	
			return 	(List<Profile>) jdbcTemplate.query(getProfileQuery, new ProfileMapper()); 
	    	
	    }
	    
	    
	    class ProfileMapper implements RowMapper<Profile> {
			public Profile mapRow(ResultSet rs, int arg1) throws SQLException {
				Profile user = new Profile();
			
				user.setCustomer_id(rs.getInt(1));
				user.setFirst_name(rs.getString(2));
				user.setMiddle_name(rs.getString(3));
				user.setLast_name(rs.getString(4));
				user.setFather_name(rs.getString(5));
				user.setEmail_id(rs.getString(6));
				user.setMobile_number(rs.getLong(7));
				user.setAadhar_card(rs.getLong(8));
				user.setDate_of_birth(rs.getString(9));
				user.setAnnual_income(rs.getInt(10));
				user.setAddress_line_1(rs.getString(12));
				user.setAddress_line_2(rs.getString(13));
				user.setPin_code(rs.getString(14));
				user.setCity(rs.getString(15));
				user.setState(rs.getString(16));
				user.setAccount_number(rs.getLong(19));
				user.setAccount_type(rs.getString(21));
				user.setBalance(rs.getFloat(20));



				return user;
			}

		}


		@Override
		public int reject(int customerID) {
			// TODO Auto-generated method stub
			String rejectRequestQuery="delete from gr13_customers where GC_CUSTOMER_ID="+customerID; 

			
			return 	jdbcTemplate.update(rejectRequestQuery); 

		}
		
		
		@Override
		public int approve(int customerID) {
			// TODO Auto-generated method stub
			String rejectRequestQuery="update gr13_customers set gc_status = 'active' where gc_customer_id="+customerID; 

			
			return 	jdbcTemplate.update(rejectRequestQuery); 

		}
		
		public Profile getProfile(int customerId)
	    {
	    	
			
			String getProfileQuery="select * from gr13_customers c, gr13_addresses ad, gr13_accounts ac  where c.gc_customer_id = ad.gt_gc_customer_id  and c.gc_customer_id = ac.ga_gc_customer_id  and c.gc_customer_id="+customerId; 

			
	    	
			return 	(Profile) jdbcTemplate.queryForObject(getProfileQuery, new ProfileMapper()); 
	    	
	    }
	
}
