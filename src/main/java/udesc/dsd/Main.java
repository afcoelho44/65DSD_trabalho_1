package udesc.dsd;

import udesc.dsd.Model.Department;
import udesc.dsd.Utils.AccessKeyGenerator;
import udesc.dsd.Utils.Hasher256;

public class Main {
    public static void main(String[] args) {
        Department department = new Department("Security");

        System.out.println(department);
    }
}