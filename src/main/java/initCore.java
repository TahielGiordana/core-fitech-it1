import interfaces.Validator;
import pojos.Machine;
import pojos.Person;
import pojos.Routine;
import services.PaymentFinder;
import services.RoutineFinder;
import validators.PaymentValidator;
import validators.RoutineValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class initCore {

    RoutineValidator routineValidator;
    PaymentValidator paymentValidator;

    public initCore() {
        RoutineFinder routineFinder = new RoutineFinder();
        PaymentFinder paymentFinder = new PaymentFinder();
        this.routineValidator = new RoutineValidator(routineFinder);
        this.paymentValidator = new PaymentValidator(paymentFinder);
    }

    public static void main(String[] args) {
        initCore core = new initCore();

        Person person0 = new Person("persona_1"
                , true
                ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
        Machine machine0 =new Machine("A2", "bicicleta");

        boolean validateMachine0 = core.routineValidator.validate(person0,machine0);
        System.out.println("primer caso validateMachine: " + validateMachine0);


        Person person1 =new Person("persona_1"
                , true
                ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
        Machine machine1 =new Machine("A2", "bicicleta");
        boolean validatePayment = core.paymentValidator.validate(person1,machine1);
        System.out.println("segundo caso validatePayment: " + validatePayment);


        Person person2 = new Person();
        Machine machine2 =new Machine("A2", "bicicleta");
        boolean validateMachine2 = core.routineValidator.validate(person2,machine2);
        System.out.println("tercer caso: " + validateMachine2);
    }


}