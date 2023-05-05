package services;

import interfaces.Validator;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ValidatorFinder {

    public ValidatorFinder() {
    }

    public Set<Validator> findValidators(String path) {
        Set<Validator> result = new HashSet<>();
        File[] files = getFiles();
        if(files!=null){
            for (File f : files) {
                if (f.getName().endsWith(".jar")){
                    System.out.println("file " + f.getName());
                    getValidator(result, f);
                }
            }
        }
        System.out.println("Cantidad de clases instanciadas: "+ result.size());
        return result;
    }

    private void getValidator(Set<Validator> result, File f) {
        try{
            JarFile jar = new JarFile(f);
            Enumeration<JarEntry> entries = jar.entries();

            URLClassLoader classLoader = new URLClassLoader(new URL[]{f.toURI().toURL()});

            List<Class<?>> classes = new ArrayList<>();

            while(entries.hasMoreElements()){
                JarEntry jarEntry = entries.nextElement();
                if(jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")){
                    continue;
                }
                String className = jarEntry.getName().substring(0,jarEntry.getName().length()-6);
                className = className.replace('/','.');
                classes.add( classLoader.loadClass(className));
            }
            System.out.println("Lista de Clases Encontradas:\n  " + classes);

            classes.forEach(possibleValidator -> {
                if (!Validator.class.isAssignableFrom(possibleValidator) || possibleValidator.isInterface()){
                    System.out.println(possibleValidator + " No asignable");
                }else{
                    System.out.println(possibleValidator + " Asignable");
                    try {
                        result.add((Validator) possibleValidator.newInstance());
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Ocurrió un problema al instanciar las clases");
        }
    }

    private File[] getFiles() {
        File[] files = new File[0];
        try{
            File file = new File("");
            System.out.println("path del file: " + file.getAbsolutePath());
            files = new File(file.getAbsolutePath()+File.separator+"validators").listFiles();
            assert files != null;
            System.out.println("cantidad de archivos listados: "+files.length);
        }catch(Exception e){
            System.out.println("no se pudo leer lista de archivos");
        }
        return files;
    }
}
