package core;

import interfaces.Observer;
import services.ValidatorFinder;
import services.ValidationObservable;

import java.io.*;
import java.util.Properties;

public class CoreFitech {
    private ValidationObservable observableValidationEngine;

    public CoreFitech(String path) {
        ValidatorFinder validatorFinder = new ValidatorFinder();
        observableValidationEngine = new ValidationObservable(validatorFinder.findValidators(path), getMachineCode());
    }

    public void postValidationRequest(String userName){
        this.observableValidationEngine.runValidationTask(userName);
    }

    public boolean getResult(){
        return this.observableValidationEngine.getValidationResult();
    }

    public void subscribe(Observer observer){
        this.observableValidationEngine.addObserver(observer);
    }

    private String getMachineCode(){
        Properties properties = new Properties();
        String path = new File("").getAbsolutePath() + "/src/main/resources/application.properties";
        File file = new File(path);
        try (InputStream inputStream = new FileInputStream(file)) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  properties.getProperty("machineCode");
    }

}