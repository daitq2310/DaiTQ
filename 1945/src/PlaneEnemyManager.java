import java.util.Vector;

/**
 * Created by Quang Đại on 11/3/2016.
 */
public class PlaneEnemyManager {
    Vector<PlaneEnemy>planeEnemyVector=new Vector<>();

    public Vector<PlaneEnemy> getPlaneEnemyVector() {
        return planeEnemyVector;
    }

    private static PlaneEnemyManager ourInstance = new PlaneEnemyManager();

    public static PlaneEnemyManager getInstance() {
        return ourInstance;
    }

    private PlaneEnemyManager() {
    }

    public static PlaneEnemyManager getOurInstance() {
        return ourInstance;
    }
}
