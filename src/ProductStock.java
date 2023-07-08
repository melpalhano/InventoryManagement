import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductStock extends JFrame implements ActionListener, ProductControl {
    private final JButton jInsertProduct;
    private final JButton jShowProduct;
    private final JButton jUpdateProduct;
    private final JButton jDeleteProduct;
    private final JButton jLogOutButton;
    private final JComboBox<String> jComboButton;
    private int comboButtonState;
    public ProductStock(){
        // Creating main screen
        setTitle("Product Management");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the title label and add it to the main panel
        JLabel titleLabel = new JLabel("Product Inventory");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create the panel for the GridLayout and add it to the main panel
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2,2, 10, 10));
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        // Creating insert container to use inside the GridLayout
        JPanel insertContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        insertContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));

        jInsertProduct = new JButton("Insert Product");
        // Setting button size
        jInsertProduct.setPreferredSize(new Dimension(400,80));
        // Inserting button in the container
        insertContainer.add(jInsertProduct);


        // Creating show container to use inside the GridLayout
        JPanel showContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        showContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

        jShowProduct = new JButton("Show Product");
        // Setting button size
        jShowProduct.setPreferredSize(new Dimension(400,80));
        // Inserting button in the container
        showContainer.add(jShowProduct);


        // Creating update container to use inside the GridLayout
        JPanel updateContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        updateContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));

        jUpdateProduct = new JButton("Update Product");
        // Setting button size
        jUpdateProduct.setPreferredSize(new Dimension(400,80));
        // Inserting button in the container
        updateContainer.add(jUpdateProduct);


        // Creating delete container to use inside the GridLayout
        JPanel deleteContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        deleteContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

        jDeleteProduct = new JButton("Delete Product");
        // Setting button size
        jDeleteProduct.setPreferredSize(new Dimension(400,80));
        // Inserting button in the container
        deleteContainer.add(jDeleteProduct);


        // Add components to the gridPanel
        gridPanel.add(insertContainer);
        gridPanel.add(showContainer);
        gridPanel.add(updateContainer);
        gridPanel.add(deleteContainer);

        // Adding another JPanel to the bottom of the BorderLayout
        JPanel bottomPanel = new JPanel();
        // Adding flow layout so we can move the button around
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Adding a back button
        jLogOutButton = new JButton("Log Out");
        jLogOutButton.setPreferredSize(new Dimension(390, 30));

        // Creating a combo box button
        jComboButton = new JComboBox<String>(new String[]{"Select an option:", "Physical Inventory", "Virtual Inventory"});
        jComboButton.setPreferredSize(new Dimension(390, 30));
        // Creating an empty label to separate the two buttons
        JLabel invisibleSpace = new JLabel("");

        if (getComboButtonState() != 0){
            jComboButton.setSelectedIndex(getComboButtonState());
        }

        // Adding back button to the main BorderLayout panel
        bottomPanel.add(jLogOutButton);
        // Adding the empty label
        bottomPanel.add(invisibleSpace);
        // Adding the combo button
        bottomPanel.add(jComboButton);
        // Adding the new panel to the bottom part of the Border Layout
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);


        // Set the main panel as the content pane of the JFrame
        setContentPane(mainPanel);

        // Adding Listeners to buttons
        jInsertProduct.addActionListener(this);
        jShowProduct.addActionListener(this);
        jUpdateProduct.addActionListener(this);
        jDeleteProduct.addActionListener(this);
        jLogOutButton.addActionListener(this);
        jComboButton.addActionListener(this);


        // Centralizing the information
        setLocationRelativeTo(null);
    }



    public int getComboButtonState() {
        return comboButtonState;
    }

    public void setComboButtonState(int comboButtonState) {
        this.comboButtonState = comboButtonState;
    }
    

    @Override
    public void insertProduct(int param) {
        if (param != 0){
           InsertScreen insertScreen = new InsertScreen(param);
           insertScreen.setVisible(true);
        }
    }

    @Override
    public void showProduct(int param) {
        if (param != 0){
            ShowScreen showScreen = new ShowScreen(param);
            showScreen.setVisible(true);
        }
    }

    @Override
    public void updateProduct(int param) {
        if (param != 0){
            UpdateScreen updateScreen = new UpdateScreen(param);
            updateScreen.setVisible(true);
        }
    }

    @Override
    public void deleteProduct(int param) {
        if (param != 0){
            DeleteScreen deleteScreen = new DeleteScreen(param);
            deleteScreen.setVisible(true);
        }
    }

    private int comboButtonAction(){
            comboButtonState = 0;

        if (jComboButton.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Please, select an option!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jComboButton.getSelectedIndex() == 1){
            comboButtonState = 1;
        } else{
            comboButtonState = 2;
        }
        return comboButtonState;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == jInsertProduct){
            insertProduct(comboButtonAction());
        } else if (event.getSource() == jShowProduct){
            showProduct(comboButtonAction());
        }else if (event.getSource() == jUpdateProduct){
            updateProduct(comboButtonAction());
        } else if (event.getSource() == jDeleteProduct){
            deleteProduct(comboButtonAction());
        } else if (event.getSource() == jLogOutButton){
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }
}
