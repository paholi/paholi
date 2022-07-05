public class Department {
    private String depId;
    private String depName;
    private int currentStaffOfDep;
    public Department(String depId,String depName){
        this.depId=depId;
        this.depName=depName;
    };

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getCurrentStaffOfDep() {
        return this.currentStaffOfDep;
    }

    public void setCurrentStaffOfDep(int currentStaffOfDep) {
        this.currentStaffOfDep = currentStaffOfDep;
    }

    public String toString(){
        return "dd";
    };

}
