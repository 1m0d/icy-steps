package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public interface IDrawable {

    public void Draw(JPanel jp);
    public BufferedImage getImage();
}
