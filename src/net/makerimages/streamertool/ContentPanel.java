package net.makerimages.streamertool;

import net.makerimages.streamertool.actionpane.ActionPaneManager;
import net.makerimages.streamertool.actionpane.DashboardActionPane;
import net.makerimages.streamertool.actionpane.LoginActionPane;
import net.makerimages.streamertool.actionpane.OverlayManagementActionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Makerimages on 7/10/2015.
 */
public class ContentPanel extends JPanel implements MouseMotionListener, MouseListener{

    public static ActionPaneManager actionPaneManager;

    public ContentPanel() {
        super();
        addMouseMotionListener(this);
        addMouseListener(this);
        actionPaneManager = new ActionPaneManager();
        actionPaneManager.addActionPane(new LoginActionPane());
        actionPaneManager.addActionPane(new DashboardActionPane());
        actionPaneManager.addActionPane(new OverlayManagementActionPane());
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        super.paintComponent(g);
        actionPaneManager.renderActionPane(g);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        actionPaneManager.paneMouseMoveAction(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        actionPaneManager.paneMouseClickAction(e.getButton());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
