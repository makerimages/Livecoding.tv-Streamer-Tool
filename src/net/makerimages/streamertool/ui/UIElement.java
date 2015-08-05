package net.makerimages.streamertool.ui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.SampleModel;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class UIElement {

    int xPos, yPos;
    public int id;
    public boolean hovering = false;
    public boolean clicked = false;
    public UIElement(int id, int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.id = id;
    }

    public void draw(Graphics graphics) {}

    public void hoverCheck(int mouseX, int mouseY) {

    }

    public void clickCheck(int button) {
    }

    public void keyEvent(KeyEvent e) {

    }
    
    public void setPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

	public void keyEventSpecial() {
		// TODO Auto-generated method stub
		
	}
}
