import interfaces.Validator;
import pojos.Machine;
import pojos.Person;
import pojos.Routine;
import validators.PaymentValidator;
import validators.RoutineValidator;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class InitCore {

    Set<Object> validatorsSet;

    public InitCore(Set<Object> validatorsSet){
        this.validatorsSet = validatorsSet;

    }

    public static Set<Object> findClasses() {
        Set<Object> result = new HashSet<>();
        File[] files = getFiles();
        if(files!=null && files.length > 0){
            for (File f : files) {
                if (f.getName().endsWith(".class")){
                    getClase(result, f);
                }
            }
        }
        System.out.println("Cantidad de clases instanciadas: "+ result.size());
        return result;
    }

    private static void getClase(Set<Object> result, File f) {
        String className = f.getName().substring(0, f.getName().lastIndexOf('.'));
        try {
            Class<?> cls = Class.forName("validators"+"."+className);
            System.out.println("clase: " + cls);
            if (!Validator.class.isAssignableFrom(cls)){
                System.out.println("no asignable");
            }else{
                result.add(cls.newInstance());
            }
        } catch (Exception e) {
            System.out.println("ocurrio un problema al instanciar las clases");;
        }
    }

    private static File[] getFiles() {
        File[] files = new File[0];
        try{
            File file = new File("");
            String path = file.getAbsolutePath()+File.separator+"build"+File.separator+"classes"+File.separator+"java"+File.separator+"main"+File.separator+"validators";
            System.out.println("path: " + path);
            files = new File(path).listFiles();
            assert files != null;
            System.out.println("cantidad de archivos listados: "+files.length);
        }catch(Exception e){
            System.out.println("no se pudo leer lista de archivos");
        }
        return files;
    }

    public Set<Object> getValidatorsSet() {
        return this.validatorsSet;
    }

    public static void main(String[] args) {

        Set<Object> classes = InitCore.findClasses();
        InitCore core = new InitCore(classes);

        for(Object obj: core.getValidatorsSet()){
            if(obj instanceof PaymentValidator){
                Person person1 =new Person("persona_1"
                        , true
                        ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
                Machine machine1 =new Machine("A2", "bicicleta");
                boolean validatePayment = ((PaymentValidator)obj).validate(person1,machine1);
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
        }
        
        /*Person person2 = new Person();
        Machine machine2 =new Machine("A2", "bicicleta");
        boolean validateMachine2 = core.routineValidator.validate(person2,machine2);
        System.out.println("tercer caso: " + validateMachine2);*/

    }


}