package criteriosAceptacionIteacion0;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pojos.Machine;
import pojos.Person;
import pojos.Routine;
import services.RoutineFinder;
import validators.RoutineValidator;
import java.util.*;

public class UserStory1 {

    private RoutineValidator validator;
    private RoutineFinder routineFinder;
    private Person mateo;
    private Machine stationaryBike;
    private List<Machine> machines;
    private Routine routine;
    @BeforeEach
    public void setUp() {
        routineFinder = mock(RoutineFinder.class);
        validator = new RoutineValidator(routineFinder);

        mateo = new Person("Mateo", "Gomez");
        stationaryBike  = new Machine("Stationary Bike","07569LK500IC0122");
        machines = new ArrayList<>();
        machines.add(stationaryBike);
        routine = new Routine();
        routine.setMachines(machines);
    }

    @Test
    public void criterio1(){
        assertFalse(validator.validate(null, stationaryBike));
    }

    @Test
    public void criterio2() {
        when(routineFinder.getRoutineByPerson(mateo)).thenReturn(null);
        assertFalse(validator.validate(mateo, stationaryBike));
    }

    @Test
    public void criterio3() {
        routine.setMachines(null);
        when(routineFinder.getRoutineByPerson(mateo)).thenReturn(routine);
        assertFalse(validator.validate(mateo, stationaryBike));
    }

    @Test
    public void criterio4() {
        when(routineFinder.getRoutineByPerson(mateo)).thenReturn(routine);
        assertTrue(validator.validate(mateo, stationaryBike));
    }

    /*@Test
    public void criterio5(){
        assertThrows(NullPointerException.class, () -> validator.validate(mateo, null));
    }*/
}