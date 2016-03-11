import java.util.Vector;

/**
 * Created by Quang Đại on 11/3/2016.
 */
public class PlaneManager {
    private Plane planeMoveByKey;
    private Plane planeMoveByMouse;
    private static PlaneManager ourInstance = new PlaneManager();

    public static PlaneManager getInstance() {
        return ourInstance;
    }

    private PlaneManager() {
        planeMoveByKey = new Plane(200,200,3,4);
        planeMoveByMouse = new Plane(300,300,4,2);
    }

    public Plane getPlaneMoveByKey() {
        return planeMoveByKey;
    }

    public Plane getPlaneMoveByMouse() {
        return planeMoveByMouse;
    }
}
