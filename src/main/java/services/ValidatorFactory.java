package services;

import interfaces.Validator;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class ValidatorFactory {

    public ValidationTask create(String path){
        Set<Validator> validators = new ValidatorFinder().findValidators(path);
        return new ValidationTask(validators, getMachineCode());
    }

    public String getMachineCode(){
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
