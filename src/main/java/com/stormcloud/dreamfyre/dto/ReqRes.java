package com.stormcloud.dreamfyre.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stormcloud.dreamfyre.entity.DreamfyreUser;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    
    private String error;
    
    private String message;
    
    private String token;
    
    private String refreshToken;
    
    private String expirationTime;
    
    private String role;
   
    private String email;
    
    private String password;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
	private String lastName;

	@JsonProperty("middle_name")
	private String middleName;

	@JsonProperty("known_as")
	private String knownAs;

	@JsonProperty("contact_phone_number")
	private String contactPhoneNumber;

	private String gender;

	@JsonProperty("date_of_birth")
	private LocalDate dateOfBirth;
	
    private DreamfyreUser ourUsers;
    private List<DreamfyreUser> ourUsersList;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getKnownAs() {
		return knownAs;
	}
	public void setKnownAs(String knownAs) {
		this.knownAs = knownAs;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DreamfyreUser getOurUsers() {
		return ourUsers;
	}
	public void setOurUsers(DreamfyreUser ourUsers) {
		this.ourUsers = ourUsers;
	}
	public List<DreamfyreUser> getOurUsersList() {
		return ourUsersList;
	}
	public void setOurUsersList(List<DreamfyreUser> ourUsersList) {
		this.ourUsersList = ourUsersList;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
