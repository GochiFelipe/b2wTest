package br.com.b2wTestJava.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.b2wTestJava.Json.PlanetJson;
import br.com.b2wTestJava.Json.SwapiJson;

public class bacalhau {

	private static List<String> planetsName = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		String planetsApi = getSWApi("https://swapi.co/api/planets/");
		SwapiJson data = montListPlanets(planetsApi);
		
		while (data.getNext() != null) {
			String planetApiNext = getSWApi(data.getNext());
			data = montListPlanets(planetApiNext);
		}
		
		System.out.println(planetsName);
	}

	private static SwapiJson montListPlanets(String planetsApi) {
		SwapiJson data = new Gson().fromJson(planetsApi, SwapiJson.class);
		
		for (PlanetJson planet : data.getResults()) {
			planetsName.add(planet.getName());
		}
		return data;
	}

	private static String getSWApi(String URL) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> planetsApi = restTemplate.exchange(URL, HttpMethod.GET,
				entity, String.class);
		return planetsApi.getBody();
	}

}
