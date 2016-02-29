public class Main {

    public static void main(String[] args) {
	// write your code here
        gameWindow gw = new gameWindow();
        Thread t = new Thread(gw);
                t.start();
    }
}
