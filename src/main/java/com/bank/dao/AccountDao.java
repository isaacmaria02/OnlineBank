package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.Account;
import com.bank.model.Address;
import com.bank.model.Customer;
import com.bank.model.InternetBankingUser;
import com.bank.model.Login;
import com.bank.model.MD5;
import com.bank.model.Profile;

/**
 * 
 * @author Isaac Maria <isaac.maria@lntinfotech.com>
 *
 */

public class AccountDao implements IAccountDao {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	MD5 hash;

	/**
	 * Processes the open account request from the user
	 * <p>
	 * The open account form is validated and then inserted into Customers, Accounts
	 * and Addresses relation
	 * </p>
	 * 
	 * @param customer : Fetches values from the getters of model class Customers
	 * @param account  : Fetches values from the getters of Model class Accounts
	 * @param address  : Fetches values from the getters of Model class Addresses
	 * @return long : return the account number if the record is updated
	 */
	public long createAccount(Customer customer, Account account, Address address) {
		int i = 0, j = 0, k = 0;

		String getCustomerId = "select GR13_customers_seq.nextval from dual";
		long customerId = getCustomerSeq(getCustomerId);

		String getAccountNumber = "select GR13_accounts_seq.nextval from dual";
		long accountNumber = getCustomerSeq(getAccountNumber);

		String getAddressId = "select GR13_addresses_seq.nextval from dual";
		long addressId = getCustomerSeq(getAddressId);

		String customerTableQuery = "insert into GR13_customers values(" + customerId + ",'" + customer.getFirst_name()
				+ "','" + customer.getMiddle_name() + "','" + customer.getLast_name() + "','"
				+ customer.getFather_name() + "','" + customer.getEmail_id() + "'," + customer.getMobile_number() + ","
				+ customer.getAadhar_card() + ",'" + customer.getDate_of_birth() + "'," + customer.getAnnual_income()
				+ ",'pending')";

		// ADD ALL THE CONDITIONS

		i = jdbcTemplate.update(customerTableQuery);

		String accountTableQuery = "insert into GR13_accounts values(" + accountNumber + ",500000,'SAVINGS',"
				+ customerId + ")";

		i = jdbcTemplate.update(accountTableQuery);

		String addressTableQuery = "insert into GR13_addresses values(" + addressId + ",'" + address.getAddress_line_1()
				+ "','" + address.getAddress_line_2() + "'," + address.getPin_code() + ",'" + address.getCity() + "','"
				+ address.getState() + "'," + customerId + ")";

		i = jdbcTemplate.update(addressTableQuery);

		if (i <= 0) {
			return 0;
		}

		return accountNumber;
	}

	/**
	 * User will register for internet banking after account opening process is
	 * complete
	 * <p>
	 * Account Number will be emailed to user after the admin approves the account
	 * opening request. The customer can use the account number for availing
	 * internet banking.
	 * 
	 * @param InternetBankingUser : It is a model class obtained from Internet
	 *                            Banking registation form.
	 * @return int : return positive values when successfully registered for
	 *         internet banking
	 *         </p>
	 */
	public int register(InternetBankingUser ibu) {
		int i = 0;

		i = jdbcTemplate.update("insert into GR13_internet_banking_users values(?,?,?,?,?,?,?,?)",
				new Object[] { ibu.getUser_id(), ibu.getLogin_password(), ibu.getTransaction_password(), 0, "enabled",
						ibu.getSecurity_questions(), ibu.getSecurity_answers(), ibu.getAccount_number() });

		return i;

	}

	/**
	 * MD5 hash is obtained to store the password in the encrypted format
	 * 
	 * @param login
	 * @return Returns true if the user is successfully validated
	 */
	public boolean login(Login login) {

		String validateUserQuery = "select * from GR13_internet_banking_users where GIBU_USER_ID='" + login.getUser_id()
				+ "' and GIBU_LOGIN_PASSWORD='" + hash.getMd5(login.getPassword()) + "'";
		List<InternetBankingUser> users = jdbcTemplate.query(validateUserQuery, new UserMapper());

		return users.size() > 0 ? true : false;

	}

