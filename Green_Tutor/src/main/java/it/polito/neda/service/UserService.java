package it.polito.neda.service;

import it.polito.neda.bean.UserBean;
import it.polito.neda.dao.UserDao;
import it.polito.neda.utilitiy.PasswordCodification;

public class UserService {

	 private UserDao uDao=new UserDao();


	 public boolean registerUser(UserBean u){
		 u.setPassword(convertPass(u.getPassword()));
		  return  uDao.createUser(u);
	 }

	 public String convertPass(String pass){
		 return PasswordCodification.codificatePass(pass);
	 }

	public UserBean getUser(String username) {

		return uDao.findUserByUsername(username);
	}

	public boolean updateUser(UserBean u) {

		return uDao.updateUser(u);
	}

	 public void fillBean(UserBean user,UserBean ub){
		 user.setId_User(ub.getId_User());
		 user.setKidAge(ub.getKidAge());
		 user.setKidGender(ub.getKidGender());
		 user.setKidName(ub.getKidName());
		 user.setUsername(ub.getUsername());
		 user.setDeviceMacAdress(ub.getDeviceMacAdress());
		 user.setPassword(ub.getPassword());
	 }

}
