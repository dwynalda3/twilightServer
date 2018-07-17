package twilightServer;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Model {
	private ArrayList<Space> planetSystems;
	private ArrayList<Space> nonPlanetSystems;
	private ArrayList<Space> board;
	private ArrayList<Planet> planets;
	public ArrayList<ArrayList<Space>> playerSystems = new ArrayList<ArrayList<Space>>();
	private ArrayList<Player> players = new ArrayList<Player>() ;
	
	public Model() {
	}
	public void SystemSetup(ArrayList<Space> systems) {
		board = systems;
		if(systems.size()!=37) {
			System.out.println("Mecatol Rex not added");
		}
		createNeighbors(0,1);
		createNeighbors(0,4);
		createNeighbors(0,5);
		createNeighbors(1,2);
		createNeighbors(1,5);
		createNeighbors(1,6);
		createNeighbors(2,3);
		createNeighbors(2,6);
		createNeighbors(2,7);
		createNeighbors(3,7);
		createNeighbors(3,8);
		createNeighbors(4,5);
		createNeighbors(4,9);
		createNeighbors(4,10);
		createNeighbors(5,6);
		createNeighbors(5,10);
		createNeighbors(5,11);
		createNeighbors(6,7);
		createNeighbors(6,11);
		createNeighbors(6,12);
		createNeighbors(7,8);
		createNeighbors(7,12);
		createNeighbors(7,13);
		createNeighbors(8,13);
		createNeighbors(8,14);
		createNeighbors(9,10);
		createNeighbors(9,15);
		createNeighbors(9,16);
		createNeighbors(10,11);
		createNeighbors(10,16);
		createNeighbors(10,17);
		createNeighbors(11,12);
		createNeighbors(11,18);
		createNeighbors(11,19);
		createNeighbors(12,13);
		createNeighbors(12,19);
		createNeighbors(12,20);
		createNeighbors(13,14);
		createNeighbors(13,19);
		createNeighbors(13,20);
		createNeighbors(14,20);
		createNeighbors(14,21);		
		createNeighbors(15,16);
		createNeighbors(15,22);
		createNeighbors(16,17);
		createNeighbors(16,22);
		createNeighbors(16,23);
		createNeighbors(17,18);
		createNeighbors(17,23);
		createNeighbors(17,24);
		createNeighbors(18,19);
		createNeighbors(18,24);
		createNeighbors(18,25);
		createNeighbors(19,20);
		createNeighbors(19,25);
		createNeighbors(19,26);
		createNeighbors(20,21);
		createNeighbors(20,26);
		createNeighbors(20,27);
		createNeighbors(21,27);
		createNeighbors(22,23);
		createNeighbors(22,28);
		createNeighbors(23,24);
		createNeighbors(23,28);
		createNeighbors(23,29);
		createNeighbors(24,25);
		createNeighbors(24,29);
		createNeighbors(24,30);
		createNeighbors(25,26);
		createNeighbors(25,30);
		createNeighbors(25,31);
		createNeighbors(26,27);
		createNeighbors(26,31);
		createNeighbors(26,32);
		createNeighbors(27,32);
		createNeighbors(28,29);
		createNeighbors(28,33);
		createNeighbors(29,30);
		createNeighbors(29,33);
		createNeighbors(29,34);
		createNeighbors(30,31);
		createNeighbors(30,34);
		createNeighbors(30,35);
		createNeighbors(31,32);
		createNeighbors(31,35);
		createNeighbors(31,36);
		createNeighbors(32,36);
		createNeighbors(33,34);
		createNeighbors(34,35);
		createNeighbors(35,36);
	}
	public void PlayerSetup(int numPlayers) {

		//end assumption
		PlanetSetup(numPlayers);
		int i = 0;
		for(i=0;i<numPlayers;i++) {
			Player p = new Player();
			p.setSystems(playerSystems.get(i));
			players.add(p);
		}
		
	}
	private void PlanetSetup(int numPlayers){
		if(numPlayers != 3 && numPlayers != 4) {
			JOptionPane.showMessageDialog(null, 
					"Only supports 3 and 4 players so far", 
					"Error", 
					JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		createPlanetSystems();
		createNonPlanetSystems();
		shuffleSystems(numPlayers);
		displaySystems();
	}
	public ArrayList<Planet> getPlanets() {
		return planets;
	}	
	private void shuffleSystems(int numPlayers){
		Collections.shuffle(planetSystems);
		Collections.shuffle(nonPlanetSystems);
		for(int i=0; i<numPlayers;i++) {
			playerSystems.add(new ArrayList<Space>());
		}
		if(numPlayers == 4) {
			int i = 0;
			for(Space s: planetSystems) {
				playerSystems.get(i%numPlayers).add(s);
				i++;
			}
			i = 0;
			for(Space s: nonPlanetSystems) {
				playerSystems.get(i%numPlayers).add(s);
				i++;
			}
		}
	}
	private void createPlanetSystems() {
		planets = new ArrayList<Planet>();
		planetSystems = new ArrayList<Space>();		

		PlanetType industrial = PlanetType.INDUSTRIAL;
		PlanetType hazardous = PlanetType.HAZARDOUS;
		PlanetType cultural = PlanetType.CULTURAL;
		TechReducer red = TechReducer.RED;
		TechReducer blue = TechReducer.BLUE;
		TechReducer yellow = TechReducer.YELLOW;
		TechReducer green = TechReducer.GREEN;
		TechReducer none = TechReducer.NONE;

		Planet Mecatol = new Planet("Mecatol Rex",1,6,PlanetType.NONE,none);
		planets.add(Mecatol);

		Planet Thibah = new Planet("Thibah",1,1,industrial,blue);
		planets.add(Thibah);
		addSystem(Thibah);

		Planet Mellon = new Planet("Mellon",0,2,cultural,none);
		planets.add(Mellon);
		Planet Zohbat = new Planet("Zohbat",3,1,hazardous,none);
		planets.add(Zohbat);
		addSystem(Zohbat,Mellon);

		Planet Vefut = new Planet("Vefut II",2,2,hazardous,none);
		planets.add(Vefut);
		addSystem(Vefut);

		Planet Tarmann = new Planet("Tar'mann",1,1,industrial,green);
		planets.add(Tarmann);
		addSystem(Tarmann);

		Planet Tequran = new Planet("Tequ'ran",2,0,hazardous,none);
		planets.add(Tequran);
		Planet Torkan = new Planet("Torkan",0,3,cultural,none);
		planets.add(Torkan);
		addSystem(Tequran, Torkan);

		Planet Dalbootha = new Planet("Dal Bootha",0,2,cultural,none);
		planets.add(Dalbootha);
		Planet Xxehan = new Planet("Xxehan",1,1,cultural,none);
		planets.add(Xxehan);
		addSystem(Dalbootha, Xxehan);

		Planet Corneeq = new Planet("Corneeq",1,2,cultural,none);
		planets.add(Corneeq);
		Planet Resculon = new Planet("Resculon",2,0,cultural,none);
		planets.add(Resculon);
		addSystem(Corneeq, Resculon);

		Planet Abyz = new Planet("Abyz",3,0,hazardous,none);
		planets.add(Abyz);
		Planet Fria = new Planet("Fria",2,0,hazardous,none);
		planets.add(Fria);
		addSystem(Fria, Abyz);

		Planet Lodor = new Planet("Lodor",3,1,cultural,none);
		planets.add(Lodor);
		addSystem(Lodor);

		Planet Qucenn = new Planet("Qucen'n",1,2,industrial,none);
		planets.add(Qucenn);
		Planet Rarron = new Planet("Rarron",0,3,cultural,none);
		planets.add(Rarron);
		addSystem(Qucenn, Rarron);

		Planet Arinam = new Planet("Arinam",1,2,industrial,none);
		planets.add(Arinam);
		Planet Meer = new Planet("Meer",0,4,hazardous,red);
		planets.add(Meer);
		addSystem(Meer, Arinam);

		Planet Quann = new Planet("Quann",2,1,cultural,none);
		planets.add(Quann);
		addSystem(Quann);

		Planet Saudor = new Planet("Saudor",2,2,industrial,none);
		planets.add(Saudor);
		addSystem(Saudor);

		Planet Centauri = new Planet("Centauri",1,3,cultural,none);
		planets.add(Centauri);
		Planet Gral = new Planet("Gral",1,1,industrial,blue);
		planets.add(Gral);
		addSystem(Centauri, Gral);

		Planet Mehar = new Planet("Mehar Xull",1,3,hazardous,red);
		planets.add(Mehar);
		addSystem(Mehar);

		Planet Bereg = new Planet("Bereg",3,1,hazardous,none); 
		planets.add(Bereg);
		Planet LirtaIV = new Planet("Lirta IV",2,3,hazardous,none);
		planets.add(LirtaIV);
		addSystem(Bereg, LirtaIV);

		Planet Starpoint = new Planet("Starpoint",3,1,hazardous,none); 
		planets.add(Starpoint);
		Planet Newalbion = new Planet("New Albion",1,1,industrial,green); 
		planets.add(Newalbion);
		addSystem(Starpoint, Newalbion);

		Planet Wellon = new Planet("Wellon",1,2,industrial,yellow); 
		planets.add(Wellon);
		addSystem(Wellon);

		Planet Arnor = new Planet("Arnor",2,1,industrial,none); 
		planets.add(Arnor);
		Planet Lor = new Planet("Lor",1,2,industrial,none); 
		planets.add(Lor);
		addSystem(Lor, Arnor);	

		Planet Lazar = new Planet("Lazar",1,0,industrial,yellow); 
		planets.add(Lazar);
		Planet Sakulag = new Planet("Sakulag",2,1,hazardous,none); 
		planets.add(Sakulag);
		addSystem(Lazar, Sakulag);
	}
	private void createNonPlanetSystems(){
		nonPlanetSystems = new ArrayList<Space>();
		Space tempSystem;
		tempSystem = new Space(Hazard.ASTEROIDFIELD);
		this.nonPlanetSystems.add(tempSystem);
		this.nonPlanetSystems.add(tempSystem);
		tempSystem = new Space(Hazard.NEBULA);
		this.nonPlanetSystems.add(tempSystem);
		tempSystem = new Space(Hazard.GRAVITYRIFT);
		this.nonPlanetSystems.add(tempSystem);
		tempSystem = new Space(Hazard.SUPERNOVA);
		this.nonPlanetSystems.add(tempSystem);
		tempSystem = new Space(Hazard.ALPHA);
		this.nonPlanetSystems.add(tempSystem);
		tempSystem = new Space(Hazard.BETA);
		this.nonPlanetSystems.add(tempSystem);
		tempSystem = new Space(Hazard.EMPTY);
		for(int i =0; i<5; i++) {
			this.nonPlanetSystems.add(tempSystem);
		}		
	}
	private void addSystem(Planet p) {
		Space s = new Space(p,Hazard.EMPTY);
		this.planetSystems.add(s);
	}
	private void addSystem(Planet p, Planet p2) {
		Space s = new Space(p, p2 ,Hazard.EMPTY);
		this.planetSystems.add(s);
	}
	private void displaySystems() {
		for(ArrayList<Space> list: playerSystems ) {
			for(Space s : list) {
				System.out.println(s);
			}
			System.out.println("\n");
		}
	}
	private void createNeighbors(int index1, int index2) {
		board.get(index1).addNeighbor(board.get(index2));
		board.get(index2).addNeighbor(board.get(index1));
	}
	public ArrayList<Space> getBoard() {
		return board;
	}
	public ArrayList<ArrayList<Space>> getPlayerSystems() {
		return playerSystems;
	}
	public Player getPlayer(int number) {
		return players.get(number);
	}
	public void setPlayer(int number, Player p) {
		players.set(number, p);
	}
	

}

