package twilightServer;

public class Spacedock implements IUnit {
	private int productionModifier = 2;
	private int combat = -1;
	private Color owner;
	private Planet planet;
	private int capacity = 3;
	
	public Spacedock(Color owner, Planet planet) {
		this.owner = owner;
		this.planet = planet;
	}

	@Override
	public String type() {
		return "Spacedock";
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
		return planet.getResources() + productionModifier;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setProductionModifier(int productionModifier) {
		this.productionModifier = productionModifier;
	}

}
