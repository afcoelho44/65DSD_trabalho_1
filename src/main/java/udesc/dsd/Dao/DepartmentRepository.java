package udesc.dsd.Dao;

import udesc.dsd.Model.Department;

import java.util.List;

public interface DepartmentRepository {

    Department getById(long id);
    List<Department> getAll();
    void add(Department department);
    void remove(Department department);

}
