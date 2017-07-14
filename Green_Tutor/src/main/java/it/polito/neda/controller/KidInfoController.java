package it.polito.neda.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.polito.neda.bean.UserBean;
import it.polito.neda.service.UserService;
@ManagedBean(name = "kidRegisterCtrl")
public class KidInfoController {

	private int age;
	private String name;
	private char gender;

	@ManagedProperty(value="#{user}")
	 private UserBean user;
     private UserService userServices=new UserService();

      public KidInfoController(){
    	  age=0;
    	  name="";
    	  gender=' ';
      }

     public String register() {
    		user.setKidAge(age);
     		user.setKidGender(gender);
     		user.setKidName(name);
     		userServices.updateUser(user);

     return "/portal/userPortal?faces-redirect=true";
 	}



	public String update(UserBean ub) {
		if(! ub.isValid()){

		}
//         UserBean uTempBean=userServices.getUser(ub.getUsername());

		user.setKidAge(ub.getKidAge());
		user.setKidGender(ub.getKidGender());
		user.setKidName(ub.getKidName());
		userServices.updateUser(user);


		return "/portal/userPortal?faces-redirect=true";
	}


	public void setUser(UserBean user) {
		this.user = user;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}

}
