package validators;

import java.util.List;

import pojos.Machine;
import pojos.Person;
import pojos.Routine;

public class RoutineValidator implements Validator {

	@Override
	public boolean validate(Person person, Machine machine) {
		
        Routine routine = person.getRoutine();
        String serialCode = machine.getSerialCode();
        List<String> machineSerialCodes = routine.getMachineSerialCodes();

        //Validation logic
        return machineSerialCodes.contains(serialCode);
	}
}