package twilightServer;

public class Destroyer implements IShip {
	private String type = "Destroyer";
	private Color owner;
	private int combat = 9;
	private int movement = 2;
	private int capacity = 0;
	private int cost = 1;
	
	public Destroyer(Color color) {
		this.owner = color;
	}

	@Override
	public String type() {
		return type;
	}

	@Override
	public Color color() {
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
		return 1;
	}

	@Override
	public int getNumBombards() {
		return 0;
	}

	@Override
	public int getBombardCombat() {
		return 0;
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
