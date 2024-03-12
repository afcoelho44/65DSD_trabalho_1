package udesc.dsd.enums;

public enum DataIndexes {

    /*pattern:
    Person
    INSERT METHOD {"class", "method", "departmentId", "cpf", "name", "address", "type", "speciality"}
    UPDATE METHOD {"class", "method", "departmentId", "cpf", "name", "address", "type", "speciality"}
    DELETE METHOD {"class", "method", "", "cpf"}
    GET METHOD    {"class", "method", "", "cpf"}
    LIST METHOD   {"class", "method"}

    Department
    INSERT METHOD {"class", "method", "", "", "name"}
    UPDATE METHOD {"class", "method", "departmentId", "name"}
    DELETE METHOD {"class", "method", "departmentId"}
    LIST METHOD   {"class", "method"}
    GET METHOD    {"class", "method", "departmentId"} */

    CLASS(0),
    METHOD(1),
    DEPARTMENT_ID(2),
    CPF(3),
    NAME(4),
    ADDRESS(5),
    TYPE(6),
    SPECIALITY(7);

    public final int index;

    DataIndexes(int index){
        this.index = index;
    }

}