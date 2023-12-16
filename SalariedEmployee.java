import java.util.*;
class Employee {
    
    public int employeeId;
    
    public String employeeName;
    
    public String designation;
    
    public static int getemployeeId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter employee id:");
        int employeeId = scanner.nextInt();
        return employeeId;
    }
    public static String getemployeeName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();
        return employeeName;
    }
    public static String getdesignation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();
        return designation;
    }
}
class HourlyEmployee extends Employee {
    public double hourlyRate;

    public int hoursWorked;

    public double weekly_earnings;

    public static double gethourlyRate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter employee id:");
        double hourlyRate = scanner.nextDouble();
        return hourlyRate;
    }
    public static int gethoursWorked() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter employee id:");
        int hoursWorked = scanner.nextInt();
        return hoursWorked;
    }

    public double calcweekly_earnings(double hourlyRate,int hoursWorked){
        weekly_earnings = hourlyRate * hoursWorked ;
        return weekly_earnings;
    }
}

class SalariedEmployee extends Employee {
    public double monthlySalary;

    public double weekly_Salary;

    public static double getmonthlySalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter employee id:");
        double monthlySalary = scanner.nextDouble();
        return monthlySalary;
    }
    public double getweekly_earnings(double monthlySalary){
        weekly_Salary = monthlySalary / 4;
        return weekly_Salary;

    }


}
