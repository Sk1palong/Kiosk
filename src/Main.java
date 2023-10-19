public class Main {
    public static void main(String[] args) throws InterruptedException {
        KioskApp app = new KioskApp();

        app.loadMenu();
        app.start();

    }
}