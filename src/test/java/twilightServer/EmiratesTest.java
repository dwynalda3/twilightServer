package twilightServer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class EmiratesTest {
	@org.junit.Test
	public void test() {
		Color color = Color.RED;
		int commodities = 6;
		int numPlanets = 3;
		int production =4;
		String name = "Arretze, Hercant, and Kamdorn";
		Emirates b = new Emirates(color);
		ArrayList<IShip> ships = new ArrayList<IShip>();
		ships.add(new Carrier(color));
		ships.add(new Carrier(color));
		ships.add(new Cruiser(color));
		ships.add(new Fighter(color));
		ships.add(new Fighter(color));
		
		ArrayList<IUnit> units = new ArrayList<IUnit>();
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Infantry(color));
		units.add(new Spacedock(color, b.getHomeSystem().getPlanets().get(0)));
		
		assertEquals(b.getCommodities(), commodities);
		assertEquals(b.getHomeSystem().getNumPlanets(), numPlanets);
		assertEquals(b.getHomeSystem().getOwner(), color);
		assertEquals(b.getHomeSystem().getShips().size(), ships.size());
		assertEquals(b.getHomeSystem().getPlanets().get(0).getUnits().size(), units.size());
		int i =0;
		for(IShip s : b.getHomeSystem().getShips()) {
			assertEquals(s.type(), ships.get(i).type());
			i++;
		}
		i =0;
		for(IUnit u : b.getHomeSystem().getPlanets().get(0).getUnits()) {
			assertEquals(u.type(), units.get(i).type());
			i++;
		}
		assertEquals(b.getHomeSystem().getPlanets().get(0).getResources(), 2);
		assertEquals(b.getHomeSystem().getPlanets().get(0).getInfluence(), 0);
		assertEquals(b.getHomeSystem().getPlanets().get(1).getResources(), 1);
		assertEquals(b.getHomeSystem().getPlanets().get(1).getInfluence(), 1);
		assertEquals(b.getHomeSystem().getPlanets().get(2).getResources(), 0);
		assertEquals(b.getHomeSystem().getPlanets().get(2).getInfluence(), 1);
		assertEquals(b.getHomeSystem().toString(), "Arretze, Hercant, and Kamdorn");
		assertEquals(b.getHomeSystem().getPlanets().get(0).getUnits().get(units.size()-1).getProduction(), production);
	}
}
