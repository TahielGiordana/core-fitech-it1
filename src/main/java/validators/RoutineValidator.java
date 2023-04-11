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

	// Metodo para validar si la maquina esta dentro de la rutina
	@Override
	public boolean validate(Person person, Machine machine) {
		Routine routine = routineFinder.getRoutineByPerson(person);

		if (routine != null && routine.getMachines() != null) {
			return routine.getMachines().stream().anyMatch(m -> m.getSerialCode().equals(machine.getSerialCode()));
		}
		return false;
	}
}