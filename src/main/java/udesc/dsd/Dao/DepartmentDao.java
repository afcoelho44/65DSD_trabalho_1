package udesc.dsd.Dao;

import udesc.dsd.Model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements DepartmentRepository{

    private static List<Department> departments = new ArrayList<>();

    public DepartmentDao(){
        departments.add(new Department("Security"));
    }

    @Override
    public Department getById(long id) {
        return departments.stream().filter(d -> d.getNumberID() == id).findFirst().orElseThrow(RuntimeException::new);
    }
}
