public class Main {
    public static void main(String[] args) throws InterruptedException {
//        키오스크 앱 작동
//        메인 메뉴판 표시->해당 카테고리 메뉴판 표시 -> 장바구니에 추가 확인
//        ->메인 메뉴판으로 이동 ->반복 후  ->Order 메뉴 선택 or Cancel 메뉴 선택
//        ->if Order 메뉴 선택
//          ->장바구니 목록 출력(메뉴(이름,가격,설명),합계금액,주문 or 메뉴판)
//          ->if 주문 선택
//              -> 대기번호 발급 -> 3초 후 메인 메뉴판으로 돌아갑니다 출력
//          ->메뉴판 선택
//              ->메뉴판으로 돌아감
//        ->Cancel 선택
//              -> 진행하던 주문을 취소하시겠습니까? 출력 1.확인 2취소
//        키오스크 앱 종료?
        KioskApp app = new KioskApp();
        app.loadMenu();
        app.start();

    }
}