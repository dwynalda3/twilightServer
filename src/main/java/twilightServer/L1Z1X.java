package twilightServer;

import java.util.ArrayList;

public class L1Z1X implements Race {
	private Space homeSystem;
	private int commodities = 2;
	
	public L1Z1X(Color color) {
		Planet p1 = new Planet("0.0.0", 5, 0, PlanetType.NONE, TechReducer.NONE);
		
		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new PDS(color, p1));
		units.add(new Spacedock(color, p1));
		p1.addUnits(units);		
		
		homeSystem = new Space(p1, Hazard.EMPTY);
		
		ArrayList<IShip> ships = new ArrayList<IShip>();
		ships.add(new Carrier(color));
		ships.add(new Dreadnought(color));
		ships.add(new Destroyer(color));
		ships.add(new Fighter(color));
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
