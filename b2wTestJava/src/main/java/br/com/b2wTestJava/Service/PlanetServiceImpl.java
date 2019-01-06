package br.com.b2wTestJava.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import br.com.b2wTestJava.Helper.SWApiHelper;
import br.com.b2wTestJava.Json.PlanetJson;
import br.com.b2wTestJava.Json.SwapiJson;
import br.com.b2wTestJava.Models.Planet;
import br.com.b2wTestJava.Preferences.SWApiPreference;
import br.com.b2wTestJava.Repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	PlanetRepository planetRepository;
	
	@Autowired
	MongoOperations mongoOperations;

	private Integer filmsSize;

	@Override
	@SuppressWarnings("unchecked")
	public void save(Planet planet) {

		List<String> planetsName = new ArrayList<String>();

		String planetsApi = SWApiHelper.getSWApi("https://swapi.co/api/planets/");
		List<Object> data = SWApiHelper.montListPlanets(planetsApi, planetsName);
		String next;
		next = ((SwapiJson) data.get(0)).getNext();

		if (((List<String>) data.get(1)).contains(planet.getName())) {
			List<PlanetJson> listPlanets = ((SwapiJson) data.get(0)).getResults();
			for (PlanetJson planetJson : listPlanets) {
				if (planetJson.getName().equals(planet.getName())) {
					filmsSize = planetJson.getFilms().size();
				}
				break;
			}
		} else {
			while (next != null) {
				String planetApiNext = SWApiHelper.getSWApi(next);
				data = SWApiHelper.montListPlanets(planetApiNext, planetsName);
				next = ((SwapiJson) data.get(0)).getNext();
				if (((List<String>) data.get(1)).contains(planet.getName())) {
					List<PlanetJson> listPlanets = ((SwapiJson) data.get(0)).getResults();
					for (PlanetJson planetJson : listPlanets) {
						if (planetJson.getName().equals(planet.getName())) {
							filmsSize = planetJson.getFilms().size();
							break;
						}
					}
					break;
				}
			}
		}
		if (planet.getId() != null) {
			
			SWApiPreference preference = new SWApiPreference();
								
			Planet planetFind = mongoOperations.findOne(preference.DocumentQueryUpdate(planet.getId()), Planet.class);
			planetFind.setName(planet.getName());
			planetFind.setClimate(planet.getClimate());
			planetFind.setTerrain(planet.getTerrain());
			planetFind.setFilms(filmsSize);
			planet = planetFind;
		} else {
			planet = new Planet(planet.getName(), planet.getClimate(), planet.getTerrain(), filmsSize);
		}
		mongoOperations.save(planet);
	}

	@Override
	public Planet findByName(String name) {
		return planetRepository.findByName(name);
	}

	@Override
	public List<Planet> listAll() {
		return planetRepository.findAll();
	}

	@Override
	public Optional<Planet> findById(String id) {
		return planetRepository.findById(id);
	}

	@Override
	public void deleteByName(String name) {
		planetRepository.deleteByName(name);
	}

	@Override
	public void deleteById(String id) {
		planetRepository.deleteById(id);
	}

}
