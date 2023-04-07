package validators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Routine> routines = this.routineFinder.findRoutines(person);
        final List<String>[] serialCodes = new List[]{new ArrayList<>()};
        if(!routines.isEmpty()){
            String serialCode = machine.getSerialCode();
            routines.forEach(routine -> {
                serialCodes[0] = routine.getMachineSerialCodes().stream().filter(code -> code.equalsIgnoreCase(serialCode)).collect(Collectors.toList());
            });
            //Validation logic
            return !serialCodes[0].isEmpty() && serialCodes[0].contains(serialCode);
        }else{
            System.out.println("No se encontro rutina para la persona ingresada");
            return false;
        }

    }
}