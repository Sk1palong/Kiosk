public class Menu {
    private String menuName;
    private String description;

    public Menu(String menuName, String description) {
        this.menuName = menuName;
        this.description = description;
    }
    public void information() {
        System.out.printf("%-15s | %s\n ", menuName, description); //상위 메뉴판 출력
    }

    public String getMenuName() {
        return menuName;
    }

    public String getDescription() {
        return description;
    }

}
