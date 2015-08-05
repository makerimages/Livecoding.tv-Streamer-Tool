package net.makerimages.streamertool.actionpane;

import net.makerimages.streamertool.Main;
import net.makerimages.streamertool.ui.UIButton;
import net.makerimages.streamertool.ui.UIElement;
import net.makerimages.streamertool.ui.UITextBox;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class ActionPane {

    public ArrayList<UIElement> uiElements;

    public ActionPane() {
        uiElements = new ArrayList<UIElement>();
        uiElements.clear();
    }

    public void render(Graphics graphics) {
        for (UIElement uiElement : uiElements) {
            uiElement.draw(graphics);
        }
    }

    public void mouseMoveAction(int mouseX, int mouseY) {
        for (UIElement uiElement : uiElements) {
            uiElement.hoverCheck(mouseX, mouseY);
        }

    }

    public void elementAction(UIElement element) {
        for (UIElement uiElement : uiElements) {
            if(uiElement instanceof UITextBox) {
                UITextBox unfocusing = (UITextBox) uiElement;
                unfocusing.focused = false;
            }

        }
        if(element instanceof  UITextBox) {
            UITextBox focusing = (UITextBox) element;
            focusing.focused = true;
        }



    }

    public void mouseClickAction(int button) {
        for (UIElement uiElement : uiElements) {
            if(uiElement instanceof UITextBox) {
                UITextBox unfocusing = (UITextBox) uiElement;
                unfocusing.focused = false;
            }

        }
        for (UIElement uiElement : uiElements) {
            uiElement.clickCheck(button);
            if(uiElement.clicked) {
                elementAction(uiElement);
            }
        }

    }

    public void keyEvent(KeyEvent e) {
        for (UIElement uiElement : uiElements) {
            uiElement.keyEvent(e);
        }
    }

	public void keyEventSpecial() {
		  for (UIElement uiElement : uiElements) {
	            uiElement.keyEventSpecial();
	        }		
	}
}
