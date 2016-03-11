import java.util.Vector;

/**
 * Created by Quang Đại on 11/3/2016.
 */
public class BulletEnemyManager {
    private Vector<BulletEnemy> bulletEnemyVector = new Vector<>();
    private static BulletEnemyManager ourInstance = new BulletEnemyManager();

    public static BulletEnemyManager getInstance() {
        return ourInstance;
    }

    private BulletEnemyManager() {
    }

    public Vector<BulletEnemy> getBulletEnemyVector() {
        return bulletEnemyVector;
    }
}
