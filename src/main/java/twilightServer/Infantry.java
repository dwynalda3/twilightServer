package twilightServer;

public class Infantry implements IUnit {
	private Color owner;
	private int combat = 8;
	private int cost = 1;
	private int production = 0;
	private Planet planet;
	
	public Infantry(Color owner, Planet planet) {
		this.owner = owner;
		this.planet = planet;
	}

	public Infantry(Planet planet) {
		this.planet=planet;
	}

	public Color getOwner() {
		return owner;
	}

	@Override
	public String type() {
		return "Infantry";
	}

	@Override
	public Color color() {
		return owner;
	}


	public int getCost() {
		return cost;
	}

	@Override
	public int getCombat() {
		return combat;
	}

	@Override
	public int getProduction() {
		return production;
	}
	
	public void setCombat(int combat) {
		this.combat = combat;
	}

	public void setProduction(int production) {
		this.production = production;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	
	
}
