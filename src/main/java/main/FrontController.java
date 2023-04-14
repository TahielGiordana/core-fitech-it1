package main;

import pojos.Machine;
import pojos.Person;
import services.RoutineFinder;
import validators.RoutineValidator;

public class FrontController {

    public static void main(String[] args) {
        //Person person = new Person("Joan", "Ene");
        Person person = new Person(args[0],args[1]);
        //Machine machine =new Machine("07569LK500IC0122", "Stationary Bike");
        Machine machine =new Machine(args[2], args[3]);
        FrontController frontController = new FrontController();
        boolean validateMachine = frontController.validateMachine(person, machine);
        System.out.println("Uso de Bicicleta Fija: " + validateMachine);
    }

    public boolean validateMachine(Person persona, Machine machine){
        RoutineValidator routineValidator = new RoutineValidator(new RoutineFinder());
        return routineValidator.validate(persona, machine);
    }
}