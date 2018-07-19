package twilightServer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BaseController {

	private static int counter = 0;
	Model model;
	private Space[] systems = new Space[37];
	private int numPlayers;
	private State state = State.SETUP;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/start")
	public Space[] start(@RequestParam(value = "numPlayers", defaultValue = "4") final int numPlayers) {
		if(counter<numPlayers) {
			if(model == null) {
				model = new Model();
				this.numPlayers = numPlayers;
				model.PlayerSetup(numPlayers);
				systems[18] = new Space(model.getPlanets().get(0), Hazard.EMPTY);
			}
		}
		return systems;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/create/{color}/{race}")
	public Player create(@PathVariable String color, @PathVariable String race) {
		Color c = Color.valueOf(color.toUpperCase());
		Race r = createRace(race, c);
		for(int i = 0; i<numPlayers; i++) {
			if(model.getPlayer(i).getColor() != null) {
				if (model.getPlayer(i).getRace().getHomeSystem().getOwner().equals(r.getHomeSystem().getOwner())) {
					return model.getPlayer(i);
				}else if(model.getPlayer(i).getRace().getHomeSystem().toString().equals(r.getHomeSystem().toString()) || model.getPlayer(i).color.equals(c)) {
					System.out.println(r + ", " + c);
					return null;
				}
			}
		}
		if(counter<numPlayers) {
			counter++;
			System.out.println(counter);
			assignHomeSystem(counter, r.getHomeSystem());
			model.setPlayer(counter-1, new Player(counter, c, r, model.getPlayerSystems().get(counter-1)));
			return model.getPlayer(counter-1);
		}
		return null;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/assign/{system}/{index}/{playerNum}")
	public Space[] assign(@PathVariable String system, @PathVariable int index, @PathVariable int playerNum) {
		System.out.println(state.equals(State.SETUP));
		if(state.equals(State.SETUP)) {
			if(systems[index] !=null) {
				return systems;
			}
			int i =0;
			int placedSystem = -1;
			for(Space s : model.getPlayerSystems().get(playerNum-1)) {
				if(s.toString().equals(system)) {
					systems[index] = s;	
					placedSystem = i;
				}
				i++;
			}
			if(placedSystem != -1) {
				model.playerSystems.get(playerNum-1).remove(placedSystem);
			}
		}
		return systems;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewSystem/{index}")
	public Space create(@PathVariable int index) {
		for(Integer s : model.getBoard().get(index).getNeighborLocations()) {
			System.out.println(s.intValue());
		}
		return model.getBoard().get(index);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/refresh")
	public Space[] refresh() {
		boolean finishedSetup = true;
		for(Space s : systems) {
			if(s == null) {
				finishedSetup = false;
			}
		}
		if(finishedSetup == true) {
			ArrayList<Space> board = new ArrayList<Space>();
			for (Space s : systems) {
				board.add(s);
			}
			model.SystemSetup(board);
			state = State.PLAY;
		}
		return systems;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getState")
	public State getState() {
		return this.state;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/setBoard")
	public void setBoard() {
		ArrayList<Space> board = new ArrayList<Space>();
		for(ArrayList<Space> list : model.getPlayerSystems()) {
			for(Space s : list) {
				board.add(s);
			}
		}
		for(int i=0; i<5;i++) {
			board.add(new Space(Hazard.EMPTY));
		}
		for(int i=0;i<board.size();i++) {
			systems[i]= board.get(i);
		}
		model.SystemSetup(board);
		state = State.PLAY;
		}

	private Race createRace(String race, Color color) {
		if(race.equals("Barony"))
			return new Barony(color);
		else if(race.equals("Emirates")) {
			return new Emirates(color);
		}else if(race.equals("Sol")) {
			return new Sol(color);
		}else if(race.equals("Mentak")) {
			return new Mentak(color);
		}else if(race.equals("L1Z1X")) {
			return new L1Z1X(color);
		}else if(race.equals("Naalu")) {
			return new Naalu(color);
		}else if(race.equals("Sardakk")) {
			return new Sardakk(color);
		}else if(race.equals("Universities")) {
			return new Universities(color);
		}else if(race.equals("Xxcha")) {
			return new Xxcha(color);
		}
		else {
			return new Barony(color);
		}
	}

	private void assignHomeSystem(int playerNum, Space homeSystem) {
		if(numPlayers == 4) {
			if(playerNum == 1) {
				systems[4] = homeSystem;
			}else if(playerNum == 2) {
				systems[8] = homeSystem;
			}else if(playerNum == 3) {
				systems[28] = homeSystem;
			}else if(playerNum == 4) {
				systems[32] = homeSystem;
			}
		}

	}

	/*
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}*/

}