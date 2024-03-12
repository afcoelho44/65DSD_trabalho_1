package udesc.dsd.Dao;

import udesc.dsd.Exception.DepartmentNotFoundException;
import udesc.dsd.Exception.NotAnyDepartmentException;
import udesc.dsd.Model.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentDao implements DepartmentRepository{

    private static final List<Department> departments = new ArrayList<>();
    private static boolean populated = false;

    @Override
    public Department getById(long id) {
        if (!departments.isEmpty())
            return departments
                    .stream()
                    .filter(d -> d.getNumberID() == id)
                    .findFirst()
                    .orElseThrow(DepartmentNotFoundException::new);

        else throw new NotAnyDepartmentException();
    }

    @Override
    public List<Department> getAll() {
        if (!departments.isEmpty())
            return departments;
        else throw new  NotAnyDepartmentException();
    }

    @Override
    public void add(Department department) {
        departments.add(department);
    }

    @Override
    public void remove(Department department) {
        if (!departments.isEmpty())
            departments.remove(department);
        else throw new  NotAnyDepartmentException();
    }

    public static void populate (){
        if(!populated){

            Department[] population = new Department[]{
                    new Department("Security"),
                    new Department("RH"),
                    new Department("Development"),
                    new Department("Marketing"),
            };

            departments.addAll(Arrays.asList(population));
            populated = true;
        }
    }
}
