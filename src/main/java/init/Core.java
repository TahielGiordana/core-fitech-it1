package init;

import interfaces.Validator;
import services.ValidatorFinder;
import services.ValidatorSequence;

import java.io.File;
import java.util.Set;

public class Core{

    private final ValidatorSequence validatorSequence;

    public Core(String path){
        ValidatorFinder validatorFinder = new ValidatorFinder();
        Set<Validator> classes = validatorFinder.findValidatorsClasses(path);
        this.validatorSequence = new ValidatorSequence(classes);
    }


    public boolean validate(String userName, String machineCode){
        System.out.println("inicio con datos: "+ userName + "- maquina - " + machineCode);
        return this.validatorSequence.validate(userName, machineCode);
    }


    public static void main(String[] args) {

        File file = new File("");
        System.out.println("path del file en el main" + file.getAbsolutePath());
        Core core = new Core(file.getAbsolutePath() + "validators");
        core.validate("Tahiel", "BicicletaFija");

    }

}