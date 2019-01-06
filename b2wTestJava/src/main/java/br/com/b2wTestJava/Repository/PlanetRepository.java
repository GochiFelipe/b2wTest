package br.com.b2wTestJava.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.b2wTestJava.Models.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String>{

	Planet findByName();

	Planet findByName(String name);
	
	void deleteByName(String name);

}
