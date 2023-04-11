package services;

import pojos.Person;
import pojos.Routine;

import java.util.Map;

public class RoutineFinder {

	public Routine getRoutineByPerson(Person person) {
		return RoutineMap.getRoutineMap().entrySet().stream()
				.filter(entry -> entry.getKey().getName().equals(person.getName()) && entry.getKey().getLastname().equals(person.getLastname()))
				.map(Map.Entry::getValue)
				.findFirst()
				.orElse(null);
	}
}
