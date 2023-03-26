public class Store {

    private Long id;

    private String name;

    private String owner;

    private Long wallet;

    public Store() {
    }

    public Store(Long id, String name, String owner, Long wallet) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.wallet = wallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getWallet() {
        return wallet;
    }

    public void setWallet(Long wallet) {
        this.wallet = wallet;
    }
}
