import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class SystemMenu {
    EmployeeRegister employeeRegister = new EmployeeRegister();
    ArrayList<Employee> employeeList = employeeRegister.getEmployeeList();
    Login login = new Login(employeeList);
    ProductStock productStock = new ProductStock();

    Scanner input = new Scanner(System.in);

    public SystemMenu(){}

    public void MenuStart(){
        int entry = 0;
        boolean isValid = false;

        do {
            do {
                try {
                    System.out.println();
                    System.out.println("Welcome to the Stock Management Tool!");
                    System.out.println();
                    System.out.println("1 - Login");
                    System.out.println("2 - Register");
                    System.out.println("3 - Stock Management");
                    System.out.println("4 - Quit");
                    System.out.println();
                    System.out.print("Choose an option: ");

                    entry = input.nextInt();

                    if (entry <= 0 || entry > 4){
                        System.err.println("Please, choose a valid option!");
                        System.out.println();
                    } else{
                        isValid = true;
                    }

                    input.nextLine();
                } catch(InputMismatchException e){
                    System.err.println("Please, choose a valid option!");
                    input.nextLine();
                    System.out.println();
                }
            }while(!isValid);

            switch (entry) {
                case 1:
                    login.UserLogin();
                    break;
                case 2:
                    employeeRegister.RegisterProcess();
                    break;
                case 3:
                    if (login.getIsLoggedIn() == false){
                        System.out.println("You must be logged in!");
                        break;
                    } else{
                        productStock.AllProductHandling();
                        break;
                    }
                case 4:
                    System.out.println();
                    System.out.println("Logging off!");
                    break;

            }
        } while(entry != 4);
    }

}
