package twilightServer;

public class Infantry implements IUnit {
	private String type = "Infantry";
	private Color owner;
	private int combat = 8;
	private int cost = 1;
	private int production = 0;
	
	public Infantry(Color owner) {
		this.owner = owner;
	}
	public Color getOwner() {
		return owner;
	}

	@Override
	public String getType() {
		return type;
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
	
	
}
