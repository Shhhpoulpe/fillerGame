import java.awt.Image;
import javax.swing.ImageIcon;

public class Init {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;

    public Init(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

        // class ImageIcon pour charger un icone à partir d'une image
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}