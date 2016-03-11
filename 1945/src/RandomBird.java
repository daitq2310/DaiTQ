import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 7/3/2016.
 */
public class RandomBird extends GameObject {
    private int xVelocity = 1;
    private int yVelocity = 1;
    private static final int RIGHT_WALL = 1000;
    private static final int LEFT_WALL = 1;
    private static final int DOWN_WALL = 700;
    private static final int UP_WALL = 1;

    public RandomBird(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            setSprite(ImageIO.read(new File("Resources/bird1.png")));
        } catch (IOException e) {
        }
    }

    public void move() {
        this.positionX += xVelocity;
        this.positionY += yVelocity;

        if (this.positionX >= RIGHT_WALL) {
            this.positionX = RIGHT_WALL;
            randomDirection();
        }

        if (this.positionY <= UP_WALL) {
            this.positionY = UP_WALL;
            randomDirection();
        }

        if (this.positionX <= LEFT_WALL) {
            this.positionX = LEFT_WALL;
            randomDirection();
        }
        if (this.positionY >= DOWN_WALL) {
            this.positionY = DOWN_WALL;
            randomDirection();
        }
    }

    private void randomDirection() {
        double speed = 2.0;
        double direction = Math.random() * 2 * Math.PI;
        xVelocity = (int) (speed * Math.cos(direction));
        yVelocity = (int) (speed * Math.sin(direction));
    }

        public void update() {
        this.move();
    }

    public void draw(Graphics g) {
        g.drawImage(this.sprite, (int) this.positionX, (int) this.positionY, null);
    }
}