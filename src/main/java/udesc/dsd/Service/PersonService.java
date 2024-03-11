package udesc.dsd.Service;

import udesc.dsd.Commons.Constants;
import udesc.dsd.Dao.DepartmentDao;
import udesc.dsd.Dao.DepartmentRepository;
import udesc.dsd.Dao.PersonDao;
import udesc.dsd.Dao.PersonRepository;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Manager;
import udesc.dsd.Model.Person;
import udesc.dsd.Utils.ProtocolTranslator;
import udesc.dsd.enums.DataIndexes;

import java.io.PrintWriter;
import java.util.List;

import static udesc.dsd.Commons.Constants.TYPE_MANAGER;
import static udesc.dsd.enums.DataIndexes.*;

public class PersonService extends Service{

    private final PersonRepository personRepository = new PersonDao();
    private final DepartmentRepository departmentRepository = new DepartmentDao();
    public PersonService(String[] request, PrintWriter out) {
        super(request, out);
    }

    @Override
    public void insert() {
        boolean isManager = request[TYPE.index].equals(TYPE_MANAGER);
        String cpf = request[CPF.index];
        String name = request[NAME.index];
        String address = request[ADDRESS.index];
        String speciality = request[SPECIALITY.index];
        long departmentId = Long.parseLong(request[DEPARTMENT_ID.index]);

        Department department = departmentRepository.getById(departmentId);

        Person person;
        if (isManager){
            person = new Manager(cpf, name, address, department, speciality);
            department.setManager((Manager) person);
        }
        else person = new Employee(cpf, name, address, department, speciality);

        personRepository.add(person);

    }

    @Override
    public void update() {
        boolean isManager = request[TYPE.index].equals(TYPE_MANAGER);
        String cpf = request[CPF.index];
        String name = request[NAME.index];
        String address = request[ADDRESS.index];

        long departmentId = Long.parseLong(request[DEPARTMENT_ID.index]);

        Department department = departmentRepository.getById(departmentId);

        Person person = personRepository.getById(cpf);

        person.setName(name);
        person.setAddress(address);
        person.setDepartment(department);

        if (!isManager) {
            String speciality = request[SPECIALITY.index];
            Employee e = (Employee) person;
            e.setWorkShift(speciality);
        }

        department.addEmployee(person.getCpf(), person);
    }

    @Override
    public void delete() {
        String cpf = request[CPF.index];
        Person person = personRepository.getById(cpf);

        Department department = person.getDepartment();
        department.removeEmployee(cpf);

        personRepository.remove(person);
    }

    @Override
    public void get() {
        String cpf = request[CPF.index];
        Person person = personRepository.getById(cpf);

        out.println(person);
    }

    @Override
    public void list() {
        String[] response = personRepository.getAll().stream().map(Object::toString).toArray(String[]::new);
        String payload = ProtocolTranslator.translateResponse(response);

        out.println(payload);
    }
}
