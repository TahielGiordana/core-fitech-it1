package service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class RoutineConnectorService {

    public static JSONObject getRutina1(){
        File file = new File("");
        String pathFile = file.getAbsolutePath()+File.separator+"rutinas"+File.separator+"routine1.json";
        JSONParser parser = new JSONParser();
        JSONObject rutina = null;
        try {
            Object obj = parser.parse(new FileReader(pathFile));
            rutina = (JSONObject) obj;
        } catch (Exception e) {
            System.out.println("Error al leer datos de servicios externos");
        }
        return rutina;
    }
    

}
