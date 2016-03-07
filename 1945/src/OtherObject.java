import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quang Đại on 7/3/2016.
 */
public class OtherObject extends GameObject {
    private int typeObject;

    public OtherObject(int positionX, int positionY, int typeObject) {
        this.positionX = positionX;
        this.positionY = positionY;
        switch (typeObject) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/mountain.png"));
                } catch (IOException e) {

                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/island.png"));
                } catch (IOException e) {

                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/cloud1.png"));
                } catch (IOException e) {

                }
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(), (int) getPositionX(), (int)getPositionY(), null);
    }

    public int getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(int typeObject) {
        this.typeObject = typeObject;
    }
}
