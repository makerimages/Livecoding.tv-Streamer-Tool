package net.makerimages.streamertool.lctv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import org.json.JSONObject;

public class Livecoding {
	
	public Livecoding() {
		
	}
	
	public int getLiveViews(String channel) {
		URL website;
		try {
			website = new URL("https://www.livecoding.tv/livestreams/"+channel+"/stats.json");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("channelStats.json");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File statsFile = new File("channelStats.json");
		String stats = "";
		try {
			Scanner in = new Scanner(new FileReader(statsFile));
			while(in.hasNext()) {
				stats = stats +in.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject statsObject = new JSONObject(stats);
		statsFile.delete();
		
		return statsObject.getInt("views_live");
		
	}
	
	public int getTotalViews(String channel) {
		URL website;
		try {
			website = new URL("https://www.livecoding.tv/livestreams/"+channel+"/stats.json");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("channelStats.json");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File statsFile = new File("channelStats.json");
		String stats = "";
		try {
			Scanner in = new Scanner(new FileReader(statsFile));
			while(in.hasNext()) {
				stats = stats +in.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject statsObject = new JSONObject(stats);
		statsFile.delete();
		
		return statsObject.getInt("views_overall");
		
	}
}
