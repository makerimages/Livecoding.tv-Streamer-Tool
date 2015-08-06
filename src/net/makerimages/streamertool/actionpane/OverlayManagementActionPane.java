package net.makerimages.streamertool.actionpane;

import java.awt.Color;
import java.awt.Graphics;

import net.makerimages.streamertool.Main;
import net.makerimages.streamertool.ui.UIButton;
import net.makerimages.streamertool.ui.UICheckbox;

public class OverlayManagementActionPane extends ActionPane {
	
	public OverlayManagementActionPane() {
		super();
		
		UICheckbox overlaysEnabled = new UICheckbox(0, 142, 12);
		UIButton addOverlay = new UIButton(1, "Add", 1, 1);
		addOverlay.setPos(Main.appFrame.getWidth()-addOverlay.getCalculateSize().x-18,Main.appFrame.getHeight()-addOverlay.getCalculateSize().y*2-2);
		uiElements.add(overlaysEnabled);
		uiElements.add(addOverlay);
		
	}
	
	@Override
	public void render(Graphics graphics) {
		super.render(graphics);
		graphics.setFont(Main.fontManager.primary);
		graphics.setColor(Color.white);
		graphics.drawString("Use Overlays", 14, 35);
	}
}
