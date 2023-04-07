package services;

import pojos.Person;
import pojos.Routine;

import java.util.*;
import java.util.stream.Collectors;

public class DatosDummy {
    public static List<Routine> getRutinasByPerson(Person person){
        List<Routine> rutinas = new ArrayList<>();
        rutinas.add(new Routine("rutina_a", Arrays.asList("A1","A2")));
        rutinas.add(new Routine("rutina_b", Arrays.asList("A3","A7")));
        rutinas.add(new Routine("rutina_c", Arrays.asList("A3","A3")));
        rutinas.add(new Routine("rutina_d", Arrays.asList("A6","A1")));
        return rutinas.stream().filter(routine -> routine.equals(person.getRoutine())).collect(Collectors.toList());
    }
}
