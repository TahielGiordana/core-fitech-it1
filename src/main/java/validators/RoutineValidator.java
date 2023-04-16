package validators;

import interfaces.Validator;
import pojos.Machine;
import pojos.Person;
import pojos.Routine;
import services.RoutineFinder;

public class RoutineValidator implements Validator {

	private final RoutineFinder routineFinder;

	public RoutineValidator(RoutineFinder routineFinder) {
		this.routineFinder = routineFinder;
	}

	@Override
	public boolean validate(Person person, Machine machine) {
		Routine routineByPerson = this.routineFinder.getRoutineByPerson(person);
		return routineByPerson != null && routineByPerson.getMachine().getCode().equalsIgnoreCase(machine.getCode());
	}

}