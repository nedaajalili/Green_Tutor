package it.polito.neda.bean;

import it.polito.neda.dao.UserDao;
import it.polito.neda.service.UserService;

public class MainProva {

	public static void main(String[] args) {


		UserService s=new UserService();
		UserDao uDao=new UserDao();

//		UserBean a=new UserBean();
//		a.setUsername("aaaaa");
//		a.setPassword("aaaa");
//		s.registerUser(a);
////
   	System.out.println(uDao.findUserByUsername("ff").getDeviceMacAdress());


}

	}

