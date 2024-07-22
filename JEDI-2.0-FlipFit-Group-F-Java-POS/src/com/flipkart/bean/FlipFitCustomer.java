package com.flipkart.bean;
/**
 * The FlipFitCustomer class represents a customer in the FlipFit system.
 * It includes details such as weight, age, gender, customer name, phone, address, and customer ID.
 */
public class FlipFitCustomer{

    private int weight;
    private int age;
    private String gender;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private int customerId;
    /**
     * Constructor to initialize a FlipFitCustomer object with all fields.
     *
     * @param weight           the weight of the customer
     * @param age              the age of the customer
     * @param gender           the gender of the customer
     * @param customerName     the name of the customer
     * @param customerPhone    the phone number of the customer
     * @param customerAddress  the address of the customer
     * @param customerId       the unique identifier for the customer
     */
    public FlipFitCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerId = customerId;
    }
    /**
     * Returns a string representation of the customer object.
     * The string includes all the details of the customer.
     *
     * @return a string representation of the customer
     */
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
    /**
     * Gets the weight of the customer.
     *
     * @return the weight of the customer
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the customer.
     *
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets the age of the customer.
     *
     * @return the age of the customer
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the customer.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the gender of the customer.
     *
     * @return the gender of the customer
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the customer.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the phone number of the customer.
     *
     * @return the phone number of the customer
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param customerPhone the phone number to set
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of the customer
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the name of the customer.
     *
     * @param customerName the name to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the address of the customer.
     *
     * @return the address of the customer
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the address of the customer.
     *
     * @param customerAddress the address to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Gets the unique identifier for the customer.
     *
     * @return the unique identifier for the customer
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the unique identifier for the customer.
     *
     * @param customerId the unique identifier to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}