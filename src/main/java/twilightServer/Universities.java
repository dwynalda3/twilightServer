package twilightServer;

import java.util.ArrayList;

public class Universities implements Race {
	private Space homeSystem;
	private int commodities = 4;
	
	public Universities(Color color) {
		Planet p1 = new Planet("Jol", 1, 2, PlanetType.NONE, TechReducer.NONE);
		Planet p2 = new Planet("Nar", 2, 3, PlanetType.NONE, TechReducer.NONE);
		
		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new PDS(color, p1));
		p1.addUnits(units);
		units.clear();
		units.add(new PDS(color, p2));
		units.add(new Spacedock(color, p2));
		p2.addUnits(units);
		
		homeSystem = new Space(p1, p2, Hazard.EMPTY);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		
		ships.add(new Dreadnought(color));
		ships.add(new Carrier(color));
		ships.add(new Carrier(color));
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
