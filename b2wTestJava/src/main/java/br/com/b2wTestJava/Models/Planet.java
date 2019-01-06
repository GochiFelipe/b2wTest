package br.com.b2wTestJava.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class Planet {
	
	@Id
	private String id = null;
	private String name = null;
	private String climate = null;
	private String terrain = null;
	private Integer films = null;
	
	public Planet() {}
	
	public Planet(String name, String climate, String terrain, Integer films) {
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
		this.films = films;
	}
	
	public Planet(String id, String name, String climate, String terrain, Integer films) {
		this.id = id;
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
		this.films = films;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Integer getFilms() {
		return films;
	}

	public void setFilms(Integer films) {
		this.films = films;
	}	
	
}
