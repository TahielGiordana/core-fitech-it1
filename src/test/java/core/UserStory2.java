package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserStory2 {

    private Logger log = LogManager.getLogger("UserStory2");


    @BeforeEach
    public void setUp() {

    }

    @Test
    public void CA1(){
        log.warn("se ejecuta test de CA1");

    }

    @Test
    public void CA2() {
        log.warn("se ejecuta test de CA2");
    }
}