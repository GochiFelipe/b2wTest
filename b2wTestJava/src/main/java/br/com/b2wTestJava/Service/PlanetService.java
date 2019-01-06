package br.com.b2wTestJava.Service;

import java.util.List;
import java.util.Optional;

import br.com.b2wTestJava.Models.Planet;

public interface PlanetService {

	void save(Planet planet);
	Planet findByName(String Name);
	List<Planet> listAll();
	Optional<Planet> findById(String id);
	void deleteByName(String name);
	void deleteById(String id);
	
}
