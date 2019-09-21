package app;

import java.util.Optional;

public class PersonTest {
    public static void main(String[] args) {

        PersonDatabase db = new PersonDatabase();
        db.add(new Person(1, "Jan", "Kowalski"));
        db.add(new Person(2, "Karol", "Zawadzki"));
        db.add(new Person(3, "Bartosz", "Abacki"));
        db.add(new Person(4, "Ania", "Walczak"));

        Optional<Person> personOpt1 = db.findById(2);
        Optional<Person> personOpt2 = db.findById(55);

        personOpt1.ifPresent(p -> System.out.println(p.getLastName()));
        personOpt2.ifPresent(p -> System.out.println(p.getLastName()));
        personOpt2.ifPresentOrElse(
                p -> System.out.println(p.getLastName()),
                () -> System.out.println("Brak obiektu o wskazanym id")
        );
    }
}
