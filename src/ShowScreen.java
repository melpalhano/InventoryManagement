import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import resources.DatabaseConnection;

import java.sql.Connection;
import java.util.Arrays;

public class ShowScreen extends JFrame implements ActionListener {
    private int productParam;
    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField quantityField;
    private JTextField locationField;
    private JTextField methodField;
    private final JButton jBackButton;
    private final JButton jShowAllButton;
    private final JButton jPreviousButton;
    private final JButton jNextButton;
    private String[][] products = {};

    private String[][] productsdb;
    private String[][] productsPhysical;
    private String[][] productsVirtual;
    // Trim the arrays to remove any unused elements
    private String[][] trimmedProductsPhysical;
    private String[][] trimmedProductsVirtual;

    private int currentIndex;

    public ShowScreen(int param) {
        this.productParam = param;
        // Creating main screen
        setTitle("Insert Product Information");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating BoxLayout panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Creating and setting title properties
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Insert a Product");
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

        // Setting fields to be non-editable
        idField.setEditable(false);
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
        if (param == 1) {
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
        } else if (param == 2) {
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

        // Creating Panel Button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Creating buttons
        jBackButton = new JButton("Back");
        jBackButton.setPreferredSize(new Dimension(390, 30));

        jShowAllButton = new JButton("Show All");
        jShowAllButton.setPreferredSize(new Dimension(390, 30));
        // Adding buttons to the panel
        buttonPanel.add(jBackButton);
        buttonPanel.add(jShowAllButton);
        // Creating another panel button
        JPanel buttonPNPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Creating buttons
        jPreviousButton = new JButton("Previous Product");
        jPreviousButton.setPreferredSize(new Dimension(390, 30));

        jNextButton = new JButton("Next Product");
        jNextButton.setPreferredSize(new Dimension(390, 30));
        // Adding buttons to panel
        buttonPNPanel.add(jPreviousButton);
        buttonPNPanel.add(jNextButton);

        // Adding listeners to buttons
        jBackButton.addActionListener(this);
        jShowAllButton.addActionListener(this);
        jPreviousButton.addActionListener(this);
        jNextButton.addActionListener(this);

        // Adding components to main panel
        panel.add(titlePanel);
        panel.add(gridPanel);
        panel.add(buttonPNPanel);
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

        if (event.getSource() == jBackButton) {
//            ProductStock productStock = new ProductStock();
//            productStock.setVisible(true);
//            productStock.setComboButtonState(getProductParam());
            this.dispose();
        } else if (event.getSource() == jShowAllButton) {
            try {
                // TO-DO:
                // Select all the values from the database
                // Insert the values in an array
                // Test if the values are from physical ou virtual products
                // Enhance the exception treatment process
                DatabaseConnection db = new DatabaseConnection();
                Connection connection = db.connect_to_db("inventory", "postgres", "admin");

                productsdb = db.readProduct(connection, "product_id", "product_name", "product_price", "product_quantity", "product_location", "product_type");


                int physicalCount = 0; // Counter for physical products
                int virtualCount = 0; // Counter for virtual products

                String[][] productsPhysical = new String[productsdb.length][5]; // Array for physical products
                String[][] productsVirtual = new String[productsdb.length][5]; // Array for virtual products

                for (int i = 0; i < productsdb.length; i++) {
                    if (productsdb[i][5].equals("Physical Product")) {
                        productsPhysical[physicalCount] = new String[]{productsdb[i][0], productsdb[i][1], productsdb[i][2], productsdb[i][3], productsdb[i][4]};
                        physicalCount++;
                    } else {
                        productsVirtual[virtualCount] = new String[]{productsdb[i][0], productsdb[i][1], productsdb[i][2], productsdb[i][3], productsdb[i][4]};
                        virtualCount++;
                    }
                }

                // Trim the arrays to remove any unused elements
                trimmedProductsPhysical = Arrays.copyOf(productsPhysical, physicalCount);
                trimmedProductsVirtual = Arrays.copyOf(productsVirtual, virtualCount);

                currentIndex = 0;
                setProductFields(currentIndex);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == jPreviousButton) {
            // TO-DO
            // Add try catch block for values < 0
            // Test if the array is not empty
            try {
                if (productsdb.length > 0) {
                    if (currentIndex > 0) {
                        currentIndex--;
                        setProductFields(currentIndex);
                    } else {
                        throw new Exception("This is the first item!");
                    }
                } else {
                    throw new Exception("Show the products first!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == jNextButton) {
            // TO-DO
            // Add try catch block for values greater than the array size
            // Test if the array is not empty
            try {
                if (productsdb.length > 0) {
                    if (getProductParam() == 1) {
                        if (currentIndex < trimmedProductsPhysical.length - 1) {
                            currentIndex++;
                            setProductFields(currentIndex);
                        } else {
                            throw new Exception("This is the last item!");
                        }
                    } else if (getProductParam() == 2) {
                        if (currentIndex < trimmedProductsVirtual.length - 1) {
                            currentIndex++;
                            setProductFields(currentIndex);
                        } else {
                            throw new Exception("This is the last item!");
                        }
                    }
                } else {
                    throw new Exception("Show the products first!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Setting the textField values
    private void setProductFields(int index) {
        if (getProductParam() == 1) {
            idField.setText(trimmedProductsPhysical[index][0]);
            nameField.setText(trimmedProductsPhysical[index][1]);
            priceField.setText(trimmedProductsPhysical[index][2]);
            quantityField.setText(trimmedProductsPhysical[index][3]);
            locationField.setText(trimmedProductsPhysical[index][4]);
        } else if (getProductParam() == 2) {
            idField.setText(trimmedProductsVirtual[index][0]);
            nameField.setText(trimmedProductsVirtual[index][1]);
            priceField.setText(trimmedProductsVirtual[index][2]);
            quantityField.setText(trimmedProductsVirtual[index][3]);
            methodField.setText(trimmedProductsVirtual[index][4]);
        }
    }
}
