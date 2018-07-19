package twilightServer;

public class Spacedock implements IUnit {
	private String type = "Spacedock";
	private int productionModifier = 2;
	private int combat = -1;
	private Color owner;
	private Planet planet;
	private int capacity = 3;
	
	public Spacedock(Color owner, Planet planet) {
		this.owner = owner;
		this.planet = planet;
	}

	public Spacedock(Planet arcPrime) {
		this.planet = planet;
	}

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
