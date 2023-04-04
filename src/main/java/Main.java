import org.json.simple.JSONObject;
import service.RoutineConnectorService;

public class Main {
    public static void main(String[] args){
        //prueba lectura archivo json, ver si hace falta implementar DTO
        JSONObject rutina1 = RoutineConnectorService.getRutina1();
        System.out.println("Consultando rutina de servicios externos");
        System.out.println("se obtiene: " + rutina1);
    }
}
