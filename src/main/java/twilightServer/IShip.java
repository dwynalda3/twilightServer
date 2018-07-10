package twilightServer;

public interface IShip extends IUnit {
	
	int getNumShots();
	
	int getNumBombards();
 	
	int getBombardCombat();

	int getCapacity();
	
	int getMovement();
	
	int getCost();
	
	boolean canSustain();
	
	boolean isDamaged();
	
}
