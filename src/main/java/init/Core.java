package init;

import interfaces.Validator;
import pojos.Machine;
import pojos.Person;
import pojos.Routine;
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


    public boolean executeValidators(Person person, Machine machine){
        System.out.println("inicio con datos: "+ person + "- maquina - " + machine);
        return this.validatorSequence.executeValidators(person, machine);
    }


    public static void main(String[] args) {

        File file = new File("");
        System.out.println("path del file en el main" + file.getAbsolutePath());
        Core core = new Core(file.getAbsolutePath() + "files");

        /*Person person1 =new Person("persona_1"
                , true
                ,new Routine("ejercicio_1", new Machine("A2", "bicicleta_1")));
        Machine machine1 =new Machine("A2", "bicicleta");


        boolean b = core.executeValidators(person1,machine1);

        System.out.println("resultado: " + b);*/

        /*
        *
        File pluginDir = new File("plugins");
        File[] pluginJars = pluginDir.listFiles((dir, name) -> name.endsWith(".jar"));

        // Cargamos la clase del plugin dinámicamente usando una instancia de URLClassLoader
        URLClassLoader classLoader = new URLClassLoader(new URL[]{pluginJars[0].toURI().toURL()});
        Class<?> pluginClass = classLoader.loadClass("com.myplugin.MyPlugin");

        // Instanciamos el plugin y ejecutamos su método
        Plugin plugin = (Plugin) pluginClass.newInstance();
        plugin.execute();
        *
        * */

    }


}