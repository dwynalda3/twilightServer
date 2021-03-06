package twilightServer;

public class PDS implements IUnit{
	private String type = "PDS";
	private int numSpaceCannons=1;
	private Color owner;
	private int combat = 6; 
	private Planet planet;
	
	public PDS(Color owner, Planet planet) {
		this.owner = owner;
		this.planet = planet;
	}

	public int getNumSpaceCannons(){
		return numSpaceCannons;
	}

	public void setNumSpaceCannons(int numSpaceCannons) {
		this.numSpaceCannons = numSpaceCannons;
	}

	public void setCombat(int combat) {
		this.combat = combat;
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
		return 0;
	}

}