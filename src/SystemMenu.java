import java.util.InputMismatchException;
import java.util.Scanner;
public class SystemMenu {
    private Login login;
    private EmployeeRegister employeeRegister;
    private ProductStock productStock;

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
                    //login
                    break;
                case 2:
                    employeeRegister = new EmployeeRegister();
                    employeeRegister.RegisterProcess();
                    break;
                case 3:
                    //stock management
                    break;
                case 4:
                    System.out.println("Hope to see you again!");
                    break;

            }
        } while(entry != 4);
    }

}
