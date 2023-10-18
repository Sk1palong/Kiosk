public class Menu {
    private String menuName;
    private String description;
    public Menu(String menuName, String description){
        this.menuName = menuName;
        this.description = description;
    }
    public Menu(){

    }
    public void information(){
        System.out.printf("%-15s | %s\n ", menuName, description);
    }
    public String getMenuName(){
        return menuName;
    }
    public String getDescription() {
        return description;
    }
    public void show(){

    }

}
