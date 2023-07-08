import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateScreen extends JFrame implements ActionListener {
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
    private final JButton jUpdateButton;
    private String[][] products;
    private int currentIndex;

    public UpdateScreen(int param) {
        this.productParam = param;
        // Creating main screen
        setTitle("Update Product Information");
        setSize(850, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating BoxLayout panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Creating and setting title properties
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Update a Product");
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
        jUpdateButton = new JButton("Update Product");
        jUpdateButton.setPreferredSize(new Dimension(390, 30));
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
        buttonUpdatePanel.add(jUpdateButton);
        buttonUpdatePanel.add(jInvisibleButton);


        // Adding listeners to buttons
        jBackButton.addActionListener(this);
        jSearchButton.addActionListener(this);
        jPreviousButton.addActionListener(this);
        jNextButton.addActionListener(this);
        jUpdateButton.addActionListener(this);

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
        PhysicalProduct physicalProduct = new PhysicalProduct();
        VirtualProduct virtualProduct = new VirtualProduct();
        Product product = new Product();

        if (event.getSource() == jBackButton){
//            ProductStock productStock = new ProductStock();
//            productStock.setComboButtonState(getProductParam());
//            productStock.setVisible(true);
            this.dispose();
        } else if (event.getSource() == jSearchButton){
            try {
                // TO-DO:
                // Select the value by id from the database
                // Insert the values in an array
                // Test if the values are from physical ou virtual products
                // Enhance the exception treatment process

                if (idField.getText().isEmpty()){
                    throw new IllegalArgumentException("ID Field cannot be empty!");
                }

                // Set ID field to bet not editable and turn other back to editable
                idField.setEditable(false);
                nameField.setEditable(true);
                priceField.setEditable(true);
                quantityField.setEditable(true);

                if (getProductParam() == 1){
                    locationField.setEditable(true);
                } else if (getProductParam() == 2){
                    methodField.setEditable(true);
                }

                // Gets the ID value from the ID Field
                product.setIdProduct(Integer.parseInt(idField.getText()));

                // TO-DO
                // Logic that gets the values associated to the ID from the database

//                products = new String[][]{{"1","Mel Test", "10000", "1", "Gramadil","type"},
//                        {"2","Cesar Test", "100", "1", "Sluizil"}};
//
//                currentIndex = 0;
//                setProductFields(currentIndex);
            } catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == jPreviousButton){
            // Not being used
            if (currentIndex > 0) {
                currentIndex--;
                setProductFields(currentIndex);
            }
        } else if (event.getSource() == jNextButton){
            // Not being used
            if (currentIndex < products.length - 1) {
                currentIndex++;
                setProductFields(currentIndex);
            }
        } else if (event.getSource() == jUpdateButton){
            try {

                if (nameField.getText().isEmpty() && priceField.getText().isEmpty() && quantityField.getText().isEmpty()
                        && (locationField.getText().isEmpty() || methodField.getText().isEmpty())) {
                    throw new IllegalArgumentException("Please, fulfill the fields!");
                } else if (nameField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Please enter a product name.");
                } else if (priceField.getText().isEmpty() || (!priceField.getText().matches("-?\\d+(\\.\\d+)?"))) {
                    throw new IllegalArgumentException("Please enter a valid product price.");
                } else if (Double.parseDouble(priceField.getText()) <= 0) {
                    throw new IllegalArgumentException("Invalid product price. Please enter a positive value.");
                }else if (quantityField.getText().isEmpty() || (!quantityField.getText().matches("-?\\d+(\\.\\d+)?"))) {
                    throw new IllegalArgumentException("Please enter a valid product quantity.");
                }else if (Integer.parseInt(quantityField.getText()) <= 0) {
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

                // Banks logic
                System.out.println("Name: " + product.getNameProduct());
                System.out.println("Price: " + product.getPriceProduct());
                System.out.println("Quantity: " + product.getQuantityProduct());
                System.out.println("Location or Shipping: " + ((!physicalProduct.getStoreLocation().isBlank()) ? physicalProduct.getStoreLocation() : virtualProduct.getShippingMethod()));


                // Reset the field values
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                if (getProductParam() == 1){
                    locationField.setText("");
                } else if (getProductParam() == 2){
                    methodField.setText("");
                }

                JOptionPane.showMessageDialog(null, "Product Inserted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    // Setting the textField values
    private void setProductFields(int index) {
        idField.setText(products[index][0]);
        nameField.setText(products[index][1]);
        priceField.setText(products[index][2]);
        quantityField.setText(products[index][3]);

        if (getProductParam() == 1){
            locationField.setText(products[index][4]);
        } else if (getProductParam() == 2){
            methodField.setText(products[index][4]);
        }
    }
}
