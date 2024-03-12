package udesc.dsd.Dao;

import udesc.dsd.Exception.NotAnyPersonException;
import udesc.dsd.Exception.PersonNotFoundException;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Manager;
import udesc.dsd.Model.Person;
import udesc.dsd.Utils.AccessKeyGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDao implements PersonRepository{

    private static final Set<Person> persons = new HashSet<>();
    private static boolean populated = false;

    @Override
    public Person getById(String cpf) {
        if (!persons.isEmpty())
            return persons
                    .stream()
                    .filter(d -> d.getCpf().equals(cpf))
                    .findFirst()
                    .orElseThrow(PersonNotFoundException::new);

        else throw new NotAnyPersonException();
    }

    @Override
    public List<Person> getAll() {
            return persons.stream().toList();
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

    public static void populate(){
        if(!populated){
            AccessKeyGenerator generator = new AccessKeyGenerator();
            DepartmentRepository departmentRepository= new DepartmentDao();

            Department department1 = departmentRepository.getById(1);
            Department department2 = departmentRepository.getById(2);
            Department department3 = departmentRepository.getById(3);
            Department department4 = departmentRepository.getById(4);

            Manager[] managersPop = new Manager[]{
                    new Manager("12345678910", "gervasio", "Rua w", department1, generator.generateAccessCode()[1]),
                    new Manager("23648276307", "gervasia", "Rua x", department2, generator.generateAccessCode()[1]),
                    new Manager("63287634231", "gervasino", "Rua y", department3, generator.generateAccessCode()[1]),
                    new Manager("74368432234", "gervasiano", "Rua z", department4, generator.generateAccessCode()[1]),
            };
            Employee[] employeesPop = new Employee[]{
                    new Employee("99999999991", "Pernilonguildo", "Avenida a", department1, "manhã"),
                    new Employee("99999999992", "Pernilonguilda", "Avenida b", department2, "manhã"),
                    new Employee("99999999993", "Vanessinhaaaaa", "Avenida c", department3, "manhã"),
                    new Employee("99999999994", "Venceslauuuuuu", "Avenida d", department4, "manhã"),
                    new Employee("99999999995", "Fullano de tal", "Avenida e", department1, "manhã"),
                    new Employee("99999999996", "Gertrudinhaaaa", "Avenida f", department2, "tarde"),
                    new Employee("99999999997", "Mano Brown yea", "Avenida g", department3, "tarde"),
                    new Employee("99999999998", "Joao damasceno", "Avenida h", department4, "tarde"),
                    new Employee("99999999999", "Julianinho lee", "Avenida i", department1, "tarde"),
                    new Employee("99999999990", "Luiz Fernandin", "Avenida j", department2, "tarde")
            };

            department1.addEmployee(managersPop[0].getCpf(), managersPop[0]);
            department1.addEmployee(employeesPop[0].getCpf(), employeesPop[0]);
            department1.addEmployee(employeesPop[4].getCpf(), employeesPop[4]);
            department1.addEmployee(employeesPop[8].getCpf(), employeesPop[8]);

            department2.addEmployee(managersPop[1].getCpf(), managersPop[1]);
            department2.addEmployee(employeesPop[1].getCpf(), employeesPop[1]);
            department2.addEmployee(employeesPop[5].getCpf(), employeesPop[5]);
            department2.addEmployee(employeesPop[9].getCpf(), employeesPop[9]);

            department3.addEmployee(managersPop[2].getCpf(), managersPop[2]);
            department3.addEmployee(employeesPop[2].getCpf(), employeesPop[2]);
            department3.addEmployee(employeesPop[6].getCpf(), employeesPop[6]);

            department4.addEmployee(managersPop[3].getCpf(), managersPop[3]);
            department4.addEmployee(employeesPop[3].getCpf(), employeesPop[3]);
            department4.addEmployee(employeesPop[7].getCpf(), employeesPop[7]);

            persons.addAll(Arrays.asList(managersPop));
            persons.addAll(Arrays.asList(employeesPop));
            populated = true;
        }
    }
}
