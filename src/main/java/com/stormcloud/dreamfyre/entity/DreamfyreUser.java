package com.stormcloud.dreamfyre.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dreamfyre_user", schema = "pid")
public class DreamfyreUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	public DreamfyreUserPrimaryKey key;

	private String role;

	@Column(name = "source_id")
	private String sourceId;

	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "known_as")
	private String knownAs;

	private String email;

	@Column(name = "contact_phone_number")
	private String contactPhoneNumber;

	private String gender;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "welcome_mail_sent")
	private boolean welcomeMailSent;

	@Column(name = "time_first_login")
	private LocalDateTime timeFirstLogin;

	@Column(name = "time_updated")
	private LocalDateTime timeUpdated;

	@Column(name = "time_last_active")
	private LocalDateTime timeLastActive;

	@Column(name = "job_start_date")
	private LocalDate jobStartDate;

	@Column(name = "job_end_date")
	private LocalDate jobEndDate;

	@Column(name = "account_expiry_date")
	private LocalDate accountExpiryDate;

	@Column(name = "is_active_account")
	private boolean isActiveAccount;

	public DreamfyreUser() {
		super();
	}

	public DreamfyreUserPrimaryKey getKey() {
		return key;
	}

	public void setKey(DreamfyreUserPrimaryKey key) {
		this.key = key;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role));
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public boolean isWelcomeMailSent() {
		return welcomeMailSent;
	}

	public void setWelcomeMailSent(boolean welcomeMailSent) {
		this.welcomeMailSent = welcomeMailSent;
	}

	public LocalDateTime getTimeFirstLogin() {
		return timeFirstLogin;
	}

	public void setTimeFirstLogin(LocalDateTime timeFirstLogin) {
		this.timeFirstLogin = timeFirstLogin;
	}

	public LocalDateTime getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(LocalDateTime timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public LocalDateTime getTimeLastActive() {
		return timeLastActive;
	}

	public void setTimeLastActive(LocalDateTime timeLastActive) {
		this.timeLastActive = timeLastActive;
	}

	public LocalDate getJobStartDate() {
		return jobStartDate;
	}

	public void setJobStartDate(LocalDate jobStartDate) {
		this.jobStartDate = jobStartDate;
	}

	public LocalDate getJobEndDate() {
		return jobEndDate;
	}

	public void setJobEndDate(LocalDate jobEndDate) {
		this.jobEndDate = jobEndDate;
	}

	public LocalDate getAccountExpiryDate() {
		return accountExpiryDate;
	}

	public void setAccountExpiryDate(LocalDate accountExpiryDate) {
		this.accountExpiryDate = accountExpiryDate;
	}

	public boolean isActiveAccount() {
		return isActiveAccount;
	}

	public void setActiveAccount(boolean isActiveAccount) {
		this.isActiveAccount = isActiveAccount;
	}

	public DreamfyreUser(DreamfyreUserPrimaryKey key, String password, String firstName, String lastName,
			String middleName, String knownAs, String email, String contactPhoneNumber, String gender,
			LocalDate dateOfBirth) {
		super();
		this.key = key;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.knownAs = knownAs;
		this.email = email;
		this.contactPhoneNumber = contactPhoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "DreamfyreUser [key=" + key + ", sourceId=" + sourceId + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", knownAs=" + knownAs
				+ ", email=" + email + ", contactPhoneNumber=" + contactPhoneNumber + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", jobTitle=" + jobTitle + ", departmentName=" + departmentName
				+ ", welcomeMailSent=" + welcomeMailSent + ", timeFirstLogin=" + timeFirstLogin + ", timeUpdated="
				+ timeUpdated + ", timeLastActive=" + timeLastActive + ", jobStartDate=" + jobStartDate
				+ ", jobEndDate=" + jobEndDate + ", accountExpiryDate=" + accountExpiryDate + ", isActiveAccount="
				+ isActiveAccount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountExpiryDate == null) ? 0 : accountExpiryDate.hashCode());
		result = prime * result + ((contactPhoneNumber == null) ? 0 : contactPhoneNumber.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isActiveAccount ? 1231 : 1237);
		result = prime * result + ((jobEndDate == null) ? 0 : jobEndDate.hashCode());
		result = prime * result + ((jobStartDate == null) ? 0 : jobStartDate.hashCode());
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((knownAs == null) ? 0 : knownAs.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((timeFirstLogin == null) ? 0 : timeFirstLogin.hashCode());
		result = prime * result + ((timeLastActive == null) ? 0 : timeLastActive.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (welcomeMailSent ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DreamfyreUser other = (DreamfyreUser) obj;
		if (accountExpiryDate == null) {
			if (other.accountExpiryDate != null)
				return false;
		} else if (!accountExpiryDate.equals(other.accountExpiryDate))
			return false;
		if (contactPhoneNumber == null) {
			if (other.contactPhoneNumber != null)
				return false;
		} else if (!contactPhoneNumber.equals(other.contactPhoneNumber))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (isActiveAccount != other.isActiveAccount)
			return false;
		if (jobEndDate == null) {
			if (other.jobEndDate != null)
				return false;
		} else if (!jobEndDate.equals(other.jobEndDate))
			return false;
		if (jobStartDate == null) {
			if (other.jobStartDate != null)
				return false;
		} else if (!jobStartDate.equals(other.jobStartDate))
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (knownAs == null) {
			if (other.knownAs != null)
				return false;
		} else if (!knownAs.equals(other.knownAs))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (timeFirstLogin == null) {
			if (other.timeFirstLogin != null)
				return false;
		} else if (!timeFirstLogin.equals(other.timeFirstLogin))
			return false;
		if (timeLastActive == null) {
			if (other.timeLastActive != null)
				return false;
		} else if (!timeLastActive.equals(other.timeLastActive))
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (welcomeMailSent != other.welcomeMailSent)
			return false;
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
