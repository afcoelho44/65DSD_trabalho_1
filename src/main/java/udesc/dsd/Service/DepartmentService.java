package udesc.dsd.Service;

import udesc.dsd.Dao.DepartmentDao;
import udesc.dsd.Dao.DepartmentRepository;
import udesc.dsd.Model.Department;
import udesc.dsd.Utils.ProtocolTranslator;
import udesc.dsd.Utils.ResponseMessage;
import udesc.dsd.enums.DataIndexes;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
            response = ResponseMessage.messageResponse("Departamento criado.");

        } catch (Exception e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void update() {
        String response;

        try {

            Department department = repository.getById(DataIndexes.DEPARTMENT_ID.index);
            department.setName(request[DataIndexes.NAME.index]);
            response = ResponseMessage.messageResponse("Pessoa atualizada com sucesso");

        } catch (Exception e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void delete() {
        String response;

        try {

            Department department = repository.getById(DataIndexes.DEPARTMENT_ID.index);
            repository.remove(department);
            response = ResponseMessage.messageResponse("Departamento removido com sucesso");

        } catch (Exception e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }

    @Override
    public void get() {
        String response;

        try {

            Department department = repository.getById(DataIndexes.DEPARTMENT_ID.index);
            response = ResponseMessage.objectResponse(department.toString());

        } catch (Exception e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);

    }

    @Override
    public void list() {

        String response;
        try{
            List<Department> departmentList = repository.getAll();
            String formattedSize = String.format("%02d", departmentList.size());

            if (departmentList.isEmpty()) response = formattedSize;
            else {
                List<String> responseList = new ArrayList<>();
                responseList.add(formattedSize);
                departmentList.stream().map(Department::toString).forEach(responseList::add);

                String[] responseArray = responseList.toArray(String[]::new);
                response = ProtocolTranslator.translateResponse(responseArray);
                response = ResponseMessage.objectResponse(response);
            }

        out.println(response);
        } catch (Exception e){
            response = ResponseMessage.messageResponse(e.getMessage());
        }

        out.println(response);
    }
}
