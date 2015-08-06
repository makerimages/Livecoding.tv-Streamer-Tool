package net.makerimages.streamertool.actionpane;

import java.awt.Graphics;

import net.makerimages.streamertool.ContentPanel;
import net.makerimages.streamertool.Main;
import net.makerimages.streamertool.ui.UIButton;
import net.makerimages.streamertool.ui.UICheckbox;
import net.makerimages.streamertool.ui.UIElement;
import net.makerimages.streamertool.ui.UITextBox;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class LoginActionPane extends ActionPane {

	 public UIButton auth;
	 public  UITextBox username;
	 
    public LoginActionPane() {
        super();
        auth = new UIButton(0,"Authenticate via Livecoding", 1,1);
        username = new UITextBox(1,20,40,150,false,"Username");
        UITextBox password = new UITextBox(2,20,140,150,true,"Password");
        UIButton go = new UIButton(3,"DEV", 1,1);
        UICheckbox remember = new UICheckbox(4, 1, 1);
        
        remember.setPos(Main.appFrame.getWidth()/2+username.getCalculateSize().x/2-remember.getCalculateSize().x,Main.appFrame.getHeight()/2-remember.getCalculateSize().y/2-3);
        
        username.setPos(Main.appFrame.getWidth()/2-username.getCalculateSize().x/2,(Main.appFrame.getHeight()/2-username.getCalculateSize().y/2)-75);
        password.setPos(Main.appFrame.getWidth()/2-password.getCalculateSize().x/2,(Main.appFrame.getHeight()/2-password.getCalculateSize().y/2)-38);

        auth.setPos(Main.appFrame.getWidth()/2-auth.getCalculateSize().x/2,Main.appFrame.getHeight()/2+auth.getCalculateSize().y/2);
        go.setPos(Main.appFrame.getWidth()-go.getCalculateSize().x-18,Main.appFrame.getHeight()-go.getCalculateSize().y*2-2);

        uiElements.add(auth);
        uiElements.add(username);
        uiElements.add(password);
        uiElements.add(go);
        uiElements.add(remember);
        
     
    }

    @Override
    public void elementAction(UIElement element) {
        super.elementAction(element);
        switch(element.id)  {
        	case 3:
        		ContentPanel.actionPaneManager.swap(1);
        		break;
       }
    }
    
    @Override
    public void render(Graphics graphics) {
    	super.render(graphics);
    	graphics.drawString("Remember",Main.appFrame.getWidth()/2-username.getCalculateSize().x/2,Main.appFrame.getHeight()/2+4);
    }
}
