package Airports;

import java.io.Serializable;

/**
 * Person class represents all the people of the program
 * AirportStuff, flightCrew and passenger is a Person
 */
public class Person implements Serializable {

    private String ssn;
    private String name;
    private String lastName;
    private String address;
    private String phone;

    /**
    * Costructor of the class
    * Creates a person with the specified ssn, name, last name, address and phone
    * @param ssn The ssn of person. It's unique for each person
    * @param name The first name of person
    * @param lastName The last name of person
    * @param address The address of person
    * @param phone The phone of person
    */
    public Person(String ssn, String name, String lastName, String address, String phone) {
        this.ssn = ssn;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Sets the ssn of the person
     * @param ssn String containing the ssn of the person
     */
    public void setSSN(String ssn) {
	this.ssn = ssn;
    }

    /**
     * Gets the ssn of the person
     * @return String representing the ssn of the person
     */
    public String getSSN() {
	return ssn;
    }

    /**
     * Sets the first name of the person
     * @param name String containing the first name of the person
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the first name of the person
     * @return String representing the first name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the last name of the person
     * @param lastName String containing the last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the last name of the person
     * @return String representing the last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the address of the person
     * @param address String containing the address of the person
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the address of the person
     * @return String representing the address of the person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the phone of the person
     * @param phone String containing the phone of the person
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the phone of the person
     * @return String representing the phone of the person
     */
    public String getPhone() {
	return phone;
    }

    /**
     * Gets the full name of the person
     * @return String representing the full name of the person
     */
    public String getFullName() {
        return getName() + " " + getLastName();
    }
}
