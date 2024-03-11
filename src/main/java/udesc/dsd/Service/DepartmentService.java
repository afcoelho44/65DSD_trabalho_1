package udesc.dsd.Service;

import udesc.dsd.Dao.DepartmentDao;
import udesc.dsd.Dao.DepartmentRepository;
import udesc.dsd.Model.Department;
import udesc.dsd.enums.DataIndexes;

import java.io.PrintWriter;

public class DepartmentService extends Service{

    private final DepartmentRepository repository = new DepartmentDao();

    public DepartmentService(String[] request, PrintWriter out) {
        super(request, out);
    }

    @Override
    public void insert() {
        String response;
        try {

            Department department = new Department(request[DataIndexes.NAME.index]);
            repository.add(department);
            response = "Success!";

        } catch (Exception e){
            response = "Error inserting department!";
        }

        out.println(response);
    }

    @Override
    public void update() {
        String response;

        try {

            Department department = repository.getById(DataIndexes.DEPARTMENT_ID.index);
            department.setName(request[DataIndexes.NAME.index]);
            response = "Pessoa atualizada com sucesso";

        } catch (Exception e){
            response = e.getMessage();
        }

        out.println(response);
    }

    @Override
    public void delete() {
        String response;

        try {

            Department department = repository.getById(DataIndexes.DEPARTMENT_ID.index);
            repository.remove(department);
            response = "Departamento removido com sucesso";

        } catch (Exception e){
            response = e.getMessage();
        }

        out.println(response);
    }

    @Override
    public void get() {
        String response;

        try {

            Department department = repository.getById(DataIndexes.DEPARTMENT_ID.index);
            response = department.toResponseString();

        } catch (Exception e){
            response = e.getMessage();
        }

        out.println(response);

    }

    @Override
    public void list() {

        String response;
        StringBuilder builder = new StringBuilder();

        try {
            repository.getAll().forEach(department -> builder.append(department.toResponseString()));
            response = builder.toString();
        } catch (Exception e){
            response = e.getMessage();
        }

        out.println(response);
    }
}
