public class Product {
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private int quantityProduct;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double priceProduct, int quantityProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
    }

    /*
    public void getProduct(){
        System.out.println("Product ID: "+this.getIdProduct());
        System.out.println("Product's name: "+this.getNameProduct());
        System.out.println("Price: "+this.getPriceProduct());
        System.out.println("Quantity: "+this.getQuantityProduct());
    }
    */
    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public void AllProductHandling(){
        System.out.println();
    }

}