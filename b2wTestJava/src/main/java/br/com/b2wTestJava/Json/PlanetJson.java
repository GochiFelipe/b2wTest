package br.com.b2wTestJava.Json;

import java.util.List;

public class PlanetJson {
	
	private String id = null;
	
	private String name = null;
	
	private String climate = null;
	
	private String terrain = null;
	
	private List<String> films = null;
	
	public PlanetJson() {}
	
	

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

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	
}
