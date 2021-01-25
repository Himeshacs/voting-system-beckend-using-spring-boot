package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the politicions_has_election database table.
 * 
 */
@Entity
@Table(name="politicions_has_election")
@NamedQuery(name="PoliticionsHasElection.findAll", query="SELECT p FROM PoliticionsHasElection p")
public class PoliticionsHasElection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="number_ele")
	private String numberEle;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to District
	@ManyToOne
	private District district;

	//bi-directional many-to-one association to Election
	@ManyToOne
	private Election election;

	//bi-directional many-to-one association to Politicion
	@ManyToOne
	@JoinColumn(name="politicions_id")
	private Politicion politicion;

	//bi-directional many-to-one association to Vote
	@OneToMany(mappedBy="politicionsHasElection")
	private List<Vote> votes;

	public PoliticionsHasElection() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberEle() {
		return this.numberEle;
	}

	public void setNumberEle(String numberEle) {
		this.numberEle = numberEle;
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

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Election getElection() {
		return this.election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public Politicion getPoliticion() {
		return this.politicion;
	}

	public void setPoliticion(Politicion politicion) {
		this.politicion = politicion;
	}

	public List<Vote> getVotes() {
		return this.votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public Vote addVote(Vote vote) {
		getVotes().add(vote);
		vote.setPoliticionsHasElection(this);

		return vote;
	}

	public Vote removeVote(Vote vote) {
		getVotes().remove(vote);
		vote.setPoliticionsHasElection(null);

		return vote;
	}

}