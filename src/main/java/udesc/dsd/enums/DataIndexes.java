package udesc.dsd.enums;

public enum DataIndexes {

    //pattern = {"method", "cpf", "name", "address", "type", "speciality", "departmentId"}

    METHOD(0),
    CPF(1),
    NAME(2),
    ADDRESS(3),
    TYPE(4),
    SPECIALITY(5),
    DEPARTMENT_ID(6);

    public final int index;

    DataIndexes(int index){
        this.index = index;
    }

}