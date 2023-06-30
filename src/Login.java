import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Login {
    private boolean isLoggedIn;

    // The way to access the employeeList that is inside another class
    public ArrayList<Employee> employeeList;

    Scanner input = new Scanner(System.in);


    public Login() {
    }
    public Login(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public Login(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void UserLogin(){
        int id = 0;
        String password = "";
        boolean isValid = false;
        boolean isNull = false;

        System.out.println("Insert your credentials!");
        System.out.println();
        do {
            try {
                System.out.print("ID: ");
                id = input.nextInt();
                isValid = true;
                input.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("The ID must be numeric!");
            }
        } while (!isValid);

        do {
            try {
                System.out.print("Password: ");
                password = input.nextLine();
                if (password.isEmpty()) {
                    throw new IllegalArgumentException("Password cannot be empty!");
                }
                isNull = true;
            } catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
                System.out.println();
            }
        } while(!isNull);
        if (!employeeList.isEmpty()) {
            for (Employee employee : employeeList) {

                if (id == employee.getIdEmployee() && password.equals(employee.getPassword()) && getIsLoggedIn() == false) {
                    // Libera acesso a Product Stock
                    System.out.println("Login Successful!");
                    setIsLoggedIn(true);
                } else if (getIsLoggedIn() == true) {
                    System.out.println("You are already logged in!");
                    break;
                } else {
                    System.out.println("You don't have an active account!");
                    break;
                }
            }
        }else {
            System.out.println("You don't have an active account!");
            System.out.println();
        }

    }
    public void UserValidation(){

    }
}
