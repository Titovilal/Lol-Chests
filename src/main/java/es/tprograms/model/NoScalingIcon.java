package es.tprograms.model;

import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

/**
 * An Icon that does not scale when its container is resized. The icon is
 * centered within its container. From stackOverflow:
 * https://stackoverflow.com/questions/65742162/how-to-fix-the-blurry-image-when-i-run-my-java-swing-project/65742492#65742492
 *
 * @author Titovilal
 */
public class NoScalingIcon implements Icon {

    private final Icon icon;

    public NoScalingIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight();
    }

    /**
     * Paints an icon at the specified location. This method is called by the
     * container's paint method.
     *
     * @param c the component where the icon is painted
     * @param g the graphics context
     * @param x the x coordinate of the icon's top-left corner
     * @param y the y coordinate of the icon's top-left corner
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();

        AffineTransform at = g2d.getTransform();

        int locationX = getLocationX(x, at);
        int locationY = getLocationY(y, at);
        resetScaling(at, g2d);

        icon.paintIcon(c, g2d, locationX, locationY);

        g2d.dispose();
    }

    /**
     * Resets the scaling of the given AffineTransform to 1.0.
     *
     * @param at the AffineTransform to reset
     * @param g2d the Graphics2D context
     */
    private void resetScaling(AffineTransform at, Graphics2D g2d) {
        //  Reset scaling to 1.0 by concatenating an inverse scale transfom
        AffineTransform scaled = AffineTransform.getScaleInstance(1.0 / at.getScaleX(), 1.0 / at.getScaleY());
        at.concatenate(scaled);
        g2d.setTransform(at);
    }

    /**
     * Calculates the x coordinate of the icon's top-left corner.
     *
     * @param x the x coordinate of the icon's top-left corner
     * @param at the current AffineTransform
     * @return the calculated x coordinate of the icon's top-left corner
     */
    private int getLocationX(int x, AffineTransform at) {
        int scaleX = (int) (x * at.getScaleX());
        int offsetX = (int) (icon.getIconWidth() * (at.getScaleX() - 1) / 2);
        int locationX = scaleX + offsetX;
        return locationX;
    }

    /**
     * Calculates the y coordinate of the icon's top-left corner.
     *
     * @param y the y coordinate of the icon's top-left corner
     * @param at the current AffineTransform
     * @return the calculated y coordinate of the icon's top-left corner
     */
    private int getLocationY(int y, AffineTransform at) {
        int scaleY = (int) (y * at.getScaleY());
        int offsetY = (int) (icon.getIconHeight() * (at.getScaleY() - 1) / 2);
        int locationY = scaleY + offsetY;
        return locationY;
    }
}
