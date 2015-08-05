package net.makerimages.streamertool.actionpane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class ActionPaneManager {

    ArrayList<ActionPane> actionPanes;
    int active = 0;

    public ActionPaneManager()  {
        actionPanes = new ArrayList<ActionPane>();
    }


    public void swap(int to) {
        this.active = to;
    }
    public void addActionPane(ActionPane pane) {
        actionPanes.add(pane);
    }

    public void renderActionPane(Graphics graphics) {
       if(this.actionPanes.get(this.active) != null) {
           this.actionPanes.get(this.active).render(graphics);
       }
    }

    public void paneMouseMoveAction(int mouseX, int mouseY) {
        this.actionPanes.get(this.active).mouseMoveAction(mouseX, mouseY);
    }

    public void paneMouseClickAction(int button) {
        this.actionPanes.get(this.active).mouseClickAction(button);

    }

    public void paneKeyEvent(KeyEvent e) {
        this.actionPanes.get(this.active).keyEvent(e);
    }
}
