import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import resources.DatabaseConnection;
import java.sql.Connection;

public class EmployeeRegister extends JFrame implements ActionListener {
    private final JTextField jUserTextField;
    private final JTextField jPasswordTextField;
    private final JButton jBackButton;
    private final JButton jConfirmButton;

    public EmployeeRegister(){
        // Creating main screen
        setTitle("Register");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(null);

        // Adding labels for text fields
        JLabel jUserLabel = new JLabel("Create your user:");
        //jUserLabel.setBounds(10, 10, 90,50);
        jUserLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel jPasswordLabel = new JLabel("Create your password:");
        //jUserLabel.setBounds(10, 20, 90,50);
        jPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));


        // Adding text fields
        jUserTextField = new JTextField();
        //jUserTextField.setBounds(40, 10, 90,50);

        jPasswordTextField = new JTextField();
        //jUserTextField.setBounds(40, 20, 90,50);


        //Adding buttons
        jBackButton = new JButton("Back");
        jBackButton.setFont(new Font("Arial", Font.BOLD, 14));
        //jLoginButton.setBounds(100, 200, 250, 70);

        jConfirmButton = new JButton("Confirm");
        jConfirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        //jRegisterButton.setBounds(200, 200, 250, 70);


        // Adding listener to buttons
        jBackButton.addActionListener(this);
        jConfirmButton.addActionListener(this);


        // Applying a 3x3 grid layout to the components
        setLayout(new GridLayout(3,3));


        //Adding fields to screen
        add(jUserLabel);
        add(jUserTextField);
        add(jPasswordLabel);
        add(jPasswordTextField);
        add(jBackButton);
        add(jConfirmButton);

        // Centralizing the information and making the screen visible, respectively
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Employee employee = new Employee();

        if (event.getSource() == jBackButton){
            Login login = new Login();
            login.setVisible(true);
            dispose();
        } else if (event.getSource() == jConfirmButton){
            try {
                employee.setUser(jUserTextField.getText());
                employee.setPassword(jPasswordTextField.getText());

                if (employee.getUser().isEmpty() && employee.getPassword().isEmpty()) {
                    throw new IllegalArgumentException("Fields cannot be empty!");
                } else if (employee.getUser().isEmpty()) {
                    throw new IllegalArgumentException("User field cannot be empty!");
                } else if (employee.getPassword().isEmpty()) {
                    throw new IllegalArgumentException("Password field cannot be empty!");
                }

                // Banks logic
                System.out.println("User: " + employee.getUser());
                System.out.println("Passwd: " + employee.getPassword());

                DatabaseConnection db = new DatabaseConnection();
                Connection connection=db.connect_to_db("inventory","postgres","admin");
                db.insertEmployee(connection, employee.getUser(),employee.getPassword());


                // Success message
                JOptionPane.showMessageDialog(null, "User created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}