package twilightServer;

public class WarSun implements IShip {
	private String type = "War Sun";
	Color owner;
	int combat = 3;
	int movement = 2;
	int capacity = 6;
	int cost = 12;
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public Color getOwner() {
		return owner;
	}

	@Override
	public int getCombat() {
		return combat;
	}

	@Override
	public int getProduction() {
		return 0;
	}

	@Override
	public int getMovement() {
		return movement;
	}

	@Override
	public int getNumShots() {
		return 3;
	}

	@Override
	public int getNumBombards() {
		return 3;
	}

	@Override
	public int getBombardCombat() {
		return combat;
	}

	@Override
	public int getCapacity() {
		return capacity;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public boolean canSustain() {
		return false;
	}

	@Override
	public boolean isDamaged() {
		return false;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setCombat(int combat) {
		this.combat = combat;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}
}
