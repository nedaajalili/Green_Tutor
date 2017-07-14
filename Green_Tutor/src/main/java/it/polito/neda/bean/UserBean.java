package it.polito.neda.bean;

import it.polito.neda.utilitiy.CheckValues;
import it.polito.neda.utilitiy.IsValid;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@Entity(name="users")
@ManagedBean(name = "user", eager = true)
@SessionScoped
public class UserBean implements Serializable, IsValid {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_User;

	private String kidName;
	private int kidAge;
	private char kidGender;
	private String deviceMacAdress;
	@Column(unique = true)
	private String username;
	private String password;

	public UserBean() {

	}

	public UserBean( String kidName, int kidAge,
			char kidGender, String deviceMacAdress, String username,
			String password) {
		super();

		this.kidName = kidName;
		this.kidAge = kidAge;
		this.kidGender = kidGender;
		this.deviceMacAdress = deviceMacAdress;
		this.username = username;
		this.password = password;
	}


	public long getId_User() {
		return id_User;
	}


	public void setId_User(long id_User) {
		this.id_User = id_User;
	}


   public String getKidName() {
		return kidName;
	}


	public void setKidName(String kidName) {
		this.kidName = kidName;
	}


	public int getKidAge() {
		return kidAge;
	}


	public void setKidAge(int kidAge) {
		this.kidAge = kidAge;
	}


	public char getKidGender() {
		return kidGender;
	}


	public void setKidGender(char kidGender) {
		this.kidGender = kidGender;
	}


	public String getDeviceMacAdress() {
		return deviceMacAdress;
	}


	public void setDeviceMacAdress(String deviceMacAdress) {
		this.deviceMacAdress = deviceMacAdress;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public boolean isValid() {
		return (CheckValues.checkString(kidName)
				  && kidAge!=0);
	}

}
