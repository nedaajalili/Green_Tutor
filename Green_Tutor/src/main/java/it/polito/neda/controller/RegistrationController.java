package it.polito.neda.controller;

import it.polito.neda.bean.UserBean;
import it.polito.neda.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registerController")
@SessionScoped
public class RegistrationController {
   private UserService userService;
   private String password;
   private String username;
   private String deviceMacAdress;


	public String registerUser() {

		UserBean u=new UserBean();
		u.setDeviceMacAdress(deviceMacAdress);
		u.setPassword(password);
		u.setUsername(username);

		   userService.registerUser(u);

		return "login?faces-redirect=true";
	}


	public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}







	public String getDeviceMacAdress() {
	return deviceMacAdress;
}


public void setDeviceMacAdress(String deviceMacAdress) {
	this.deviceMacAdress = deviceMacAdress;
}


	public RegistrationController() {
		this.userService=new UserService();
   }





}
