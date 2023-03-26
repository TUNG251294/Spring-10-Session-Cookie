import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args){
        Set<Store> storeSet = new HashSet<>();
        storeSet.add(new Store(1L, "trung trau", "trung", 0L));
        storeSet.add(new Store(2L, "Phu", "Phu", 0L));
        storeSet.add(new Store(3L, "Khang", "khang", 0L));
        storeSet = ApplicationManagement.inputStores(storeSet);
        storeSet = ApplicationManagement.getStores();

        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product(1L, "giay sandan", 5, 10, 1L));
        productSet.add(new Product(2L, "giay bup be", 6, 10, 1L));
        productSet.add(new Product(3L, "giay snake", 7, 10, 1L));
        productSet.add(new Product(4L, "Son moi huong canh sen", 2, 10, 1L));
        productSet.add(new Product(5L, "tui Luis Vutton", 4, 10, 1L));

        productSet.add(new Product(6L, "chuot laptop", 4, 10, 2L));
        productSet.add(new Product(7L, "pin laptop", 5, 10, 2L));
        productSet.add(new Product(8L, "Ban phim laptop", 10, 10, 2L));
        productSet.add(new Product(9L, "Loa", 2, 10, 2L));
        productSet.add(new Product(10L, "Tui dung", 3, 10, 2L));

        productSet = ApplicationManagement.inputProducts(productSet);

        Set<Customer> customers = new HashSet<>();
        customers.add(new Customer(1L, "Thao", 18, 50));
        customers.add(new Customer(2L, "Quang", 40, 20));
        customers.add(new Customer(3L, "Long", 45, 100));
        customers = ApplicationManagement.inputCustomers(customers);

        Set<Product> productOfTrungTrau = ApplicationManagement.getProductsByStoreId(1L);
        for(Product product: productOfTrungTrau){
            System.out.println(product.toString());
        }

        ApplicationManagement.buyProduct(1L, 4L);
    }
}
