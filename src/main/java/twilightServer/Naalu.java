package twilightServer;

import java.util.ArrayList;

public class Naalu implements Race {
	private Space homeSystem;
	private int commodities = 3;
	
	public Naalu(Color color) {
		Planet p1 = new Planet("Druua", 3, 1, PlanetType.NONE, TechReducer.NONE);
		Planet p2 = new Planet("Maaluuk", 0, 2, PlanetType.NONE, TechReducer.NONE);
		
		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new PDS(color, p1));
		units.add(new Spacedock(color, p1));
		p1.addUnits(units);
		
		homeSystem = new Space(p1, p2, Hazard.EMPTY);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		
		ships.add(new Cruiser(color));
		ships.add(new Carrier(color));
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
