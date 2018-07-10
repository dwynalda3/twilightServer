package twilightServer;

import java.util.ArrayList;
import java.util.List;

public class Planet {
	private String name;
	private int resources, influence, numPDS = 0;
	private TechReducer reducer;
	private PlanetType type;
	private List<IUnit> units = new ArrayList<IUnit>();
	private boolean hasSpacedock = false;
	
	public Planet(String name, int resources, int influence,
			PlanetType type, TechReducer reducer) {
		this.name = name;
		this.resources = resources;
		this.influence = influence;
		this.type = type;
		this.reducer = reducer;
	}

	public String getName() {
		return name;
	}

	public int getResources() {
		return resources;
	}

	public int getInfluence() {
		return influence;
	}

	public List<IUnit> getUnits() {
		return units;
	}

	public void addUnits(List<IUnit> units) {
		this.units.addAll(units);
	}

	public void setResources(int resources) {
		this.resources = resources;
	}

	public void setInfluence(int influence) {
		this.influence = influence;
	}

	public PlanetType getType() {
		return type;
	}
	
	public boolean hasPlanetaryShield(){
		if (numPDS != 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int addPDS(PDS pds){
		units.add(pds);
		numPDS++;
		return numPDS;
	}
	public boolean addSpaceDock(Spacedock s){
		if(!hasSpacedock){
			units.add(s);
			hasSpacedock = true;
			return true;
		}else{
			return false;
		}
		
	}
}
