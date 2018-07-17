package twilightServer;

import java.util.ArrayList;

public class Barony implements Race {
	Space homeSystem;
	ArrayList<IUnit> units = new ArrayList<IUnit>();
	
	public Barony(Color color) {
		Planet ArcPrime = new Planet("Arc Prime", 4, 0, PlanetType.NONE, TechReducer.NONE);
		Planet WrenTerra = new Planet("Wren Terra", 2, 1, PlanetType.NONE, TechReducer.NONE);
		homeSystem = new Space(ArcPrime, WrenTerra, Hazard.EMPTY);
		units.add(new Dreadnought(color));
		units.add(new Carrier(color));
		units.add(new Destroyer(color));
		units.add(new Fighter(color));
		units.add(new Infantry(color, ArcPrime));
		units.add(new Infantry(color, ArcPrime));
		units.add(new Infantry(color, WrenTerra));
		units.add(new Spacedock(color, ArcPrime));
	}
	@Override
	public Space getHomeSystem() {
		return homeSystem;
	}

	@Override
	public ArrayList<IUnit> getShips() {
		
		return units;
	}

}
