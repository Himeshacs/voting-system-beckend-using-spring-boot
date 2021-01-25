package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the district database table.
 * 
 */
@Entity
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private int status;

	//bi-directional many-to-one association to Citizen
	@OneToMany(mappedBy="district")
	private List<Citizen> citizens;

	//bi-directional many-to-one association to PoliticionsHasElection
	@OneToMany(mappedBy="district")
	private List<PoliticionsHasElection> politicionsHasElections;

	public District() {
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
		citizen.setDistrict(this);

		return citizen;
	}

	public Citizen removeCitizen(Citizen citizen) {
		getCitizens().remove(citizen);
		citizen.setDistrict(null);

		return citizen;
	}

	public List<PoliticionsHasElection> getPoliticionsHasElections() {
		return this.politicionsHasElections;
	}

	public void setPoliticionsHasElections(List<PoliticionsHasElection> politicionsHasElections) {
		this.politicionsHasElections = politicionsHasElections;
	}

	public PoliticionsHasElection addPoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		getPoliticionsHasElections().add(politicionsHasElection);
		politicionsHasElection.setDistrict(this);

		return politicionsHasElection;
	}

	public PoliticionsHasElection removePoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		getPoliticionsHasElections().remove(politicionsHasElection);
		politicionsHasElection.setDistrict(null);

		return politicionsHasElection;
	}

}