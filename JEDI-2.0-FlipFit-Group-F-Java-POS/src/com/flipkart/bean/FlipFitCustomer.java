package com.flipkart.bean;

public class FlipFitCustomer{

    private int weight;
    private int age;
    private String gender;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private int customerId;

    public FlipFitCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "-------------------------Customer Details-------------------------\n" +
                "Weight: " + weight + "\n" +
                "Age: " + age + "\n" +
                "Gender: '" + gender + '\'' + "\n" +
                "Customer name: '" + customerName + '\'' + "\n" +
                "Customer Phone: '" + customerPhone + '\'' + "\n" +
                "Customer Address: '" + customerAddress + '\'' + "\n" +
                "Customer Id: " + customerId + "\n" +
                "----------------------------------------------------------------\n";
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}