	/**
	 * @param login It is used to obtain the account number of the user id mentioned
	 *              in the Login Model
	 * @return It returns the account number which is in Long format
	 */
	public long getAccountNumber(Login login) {
		// TODO Auto-generated method stub

		String getAccountNumberQuery = "select GIBU_GA_ACCOUNT_NUMBER from gr13_internet_banking_users where gibu_user_id='"
				+ login.getUser_id() + "'";

		long accountNumber = jdbcTemplate.queryForObject(getAccountNumberQuery, Long.class);

		return accountNumber;

	}

	/**
	 * @param query It is the SQL query of sequences using dual table
	 * @return Returns the sequence numbers for Account, Customer and Addresses
	 */
	public long getCustomerSeq(String query) {

		long res = jdbcTemplate.queryForObject(query, Long.class);
		return res;
	}

	/**
	 * 
	 * @author Isaac Maria <isaac.maria@lntinfotech.com>
	 *
	 */
	class UserMapper implements RowMapper<InternetBankingUser> {
		public InternetBankingUser mapRow(ResultSet rs, int arg1) throws SQLException {
			InternetBankingUser user = new InternetBankingUser();

			user.setUser_id(rs.getString(1));
			user.setLogin_password(rs.getString(2));

			return user;
		}

	}

	/**
	 * @param customerAccountNumber It is the account number of the customer
	 * @return the balance in floating point of the customer's account number
	 *         mentioned in the customerAccountNumber parameter
	 */
	public float checkBalance(long customerAccountNumber) {
		String getBalanceQuery = "select ga_balance from gr13_accounts where ga_account_number="
				+ customerAccountNumber;

		float balance = jdbcTemplate.queryForObject(getBalanceQuery, Float.class);

		return balance;
	}

	/**
	 * @param customerAccountNumber : It is used as a parameter to obtain summary
	 *                              information of the customer
	 * @return Account : returns the Account Summary Model object
	 */
	@Override
	public Account getSummary(long customerAccountNumber) {
		// TODO Auto-generated method stub

		String getSummaryQuery = "select * from gr13_accounts where ga_account_number=" + customerAccountNumber;

		Account userAccount = jdbcTemplate.queryForObject(getSummaryQuery, new AccountMapper());

		return userAccount;
	}

