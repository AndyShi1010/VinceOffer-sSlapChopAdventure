package MainGame;

import java.awt.*;

public class ImageUtilities {
    public static Image darkenImage (Image inputImage, float alpha) {
        Graphics2D g2d = (Graphics2D) inputImage.getGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g2d.setColor(Color.black);
        g2d.fillRect(0,0,inputImage.getWidth(null), inputImage.getHeight(null));
        return inputImage;
    }
}
