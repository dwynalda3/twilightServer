package twilightServer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class UniversitiesTest {
	@org.junit.Test
	public void test() {
		Color color = Color.RED;
		int commodities = 4;
		int numPlanets = 2;
		int production = 4;
		String name = "Jol and Nar";
		Race race = new Universities(color);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		ships.add(new Dreadnought(color));
		ships.add(new Carrier(color));
		ships.add(new Carrier(color));
		ships.add(new Fighter(color));
		
		Planet p1 = race.getHomeSystem().getPlanets().get(0);
		Planet p2 = race.getHomeSystem().getPlanets().get(1);
		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new PDS(color, p1));
		units.add(new PDS(color, p2));
		units.add(new Spacedock(color, p2));
		
		assertEquals(race.getCommodities(), commodities);
		assertEquals(race.getHomeSystem().getNumPlanets(), numPlanets);
		assertEquals(race.getHomeSystem().getOwner(), color);
		assertEquals(race.getHomeSystem().getShips().size(), ships.size());
		int i =0;
		for(IShip s : race.getHomeSystem().getShips()) {
			assertEquals(s.type(), ships.get(i).type());
			i++;
		}
		assertEquals(race.getHomeSystem().getPlanets().get(0).getResources(), 1);
		assertEquals(race.getHomeSystem().getPlanets().get(0).getInfluence(), 2);
		assertEquals(race.getHomeSystem().getPlanets().get(1).getResources(), 2);
		assertEquals(race.getHomeSystem().getPlanets().get(1).getInfluence(), 3);
		assertEquals(race.getHomeSystem().toString(), name);
		assertEquals(race.getHomeSystem().getPlanets().get(1).getUnits().get(race.getHomeSystem().getPlanets().get(1).getUnits().size()-1).getProduction(), production);
	}
}
