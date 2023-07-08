public class VirtualProduct extends Product {
    private String shippingMethod;

    public VirtualProduct() {
    }

    public VirtualProduct(int idProduct, String nameProduct, double priceProduct, int quantityProduct, String storeLocation, String shippingMethod) {
        super(idProduct, nameProduct, priceProduct, quantityProduct);
        this.shippingMethod = shippingMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}