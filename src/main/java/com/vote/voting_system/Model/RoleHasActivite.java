package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the role_has_activites database table.
 * 
 */
@Entity
@Table(name="role_has_activites")
@NamedQuery(name="RoleHasActivite.findAll", query="SELECT r FROM RoleHasActivite r")
public class RoleHasActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	@Lob
	private String token;

	//bi-directional many-to-one association to Activite
	@ManyToOne
	@JoinColumn(name="activites_id")
	private Activite activite;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public RoleHasActivite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Activite getActivite() {
		return this.activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}