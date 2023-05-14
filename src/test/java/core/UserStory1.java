package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserStory1 {

    private Logger log = LogManager.getLogger("UserStory1");
    CoreFitech coreFitech = new CoreFitech(new File("").getAbsolutePath(), "Bicicleta1");

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void CA1(){
        log.warn("se ejecuta test de CA1 con dato de entrada: Tahiel");
        coreFitech.postValidationRequest("Tahiel");
        boolean isValidPerson = coreFitech.getResult();
        log.warn("result CA1: {}", isValidPerson);
        assertTrue(isValidPerson);
    }

    @Test
    public void CA2() {
        log.warn("se ejecuta test de CA2 - con dato de entrada: Evelyn");
        coreFitech.postValidationRequest("Evelyn");
        boolean notRoutine = coreFitech.getResult();
        log.warn("result CA2: {}", notRoutine);
        assertFalse(notRoutine);
    }

    @Test
    public void CA3() {
        log.warn("se ejecuta test de CA3 - con dato de entrada: '' ");
        coreFitech.postValidationRequest("");
        boolean invalidPerson = coreFitech.getResult();
        log.warn("result CA3: {}", invalidPerson);
        assertFalse(invalidPerson);
    }
}