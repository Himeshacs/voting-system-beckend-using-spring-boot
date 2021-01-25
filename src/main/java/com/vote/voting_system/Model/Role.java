package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="roleBean")
	private List<Login> logins;

	//bi-directional many-to-one association to RoleHasActivite
	@OneToMany(mappedBy="role")
	private List<RoleHasActivite> roleHasActivites;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setRoleBean(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setRoleBean(null);

		return login;
	}

	public List<RoleHasActivite> getRoleHasActivites() {
		return this.roleHasActivites;
	}

	public void setRoleHasActivites(List<RoleHasActivite> roleHasActivites) {
		this.roleHasActivites = roleHasActivites;
	}

	public RoleHasActivite addRoleHasActivite(RoleHasActivite roleHasActivite) {
		getRoleHasActivites().add(roleHasActivite);
		roleHasActivite.setRole(this);

		return roleHasActivite;
	}

	public RoleHasActivite removeRoleHasActivite(RoleHasActivite roleHasActivite) {
		getRoleHasActivites().remove(roleHasActivite);
		roleHasActivite.setRole(null);

		return roleHasActivite;
	}

}