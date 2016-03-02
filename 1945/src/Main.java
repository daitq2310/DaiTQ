public class Main {

    public static void main(String[] args) {
	// write your code here
        GameWindow gw = new GameWindow();
        Thread t = new Thread(gw);
                t.start();
    }
}
