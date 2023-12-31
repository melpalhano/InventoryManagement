import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import resources.DatabaseConnection;
import java.sql.Connection;

public class Login extends JFrame implements ActionListener {
    private final JButton jLoginButton;
    private final JButton jRegisterButton;
    private final JTextField jUserTextField;
    private final JTextField jPasswordTextField;

    public Login() {

        // Creating main screen
        setTitle("Login");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(null);

        // Adding labels for text fields
        JLabel jUserLabel = new JLabel("User:");
        //jUserLabel.setBounds(10, 10, 90,50);
        jUserLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel jPasswordLabel = new JLabel("Password:");
        //jUserLabel.setBounds(10, 20, 90,50);
        jPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Adding text fields

        jUserTextField = new JTextField();
        //jUserTextField.setBounds(40, 10, 90,50);

        jPasswordTextField = new JTextField();
        //jUserTextField.setBounds(40, 20, 90,50);

        //Adding buttons
        jLoginButton = new JButton("Login");
        jLoginButton.setFont(new Font("Arial", Font.BOLD, 14));
        //jLoginButton.setBounds(100, 200, 250, 70);

        jRegisterButton = new JButton("Register");
        jRegisterButton.setFont(new Font("Arial", Font.BOLD, 14));
        //jRegisterButton.setBounds(200, 200, 250, 70);


        // Adding listener to buttons
        jLoginButton.addActionListener(this);
        jRegisterButton.addActionListener(this);

        // Applying a 3x3 grid layout to the components
        setLayout(new GridLayout(3, 3));

        //Adding fields to screen
        add(jUserLabel);
        add(jUserTextField);
        add(jPasswordLabel);
        add(jPasswordTextField);
        add(jLoginButton);
        add(jRegisterButton);

        // Centralizing the information and making the screen visible, respectively
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.connect_to_db("inventory", "postgres", "admin");
        if (event.getSource() == jLoginButton) {

            try {

                if(jUserTextField.getText().isEmpty() && jPasswordTextField.getText().isEmpty()){
                    throw new IllegalArgumentException("Fields cannot be empty!");
                } else if(jUserTextField.getText().isEmpty()){
                    throw new IllegalArgumentException("User field cannot be empty");
                } else if(jPasswordTextField.getText().isEmpty()){
                    throw new IllegalArgumentException("Password field cannot be empty");
                }

                if (db.loginValidation(connection, jUserTextField.getText(), jPasswordTextField.getText())){
                    JOptionPane.showMessageDialog(null, "Login Succesfull", "Error", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    throw new IllegalArgumentException("Invalid Credentials!");
                }
                ProductStock productStock = new ProductStock();
                productStock.setVisible(true);
                dispose();
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (event.getSource() == jRegisterButton) {
            EmployeeRegister employeeRegister = new EmployeeRegister();
            dispose();
        }
    }
}