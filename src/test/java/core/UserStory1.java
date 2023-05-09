package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserStory1 {

    private Logger log = LogManager.getLogger("UserStory1");
    /*private RoutineValidator validator;
    private RoutineFinder routineFinder;
    private Person joan;

    private Person tahiel;

    private Machine bike;*/

    @BeforeEach
    public void setUp() {
        /*routineFinder = mock(RoutineFinder.class);
        validator = new RoutineValidator(routineFinder);
        bike = new Machine("A2","Bike");*/
        log.warn("se ejecuta setUp de tests");
    }

    @Test
    public void CA1(){
        /*Routine joanRoutine = new Routine("excersice 1", bike);
        joan = new Person("persona_1",true,joanRoutine);
        when(routineFinder.getRoutineByPerson(joan)).thenReturn(joanRoutine);
        Boolean isValidMachine = validator.validate(joan, bike);
        assertTrue(isValidMachine);*/
        log.warn("se ejecuta test de CA1");
    }

    @Test
    public void CA2() {
        /*Routine tahielRoutine = new Routine("excersice 2", new Machine("B2","Press"));;
        tahiel = new Person("persona_2",true, tahielRoutine);
        when(routineFinder.getRoutineByPerson(tahiel)).thenReturn(tahielRoutine);
        Boolean isValidMachine = validator.validate(tahiel, bike);
        assertFalse(isValidMachine);*/

        log.warn("se ejecuta test de CA2");
    }
}