package net.makerimages.streamertool.actionpane;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Timer;

import net.makerimages.streamertool.ContentPanel;
import net.makerimages.streamertool.Main;
import net.makerimages.streamertool.threads.DashboardIndicators;
import net.makerimages.streamertool.ui.UIButton;
import net.makerimages.streamertool.ui.UIElement;
import net.makerimages.streamertool.ui.UITextBox;

public class DashboardActionPane extends ActionPane{
	public static int viewers, totalViewers;
	
	public DashboardActionPane() {
		super();
		UITextBox streamTitle = new UITextBox(0, 12, 15, 200, false, "");
		UIButton streamTitleSet = new UIButton(2, "Save", 12+streamTitle.getCalculateSize().x+4, 15);
		UIButton overlays = new UIButton(3, "Overlays", 1,1);
		overlays.setPos(12+streamTitle.getCalculateSize().x/2-overlays.getCalculateSize().x/2, 102);
		uiElements.add(streamTitle);
		uiElements.add(streamTitleSet);
		uiElements.add(overlays);
		Timer myTimer = new Timer();

		myTimer.scheduleAtFixedRate(new DashboardIndicators(), 0, 60*1000);
		
		
	}
	
	@Override
	public void render(Graphics graphics) {
		// TODO Auto-generated method stub
		super.render(graphics);
		graphics.setFont(Main.fontManager.primary);
		graphics.drawString("Viewers live: "+viewers+" total: "+totalViewers, 15, 82);
	}
	
	@Override
	public void elementAction(UIElement element) {
		super.elementAction(element);
		switch(element.id) {
			case 3:
				ContentPanel.actionPaneManager.swap(2);
				break;
		}
	}
}
