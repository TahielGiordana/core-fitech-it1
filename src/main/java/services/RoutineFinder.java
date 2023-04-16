package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import pojos.Person;
import pojos.Routine;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutineFinder {

	public Routine getRoutineByPerson(Person person) {
		Routine rutina = null;
		List<Person> search = this.search(person);
		if(search!=null && search.size() > 0){
			rutina = search.get(0).getRoutine()!=null?search.get(0).getRoutine():null;
		}
		System.out.println("Se retorna: " + rutina);
		return rutina;
	}

	private List<Person> search(Person person) {
		System.out.println("ejecutando busqueda de personas");
		List<Person> collect = new ArrayList<>();
		try {
			File file = new File("");
			String path = file.getAbsolutePath() + File.separator + "files" + File.separator + "Persons.json";
			JSONParser parser = new JSONParser();
			Object rawPersonas = parser.parse(new FileReader(path));
			ObjectMapper mapper = new ObjectMapper();
			List<Person> personasList = mapper.readValue(rawPersonas.toString(),mapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class));
			System.out.println("lista de personas " + personasList);
			collect = personasList.stream().filter(person1 -> person1.getUsername().equalsIgnoreCase(person.getUsername())).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collect;
	}
}
