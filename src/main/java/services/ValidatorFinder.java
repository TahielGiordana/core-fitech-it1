package services;

import interfaces.Validator;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ValidatorFinder {

    public ValidatorFinder() {
    }

    public Set<Validator> findClasses() {
        Set<Validator> result = new HashSet<>();
        File[] files = getFiles();
        if(files!=null){
            for (File f : files) {
                if (f.getName().endsWith(".class")){
                    getClase(result, f);
                }
            }
        }
        System.out.println("Cantidad de clases instanciadas: "+ result.size());
        return result;
    }

    private void getClase(Set<Validator> result, File f) {
        String className = f.getName().substring(0, f.getName().lastIndexOf('.'));
        try {
            Class<?> cls = Class.forName("validators"+"."+className);
            System.out.println("clase: " + cls);
            if (!Validator.class.isAssignableFrom(cls)){
                System.out.println("no asignable");
            }else{
                result.add((Validator) cls.newInstance());
            }
        } catch (Exception e) {
            System.out.println("ocurrio un problema al instanciar las clases");
        }
    }

    private File[] getFiles() {
        File[] files = new File[0];
        try{
            File file = new File("");
            String path = file.getAbsolutePath()+File.separator+"validators";
            System.out.println("path: " + path);
            files = new File(path).listFiles();
            assert files != null;
            System.out.println("cantidad de archivos listados: "+files.length);
        }catch(Exception e){
            System.out.println("no se pudo leer lista de archivos");
        }
        return files;
    }
}
