public class PhysicalProduct extends Product{
    private String storeLocation;
    public PhysicalProduct(){}
    public PhysicalProduct(int idProduct, String nameProduct, double priceProduct, int quantityProduct, String storeLocation){
        super(idProduct, nameProduct, priceProduct, quantityProduct);
        this.storeLocation = storeLocation;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
}
