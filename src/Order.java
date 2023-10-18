import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private List<Product> orderList = new ArrayList<>();

    public void addOrder(Product product) {
        Scanner sc = new Scanner(System.in);
        product.information();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        int input = sc.nextInt();
        if (input == 1) {
            orderList.add(product);
            System.out.println(product.getMenuName() + " 가 장바구니에 추가되었습니다.");
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
        }
    }

    public double getOrderList() {
        double totalprice = 0;
        for (Product p : orderList) {
            p.information();
            totalprice += p.getPrice();
        }
        System.out.println("[ Total ]");
        System.out.println("W " + totalprice + "\n");
        System.out.println("1. 주문     2. 메뉴판");
        return totalprice;
    }

}
