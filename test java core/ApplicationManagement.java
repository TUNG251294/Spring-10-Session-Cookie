import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApplicationManagement {

    private static Set<Store> stores = new HashSet<>();

    private static Set<Customer> customers = new HashSet<>();

    private static Set<Product> products = new HashSet<>();

    public static Set<Store> getStores(){
        return stores;
    }

    public static Set<Product> getProducts(){
        return products;
    }

    public static Set<Customer> getCustomers(){
        return customers;
    }

    public static Set<Store> inputStores(Set<Store> inputStores){
        stores.addAll(inputStores);
        return stores;
    }

    public static Set<Product> inputProducts(Set<Product> inputProducts){
        products.addAll(inputProducts);
        return products;
    }

    public static Set<Customer> inputCustomers(Set<Customer> inputCustomers){
        customers.addAll(inputCustomers);
        return customers;
    }

    public static Set<Product> getProductsByStoreId(Long storeId){
        Set<Product> trungTrauStore = new HashSet<>();
        for(Product ele : products){
            if(ele.getStoreId() == storeId){
                trungTrauStore.add(ele);
            }
        }
        return trungTrauStore;
    }

    public static void buyProduct(Long thaoId, Long productId){
        Product product = getProductById(productId);
        calculatorForThao(thaoId, product.getPrice());
        calculatorForShop(product);
    }

    private static Product getProductById(Long productId) {
        for(Product element: products){
            if(element.getId() == productId){
                return element;
            }
        }
        throw new IllegalArgumentException("productID is invalid");
    }

    private static void calculatorForShop(Product product) {
        long price = product.getPrice();
        long storeId = product.getStoreId();
        for(Store store : stores){
            if(store.getId() == storeId){
                long wallet = store.getWallet();
                if(wallet >= 0) {
                    wallet = wallet + price;
                    store.setWallet(wallet);
                } else{
                    throw new IllegalArgumentException("Invalid wallet of store");
                }
                break;
            }
        }

        int quantity = product.getQuantity();
        if(quantity >= 1){
            quantity = quantity - 1;
            product.setQuantity(quantity);
        } else {
            throw new IllegalArgumentException("Not enough product");
        }
    }

    private static void calculatorForThao(Long thaoId, long price) {
        for(Customer ele : customers){
            if(ele.getId() == thaoId){
                Long wallet = ele.getWallet();
                if(wallet > price){
                    wallet = wallet - price;
                    ele.setWallet(wallet);
                    return;
                } else {
                    throw new IllegalArgumentException("wallet do not have enough money");
                }
            }
        }
        throw new IllegalArgumentException("Thao is not in the system");
    }


}
