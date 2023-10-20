import java.util.Objects;

public class Product extends Menu {
    private double price;
    private String category;
    private double optionPrice;

    public Product(String menuName, String description, double price, String category) {
        super(menuName, description);
        this.price = price;
        this.category = category;
    }
    public Product(String menuName, String description, double price, String category, double optionPrice) {
//        super(menuName, description);
        this(menuName, description, price, category);
        this.optionPrice = optionPrice;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public double getOptionPrice() {
        return optionPrice;
    }
    @Override
    public void information() { //상세메뉴 출력
        System.out.printf("%-20s | W %s | %s\n ", getMenuName(), price, getDescription());
    }
    public void information(int cnt) { //장바구니에 담겨있는 상품 출력
        System.out.printf("%-20s | W %s | %s 개 | %s\n ", getMenuName(), price, cnt, getDescription());
    }
    @Override // 옵션선택하는 메뉴 수량 세기위해...
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product temp = (Product) obj;
            return this.getMenuName().equals(temp.getMenuName()) &&
                    this.getPrice() == temp.getPrice() &&
                    this.getOptionPrice() == temp.getOptionPrice() &&
                    this.getDescription().equals(temp.getDescription()) &&
                    this.getCategory().equals(temp.getCategory());
        }
        return false;
    }
    public int hashCode() {
        return Objects.hash(getMenuName(), getDescription(), getPrice(), getOptionPrice(), getCategory());
    }
}
