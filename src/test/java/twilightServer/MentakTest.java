package twilightServer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class MentakTest {
	@org.junit.Test
	public void test() {
		Color color = Color.RED;
		int commodities = 2;
		int numPlanets = 1;
		int production = 6;
		String name = "Moll Primus";
		Race race = new Mentak(color);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		ships.add(new Carrier(color));
		ships.add(new Cruiser(color));
		ships.add(new Cruiser(color));
		ships.add(new Fighter(color));
		ships.add(new Fighter(color));
		ships.add(new Fighter(color));
		
		Planet p1 = race.getHomeSystem().getPlanets().get(0);
		ArrayList<IUnit> units = new ArrayList<IUnit>();
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
		assertEquals(race.getHomeSystem().getPlanets().get(0).getUnits().size(), units.size());
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
		assertEquals(race.getHomeSystem().getPlanets().get(0).getResources(), 4);
		assertEquals(race.getHomeSystem().getPlanets().get(0).getInfluence(), 1);
		assertEquals(race.getHomeSystem().toString(), name);
		assertEquals(race.getHomeSystem().getPlanets().get(0).getUnits().get(units.size()-1).getProduction(), production);
	}
}
