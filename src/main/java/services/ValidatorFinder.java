package services;

import interfaces.Validator;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

public class ValidatorFinder {

    public ValidatorFinder() {
    }

    public Set<Validator> findValidatorsClasses(String path) {
        Set<Validator> result = new HashSet<>();
        File[] files = getFiles();
        if(files!=null){
            for (File f : files) {
                if (f.getName().endsWith(".jar")){
                    System.out.println("file " + f.getName());
                    getClase(result, f);
                }
            }
        }
        System.out.println("Cantidad de clases instanciadas: "+ result.size());
        return result;
    }

    private void getClase(Set<Validator> result, File f) {
        //String className = f.getName().substring(0, f.getName().lastIndexOf('.'));
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[]{f.toURI().toURL()});
            System.out.println("classLoader: " + classLoader.getClass());
            Class<?> pluginClass = classLoader.loadClass("validate.RoutineValidator");
            System.out.println("pluginClass: " + pluginClass);
            System.out.println(pluginClass);
           //Class<?> cls = Class.forName("validators"+"."+className);
            if (!Validator.class.isAssignableFrom(pluginClass)){
                System.out.println("no asignable");
            }else{
                System.out.println("puede asignarse");
                result.add((Validator) pluginClass.newInstance());
                //result.add(pluginClass);
            }
        } catch (Exception e) {
            System.out.println("ocurrio un problema al instanciar las clases");
        }
    }

    private File[] getFiles() {
        File[] files = new File[0];
        try{
            File file = new File("");
            System.out.println("path del file: " + file.getAbsolutePath());
            files = new File(file.getAbsolutePath()+File.separator+"files").listFiles();
            assert files != null;
            System.out.println("cantidad de archivos listados: "+files.length);
        }catch(Exception e){
            System.out.println("no se pudo leer lista de archivos");
        }
        return files;
    }
}
