package net.makerimages.streamertool.util;

import net.makerimages.streamertool.ContentPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class KeyPower implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        ContentPanel.actionPaneManager.paneKeyEvent(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
