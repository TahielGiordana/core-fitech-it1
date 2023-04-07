package services;

import pojos.Person;
import pojos.Routine;

import java.util.List;

public class RoutineFinder {

    public List<Routine> findRoutines(Person person){
        return DatosDummy.getRutinasByPerson(person);
    }
}
