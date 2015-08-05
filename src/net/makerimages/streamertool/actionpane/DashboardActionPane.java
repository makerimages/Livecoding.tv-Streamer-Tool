package net.makerimages.streamertool.actionpane;

import java.awt.FontMetrics;
import java.awt.Graphics;

import net.makerimages.streamertool.Main;
import net.makerimages.streamertool.ui.UIButton;
import net.makerimages.streamertool.ui.UITextBox;

public class DashboardActionPane extends ActionPane{
	
	public DashboardActionPane() {
		super();
		UITextBox streamTitle = new UITextBox(0, 12, 15, 200, false, "");
		UIButton streamTitleSet = new UIButton(2, "Save", 12+streamTitle.getCalculateSize().x+4, 15);
		
		uiElements.add(streamTitle);
		uiElements.add(streamTitleSet);

	}
	

}
