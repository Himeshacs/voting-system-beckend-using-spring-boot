package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the politicions database table.
 * 
 */
@Entity
@Table(name="politicions")
@NamedQuery(name="Politicion.findAll", query="SELECT p FROM Politicion p")
public class Politicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="otp_code")
	private String otpCode;

	@Column(name="reff_code")
	private String reffCode;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	//bi-directional many-to-one association to Team
	@ManyToOne
	private Team team;

	//bi-directional many-to-one association to PoliticionsHasElection
	@OneToMany(mappedBy="politicion")
	private List<PoliticionsHasElection> politicionsHasElections;

	public Politicion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOtpCode() {
		return this.otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public String getReffCode() {
		return this.reffCode;
	}

	public void setReffCode(String reffCode) {
		this.reffCode = reffCode;
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

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<PoliticionsHasElection> getPoliticionsHasElections() {
		return this.politicionsHasElections;
	}

	public void setPoliticionsHasElections(List<PoliticionsHasElection> politicionsHasElections) {
		this.politicionsHasElections = politicionsHasElections;
	}

	public PoliticionsHasElection addPoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		getPoliticionsHasElections().add(politicionsHasElection);
		politicionsHasElection.setPoliticion(this);

		return politicionsHasElection;
	}

	public PoliticionsHasElection removePoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		getPoliticionsHasElections().remove(politicionsHasElection);
		politicionsHasElection.setPoliticion(null);

		return politicionsHasElection;
	}

}