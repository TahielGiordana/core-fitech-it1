import core.Core;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationEngine;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

public class UserStory1 {

    Core core = new Core(new File("").getAbsolutePath());
    ValidationEngine validationEngine = core.getValidatorManager();

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void CA1(){
        validationEngine.validate("Tahiel", "BicicletaFija");
        assertTrue(validationEngine.getValidationResult());
    }

    @Test
    public void CA2() {
        validationEngine.validate("personaInv", "BicicletaFija");
        assertFalse(validationEngine.getValidationResult());
    }
}
