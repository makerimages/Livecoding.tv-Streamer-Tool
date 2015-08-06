package net.makerimages.streamertool.threads;

import java.util.TimerTask;

import net.makerimages.streamertool.actionpane.DashboardActionPane;
import net.makerimages.streamertool.lctv.Livecoding;

public class DashboardIndicators extends TimerTask  {
	
	Livecoding livecoding = new Livecoding();
	
	@Override
	public void run() {
		System.out.println("Fetchinf views");
		DashboardActionPane.viewers = livecoding.getLiveViews("makerimages");
		DashboardActionPane.totalViewers = livecoding.getTotalViews("makerimages");
	}

	
	

}
