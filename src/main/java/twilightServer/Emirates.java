package twilightServer;

import java.util.ArrayList;

public class Emirates implements Race {
	private Space homeSystem;
	private int commodities = 6;
	
	public Emirates(Color color) {
		Planet p1 = new Planet("Arretze", 2, 0, PlanetType.NONE, TechReducer.NONE);
		Planet p2 = new Planet("Hercant", 1, 1, PlanetType.NONE, TechReducer.NONE);
		Planet p3 = new Planet("Kamdorn", 0, 1, PlanetType.NONE, TechReducer.NONE);

		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Spacedock(color, p1));
		p1.addUnits(units);
		
		homeSystem = new Space(p1, p2, p3, Hazard.EMPTY);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		ships.add(new Carrier(color));
		ships.add(new Carrier(color));
		ships.add(new Cruiser(color));
		ships.add(new Fighter(color));
		ships.add(new Fighter(color));
		
		homeSystem.addShips(ships);
		homeSystem.setHome(true);
		homeSystem.setOwner(color);
	}
	@Override
	public Space getHomeSystem() {
		return homeSystem;
	}

	@Override
	public int getCommodities() {
		return commodities;
	}

}
