import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HumanResources {
    private static final ArrayList <Department> listOfDeps= new ArrayList<>();
    private static final ArrayList <String> titles= new ArrayList <>();
    private static final ArrayList <Staff> listOfStaffs= new ArrayList<>();
    private static final Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        opening();
        byte choose;
        Department d1= new Department("HC","Hành chính nhân sự");
        Department d2= new Department("IT","Công nghệ thông tin");
        Department d3= new Department("MKT","Marketing");
        listOfDeps.add(d1);
        listOfDeps.add(d2);
        listOfDeps.add(d3);
        titles.add("Business Leader");
        titles.add("Project Leader");
        titles.add("Technical Leader");
        do{
            menu();
            choose=sc.nextByte();
            switch(choose){
                case 1:
                    f1_ListOfStaffs();
                    break;
                case 2:
                    f2_ListOfDep();
                    break;
                case 3:
                    f3_ListStaffEachDep();
                    break;
                case 4:
                    f4_addMember();
                    break;
                case 5:
                    f5_searchStaff();
                    break;
                case 6:
                    f6_salaryTable();
                    break;
                case 7:
                    f7_salaryMinToMax();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Bạn đã nhập sai hãy nhập lại");
                    break;
            }
        }while(choose!=0);

        ending();
    }
    //CHÀO MỞ ĐẦU VÀ KẾT THÚC CHƯƠNG TRÌNH
    public static void opening(){
        System.out.println("------------------------------------CHÀO MỪNG ĐẾN VỚI PHẦN MỀM QUẢN LÝ NHÂN SỰ------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
    public static void ending(){
        System.out.println("-------------------------------------THANK YOU-------------------------------------");
    }
    //MENU CÁC CHỨC NĂNG CỦA PR0JECT
    public static void menu(){
        System.out.println("1. Hiển thị danh sách nhanh viên hiện có trong công ty.");
        System.out.println("2. Hiển thị danh sách các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên trong từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiện thị bảng lương của toàn bộ nhân viên trong công ty.");
        System.out.println("7. Hiện thị bảng lương theo số tiền lương.");
        System.out.println("0. Thoát chương trình.");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static void printCell(int maxWitdh, String str){
        String s="";
        for(byte i=0;i<maxWitdh-str.length();i++){
            s=s+" ";
        }
        System.out.print (str+s+"| ");
    }
    public static void printTable(ArrayList <Staff> list){
        String Id="Mã nhân viên";
        int widthId=15;
        String Name="Tên nhân viên";
        int widthName=40;
        String Age="Tuổi";
        int widthAge=6;
        String Coef="HS Lương";
        int widthCoef=9;
        String startDate="Ngày vào làm";
        int widthStartDate=15;
        String offDays="Số ngày nghỉ";
        int widthOffDays=15;
        String Dep="Bộ phận";
        int widthDep=40;
        String WkHoursOrTile="Số giờ làm thêm/Chức vụ";
        int widthWkHoursOrTitle=40;
        printCell(widthId,Id);
        printCell(widthName,Name);
        printCell(widthAge,Age);
        printCell(widthCoef,Coef);
        printCell(widthStartDate,startDate);
        printCell(widthOffDays,offDays);
        printCell(widthDep,Dep);
        printCell(widthWkHoursOrTitle,WkHoursOrTile);
        System.out.println("Lương");
        for(int i=0;i<list.size();i++){
            Staff s= listOfStaffs.get(i);
            printCell(widthId,s.getId());
            printCell(widthName,s.getName());
            printCell(widthAge,String.valueOf(s.getAge()));
            printCell(widthCoef,String.valueOf(s.getCoefficient()));
            printCell(widthStartDate,s.getStartDate());
            printCell(widthOffDays,String.valueOf(s.getNumberOfLeaveDays()));
            printCell(widthDep,s.getDepartment().getDepName());
            if(listOfStaffs.get(i) instanceof Employee){
                printCell(widthWkHoursOrTitle,String.valueOf(((Employee) listOfStaffs.get(i)).getWorkingHours()));
                System.out.println(String.valueOf(((Employee) listOfStaffs.get(i)).calculateSalary()));
            }else{
                printCell(widthWkHoursOrTitle,((Manager) listOfStaffs.get(i)).getTitle());
                System.out.println(String.valueOf(((Manager) listOfStaffs.get(i)).calculateSalary()));
            }
        }
    }
    //CHỨC NĂNG 1: HIỂN THỊ DANH SÁCH NHÂN VIÊN CÔNG TY
    public static void f1_ListOfStaffs(){
        printTable(listOfStaffs);
    }

    // CHỨC NĂNG 2: HIỂN THỊ DANH SÁCH CÁC BỘ PHẬN

    public static void f2_ListOfDep(){
        String DepID="Mã bộ phận";
        int depIDwidth=15;
        String DepName="Tên bộ phận";
        int depNameWidth=40;

        printCell(depIDwidth,DepID);
        printCell(depNameWidth,DepName);
        System.out.println("Số lượng nhân viên hiện tại");
        for(int i=0;i<listOfDeps.size();i++){
            int counter=0;
            Department d= listOfDeps.get(i);
            for(int j=0;j<listOfStaffs.size();j++){
                if(listOfStaffs.get(j).getDepartment().getDepId().equals(d.getDepId())){
                    counter++;
                };
                d.setCurrentStaffOfDep(counter);
            };
        };
        for(int i=0;i< listOfDeps.size();i++){
            Department d= listOfDeps.get(i);
            printCell(depIDwidth,d.getDepId());
            printCell(depNameWidth,d.getDepName());
            System.out.println(d.getCurrentStaffOfDep());
        };

    }

    // CHỨC NĂNG 3: HIỂN THỊ DANH SÁCH CÁC BỘ PHẬN THEO TỪNG BỘ PHẬN
    public static  void f3_ListStaffEachDep(){
       for(int j=0;j< listOfDeps.size();j++){
            Department d= listOfDeps.get(j);
            System.out.println(d.getDepName()+": "+d.getCurrentStaffOfDep()+" nhân viên");
            System.out.println("------------------------------------");
            ArrayList <Staff> listofDep= new ArrayList<>();
            for(int i=0;i< listOfStaffs.size();i++){
                if(listOfStaffs.get(i).getDepartment().getDepId().equals(d.getDepId())){
                    listofDep.add(listOfStaffs.get(i));
                }
            };
            printTable(listofDep);
       };
    }

    // CHỨC NĂNG 4: THÊM NHÂN VIÊN MỚI

    public static void f4_addMember(){
        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
        System.out.print("Bạn chọn: ");
        byte ans= sc.nextByte();
        if(ans==1){
            Employee sE= new Employee();
            System.out.print("Nhập mã nhân viên: ");
            sE.setId(sc.next());
            System.out.print("Nhập tên nhân viên: ");
            sE.setName(sc.next());
            System.out.print("Nhập tuổi nhân viên: ");
            sE.setAge(sc.nextByte());
            System.out.print("Nhập hệ số lương của nhân viên: ");
            sE.setCoefficient(sc.nextDouble());
            System.out.print("Nhập ngày vào làm của nhân viên: ");
            sE.setStartDate(sc.next());
            System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
            sE.setNumberOfLeaveDays(sc.nextShort());
            for(int i=0;i<listOfDeps.size();i++){
                System.out.println(i+1+" "+listOfDeps.get(i).getDepId()+"- "+listOfDeps.get(i).getDepName());
            }
            System.out.print("Bạn chọn bộ phận: ");
            sE.setDepartment(listOfDeps.get(sc.nextInt()-1));
            System.out.print("Nhập số giờ làm thêm: ");
            sE.setWorkingHours(sc.nextDouble());
            listOfStaffs.add(sE);
        }else if(ans==2){
            Manager sM= new Manager();
            System.out.print("Nhập mã nhân viên: ");
            sM.setId(sc.next());
            System.out.print("Nhập tên nhân viên: ");
            sM.setName(sc.next());
            System.out.print("Nhập tuổi nhân viên: ");
            sM.setAge(sc.nextByte());
            System.out.print("Nhập hệ số lương của nhân viên: ");
            sM.setCoefficient(sc.nextByte());
            System.out.print("Nhập ngày vào làm của nhân viên: ");
            sM.setStartDate(sc.next());
            System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
            sM.setNumberOfLeaveDays(sc.nextShort());
            for(int i=0;i<listOfDeps.size();i++){
                System.out.println(i+1+" "+listOfDeps.get(i).getDepId()+"- "+listOfDeps.get(i).getDepName());
            }
            System.out.print("Bạn chọn bộ phận: ");
            sM.setDepartment(listOfDeps.get(sc.nextInt()-1));
            System.out.println("Chức danh:");
            for(int i=0;i<titles.size();i++){
                System.out.println(i+1+" "+titles.get(i));
            }
            System.out.print("Nhập chức danh: ");
            sM.setTitle(titles.get(sc.nextInt()-1));
            listOfStaffs.add(sM);
        };

    }
    //CHỨC NĂNG 5: TÌM KIẾM THÔNG TIN NHÂN VIÊN
    public static void f5_searchStaff(){
        System.out.println("1. Tìm nhân viên theo tên");
        System.out.println("2. Tìm nhân viên theo mã nhân viên");
        Byte ans= sc.nextByte();
        String searchKey;
        ArrayList<Staff> result= new ArrayList<Staff>();
        if(ans==1){
            System.out.println("Nhập tên nhân viên cần tìm: ");
            searchKey=sc.next();
            for(int i=0;i< listOfDeps.size();i++){
                String fullName= listOfStaffs.get(i).getName();
                String name=fullName.substring(fullName.length()-1-searchKey.length(),searchKey.length());
                if(name.equals(searchKey)&&fullName.charAt(fullName.length()-2-searchKey.length())==' '){
                    result.add(listOfStaffs.get(i));
                };
            };
        }
        else if(ans==2){
            System.out.println("Nhập mã nhân viên cần tìm: ");
            searchKey=sc.next();
            for(int i=0;i<listOfStaffs.size();i++){
                if(listOfStaffs.get(i).getId().equals(searchKey)){
                    result.add(listOfStaffs.get(i));
                };
            };
        };
        printTable(result);
    }

    //CHỨC NĂNG 6: HIỂN THỊ BẢNG LƯƠNG CỦA TOÀN CÔNG TY
    public static void f6_salaryTable(){
        printTable(listOfStaffs);
    }

    //CHỨC NĂNG 7: HIỂN THỊ BẢNG LƯƠNG THEO THỨ TỰ TĂNG DẦN
    public static void f7_salaryMinToMax(){
        double[] salaryList= new double[listOfStaffs.size()]; //mảng lưu toàn bộ số tiền lương của mỗi nhân viên
            for(int i=0;i< listOfStaffs.size();i++){               //duyệt toàn bộ danh sách nhân viên và tính toán tiền lương của mỗi người, lưu vào mảng tiền lương
                if(listOfStaffs.get(i) instanceof Employee){
                    salaryList[i]=((Employee) listOfStaffs.get(i)).calculateSalary();
                 }else if(listOfStaffs.get(i) instanceof Manager){
                salaryList[i]=((Manager) listOfStaffs.get(i)).calculateSalary();
                };
            };

        double[] salaryList_sorted= Arrays.copyOf(salaryList,salaryList.length); //mảng lưu tiền lương sắp xếp từ bé đến lớn
        Arrays.sort(salaryList_sorted);
        ArrayList <Staff> listStaffsorted = new ArrayList<Staff>();   //mảng danh sách sau khi sắp xếp lại theo tiền lương
        byte ans;
        do{
            System.out.println("Bạn muốn hiển thị bảng lương theo thứ tự: "); //đưa ra lựa chọn cách sắp xếp cho người dùng
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            ans=sc.nextByte();

            if(ans==1){                                             //trường hợp sắp xếp tăng dần
                for (int i=0;i< listOfStaffs.size();i++){
                    ArrayList <Integer> index= new ArrayList<Integer>();
                    for(int k=0;k<listOfStaffs.size();k++){
                        if(salaryList_sorted[i]==salaryList[k]){
                            index.add(k);
                        };
                    };
                    for(int j=0;j<index.size();j++){
                        listStaffsorted.add(listOfStaffs.get(index.get(j)));
                    };
                };
            }
            else if(ans==2){                                        //trường hợp sắp xếp giảm dần
                for (int i=listOfStaffs.size()-1;i>=0;i--){
                    ArrayList <Integer> index= new ArrayList<Integer>();
                    for(int k=0;k<listOfStaffs.size();k++){
                        if(salaryList_sorted[i]==salaryList[k]){
                            index.add(k);
                        };
                    };
                    for(int j=0;j<index.size();j++){
                        listStaffsorted.add(listOfStaffs.get(index.get(j)));
                    };
                };
            }
            else{
                System.out.println("Bạn đã nhập sai hãy nhập lại!");
            };

        }while(ans!=1&&ans!=2);

        printTable(listStaffsorted);
    };

}
