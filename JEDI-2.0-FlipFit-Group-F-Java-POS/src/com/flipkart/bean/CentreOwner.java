package com.flipkart.bean;

public class CentreOwner {
	
	private int owner_id;
	private String owner_name;
	private int owner_contact;
	private String owner_email;
	private String password;
	private String id_proof;
	
	public CentreOwner(int owner_id, String owner_name, int owner_contact, String owner_email, String password,
			String id_proof) {
		super();
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.owner_contact = owner_contact;
		this.owner_email = owner_email;
		this.setPassword(password);
		this.id_proof = id_proof;
	}
	
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public int getOwner_contact() {
		return owner_contact;
	}
	public void setOwner_contact(int owner_contact) {
		this.owner_contact = owner_contact;
	}
	public String getOwner_email() {
		return owner_email;
	}
	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}
	public String getId_proof() {
		return id_proof;
	}
	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
