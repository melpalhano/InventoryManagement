import resources.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class DeleteScreen extends JFrame implements ActionListener {
    private int productParam;
    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField quantityField;
    private JTextField locationField;
    private JTextField methodField;
    private final JButton jBackButton;
    private final JButton jSearchButton;
    private final JButton jPreviousButton;
    private final JButton jNextButton;
    private final JButton jDeleteButton;

    private String[][] productsdb;
    private int currentIndex;

    public DeleteScreen(int param) {
        this.productParam = param;
        // Creating main screen
        setTitle("Delete Product Information");
        setSize(850, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating BoxLayout panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Creating and setting title properties
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Delete a Product");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);

        // Creating GridPanel and adding Labels and Texfields
        JPanel gridPanel = new JPanel(new GridLayout(6, 2));


        // Creating container to use inside the GridLayout
        JPanel idLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        idLabelContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));
        JLabel idLabel = new JLabel("Product ID:");
        idLabelContainer.add(idLabel);

        // Creating container to use inside the GridLayout
        JPanel idFieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        idFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));
        idField = new JTextField();
        //nameField.setPreferredSize(new Dimension(300, 90));
        idField.setColumns(20);
        idFieldContainer.add(idField);



        // Creating container to use inside the GridLayout
        JPanel nameLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        nameLabelContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabelContainer.add(nameLabel);

        // Creating container to use inside the GridLayout
        JPanel nameFieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        nameFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));
        nameField = new JTextField();
        //nameField.setPreferredSize(new Dimension(300, 90));
        nameField.setColumns(20);
        nameFieldContainer.add(nameField);


        // Creating container to use inside the GridLayout
        JPanel priceLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        priceLabelContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));
        JLabel priceLabel = new JLabel("Product Price:");
        priceLabelContainer.add(priceLabel);


        // Creating container to use inside the GridLayout
        JPanel priceFieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        priceFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

        priceField = new JTextField();
        //priceField.setPreferredSize(new Dimension(300, 90));
        priceField.setColumns(20);
        priceFieldContainer.add(priceField);


        // Creating container to use inside the GridLayout
        JPanel quantityLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        quantityLabelContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));
        JLabel quantityLabel = new JLabel("Product Quantity:");
        quantityLabelContainer.add(quantityLabel);


        // Creating container to use inside the GridLayout
        JPanel quantityFieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Using empty borders to have padding and centralize the buttons
        // inside the FlowLayout
        quantityFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

        quantityField = new JTextField();
        //quantityField.setPreferredSize(new Dimension(300, 90));
        quantityField.setColumns(20);
        quantityFieldContainer.add(quantityField);

        // Setting fields to be non-editable except the ID Field
        nameField.setEditable(false);
        priceField.setEditable(false);
        quantityField.setEditable(false);

        // Adding FlowLayout containers to the GridLayout
        gridPanel.add(idLabelContainer);
        gridPanel.add(idFieldContainer);
        gridPanel.add(nameLabelContainer);
        gridPanel.add(nameFieldContainer);
        gridPanel.add(priceLabelContainer);
        gridPanel.add(priceFieldContainer);
        gridPanel.add(quantityLabelContainer);
        gridPanel.add(quantityFieldContainer);

        // Logic to set show Physical or Virtual specific fields
        if (param == 1){
            // Creating container to use inside the GridLayout
            JPanel locationLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
            // Using empty borders to have padding and centralize the buttons
            // inside the FlowLayout
            locationLabelContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));
            JLabel locationLabel = new JLabel("Store Location:");
            locationLabelContainer.add(locationLabel);


            // Creating container to use inside the GridLayout
            JPanel locationFieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
            // Using empty borders to have padding and centralize the buttons inside the FlowLayout
            locationFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

            locationField = new JTextField();
            //locationField.setPreferredSize(new Dimension(300, 90));
            locationField.setColumns(20);
            locationFieldContainer.add(locationField);

            // Setting field to be non-editable
            locationField.setEditable(false);

            gridPanel.add(locationLabelContainer);
            gridPanel.add(locationFieldContainer);
        } else if (param == 2){
            // Creating container to use inside the GridLayout
            JPanel methodLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
            // Using empty borders to have padding and centralize the buttons
            // inside the FlowLayout
            methodLabelContainer.setBorder(BorderFactory.createEmptyBorder(50, 15, 0, 0));
            JLabel methodLabel = new JLabel("Shipping Method:");
            methodLabelContainer.add(methodLabel);


            // Creating container to use inside the GridLayout
            JPanel methodFieldContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
            // Using empty borders to have padding and centralize the buttons
            // inside the FlowLayout
            methodFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

            methodField = new JTextField();
            //methodField.setPreferredSize(new Dimension(300, 90));
            methodField.setColumns(20);
            methodFieldContainer.add(methodField);

            // Setting field to be non-editable
            methodField.setEditable(false);

            gridPanel.add(methodLabelContainer);
            gridPanel.add(methodFieldContainer);
        }

        // Creating Back and Seach buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Creating buttons
        jBackButton = new JButton("Back");
        jBackButton.setPreferredSize(new Dimension(390, 30));
        jSearchButton = new JButton("Search By ID");
        jSearchButton.setPreferredSize(new Dimension(390, 30));
        // Adding buttons to the panel
        buttonPanel.add(jBackButton);
        buttonPanel.add(jSearchButton);


        // Creating Previous and Next panel button
        JPanel buttonPNPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Creating buttons
        jPreviousButton = new JButton("Previous Product");
        jPreviousButton.setPreferredSize(new Dimension(390, 30));
        jNextButton = new JButton("Next Product");
        jNextButton.setPreferredSize(new Dimension(390, 30));
        // Adding buttons to panel
        buttonPNPanel.add(jPreviousButton);
        buttonPNPanel.add(jNextButton);


        // Creating Update panel button
        JPanel buttonUpdatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Creating buttons
        jDeleteButton = new JButton("Delete Product");
        jDeleteButton.setPreferredSize(new Dimension(390, 30));
        // Creating invisible button to set the button to the left and aligned with
        // the rest of the buttons
        JButton jInvisibleButton = new JButton("");
        jInvisibleButton.setPreferredSize(new Dimension(390, 30));
        // Making the button invisible
        jInvisibleButton.setEnabled(false);
        jInvisibleButton.setOpaque(false);
        jInvisibleButton.setContentAreaFilled(false);
        jInvisibleButton.setBorderPainted(false);
        // Adding buttons to panel
        buttonUpdatePanel.add(jDeleteButton);
        buttonUpdatePanel.add(jInvisibleButton);


        // Adding listeners to buttons
        jBackButton.addActionListener(this);
        jSearchButton.addActionListener(this);
        jPreviousButton.addActionListener(this);
        jNextButton.addActionListener(this);
        jDeleteButton.addActionListener(this);

        // Adding components to main panel
        panel.add(titlePanel);
        panel.add(gridPanel);
        panel.add(buttonUpdatePanel);
        //panel.add(buttonPNPanel);
        panel.add(buttonPanel);

        // Setting the panel as the main panel
        setContentPane(panel);

        // Centralizing the information
        setLocationRelativeTo(null);
    }

    public int getProductParam() {
        return productParam;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        DatabaseConnection db=new DatabaseConnection();
        Connection connection=db.connect_to_db("inventory","postgres","admin");
        PhysicalProduct physicalProduct = new PhysicalProduct();
        VirtualProduct virtualProduct = new VirtualProduct();
        Product product = new Product();

        if (event.getSource() == jBackButton){
            this.dispose();
        } else if (event.getSource() == jSearchButton){
            try {

                if (idField.getText().isEmpty()){
                    throw new IllegalArgumentException("ID Field cannot be empty!");
                }

              if(!idField.getText().matches("-?\\d+(\\.\\d+)?")){
                  throw new IllegalArgumentException("ID Field must be a number!");
              }

                // Gets the ID value from the ID Field
                product.setIdProduct(Integer.parseInt(idField.getText()));
                productsdb = db.searchProductID(connection,"product_id", "product_name", "product_price", "product_quantity", "product_location", "product_type", product.getIdProduct());

                if (productsdb.length <= 0){
                    throw new Exception("Please, insert a valid ID!");
                }
                // Set ID field back to non-editable
                idField.setEditable(false);


                currentIndex = 0;
                setProductFields(currentIndex);
            } catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == jPreviousButton){
            if (currentIndex > 0) {
                currentIndex--;
                setProductFields(currentIndex);
            }
        } else if (event.getSource() == jNextButton){

            if (currentIndex < productsdb.length - 1) {
                currentIndex++;
                setProductFields(currentIndex);
            }
        } else if (event.getSource() == jDeleteButton){
            try {
                //Delete in the database from the ID
                if (idField.getText().isEmpty()){
                    throw new Exception("ID Field cannot be empty!");
                }

                if(!idField.getText().isEmpty()){
                    productsdb = db.searchProductID(connection,"product_id", "product_name", "product_price", "product_quantity", "product_location", "product_type", product.getIdProduct());
                    if (productsdb == null){
                        throw new Exception("Enter a valid ID");
                    }
                    db.deleteProduct(connection, Integer.parseInt(idField.getText()));
                }else{
                    productsdb = db.searchProductID(connection,"product_id", "product_name", "product_price", "product_quantity", "product_location", "product_type", product.getIdProduct());
                    if (productsdb == null){
                        throw new Exception("Enter a valid ID");
                    }
                    db.deleteProduct(connection, product.getIdProduct());
                }

                // Successfull delete message
                JOptionPane.showMessageDialog(null, "Product Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Reset the field values
                idField.setText("");
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                if (getProductParam() == 1){
                    locationField.setText("");
                }else if (getProductParam() == 2){
                    methodField.setText("");
                }

            } catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Setting the textField values
    private void setProductFields(int index) {
        idField.setText(productsdb[index][0]);
        nameField.setText(productsdb[index][1]);
        priceField.setText(productsdb[index][2]);
        quantityField.setText(productsdb[index][3]);

        if (getProductParam() == 1){
            locationField.setText(productsdb[index][4]);
        } else if (getProductParam() == 2){
            methodField.setText(productsdb[index][4]);
        }
    }
}