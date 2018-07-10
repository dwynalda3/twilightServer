package twilightServer;

import java.util.ArrayList;
import java.util.List;

public class Space {
	private int numPlanets;
    private List<Planet> planets = new ArrayList<Planet>();
    private List<Space> neighbors = new ArrayList<Space>();
    private List<IShip> ships = new ArrayList<IShip>();
    private Hazard type;
	private Color owner;
	
	public Space(Hazard type) {
		numPlanets=0;
		this.type = type;
	}
	public Space(Planet planet, Hazard type) {
		this.planets.add(planet);
		numPlanets=planets.size();
		this.type = type;
	}
	public Space(Planet planet1, Planet planet2, Hazard type) {
		this.planets.add(planet1);
		this.planets.add(planet2);
		numPlanets=planets.size();
		this.type = type;
	}

	public List<Planet> getPlanets() {
		return planets;
	}
	public List<Space> getNeighbors() {
		return neighbors;
	}
	public List<IShip> getShips() {
		return ships;
	}
	public int getNumPlanets() {
		return numPlanets;
	}
	public Hazard getType() {
		return type;
	}
	public void setOwner(Color color) {
		this.owner = color;
	}
	public Color getOwner() {
		return owner;
	}
	public void addShips(List<IShip> ships) {
		this.ships.addAll(ships);
	}
	public void addNeighbor(Space neighbor) {
		this.neighbors.add(neighbor);
	}
	public String toString() {
		if(getNumPlanets()==2) {
			return getPlanets().get(0).getName() + 
					" and " + getPlanets().get(1).getName();
		}else if(getNumPlanets()==1) {
			return getPlanets().get(0).getName();
		}else {
			return getType().toString();
		}
	}

}
