package twilightServer;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "neighbors" })
public class Space {
	private String name;
	private int numPlanets;
    private List<Planet> planets = new ArrayList<Planet>();
    private List<Space> neighbors = new ArrayList<Space>();
    private List<IShip> ships = new ArrayList<IShip>();
    private Hazard type;
	private Color owner;
	private boolean home = false;
	
	public Space(Hazard type) {
		numPlanets=0;
		this.type = type;
		name = this.toString();
	}
	public Space(Planet planet, Hazard type) {
		this.planets.add(planet);
		numPlanets=planets.size();
		this.type = type;
		name = this.toString();
	}
	public Space(Planet planet1, Planet planet2, Hazard type) {
		this.planets.add(planet1);
		this.planets.add(planet2);
		numPlanets=planets.size();
		this.type = type;
		name = this.toString();
	}

	public Space(Planet planet1, Planet planet2, Planet planet3, Hazard type) {//for Emirates of Hacan 
		this.planets.add(planet1);
		this.planets.add(planet2);
		this.planets.add(planet3);
		numPlanets=planets.size();
		this.type = type;
		name = this.toString();
	}
	public String getName() {
		return name;
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
		}else if(getNumPlanets()==3) {
			return getPlanets().get(0).getName() +", " + getPlanets().get(1).getName() + ", and " + getPlanets().get(2).getName();
		}else {
			return getType().toString();
		}
	}
	public boolean isHome() {
		return home;
	}
	public void setHome(boolean home) {
		this.home = home;
	}
	
}
