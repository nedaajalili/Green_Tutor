package it.polito.neda.dao;

import it.polito.neda.bean.UserBean;
import it.polito.neda.utilitiy.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

	public boolean createUser(UserBean u)
	{
		boolean result=false;

		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(u);

		 result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}

		return result;
	}

	public UserBean findUserByUsername(String username) {

		UserBean ubean=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from users where username=:username");
		query.setString("username", username);

		ubean=(UserBean) query.uniqueResult();


		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return ubean;

	}

	public UserBean findUserById(long id) {

		UserBean ubean=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from users where id_User=:id_User");
		query.setLong("id_User", id);

		ubean=(UserBean) query.uniqueResult();

		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return ubean;

	}

	@SuppressWarnings("unchecked")
	public List<UserBean> getAllUsers() {
		List<UserBean> utenti= new ArrayList<UserBean>();
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from users");
		utenti=(List<UserBean>)query.list();

		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return utenti;
	}


	public boolean updateUser(UserBean u) {

		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.update(u);
		result=true;

		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}

		return result;

	}

	public boolean deleteUser(UserBean u)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.delete(u);

		result =true;

		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
	}

}
