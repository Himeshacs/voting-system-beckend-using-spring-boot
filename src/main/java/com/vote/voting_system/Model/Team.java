package com.vote.voting_system.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private int status;

	//bi-directional many-to-one association to Politicion
	@OneToMany(mappedBy="team")
	private List<Politicion> politicions;

	public Team() {
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

	public List<Politicion> getPoliticions() {
		return this.politicions;
	}

	public void setPoliticions(List<Politicion> politicions) {
		this.politicions = politicions;
	}

	public Politicion addPoliticion(Politicion politicion) {
		getPoliticions().add(politicion);
		politicion.setTeam(this);

		return politicion;
	}

	public Politicion removePoliticion(Politicion politicion) {
		getPoliticions().remove(politicion);
		politicion.setTeam(null);

		return politicion;
	}

}