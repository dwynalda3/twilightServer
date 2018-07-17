package twilightServer;

import java.util.ArrayList;

public interface Race {
	Space getHomeSystem();
	
	ArrayList<IUnit> getShips();
}
