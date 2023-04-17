package init;

import interfaces.Validator;
import pojos.Machine;
import pojos.Person;
import pojos.Routine;
import services.ValidatorFinder;
import services.ValidatorSequence;

import java.util.Set;

public class InitCore {

    private final ValidatorSequence validatorSequence;

    public InitCore(){
        ValidatorFinder validatorFinder = new ValidatorFinder();
        Set<Validator> classes = validatorFinder.findClasses();
        this.validatorSequence = new ValidatorSequence(classes);
    }


    public boolean executeValidators(Person person, Machine machine){
        return this.validatorSequence.executeValidators(person, machine);
    }


    public static void main(String[] args) {

        InitCore core = new InitCore();

        Person person1 =new Person("persona_1"
                , true
                ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
        Machine machine1 =new Machine("A2", "bicicleta");


        boolean b = core.executeValidators(person1,machine1);

        System.out.println("se corren todos los validadores disponibles: " + b);

        /*for(Validator obj: core.getValidators()){
            if(obj instanceof PaymentValidator){
                Person person1 =new Person("persona_1"
                        , true
                        ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
                Machine machine1 =new Machine("A2", "bicicleta");
                boolean validatePayment = ((Validator)obj).validate(person1,machine1);
                System.out.println("segundo caso validatePayment: " + validatePayment);
            }
            if(obj instanceof RoutineValidator){
                Person person0 = new Person("persona_1"
                        , true
                        ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
                Machine machine0 =new Machine("A2", "bicicleta");

                boolean validateMachine0 = ((RoutineValidator)obj).validate(person0,machine0);
                System.out.println("primer caso validateMachine: " + validateMachine0);
            }
        }*/
        
        /*Person person2 = new Person();
        Machine machine2 =new Machine("A2", "bicicleta");
        boolean validateMachine2 = core.routineValidator.validate(person2,machine2);
        System.out.println("tercer caso: " + validateMachine2);*/

    }


}