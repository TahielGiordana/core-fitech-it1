import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Core.Core;
import services.ValidationEngine;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.File;

public class UserStory1 {

    Core core = new Core(new File("").getAbsolutePath());
    ValidationEngine validationEngine = core.getValidatorManager();

    @BeforeEach
    public void setUp() {
        //routineFinder = mock(RoutineFinder.class);
        //validator = new RoutineValidator(routineFinder);
        //bike = new Machine("A2","Bike");
    }

    @Test
    public void CA1(){
        /*
        Routine joanRoutine = new Routine("excersice 1", bike);
        joan = new Person("persona_1",true,joanRoutine);
        when(routineFinder.getRoutineByPerson(joan)).thenReturn(joanRoutine);
        Boolean isValidMachine = validator.validate(joan, bike);
        assertTrue(isValidMachine);
        */
        validationEngine.validate("Tahiel", "BicicletaFija");
        assertTrue(validationEngine.getValidationResult());
    }

    @Test
    public void CA2() {
        /*
        Routine tahielRoutine = new Routine("excersice 2", new Machine("B2","Press"));;
        tahiel = new Person("persona_2",true, tahielRoutine);
        when(routineFinder.getRoutineByPerson(tahiel)).thenReturn(tahielRoutine);
        Boolean isValidMachine = validator.validate(tahiel, bike);
        assertFalse(isValidMachine);
        */
        validationEngine.validate("personaInv", "BicicletaFija");
        assertFalse(validationEngine.getValidationResult());
    }
}
