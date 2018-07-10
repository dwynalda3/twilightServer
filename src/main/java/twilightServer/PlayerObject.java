package twilightServer;

import java.util.ArrayList;

public class PlayerObject {
	private final int id;
	private final String color;
	private final String race;
	
	public PlayerObject(int id, String color, String race) {
		super();
		this.id = id;
		this.color = color;
		this.race = race;
	}
	public int getId() {
		return id;
	}
	public String getColor() {
		return color;
	}
	public String getRace() {
		return race;
	}
	
}

