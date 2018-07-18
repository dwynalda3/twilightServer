package twilightServer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ModelTest extends TestCase{
	Model model = new Model();
	@Override
    protected void setUp() throws Exception
    {
        super.setUp();
        model.PlayerSetup(4);
    }
	
	@org.junit.Test
	public void testPlayerSystems() {
		assertEquals(model.getPlayerSystems().size(), 4);
		for(ArrayList<Space> list : model.getPlayerSystems()) {
			assertEquals(list.size(), 8);
		}
		for(int i =0; i<8; i++) {
			model.playerSystems.get(0).remove(0);
		}
		assertEquals(model.playerSystems.get(0).size(), 0);
	}
	@org.junit.Test
	public void testPlayers() {

		for(int i =0; i<4; i++) {
			assertNotNull(model.getPlayer(i));
		}
	}
	@org.junit.Test
	public void testPlanets() {
		assertEquals(model.getPlanets().size(), 33);
	}
	@org.junit.Test
	public void testBoard() {
		assertNull(model.getBoard());
	}
	@org.junit.Test
	public void testSystems() {
		ArrayList<Space> systems = new ArrayList<Space>();
		for(ArrayList<Space> list : model.getPlayerSystems()) {
			for(Space s : list) {
				systems.add(s);
			}
		}
		assertEquals(systems.size(), 32);
		for(int i = 0; i<5; i++) {
			systems.add(new Space(Hazard.EMPTY));
		}
		assertEquals(systems.size(), 37);
		model.SystemSetup(systems);
		assert(model.getBoard() != null);
		assert(model.getBoard().size() == 37);
		assertEquals(model.getBoard().get(0).getNeighbors().size(), 3);
		assertEquals(model.getBoard().get(3).getNeighbors().size(), 3);
		assertEquals(model.getBoard().get(15).getNeighbors().size(), 3);
		assertEquals(model.getBoard().get(21).getNeighbors().size(), 3);
		assertEquals(model.getBoard().get(33).getNeighbors().size(), 3);
		assertEquals(model.getBoard().get(36).getNeighbors().size(), 3);

		assertEquals(model.getBoard().get(1).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(2).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(4).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(8).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(9).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(14).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(22).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(27).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(28).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(32).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(34).getNeighbors().size(), 4);
		assertEquals(model.getBoard().get(35).getNeighbors().size(), 4);
		
		assertEquals(model.getBoard().get(5).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(6).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(7).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(10).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(11).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(12).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(13).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(16).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(17).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(18).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(19).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(20).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(23).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(24).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(25).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(26).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(29).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(30).getNeighbors().size(), 6);
		assertEquals(model.getBoard().get(31).getNeighbors().size(), 6);

	}
}
