package udesc.dsd.Dao;

import udesc.dsd.Model.Department;

public interface DepartmentRepository {

    Department getById(long id);

}
