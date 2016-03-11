import java.util.Vector;

/**
 * Created by Quang Đại on 11/3/2016.
 */
public class RandomBirdManager {
    Vector<RandomBird> randomBirdVector = new Vector<>();
    private static RandomBirdManager ourInstance = new RandomBirdManager();

    public static RandomBirdManager getInstance() {
        return ourInstance;
    }

    private RandomBirdManager() {
    }

    public Vector<RandomBird> getRandomBirdVector() {
        return randomBirdVector;
    }
}
