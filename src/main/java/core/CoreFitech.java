package core;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import services.ValidationTask;
import services.ValidatorFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoreFitech{
    private final ValidationTask validationTask;
    //private Map<String,Boolean> validationResult;

    //private Set<String> checkedValidators;

    public CoreFitech(String path, String machineCode) throws FileNotFoundException {
        //this.validationResult = new HashMap<>();
        //this.checkedValidators = new HashSet<>();
        //System.out.println("\u001B[31mCuando se inicia el Core isValid es: "+validationResult+"\u001B[0m");
        ValidatorFactory validatorFactory = new ValidatorFactory(path, machineCode);
        this.validationTask = validatorFactory.buildValidationTask();
    }

    /*public void checkValidator(String validatorName, boolean checked){
        if(checked){
            checkedValidators.add(validatorName);
        }else{
            checkedValidators.remove(validatorName);
        }
    }

    public Map<String,Boolean> getResult(){
        return this.validationResult;
    }*/

    public ValidationTask getValidationTask() {
        return this.validationTask;
    }

    /*@Override
    public void update() {
        Set<Validator> validators = validationTask.getValidators();
        Map<String,Boolean> result = new HashMap<>();
        for(Validator validator : validators){
            if(checkedValidators.contains(validator.getClass().getName())){
                if(validator.getResult() == null){
                    return;
                }else {
                    if(!validator.getResult()){
                        System.out.println("Falló el " + validator.getClass().getName());
                    }else{
                        System.out.println("Pasó el " + validator.getClass().getName());
                    }
                    result.put(validator.getClass().getName(),validator.getResult());
                }
            }else{
                System.out.println(validator.getClass().getName()+" No está en la lista a checkear");
            }
        }
        System.out.println("\u001B[31mEl resultado de Core era "+ validationResult + "y ahora es "+ result +"\u001B[0m");

        if(validationResult.isEmpty() || !validationResult.equals(result)){
            validationResult = result;
            System.out.println("\u001B[31mAsi que notifico a la UI\u001B[0m");
            notifyObservers();
        }
    }*/
}