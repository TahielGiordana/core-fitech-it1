package core;

//java
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//custom imports
import interfaces.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;



public class UserStory2 {

    private final Logger log = LogManager.getLogger("UserStory2");


    @BeforeEach
    public void setUp() {

    }

    @Test
    public void CA1(){
        log.warn("se ejecuta test de CA1");
        FileNotFoundException fileNotFoundException = assertThrows(FileNotFoundException.class, () -> {
            new CoreFitech("", "Bicicleta1");
        });

        log.warn("mensaje de error CA1: {} ", fileNotFoundException.getMessage());
    }


    @Test
    public void CA2() {
        log.warn("se ejecuta test de CA2");
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            new CoreFitech("\\videos", "Bicicleta1");
        });

        log.warn("mensaje de error CA2: {} ", illegalArgumentException.getMessage());
    }

    @Test
    public void CA3() throws FileNotFoundException {
        log.warn("se ejecuta test de CA3");
        CoreFitech coreFitech = new CoreFitech(new File("emptyFolder").getAbsolutePath(), "Bicicleta1");
        Set<Validator> validators = coreFitech.getValidationTask().getValidators();
        assertTrue(validators.isEmpty());
        log.warn("cantidad de validators: {}", validators);

    }
}