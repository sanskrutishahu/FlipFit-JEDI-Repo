package com.flipkart.bean;

public class CentreDetails {
	
    private int Centre_Id;
    private int Centre_Owner_Id;
    private String Centre_Name;
    private String Address;
    private int No_Of_Slots;
    private int Approval_Status;
    
    public CentreDetails(int centre_Id, int centre_Owner_Id, String centre_Name, String address, int no_Of_Slots,
			int approval_Status) {
		super();
		Centre_Id = centre_Id;
		Centre_Owner_Id = centre_Owner_Id;
		Centre_Name = centre_Name;
		Address = address;
		No_Of_Slots = no_Of_Slots;
		Approval_Status = approval_Status;
	}
	public int getCentre_Id(){
        return Centre_Id;
    }
    public void setCentre_Id(int Centre_Id) {
        this.Centre_Id = Centre_Id;
    }
    public int getCentre_Owner_Id(){
        return Centre_Owner_Id;
    }
    public void setCentre_Owner_Id(int Centre_Owner_Id) {
        this.Centre_Owner_Id= Centre_Owner_Id;
    }

    public String getCentre_Name(){
        return Centre_Name;
    }
    public void setCentre_Name(String Centre_Name) {
        this.Centre_Name = Centre_Name;
    }
    public String getAddress(){
        return Address;
    }
    public void setCentre_Id(String Address) {
        this.Address= Address;
    }
    public int getNo_Of_Slots(){
        return No_Of_Slots;
    }
    public void setNo_Of_Slots(int No_Of_Slots) {
        this.No_Of_Slots = No_Of_Slots;
    }
    public int getApproval_Status(){
        return Approval_Status;
    }
    public void setApproval_Status(int Approval_Status) {
        this.Approval_Status = Approval_Status;
    }
    
}
