import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 10/3/2016.
 */
public class BulletPlayer extends Bullet {
    private Vector<PlaneEnemy> planeEnemyVector = new Vector<>();

    public BulletPlayer(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
        try {
            this.sprite = ImageIO.read(new File("Resources/Dan2.png"));
        } catch (IOException e) {
        }
    }

    @Override
    public void move() {
        this.positionY -= this.speed;
    }

    @Override
    public void update() {
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, (int) this.positionX, (int) this.positionY, null);
    }
}
