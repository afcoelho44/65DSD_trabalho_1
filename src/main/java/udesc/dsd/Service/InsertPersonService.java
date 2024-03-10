package udesc.dsd.Service;

import udesc.dsd.Commons.Constants;
import udesc.dsd.Dao.DepartmentDao;
import udesc.dsd.Dao.DepartmentRepository;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Manager;
import udesc.dsd.Model.Person;
import udesc.dsd.enums.DataIndexes;

import java.io.PrintWriter;

public class InsertPersonService extends Service{

    private final DepartmentRepository repository = new DepartmentDao();

    public InsertPersonService(String[] request, PrintWriter out){
        super(request, out);
    }

    @Override
    public boolean execute() {

        String cpf = request[DataIndexes.CPF.index];
        String name = request[DataIndexes.NAME.index];
        String address = request[DataIndexes.ADDRESS.index];
        String type = request[DataIndexes.TYPE.index];
        String speciality = request[DataIndexes.SPECIALITY.index];
        long departmentId = Long.parseLong(request[DataIndexes.DEPARTMENT_ID.index]);

        Department department = repository.getById(departmentId);

        Person person = type.equals(Constants.TYPE_MANAGER) ?
                        new Manager(cpf, name, address, department, speciality) :
                        new Employee(cpf, name, address, department, speciality);

        out.println("");
        return true;
    }
}
