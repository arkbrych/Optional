package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDatabase {
    private List<Person> people = new ArrayList<>();

    void add (Person person){
        if (person == null){
            throw new NullPointerException("Cannot add null reference");
        }
        if (findById(person.getId()).isEmpty()){
            throw new IllegalArgumentException("Object with such id already exist");
        }
        people.add(person);
    }

    Optional<Person> findById(int id) {
        for (Person person: people){
            if (person.getId() == id){
                return Optional.of(person);
            }
        } return Optional.empty();
    }

    public String findLastNameById(int id){
        return findById(id)
                .map(Person::getLastName)
                .orElse("Anonim");
    }
}
