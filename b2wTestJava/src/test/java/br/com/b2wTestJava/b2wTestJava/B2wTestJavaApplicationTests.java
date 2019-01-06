package br.com.b2wTestJava.b2wTestJava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.b2wTestJava.Models.Planet;
import br.com.b2wTestJava.Service.PlanetService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class B2wTestJavaApplicationTests {
	
	@Autowired
	PlanetService planetService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void PlanetsServiceSaveTest() {
		Planet planet = new Planet("Alderaan", "temperate", "grasslands, mountains", null);
		planetService.save(planet);
		
		Planet foundPlanet = planetService.findByName(planet.getName());
		
		assertEquals(foundPlanet.getName(), planet.getName());
		assertEquals(foundPlanet.getClimate(), planet.getClimate());
		assertEquals(foundPlanet.getTerrain(), planet.getTerrain());
		
		Planet planetPage5 = new Planet("Iridonia", "unknown", "rocky canyons, acid pools", null);
		planetService.save(planetPage5);
		
		Planet foundPlanetPage5 = planetService.findByName(planetPage5.getName());
		
		assertEquals(foundPlanetPage5.getName(), planetPage5.getName());
		assertEquals(foundPlanetPage5.getClimate(), planetPage5.getClimate());
		assertEquals(foundPlanetPage5.getTerrain(), planetPage5.getTerrain());
		
		Planet planetPage7 = new Planet("Jakku", "unknown", "deserts", null);
		planetService.save(planetPage7);
		
		Planet foundPlanetPage7 = planetService.findByName(planetPage7.getName());
		
		assertEquals(foundPlanetPage7.getName(), planetPage7.getName());
		assertEquals(foundPlanetPage7.getClimate(), planetPage7.getClimate());
		assertEquals(foundPlanetPage7.getTerrain(), planetPage7.getTerrain());
		
	}

}

