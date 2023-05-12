package services;

import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ValidatorFinder {

    private Logger log = LogManager.getLogger("ValidatorFinder");


    public ValidatorFinder() {
    }

    public Set<Validator> findValidators(String path) {
        Set<Validator> result = new HashSet<>();
        File[] files = getFiles(path);
        if(files!=null){
            for (File f : files) {
                if (f.getName().endsWith(".jar")){
                    log.info("file encontrado: " + f.getName());
                    getValidator(result, f);
                }
            }
        }
        log.info("Cantidad de clases instanciadas: "+ result.size());
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
            log.info("Lista de Clases Encontradas: size {} - clases {} ", classes.size(), classes);

            classes.forEach(possibleValidator -> {
                if (!Validator.class.isAssignableFrom(possibleValidator) || possibleValidator.isInterface()){
                    log.warn("{} No asignable", possibleValidator.getName());
                }else{
                    log.info("{} Asignable", possibleValidator.getName());
                    try {
                        result.add((Validator) possibleValidator.newInstance());
                    } catch (InstantiationException e) {
                        log.error("InstantiationException: {}", e.getMessage());
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        log.error("IllegalAccessException: {}", e.getMessage());
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (Exception e) {
            log.error("Excepcion al instanciar las clases: {}", e.getMessage());
        }
    }

    private File[] getFiles(String path) {
        File[] files = new File[0];
        try{
            log.info("path del file: " + path+File.separator+"validators");
            files = new File(path+File.separator+"validators").listFiles();
            assert files != null;
            log.info("cantidad de archivos listados: "+files.length);
        }catch(Exception e){
            log.error("no se pudo leer lista de archivos");
        }
        return files;
    }
}
