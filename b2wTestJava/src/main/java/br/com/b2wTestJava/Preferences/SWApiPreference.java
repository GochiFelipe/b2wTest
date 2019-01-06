package br.com.b2wTestJava.Preferences;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class SWApiPreference {
	
	public static final String RESULTS = "results";
	public static final String NAME = "name";
	public static final String CLIMATE = "climate";
	public static final String TERRAIN = "terrain";
	public static final String FILMS = "films";
	
	public Query DocumentQueryUpdate(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));		
		return query;
	}
	
}
