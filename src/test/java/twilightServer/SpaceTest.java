package twilightServer;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

public class SpaceTest {

	@org.junit.Test
	public void test() {
		Planet Bereg = new Planet("Bereg", 3, 1, PlanetType.HAZARDOUS, TechReducer.NONE); 
		Planet LirtaIV = new Planet("Lirta IV", 2, 3, PlanetType.HAZARDOUS, TechReducer.NONE);
		Space BL4 = new Space(Bereg,LirtaIV,Hazard.EMPTY);
		assertEquals(2,BL4.getNumPlanets());
		assertEquals(Hazard.EMPTY, BL4.getType());
		assertEquals(0, BL4.getNeighbors().size());
		assertEquals(0, BL4.getShips().size());
		assertTrue(BL4.getPlanets().contains(Bereg));
		assertTrue(BL4.getPlanets().contains(LirtaIV));
		assertEquals(3,Bereg.getResources());
		assertEquals(1,Bereg.getInfluence());
		assertEquals(2,LirtaIV.getResources());
		assertEquals(3,LirtaIV.getInfluence());
		assertEquals(PlanetType.HAZARDOUS,Bereg.getType());
		assertEquals(PlanetType.HAZARDOUS,LirtaIV.getType());
	}
}
