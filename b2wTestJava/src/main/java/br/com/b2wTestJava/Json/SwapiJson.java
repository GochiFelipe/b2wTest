package br.com.b2wTestJava.Json;

import java.util.List;

public class SwapiJson {
	
	private String next;
	
	private String previus;
	
	private List<PlanetJson> results;
	
	public SwapiJson() {}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevius() {
		return previus;
	}

	public void setPrevius(String previus) {
		this.previus = previus;
	}

	public List<PlanetJson> getResults() {
		return results;
	}

	public void setResults(List<PlanetJson> results) {
		this.results = results;
	}
	
}
