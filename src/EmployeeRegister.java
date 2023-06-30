import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class EmployeeRegister {
    Employee employee;
    public ArrayList<Employee> employeeList = new ArrayList <Employee>();
    private int id;
    private String name;
    private String email;
    private String password;
    public EmployeeRegister(){}
    Scanner input = new Scanner(System.in);
    public void RegisterProcess(){
        boolean isValid = false;
        boolean isNull = false;
        boolean isNameRead = false;
        boolean isEmailRead = false;
        boolean isPasswordRead = false;

        do {
            try {
                System.out.print("Insert your employee ID: ");
                id = input.nextInt();
                isValid = true;
                // Cleaning buffer
                input.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("The ID must be numeric!");
                input.nextLine();
                System.out.println();
            }
        } while (!isValid);

        do {
            try {
                if (!isNameRead) {
                    System.out.print("Insert your name: ");
                    name = input.nextLine();

                    if (name.isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty!");
                    }

                    isNameRead = true;
                }

                if (!isEmailRead) {
                    System.out.print("Insert your email: ");
                    email = input.nextLine();

                    if (email.isEmpty()) {
                        throw new IllegalArgumentException("Email cannot be empty!");
                    }

                    isEmailRead = true;
                }

                if (!isPasswordRead) {
                    System.out.print("Insert your password: ");
                    password = input.nextLine();

                    if (password.isEmpty()) {
                        throw new IllegalArgumentException("Password cannot be empty!");
                    }

                    isPasswordRead = true;
                }

                isNull = true;
            } catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
                System.out.println();
            }
        } while (!isNull);

        employee = new Employee(id, name, "", email, password);
        employeeList.add(employee);

        System.out.println();
        System.out.println("Successfully registered!");

        /*for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("Name: " + employee.getNameEmployee());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Password: " + employee.getPassword());
            System.out.println(); // Adding an empty line for clarity
        }*/
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

}
