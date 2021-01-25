package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String add1;

	private String add2;

	private String add3;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String fax;

	private String fname;

	private String lname;

	private String mname;

	private String mobile1;

	private String mobile2;

	private String nic;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to Citizen
	@OneToMany(mappedBy="person")
	private List<Citizen> citizens;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="person")
	private List<Login> logins;

	//bi-directional many-to-one association to Politicion
	@OneToMany(mappedBy="person")
	private List<Politicion> politicions;

	public Person() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdd1() {
		return this.add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return this.add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return this.add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMobile1() {
		return this.mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return this.mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getNic() {
		return this.nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
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

	public List<Citizen> getCitizens() {
		return this.citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	public Citizen addCitizen(Citizen citizen) {
		getCitizens().add(citizen);
		citizen.setPerson(this);

		return citizen;
	}

	public Citizen removeCitizen(Citizen citizen) {
		getCitizens().remove(citizen);
		citizen.setPerson(null);

		return citizen;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setPerson(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setPerson(null);

		return login;
	}

	public List<Politicion> getPoliticions() {
		return this.politicions;
	}

	public void setPoliticions(List<Politicion> politicions) {
		this.politicions = politicions;
	}

	public Politicion addPoliticion(Politicion politicion) {
		getPoliticions().add(politicion);
		politicion.setPerson(this);

		return politicion;
	}

	public Politicion removePoliticion(Politicion politicion) {
		getPoliticions().remove(politicion);
		politicion.setPerson(null);

		return politicion;
	}

}