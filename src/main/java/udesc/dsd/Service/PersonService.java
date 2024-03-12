package udesc.dsd.Service;

import udesc.dsd.Dao.DepartmentDao;
import udesc.dsd.Dao.DepartmentRepository;
import udesc.dsd.Dao.PersonDao;
import udesc.dsd.Dao.PersonRepository;
import udesc.dsd.Exception.ServerSideException;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Manager;
import udesc.dsd.Model.Person;
import udesc.dsd.Utils.AccessKeyGenerator;
import udesc.dsd.Utils.ProtocolTranslator;
import udesc.dsd.Utils.ResponseMessage;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static udesc.dsd.Commons.Constants.TYPE_MANAGER;
import static udesc.dsd.enums.DataIndexes.*;

public class PersonService extends Service{

    private final PersonRepository personRepository = new PersonDao();
    private final DepartmentRepository departmentRepository = new DepartmentDao();
    private final AccessKeyGenerator generator = new AccessKeyGenerator();

    public PersonService(String[] request, PrintWriter out) {
        super(request, out);
    }

    @Override
    public void insert() {
        String response;

        try {
            boolean isManager = request[TYPE.index].equals(TYPE_MANAGER);
            String cpf = request[CPF.index];
            String name = request[NAME.index];
            String address = request[ADDRESS.index];
            long departmentId = Long.parseLong(request[DEPARTMENT_ID.index]);

            Department department = departmentRepository.getById(departmentId);

            Person person;
            String speciality;
            if (isManager){
                String[] keys = generator.generateAccessCode();
                speciality = keys[1];
                person = new Manager(cpf, name, address, department, speciality);
                department.setManager((Manager) person);
                response = "Decore sua chave de acesso, ela é irrecuperável: " + keys[0];
            }
            else{
                speciality = request[SPECIALITY.index];
                person = new Employee(cpf, name, address, department, speciality);
                response = "";
            }

            personRepository.add(person);

            response = ResponseMessage.messageResponse(response);
        } catch (Exception e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void update() {
        String response;

        try {

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
            response = ResponseMessage.messageResponse("Pessoa atualizada com sucesso");

        } catch (ServerSideException e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void delete() {
        String response;

        try{

            String cpf = request[CPF.index];
            Person person = personRepository.getById(cpf);

            Department department = person.getDepartment();
            department.removeEmployee(cpf);

            personRepository.remove(person);
            response = ResponseMessage.messageResponse("Pessoa removida com sucesso");

        } catch (ServerSideException e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void get() {
        String response;

        try {

            String cpf = request[CPF.index];
            Person person = personRepository.getById(cpf);

            response = ResponseMessage.objectResponse(person.toString());

        } catch (ServerSideException e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void list() {
        String response;

        List<Person> personList = personRepository.getAll();
        String formattedSize = String.format("%02d", personList.size());

        if (personList.isEmpty()) response = formattedSize;
        else {
            List<String> responseList = new ArrayList<>();
            responseList.add(formattedSize);
            personList.stream().map(Person::toString).forEach(responseList::add);

            String[] responseArray = responseList.toArray(String[]::new);
            response = ProtocolTranslator.translateResponse(responseArray);
            response = ResponseMessage.objectResponse(response);
        }

        out.println(response);
    }
}
