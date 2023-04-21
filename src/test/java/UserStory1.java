import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojos.Machine;
import pojos.Person;
import pojos.Routine;
import services.RoutineFinder;
import validators.RoutineValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserStory1 {

    private RoutineValidator validator;
    private RoutineFinder routineFinder;
    private Person joan;

    private Person tahiel;

    private Machine bike;

    @BeforeEach
    public void setUp() {
        routineFinder = mock(RoutineFinder.class);
        validator = new RoutineValidator(routineFinder);
        bike = new Machine("A2","Bike");
    }

    @Test
    public void CA1(){
        Routine joanRoutine = new Routine("excersice 1", bike);
        joan = new Person("persona_1",true,joanRoutine);
        when(routineFinder.getRoutineByPerson(joan)).thenReturn(joanRoutine);
        Boolean isValidMachine = validator.validate(joan, bike);
        assertTrue(isValidMachine);
    }

    @Test
    public void CA2() {
        Routine tahielRoutine = new Routine("excersice 2", new Machine("B2","Press"));;
        tahiel = new Person("persona_2",true, tahielRoutine);
        when(routineFinder.getRoutineByPerson(tahiel)).thenReturn(tahielRoutine);
        Boolean isValidMachine = validator.validate(tahiel, bike);
        assertFalse(isValidMachine);
    }
}
