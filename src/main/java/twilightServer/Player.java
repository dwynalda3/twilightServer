package twilightServer;

import java.util.ArrayList;

public class Player {
	int id;
	Color color;
	Race race;
	ArrayList<Space> systems;
	Space homeSystem;
	
	public Player() {
	}

	public Player(int id, Color color, Race r, ArrayList<Space> systems) {
		this.id = id;
		this.color = color;
		this.race = r;
		this.systems = systems;
	}



	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
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
	
	public String toString() {
		return this.id + ", " + this.color + ", " + this.race;
	}
	
}