package validators;

import pojos.Machine;
import pojos.Person;

public interface Validator {
	   public boolean validate(Person person, Machine machine);
}
