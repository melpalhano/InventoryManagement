import resources.DatabaseConnection;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertScreen extends JFrame implements ActionListener {
    private int productParam;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextField quantityField;
    private JTextField locationField;
    private JTextField methodField;
    private final JButton jBackButton;
    private final JButton jInsertButton;

    public InsertScreen(int param) {
        this.productParam = param;
        // Creating main screen
        setTitle("Insert Product Information");
        setSize(880, 525);
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
        JPanel gridPanel = new JPanel(new GridLayout(5, 2));

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


        // Adding FlowLayout containers to the GridLayout
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
            // Using empty borders to have padding and centralize the buttons
            // inside the FlowLayout
            locationFieldContainer.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 15));

            locationField = new JTextField();
            //locationField.setPreferredSize(new Dimension(300, 90));
            locationField.setColumns(20);
            locationFieldContainer.add(locationField);


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


            gridPanel.add(methodLabelContainer);
            gridPanel.add(methodFieldContainer);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        jBackButton = new JButton("Back");
        jBackButton.setPreferredSize(new Dimension(390, 30));

        jInsertButton = new JButton("Insert");
        jInsertButton.setPreferredSize(new Dimension(390, 30));

        buttonPanel.add(jBackButton);
        buttonPanel.add(jInsertButton);

        jBackButton.addActionListener(this);
        jInsertButton.addActionListener(this);

        // Adding compenents to main panel
        panel.add(titlePanel);
        panel.add(gridPanel);
        panel.add(buttonPanel);

        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    public int getProductParam() {
        return productParam;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        PhysicalProduct physicalProduct = new PhysicalProduct();
        VirtualProduct virtualProduct = new VirtualProduct();
        Product product = new Product();

        if (event.getSource() == jBackButton) {
//            ProductStock productStock = new ProductStock();
//            productStock.setComboButtonState(getProductParam());
//            productStock.setIsLoggedIn(true);
//            productStock.setVisible(true);
            this.dispose();
        } else if (event.getSource() == jInsertButton) {
            try {
                //To avoid receiving null value
                physicalProduct.setStoreLocation("");
                if (nameField.getText().isEmpty() && priceField.getText().isEmpty() && quantityField.getText().isEmpty()
                        && (locationField.getText().isEmpty() || methodField.getText().isEmpty())) {
                    throw new IllegalArgumentException("Please, fulfill the fields!");
                } else if (nameField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Please enter a product name.");
                } else if (priceField.getText().isEmpty() || (!priceField.getText().matches("-?\\d+(\\.\\d+)?"))) {
                    throw new IllegalArgumentException("Please enter a valid product price.");
                } else if (Double.parseDouble(priceField.getText()) <= 0) {
                    throw new IllegalArgumentException("Invalid product price. Please enter a positive value.");
                } else if (quantityField.getText().isEmpty() || (!quantityField.getText().matches("-?\\d+(\\.\\d+)?"))) {
                    throw new IllegalArgumentException("Please enter a valid product quantity.");
                } else if (Integer.parseInt(quantityField.getText()) <= 0) {
                    throw new IllegalArgumentException("Invalid product quantity. Please enter a positive value.");
                }
                if (getProductParam() == 1) {
                    if (locationField.getText().isEmpty()) {
                        throw new IllegalArgumentException("Please enter a store location.");
                    }
                    physicalProduct.setStoreLocation(locationField.getText());
                } else if (getProductParam() == 2) {
                    if (methodField.getText().isEmpty()) {
                        throw new IllegalArgumentException("Please enter a store location.");
                    }
                    virtualProduct.setShippingMethod(methodField.getText());
                }

                product.setNameProduct(nameField.getText());
                product.setPriceProduct(Double.parseDouble(priceField.getText()));
                product.setQuantityProduct(Integer.parseInt(quantityField.getText()));

                String productLocation = (!physicalProduct.getStoreLocation().isBlank()) ? physicalProduct.getStoreLocation() : virtualProduct.getShippingMethod();
                String productType = (!physicalProduct.getStoreLocation().isBlank()) ? "Physical Product" : "Virtual Product";

                DatabaseConnection db = new DatabaseConnection();
                Connection connection = db.connect_to_db("inventory", "postgres", "admin");
                db.insertProduct(connection, product.getNameProduct(), product.getPriceProduct(), product.getQuantityProduct(), productLocation, productType);

                System.out.println("Name: " + product.getNameProduct());
                System.out.println("Price: " + product.getPriceProduct());
                System.out.println("Quantity: " + product.getQuantityProduct());
                System.out.println("Location" + productLocation);
                System.out.println("Tipo de Produto " + productType);

                // Reset the field values
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                if (getProductParam() == 1) {
                    locationField.setText("");
                } else if (getProductParam() == 2) {
                    methodField.setText("");
                }

                JOptionPane.showMessageDialog(null, "Product Inserted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
