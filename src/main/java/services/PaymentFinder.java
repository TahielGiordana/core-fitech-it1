package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import pojos.Person;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentFinder {
    public boolean findPayment(String person){
        List<Person> search = this.search(person);
        if(!search.isEmpty()){
            return search.get(0).isFeedPaid();
        }else{
            return false;
        }
    }

    private List<Person> search(String person) {
        System.out.println("ejecutando busqueda de personas");
        List<Person> collect = new ArrayList<>();
        try {
            File file = new File("");
            String path = file.getAbsolutePath() + File.separator + "files" + File.separator + "Persons.json";
            System.out.println("se buscan archivos en el path: " + path);
            JSONParser parser = new JSONParser();
            Object rawPersonas = parser.parse(new FileReader(path));
            ObjectMapper mapper = new ObjectMapper();
            List<Person> personasList = mapper.readValue(rawPersonas.toString(),mapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class));
            System.out.println("lista de personas totales" + personasList);
            //collect = personasList.stream().filter(person1 -> person1.getUsername().equals(person.getUsername())).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("lista de personas obtenidas " + collect);
        return collect;
    }
}
