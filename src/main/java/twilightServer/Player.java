package twilightServer;

import java.util.ArrayList;

public class Player {
	Color color;
	String race;
	ArrayList<Space> systems;
	
	public Player() {
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public ArrayList<Space> getSystems() {
		return systems;
	}

	public void setSystems(ArrayList<Space> systems) {
		this.systems = systems;
	}
	
}