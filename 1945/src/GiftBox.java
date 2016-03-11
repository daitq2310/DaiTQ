import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quang Đại on 11/3/2016.
 */
public class GiftBox extends GameObject {
    private boolean collision;
    public static boolean destroyAll;

    private GiftBox() {
    }

    public GiftBox(int positionX, int positionY, int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/GiftBox.png"));
        } catch (IOException e) {
        }
    }

    public boolean checkCollisionGiftBox() {
        Rectangle rectGift = new Rectangle((int) positionX, (int) positionY, sprite.getWidth(), sprite.getHeight());
        Rectangle rectPlaneKey =
                new Rectangle((int) PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
                        , (int) PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
        Rectangle rectPlaneMouse =
                new Rectangle((int) PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                        , (int) PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        if (rectGift.intersects(rectPlaneKey)) {
            collision = true;
            return true;
        } else if (rectGift.intersects(rectPlaneMouse)) {
            collision = true;
            return true;
        }
        return false;
    }

    public void move() {
        this.positionY += this.speed;
    }

    @Override
    public void update() {
        this.move();
        checkCollisionGiftBox();
        if (checkCollisionGiftBox()) {
            destroyAll = true;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, (int) this.positionX, (int) this.positionY, null);
    }

}
