package it.polito.neda.controller;

import it.polito.neda.bean.UserBean;
import it.polito.neda.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

	private String username;
	private String password;
	@ManagedProperty(value="#{user}")
	private UserBean user;




	private boolean logged;
	private long id;
	private UserService userServices;

	public LoginController() {
		logged = false;
		userServices = new UserService();
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
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

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String doLogin() {
		UserBean u = userServices.getUser(this.username);
        String dest="/portal/userPortal?faces-redirect=true";
		if (u == null
				|| !u.getPassword().equals(
						userServices.convertPass(this.password))) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!","You're username or password isn't valid"));
			return "login";
		}

		userServices.fillBean(user,u);

		this.logged = true;

		setId(u.getId_User());



		return dest ;
	}



	public String doLogout() {
		this.logged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";

	}

}
