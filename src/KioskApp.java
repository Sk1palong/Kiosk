import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KioskApp {
    private Order order = new Order();
    private List<Menu> categoryMenu = new ArrayList<>();
    private List<Product> allProduct = new ArrayList<>();
    private List<Product> categoryProduct = new ArrayList<>();


    public void loadMenu() {
        Menu[] menu = {
                new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"),
                new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림"),
                new Menu("Drinks", "매장에서 직접 만드는 음료"),
                new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주")
        };
        Product[] products = {
                new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, "Burgers"),
                new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, "Burgers"),
                new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4, "Burgers"),
                new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9, "Burgers"),
                new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 6.9, "Burgers"),


                new Product("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛 버터, 커피", 5.9, "Frozen Custard"),
                new Product("Shake of the Week", "특별한 커스터드 플레이버", 6.5, "Frozen Custard"),
                new Product("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5, "Frozen Custard"),
                new Product("Floats", "루트 비어, 퍼플 카우, 크림 시클", 5.9, "Frozen Custard"),
                new Product("Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9, "Frozen Custard"),
                new Product("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9, "Frozen Custard"),
                new Product("Shack Attack", "초콜렛 퍼지소스, 초콜렛 트러플 쿠키, Lumiere 초콜렛 청크와 스프링클이 들어간 진한 초콜렛 커스터드", 5.9, "Frozen Custard"),


                new Product("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)", 3.9, "Drinks"),
                new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, "Drinks"),
                new Product("Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5, "Drinks"),
                new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7, "Drinks"),
                new Product("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, "Drinks"),
                new Product("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, "Drinks"),


                new Product("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8, "Beer"),
                new Product("Magpie Brewing Co.", "설명 없음", 6.8, "Beer"),
        };
        categoryMenu.addAll(Arrays.asList(menu));
        allProduct.addAll(Arrays.asList(products));

    }

    public void start() {
        int mainNum;
        int categoryNum;
        int productNum;
        while(true) {
            showMainMenu();
            categoryNum = mainResponse();
            productNum = showCategoryMenu(categoryNum);
            categoryResponse(productNum,categoryProduct);

        }
    }

    public void showMainMenu() {
        int idx = 1;
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


    }

    public int showCategoryMenu(int categoryNum) {
        int idx = 1;
        categoryProduct.clear();
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        String selectedCategory = categoryMenu.get(categoryNum - 1).getMenuName();
        System.out.println("[ " + selectedCategory + " MENU ]");
        for (Product p : allProduct) {
            if (selectedCategory.equals(p.getCategory())) {
                categoryProduct.add(p);
                System.out.print(idx + ". ");
                p.information();
                idx++;
            }
        }
        return idx;
    }

    public int mainResponse() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (0 < input && input <= categoryMenu.size()) {
            System.out.println(input+"번 카테고리 선택.");
        }
        return input;
    }

    public void categoryResponse(int idx,List<Product> list) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (0 < input && input < idx) {
//            categoryProduct.get(input-1).information();
            order.addOrder(list.get(input-1));
        }

    }

}
