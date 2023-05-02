package interfaces;

import pojos.Machine;
import pojos.Person;

public interface Validator {

	boolean validate(String username, String codeMachine);
}
