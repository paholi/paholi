public abstract class Staff {
    private String id;
    private String name;
    private byte age;
    private double coefficient;
    private String startDate;
    private Department department;
    private short numberOfLeaveDays;

    public Staff(){};
    public Staff(String id, String name, byte age, double coefficient, String startDate, Department department, short numberOfLeaveDays){
        this.id=id;
        this.name=name;
        this.age=age;
        this.coefficient=coefficient;
        this.startDate=startDate;
        this.department= department;
        this.numberOfLeaveDays=numberOfLeaveDays;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){this.name=name;};
    public String getName(){
        return name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public short getNumberOfLeaveDays() {
        return numberOfLeaveDays;
    }

    public void setNumberOfLeaveDays(short numberOfLeaveDays) {
        this.numberOfLeaveDays = numberOfLeaveDays;
    }

    abstract void displayInformation();
}
