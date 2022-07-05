public class Manager extends Staff implements ICalculator {
    private String title;
    public Manager(){};
    public Manager(String id, String name, byte age, double coefficient, String startDate, Department department, short numberOfLeaveDays,String title){
        super(id,name,age,coefficient,startDate,department,numberOfLeaveDays);
        this.title=title;
    }

    public String getTitle(){
        return this.title;
    };

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void displayInformation(){};
    @Override
    public double calculateSalary(){
        double ans=5000000*this.getCoefficient();
        if(this.title=="Business Leader"){
            ans=ans+8000000;
        } else if(this.title=="Project Leader"){
            ans=ans+5000000;
        } else if(this.title=="Technical Leader"){
            ans=ans+6000000;
        }
        return ans;
    };
}
