package interfaces;

import pojos.Machine;
import pojos.Person;

public interface Validator {

	boolean validate(Person person, Machine machine);
}
