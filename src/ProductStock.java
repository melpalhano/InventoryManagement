import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductStock extends Product implements ProductControl {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Product> productManagement = new ArrayList<>();

    public ProductStock() {
    }

    public void InsertProduct() {
        boolean continueAdding = true;

        while (continueAdding) {
            int idProduct;
            String nameProduct;
            double priceProduct;
            int quantityProduct;

            try {
                System.out.print("\n------Add Product----\n");
                System.out.print("Enter product ID: ");
                idProduct = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid, product ID must be a number!");
                input.nextLine();
                continue;
            }

            if (idProduct <= 0) {
                System.out.println("Invalid, product ID must be greater than 0!");
                continue;
            }

            boolean idExists = false; // Check if the entered ID already exists
            for (Product product : productManagement) {
                if (product.getIdProduct() == idProduct) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                System.out.println("Product with ID " + idProduct + " already exists!");
                continue;
            }

            System.out.print("Enter product name: ");
            nameProduct = input.nextLine();

            if (nameProduct.isEmpty()) {
                System.out.println("Product name cannot be empty!");
                continue;
            }

            try {
                System.out.print("Enter product price: ");
                priceProduct = input.nextDouble();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid, product price must be a number!");
                input.nextLine();
                continue;
            }

            if (priceProduct <= 0) {
                System.out.println("Invalid, product price must be greater than 0!");
                continue;
            }

            try {
                System.out.print("Enter product quantity: ");
                quantityProduct = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Product quantity must be a number");
                input.nextLine();
                continue;
            }

            if (quantityProduct <= 0) {
                System.out.println("Invalid! Product quantity must be greater than 0");
                continue;
            }

            Product product = new Product(idProduct, nameProduct, priceProduct, quantityProduct);
            productManagement.add(product);

            System.out.println("Product added successfully.");

            System.out.print("Do you want to add another product? (yes/no): ");
            String continueInput = input.nextLine();

            if (continueInput.equalsIgnoreCase("no")) {
                continueAdding = false;
            }
        }
    }

    public void ShowProduct() {
        try {
            if (productManagement.isEmpty()) {
                System.out.println("No products found");
            } else {
                System.out.print("\n------Show Product----\n");
                System.out.println("Products in stock:");
                System.out.printf("%-10s %-20s %-10s %-10s\n", "ID", "Name", "Price", "Quantity");
                System.out.println("-------------------------------------------------------");
                for (Product product : productManagement) {
                    System.out.printf("%-10d %-20s %-10.2f %-10d\n", product.getIdProduct(), product.getNameProduct(), product.getPriceProduct(), product.getQuantityProduct());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }


    public void UpdateProduct() {
        if (productManagement.isEmpty()) {
            System.out.println("No products found...");
            return;
        }

        boolean continueUpdating = true;
        while (continueUpdating) {
            System.out.print("\n------Update Product----\n");
            System.out.print("Enter the product ID to update: ");
            int productId;
            try {
                productId = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid,please enter a valid product ID");
                input.nextLine();
                continue;
            }

            Product productToUpdate = null;
            for (Product product : productManagement) {
                if (product.getIdProduct() == productId) {
                    productToUpdate = product;
                    break;
                }
            }

            if (productToUpdate == null) {
                System.out.println("Product with ID " + productId + " not found");
                continue;
            }

            System.out.print("Enter product name: ");
            String newName = input.nextLine();
            if (newName.trim().isEmpty()) {
                System.out.println("Invalid, product name cannot be empty!");
                continue;
            }
            productToUpdate.setNameProduct(newName);

            System.out.print("Enter product price: ");
            double newPrice;
            try {
                newPrice = input.nextDouble();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid, please enter a valid price!");
                input.nextLine();
                continue;
            }
            if (newPrice <= 0) {
                System.out.println("Invalid, product price must be greater than 0!");
                continue;
            }
            productToUpdate.setPriceProduct(newPrice);

            System.out.print("Enter product quantity: ");
            int newQuantity;
            try {
                newQuantity = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid, please enter a valid quantity!");
                input.nextLine();
                continue;
            }
            if (newQuantity <= 0) {
                System.out.println("Invalid, product quantity must be greater than 0!");
                continue;
            }
            productToUpdate.setQuantityProduct(newQuantity);

            System.out.println("Product updated successfully");

            System.out.print("Do you want to update another product? (yes/no): ");
            String continueInput = input.nextLine();

            if (continueInput.equalsIgnoreCase("no")) {
                continueUpdating = false;
            }
        }
    }


    public void DeleteProduct() {
        if (productManagement.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        boolean continueDeleting = true;
        while (continueDeleting) {
            System.out.println("\n------Delete Product------\n");
            System.out.print("Enter the product ID to delete: ");
            int productId;
            try {
                productId = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Please enter a valid product ID");
                input.nextLine();
                continue;
            }

            boolean productFound = false;
            for (Product product : productManagement) {
                if (product.getIdProduct() == productId) {
                    productManagement.remove(product);
                    productFound = true;
                    System.out.println("Product deleted successfully");
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Product with ID " + productId + " not found");
            }
            System.out.print("Do you want to delete another product? (yes/no): ");
            String continueInput = input.nextLine();

            if (continueInput.equalsIgnoreCase("no")) {
                continueDeleting = false;
            }
        }
    }

}


