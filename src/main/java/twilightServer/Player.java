package twilightServer;

import java.util.ArrayList;

public class Player {
	int id;
	Color color;
	String race;
	ArrayList<Space> systems;
	
	public Player() {
	}

	public Player(int id, Color color, String race, ArrayList<Space> systems) {
		this.id = id;
		this.color = color;
		this.race = race;
		this.systems = systems;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}