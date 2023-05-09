package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationEngine;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserStory1 {

    private Logger log = LogManager.getLogger("UserStory1");
    Core core = new Core(new File("").getAbsolutePath());
    ValidationEngine validationEngine = core.getValidatorManager();


    @BeforeEach
    public void setUp() {

    }

    @Test
    public void CA1(){
        log.warn("se ejecuta test de CA1");
        validationEngine.validate("Tahiel", "Bicicleta1");
        assertTrue(validationEngine.getValidationResult());
    }

    @Test
    public void CA2() {
        log.warn("se ejecuta test de CA2");
        validationEngine.validate("personaInv", "Bicicleta1");
        assertFalse(validationEngine.getValidationResult());
    }
}