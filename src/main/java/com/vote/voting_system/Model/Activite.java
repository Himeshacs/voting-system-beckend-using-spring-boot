package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the activites database table.
 * 
 */
@Entity
@Table(name="activites")
@NamedQuery(name="Activite.findAll", query="SELECT a FROM Activite a")
public class Activite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String note;

	private String order;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	private String url;

	//bi-directional many-to-one association to RoleHasActivite
	@OneToMany(mappedBy="activite")
	private List<RoleHasActivite> roleHasActivites;

	public Activite() {
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

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RoleHasActivite> getRoleHasActivites() {
		return this.roleHasActivites;
	}

	public void setRoleHasActivites(List<RoleHasActivite> roleHasActivites) {
		this.roleHasActivites = roleHasActivites;
	}

	public RoleHasActivite addRoleHasActivite(RoleHasActivite roleHasActivite) {
		getRoleHasActivites().add(roleHasActivite);
		roleHasActivite.setActivite(this);

		return roleHasActivite;
	}

	public RoleHasActivite removeRoleHasActivite(RoleHasActivite roleHasActivite) {
		getRoleHasActivites().remove(roleHasActivite);
		roleHasActivite.setActivite(null);

		return roleHasActivite;
	}

}