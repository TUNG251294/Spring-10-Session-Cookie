public class Product {

    private long id;

    private String name;

    private long price;

    private int quantity;

    private long storeId;

    public Product() {
    }

    public Product(long id, String name, long price, int quantity, long storeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.storeId = storeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", storeId=" + storeId +
                '}';
    }
}
