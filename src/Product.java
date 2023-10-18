public class Product extends Menu {
    private double price;
    private String category;

    public Product(String menuName, String description, double price,String category) {
        super(menuName, description);
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory(){
        return category;
    }


    @Override
    public void information() {
        System.out.printf("%-20s | W %s | %s\n ", getMenuName(), price, getDescription());
    }

}