	/**
	 * 
	 * @author Isaac Maria <isaac.maria@lntinfotech.com> It is used to store Account
	 *         Summary information
	 *
	 */
	class AccountMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int arg1) throws SQLException {
			Account user = new Account();

			user.setCustomer_id(rs.getLong(4));
			user.setAccount_number(rs.getLong(1));
			user.setBalance(rs.getFloat(2));
			user.setAccount_type(rs.getString(3));

			return user;
		}

	}

	/**
	 * 
	 * @author Isaac Maria <isaac.maria@lntinfotech.com> Profile Mapper is used to
	 *         fetch account details information
	 *
	 */
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
			user.setAddress_line_1(rs.getString(13));
			user.setAddress_line_2(rs.getString(14));
			user.setPin_code(rs.getString(15));
			user.setCity(rs.getString(16));
			user.setState(rs.getString(17));
			user.setAccount_number(rs.getLong(19));
			user.setAccount_type(rs.getString(21));
			user.setBalance(rs.getFloat(20));

			return user;
		}

	}

	/**
	 * 
	 * @author Isaac Maria <isaac.maria@lntinfotech.com> This mapper is used to
	 *         fetch the Internet Banking User Information in the user object
	 *
	 */
	class ChangeIdMapper implements RowMapper<InternetBankingUser> {
		public InternetBankingUser mapRow(ResultSet rs, int arg1) throws SQLException {
			InternetBankingUser user = new InternetBankingUser();

			user.setUser_id(rs.getString(1));

			return user;
		}

	}

	/**
	 * Returns Profile which is used to display Account Details
	 */
	public Profile getProfileDetails(long customerAccountNumber) {
		// TODO Auto-generated method stub

		Profile userDetails = new Profile();

		String getProfileQuery = "select * from gr13_customers c, gr13_addresses ad, gr13_accounts ac  where c.gc_customer_id = ad.gt_gc_customer_id  and c.gc_customer_id = ac.ga_gc_customer_id and GA_ACCOUNT_NUMBER="
				+ customerAccountNumber;

		userDetails = jdbcTemplate.queryForObject(getProfileQuery, new ProfileMapper());

		return userDetails;
	}

	/**
	 * Checks if the user id to be changed is correct
	 */
	public boolean checkUserId(long customerAccountNumber, String oldId) {

		String getUserIdQuery = "select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="
				+ customerAccountNumber + " and GIBU_USER_ID='" + oldId + "'";

		List<InternetBankingUser> users = jdbcTemplate.query(getUserIdQuery, new ChangeIdMapper());

		if (users.size() > 0)
			return true;

		return false;

	}

	/**
	 * Returns true if duplicate user id already exists, so that user cannot
	 * register for internet banking with the mentioned id
	 */
	public boolean checkDupliateId(String userId) {

		String getUserIdQuery = "select GIBU_USER_ID from gr13_internet_banking_users where GIBU_USER_ID='" + userId
				+ "'";

		List<InternetBankingUser> users = jdbcTemplate.query(getUserIdQuery, new ChangeIdMapper());

		if (users.size() > 0)
			return true;

		return false;

	}

	/**
	 * Returns true if the Login Password to be changed is correct
	 */
	public boolean checkLoginPassword(long customerAccountNumber, String oldPassword) {

		String getLoginPasswordQuery = "select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="
				+ customerAccountNumber + " and GIBU_LOGIN_PASSWORD='" + hash.getMd5(oldPassword) + "'";

		List<InternetBankingUser> users = jdbcTemplate.query(getLoginPasswordQuery, new ChangeIdMapper());

		if (users.size() > 0)
			return true;

		return false;

	}

	/**
	 * Returns true if the old transaction password is correct
	 */
	public boolean checkTransactionPassword(long customerAccountNumber, String oldPassword) {

		String getTransactionPasswordQuery = "select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="
				+ customerAccountNumber + " and GIBU_TRANSACTION_PASSWORD='" + hash.getMd5(oldPassword) + "'";

		List<InternetBankingUser> users = jdbcTemplate.query(getTransactionPasswordQuery, new ChangeIdMapper());

		if (users.size() > 0)
			return true;

		return false;

	}

	/**
	 * Return integer greater than zero if the User ID is successfully updated
	 */
	public int changeUserId(long customerAccountNumber, String newId) {

		String changeUserIdQuery = "update gr13_internet_banking_users set gibu_user_id='" + newId
				+ "' where GIBU_GA_ACCOUNT_NUMBER=" + customerAccountNumber;

		return jdbcTemplate.update(changeUserIdQuery);

	}

	/**
	 * Returns integer greater than zero if Login Password is successfully updated
	 */
	public int changeLoginPassword(long customerAccountNumber, String newPassword) {

		String changeLoginPasswordQuery = "update gr13_internet_banking_users set GIBU_LOGIN_PASSWORD='"
				+ hash.getMd5(newPassword) + "' where GIBU_GA_ACCOUNT_NUMBER=" + customerAccountNumber;

		return jdbcTemplate.update(changeLoginPasswordQuery);

	}

	/**
	 * Returns integer greater than zero if the transaction password is successfully
	 * updated
	 */
	public int changeTransactionPassword(long customerAccountNumber, String newPassword) {

		String changeLoginPasswordQuery = "update gr13_internet_banking_users set GIBU_TRANSACTION_PASSWORD='"
				+ hash.getMd5(newPassword) + "' where GIBU_GA_ACCOUNT_NUMBER=" + customerAccountNumber;

		return jdbcTemplate.update(changeLoginPasswordQuery);

	}

	/**
	 * This method is used to check if the account number is already registered with
	 * the internet banking facility Returns true if already registered, hence the
	 * user should not be allowed to register
	 */
	@Override
	public boolean verifyAccountNumber(InternetBankingUser ibu) {
		// TODO Auto-generated method stub

		String verifyAccountNumberQuery = "select GIBU_USER_ID from gr13_internet_banking_users where GIBU_GA_ACCOUNT_NUMBER="
				+ ibu.getAccount_number();

		List<InternetBankingUser> users = jdbcTemplate.query(verifyAccountNumberQuery, new ChangeIdMapper());

		if (users.size() > 0)
			return true;

		return false;

	}

}
