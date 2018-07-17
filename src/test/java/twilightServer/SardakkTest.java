package twilightServer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SardakkTest {
	@org.junit.Test
	public void test() {
		Color color = Color.RED;
		int commodities = 3;
		int numPlanets = 2;
		int production = 5;
		String name = "Quinarra and Tren'lak";
		Race race = new Sardakk(color);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		ships.add(new Carrier(color));
		ships.add(new Carrier(color));
		ships.add(new Cruiser(color));
		
		Planet p1 = race.getHomeSystem().getPlanets().get(0);
		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new PDS(color, p1));
		units.add(new Spacedock(color, p1));
		
		assertEquals(race.getCommodities(), commodities);
		assertEquals(race.getHomeSystem().getNumPlanets(), numPlanets);
		assertEquals(race.getHomeSystem().getOwner(), color);
		assertEquals(race.getHomeSystem().getShips().size(), ships.size());
		int i =0;
		for(IShip s : race.getHomeSystem().getShips()) {
			assertEquals(s.type(), ships.get(i).type());
			i++;
		}
		i =0;
		for(IUnit u : race.getHomeSystem().getPlanets().get(0).getUnits()) {
			assertEquals(u.type(), units.get(i).type());
			i++;
		}
		assertEquals(race.getHomeSystem().getPlanets().get(0).getResources(), 3);
		assertEquals(race.getHomeSystem().getPlanets().get(0).getInfluence(), 1);
		assertEquals(race.getHomeSystem().getPlanets().get(1).getResources(), 1);
		assertEquals(race.getHomeSystem().getPlanets().get(1).getInfluence(), 0);
		assertEquals(race.getHomeSystem().toString(), name);
		assertEquals(race.getHomeSystem().getPlanets().get(0).getUnits().get(units.size()-1).getProduction(), production);
	}
}
