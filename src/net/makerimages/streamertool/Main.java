package net.makerimages.streamertool;

import net.makerimages.streamertool.ui.FontManager;
import net.makerimages.streamertool.util.KeyPower;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Makerimages on 7/10/2015.
 */
public class Main {

    public static JFrame appFrame;
    public static FontManager fontManager;

    private static void centerFrame() {

        Dimension windowSize = appFrame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        appFrame.addKeyListener(new KeyPower());
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        appFrame.setLocation(dx, dy);
    }

    public static void main(String[] args) {

        fontManager = new FontManager();
        appFrame = new JFrame("Livecoding.tv Streamer Tool");
        appFrame.setSize(1280, 720);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setContentPane(new ContentPanel());
        appFrame.getContentPane().setBackground(new Color(0x273439));
        appFrame.setResizable(false);

        centerFrame();
        appFrame.setVisible(true);
    }

}
