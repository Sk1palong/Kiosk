import java.util.*;

public class Order {
    private List<Product> orderList = new ArrayList<>();
    int cnt = 0;
    private double income;
    private HashSet<Product> soldList;

    public void addOrder(Product product) {
        Scanner sc = new Scanner(System.in);
        if (product.getOptionPrice() != 0) {
            product.information();
            Product sizeUpProduct = new Product(product.getMenuName() + "(double)", product.getDescription(), product.getOptionPrice(), product.getCategory(), product.getOptionPrice());
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.println("1. Single(W " + product.getPrice() + ")          2. Double(W " + sizeUpProduct.getPrice() + ")");
            int optionInput = sc.nextInt();
            if (optionInput == 1) {
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
            } else if (optionInput == 2) {
                sizeUpProduct.information();
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1.확인          2.취소");
                int input = sc.nextInt();
                if (input == 1) {
                    orderList.add(sizeUpProduct);
                    System.out.println(sizeUpProduct.getMenuName() + " 가 장바구니에 추가되었습니다.");
                } else if (input == 2) {
                    System.out.println("장바구니에 추가하지 않았습니다.");
                }
            }
        } else {
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
    }

    public void startOrder() throws InterruptedException {
        if (!orderList.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int confirmOrder;
            int EA;
            double totalprice = 0;
            System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println("[ Orders ]");
            HashSet<Product> orderListSet = new HashSet<>(orderList);
            for (Product p : orderListSet) {
                EA = Collections.frequency(orderList, p);
                p.information(EA);
                totalprice += p.getPrice() * EA;
            }
            totalprice = Math.round((totalprice * 100)) / 100.0;
            System.out.println("[ Total ]");
            System.out.println("W " + totalprice + "\n");
            System.out.println("1. 주문     2. 메뉴판");
            confirmOrder = sc.nextInt();
            if (confirmOrder == 1) {
                income += totalprice;
                soldList = new HashSet<>();
                soldList.addAll(orderList);
                completeOrder();
            } else if (confirmOrder == 2) {
                System.out.println("주문이 완료되지 않았습니다.");
                System.out.println("(초기 메뉴판으로 돌아갑니다.)");
                KioskApp.countDown();
            }
        } else {
            blankOrderList();
        }

    }

    public void completeOrder() throws InterruptedException {
        orderList.clear();
        cnt++;
        System.out.println("주문이 완료되었습니다!");
        System.out.println("대기번호는 [ " + cnt + " ] 번 입니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        KioskApp.countDown();
    }

    public void cancelOrder() throws InterruptedException {
        orderList.clear();
        System.out.println("진행하던 주문이 취소되었습니다. 이전 화면으로 돌아갑니다.");
        KioskApp.countDown();
    }

    public void failCancelOrder() throws InterruptedException {
        System.out.println("주문이 취소되지 않았습니다. 이전 화면으로 돌아갑니다.");
        KioskApp.countDown();
    }

    public void blankOrderList() throws InterruptedException {
        System.out.println("주문하신 내용이 없습니다.");
        System.out.println("(초기 메뉴판으로 돌아갑니다.)");
        KioskApp.countDown();
    }

    public double getIncome() {
        return income;
    }

    public HashSet<Product> getSoldList() {
        return soldList;
    }
}
