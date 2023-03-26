public class Customer {

    private long id;

    private String name;

    private int age;

    private long wallet;

    public Customer() {
    }

    public Customer(long id, String name, int age, long wallet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wallet = wallet;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }
}
