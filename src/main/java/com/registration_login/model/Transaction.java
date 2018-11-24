package com.registration_login.model;



public class Transaction {

	private int reference_id;
	private String type;
	private int amount;
	private int to_account;
	private String timestamp;
	private String remark;
	public int getReference_id() {
		return reference_id;
	}
	public void setReference_id(int reference_id) {
		this.reference_id = reference_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTo_account() {
		return to_account;
	}
	public void setTo_account(int to_account) {
		this.to_account = to_account;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Transaction [reference_id=" + reference_id + ", type=" + type + ", amount=" + amount + ", to_account="
				+ to_account + ", timestamp=" + timestamp + ", remark=" + remark + "]";
	}
	
	
	
	
	



	
	

}
