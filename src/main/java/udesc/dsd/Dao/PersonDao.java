package udesc.dsd.Dao;

import udesc.dsd.Exception.DepartmentNotFoundException;
import udesc.dsd.Exception.NotAnyPersonException;
import udesc.dsd.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao implements PersonRepository{

    private static final List<Person> persons = new ArrayList<>();

    @Override
    public Person getById(String cpf) {
        if (!persons.isEmpty())
            return persons
                    .stream()
                    .filter(d -> d.getCpf().equals(cpf))
                    .findFirst()
                    .orElseThrow(DepartmentNotFoundException::new);

        else throw new NotAnyPersonException();
    }

    @Override
    public List<Person> getAll() {
        if (!persons.isEmpty())
            return persons;
        else throw new NotAnyPersonException();
    }

    @Override
    public void add(Person person) {
        persons.add(person);
    }

    @Override
    public void remove(Person person) {
        if (!persons.isEmpty())
            persons.remove(person);
        else throw new NotAnyPersonException();
    }
}
