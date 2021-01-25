package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the election database table.
 * 
 */
@Entity
@NamedQuery(name="Election.findAll", query="SELECT e FROM Election e")
public class Election implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="max_count")
	private String maxCount;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to PoliticionsHasElection
	@OneToMany(mappedBy="election")
	private List<PoliticionsHasElection> politicionsHasElections;

	public Election() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaxCount() {
		return this.maxCount;
	}

	public void setMaxCount(String maxCount) {
		this.maxCount = maxCount;
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

	public List<PoliticionsHasElection> getPoliticionsHasElections() {
		return this.politicionsHasElections;
	}

	public void setPoliticionsHasElections(List<PoliticionsHasElection> politicionsHasElections) {
		this.politicionsHasElections = politicionsHasElections;
	}

	public PoliticionsHasElection addPoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		getPoliticionsHasElections().add(politicionsHasElection);
		politicionsHasElection.setElection(this);

		return politicionsHasElection;
	}

	public PoliticionsHasElection removePoliticionsHasElection(PoliticionsHasElection politicionsHasElection) {
		getPoliticionsHasElections().remove(politicionsHasElection);
		politicionsHasElection.setElection(null);

		return politicionsHasElection;
	}

}