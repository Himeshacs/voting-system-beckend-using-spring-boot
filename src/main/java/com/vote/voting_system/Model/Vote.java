package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vote database table.
 * 
 */
@Entity
@NamedQuery(name="Vote.findAll", query="SELECT v FROM Vote v")
public class Vote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="citizens_id")
	private Citizen citizen;

	//bi-directional many-to-one association to PoliticionsHasElection
	@ManyToOne
	@JoinColumn(name="politicions_has_election_id")
	private PoliticionsHasElection politicionsHasElection;

	public Vote() {
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

	public Citizen getCitizen() {
		return this.citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public PoliticionsHasElection getPoliticionsHasElection() {
		return this.politicionsHasElection;
	}

	public void setPoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		this.politicionsHasElection = politicionsHasElection;
	}

}