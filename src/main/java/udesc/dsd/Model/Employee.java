package udesc.dsd.Model;

public class Employee extends Person{

    private String workShift;

    public Employee(String cpf, String name, String address, Department department, String workShift) {
        super(cpf, name, address, department);
        this.workShift = workShift;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    @Override
    public String toString(){
        return super.toString()
                + ";" + workShift;
    }
}
