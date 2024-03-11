package udesc.dsd.Dao;

import udesc.dsd.Model.Department;
import udesc.dsd.Model.Person;

import java.util.List;

public interface PersonRepository {
    Person getById(String cpf);
    List<Person> getAll();
    void add(Person person);
    void remove(Person person);
}
