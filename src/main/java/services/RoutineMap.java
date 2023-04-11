package services;

import pojos.Machine;
import pojos.Person;
import pojos.Routine;

import java.util.*;

public class RoutineMap {

    private static Map<Person, Routine> routineMap = new HashMap<>();

    static {
        // Se llena el map con las rutinas de cada persona
        routineMap.put(new Person("Antonio", "Liendro"), new Routine("Rutina Dia 1", Arrays.asList(new Machine("07569LK500IC0122", "Stationary Bike"), new Machine("08569ST500LC0322", "Elliptical"))));
        routineMap.put(new Person("Joan", "Ene"), new Routine("Rutina Dia 3", Arrays.asList(new Machine("07569LK500IC0122", "Stationary Bike"), new Machine("07969ER500IF1222", "Leg Press"))));
        routineMap.put(new Person("Evelin", "Aragon"), new Routine("Rutina Dia 4", Arrays.asList(new Machine("09569WZ500IC0322", "Chess Press"), new Machine("04569XZ500IF0322", "Row Machine"))));
        routineMap.put(new Person("Tahiel", "Giordana"), new Routine("Rutina Dia 2",Arrays.asList(new Machine("08569ST500LC0322", "Elliptical"), new Machine("09569WZ500IC0322", "Chess Press"))));
    }

    public static Map<Person, Routine> getRoutineMap() {
        return routineMap;
    }
}
