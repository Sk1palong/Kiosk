import java.util.*;

public class KioskApp {
    private Order order = new Order();
    private List<Menu> categoryMenu = new ArrayList<>(); //상위 메뉴
    private List<Product> allProduct = new ArrayList<>(); // 모든 상품
    private List<Product> categoryProduct = new ArrayList<>(); //카테고리별 상품List


    public void start() throws InterruptedException {
        while (true) {
            shopping();
        }
    }

    public void shopping() throws InterruptedException {
//        메인 메뉴판 시작
        int idx = 1;
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("\"SHAKESHACK BURGER 에 오신 걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("[ SHAKESHACK MENU ]");
        for (Menu m : categoryMenu) {
            System.out.print(idx + ". ");
            m.information();
            idx++;
        }
        System.out.println("[ ORDER MENU ]");
        System.out.printf(idx + ". %-15s | %s\n", "Order", "장바구니를 확인 후 주문을 완료합니다.");
        idx++;
        System.out.printf(idx + ". %-15s | %s\n", "Cancel", "진행중인 주문을 취소합니다.");
        input = sc.nextInt();

        if (0 < input && input <= idx - 2) {
//            상세 메뉴판 시작
            int categoryIdx = 1;
            categoryProduct.clear();
            System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
            System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
            String selectedCategory = categoryMenu.get(input - 1).getMenuName();
            System.out.println("[ " + selectedCategory + " MENU ]");
            for (Product p : allProduct) {
                if (selectedCategory.equals(p.getCategory())) {
                    categoryProduct.add(p);
                    System.out.print(categoryIdx + ". ");
                    p.information();
                    categoryIdx++;
                }
            }
            int select = sc.nextInt();
            if (0 < select && select < categoryIdx) {
                order.addShoppingBag(categoryProduct.get(select - 1)); //장바구니 담기
            } else {
                wrongInput();
            }

        } else if (input == idx - 1) {
//            주문 시작
            order.startOrder();

        } else if (input == idx) {
//            캔슬 기능 시작
            order.cancelOrder();

//        히든 기능
        } else if (input == 0) {
            double totalIncome = Math.round(order.getIncome() * 100) / 100.0;
            if (order.getIncome() != 0) {
                System.out.println("[ 총 판매 금액 현황 ]");
                System.out.println("현재까지 총 판매된 금액은 [ W " + totalIncome + " ] 입니다.\n");

                System.out.println("[ 총 판매상품 목록 현황 ]");
                System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
                for (Product hs : order.getSoldList()) {
                    System.out.printf("- %-20s | W %s\n", hs.getMenuName(), hs.getPrice());
                }
                System.out.println("\n1. 돌아가기 ");

                int goBack = sc.nextInt();
                if (goBack == 1) {
                    System.out.println("메인 화면으로 돌아갑니다.");
                    countDown();
                } else {
                    wrongInput();
                }

            } else {
                System.out.println("판매 내역이 없습니다.");
                System.out.println("메인 화면으로 돌아갑니다.");
                countDown();
            }

        } else {
            wrongInput();
        }
    }

    public static void countDown() throws InterruptedException { //카운트 다운
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);
    }

    public static void wrongInput() throws InterruptedException { //범위내 입력
        System.out.println("잘못된 입력입니다.");
        System.out.println("메인 화면으로 돌아갑니다.");
        countDown();
    }

    public void loadMenu() { //메뉴 정보 저장
        Menu[] menu = {
                new Menu("Burgers", "앵거스 비프 통살을 다져 만든 포테이토 번 버거"),
                new Menu("Frozen Custard", "매장에서 신선하게 만드는 부드럽고 쫀득한 아이스크림"),
                new Menu("Drinks", "매장에서 직접 만드는 상큼한 음료"),
                new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 에일 맥주")
        };
        Product[] products = {
                new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, "Burgers", 10.9),
                new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, "Burgers", 12.9),
                new Product("\'Shroom Burger", "몬스터 치즈와 체다 치즈와 버섯패티를 넣은 베지테리안 버거", 9.4, "Burgers"),
                new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9, "Burgers", 10.9),
                new Product("Hamburger", "비프패티를 기본으로 취향따라 토핑을 선택하는 버거", 5.4, "Burgers", 9.0),


                new Product("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛 버터, 커피", 5.9, "Frozen Custard"),
                new Product("Shake of the Week", "특별한 커스터드 플레이버", 6.5, "Frozen Custard"),
                new Product("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5, "Frozen Custard"),
                new Product("Floats", "루트 비어, 퍼플 카우, 크림 시클", 5.9, "Frozen Custard"),
                new Product("Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9, "Frozen Custard", 5.9),
                new Product("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9, "Frozen Custard", 8.9),
                new Product("Shack Attack", "초콜렛 퍼지소스, 초콜렛 트러플 쿠키, Lumiere 초콜렛 청크와 스프링클이 들어간 진한 초콜렛 커스터드", 5.9, "Frozen Custard"),


                new Product("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)", 3.9, "Drinks", 4.5),
                new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, "Drinks", 3.9),
                new Product("Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5, "Drinks", 4.4),
                new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7, "Drinks", 3.3),
                new Product("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, "Drinks"),
                new Product("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, "Drinks"),


                new Product("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8, "Beer"),
                new Product("Magpie Brewing Co.", "Magpie Brewing Co.", 6.8, "Beer"),
        };
        categoryMenu.addAll(Arrays.asList(menu));
        allProduct.addAll(Arrays.asList(products));
    }
}

