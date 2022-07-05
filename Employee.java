public class Employee extends Staff implements ICalculator {
    private double workingHours;
    public  Employee(){};
    public Employee(String id, String name, byte age, double coefficient, String startDate, Department department, short numberOfLeaveDays,double workingHours){
        super(id,name,age,coefficient,startDate,department,numberOfLeaveDays);
        this.workingHours=workingHours;
    };

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    @Override
    public double calculateSalary(){
        return this.getCoefficient()*3000000+this.workingHours*200000;
    };
    @Override
    public void displayInformation(){};
}
