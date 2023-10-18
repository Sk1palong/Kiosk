import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private List<Product> orderList = new ArrayList<>();
    int cnt = 0;

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

    public void completeOrder() throws InterruptedException {
        orderList.clear();
        cnt++;
        System.out.println("주문이 완료되었습니다!");
        System.out.println("대기번호는 [ " + cnt + " ] 번 입니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);
    }

    public void cancelOrder() throws InterruptedException {
        orderList.clear();
        System.out.println("진행하던 주문이 취소되었습니다. 이전 화면으로 돌아갑니다.");
        Thread.sleep(1000);
    }
    public void failCancelOrder() throws InterruptedException {
        System.out.println("주문이 취소되지 않았습니다. 이전 화면으로 돌아갑니다.");
        Thread.sleep(1000);
    }
    public void blankOrderList() throws InterruptedException {
        System.out.println("주문하신 내용이 없습니다.");
        System.out.println("(초기 메뉴판으로 돌아갑니다.)");
        Thread.sleep(1000);
    }
}
