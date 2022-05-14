package com.devsuperior.dsmovie.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double valor;
	
	public Score() {
		
	}
	
	public void setMovie(Movie movie) {
		this.id.setMovie(movie);
	}
	
	public void setUser(User user) {
		this.id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return valor;
	}

	public void setValue(Double value) {
		this.valor = value;
	}
	
	

}
