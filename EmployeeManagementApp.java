import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String department;
    private double salary;

    public Employee(String name, int id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementApp {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployeeSalary();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting Employee Management Application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 

        Employee employee = new Employee(name, id, department, salary);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void updateEmployeeSalary() {
        System.out.print("Enter employee id to update salary: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Enter new salary for employee " + employee.getName() + ": ");
                double newSalary = scanner.nextDouble();
                scanner.nextLine(); 
                employee.setSalary(newSalary);
                System.out.println("Salary updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with id " + id + " not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (removed) {
            System.out.println("Employee with id " + id + " deleted successfully.");
        } else {
            System.out.println("Employee with id " + id + " not found.");
        }
    }
}
