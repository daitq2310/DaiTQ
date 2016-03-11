import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 10/3/2016.
 */
public class BulletEnemy extends Bullet {
    private int typeMove;
    private Plane plane;

    public BulletEnemy(int positionX, int positionY, int speed, int typeMove) {
        super(positionX, positionY, speed);
        this.typeMove = typeMove;
        try {
            this.sprite = ImageIO.read(new File("Resources/Dan1.png"));
        } catch (IOException e) {
        }
    }

    @Override
    public void move() {
        if (this.typeMove == 1) {
            this.positionY -= this.speed;
        } else if (this.typeMove == 2) {
            this.positionX -= 4;
            this.positionY += 4;
        } else if (this.typeMove == 3) {
            this.positionX += 4;
            this.positionY += 4;
        }
    }

    public boolean checkCollisionPlaneMoveByKey() {
        Rectangle rectBullet = new Rectangle((int) positionX, (int) positionY, sprite.getWidth(), sprite.getHeight());
        Rectangle rectPlaneKey =
                new Rectangle((int) PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
                        , (int) PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
        return rectBullet.intersects(rectPlaneKey);
    }

    public boolean checkCollisionPlaneMoveByMouse() {
        Rectangle rectBullet = new Rectangle((int) positionX, (int) positionY, sprite.getWidth(), sprite.getHeight());
        Rectangle rectPlaneMouse =
                new Rectangle((int) PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                        , (int) PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        return rectBullet.intersects(rectPlaneMouse);
    }

    @Override
    public void update() {
        this.move();
        if (checkCollisionPlaneMoveByKey()) {
            PlaneManager.getInstance().getPlaneMoveByKey().health -= 10;
        }
        if (checkCollisionPlaneMoveByMouse() == true) {
            PlaneManager.getInstance().getPlaneMoveByMouse().health -= 10;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, (int) this.positionX, (int) this.positionY, null);
    }

    public int getWidth() {
        return this.sprite.getWidth();
    }

    public int getHeight() {
        return this.sprite.getHeight();
    }
}
