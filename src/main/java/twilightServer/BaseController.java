package twilightServer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	private static int numPlayers;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/start")
	public Space[] start(@RequestParam(value = "numPlayers", defaultValue = "4") final int numPlayers) {
		if(model == null) {
			model = new Model();
			this.numPlayers = numPlayers;
			model.PlayerSetup(numPlayers);
			systems[18] = new Space(model.getPlanets().get(0), Hazard.EMPTY);
		}
		return systems;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/create/{color}/{race}")
	public Player create(@PathVariable String color, @PathVariable String race) {
		if(counter<numPlayers) {
			int id = ++counter;
		}
		Color c = Color.valueOf(color.toUpperCase());
		model.setPlayer(counter-1, new Player(counter, c, race, model.getPlayerSystems().get(counter-1)));
		return model.getPlayer(counter-1);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/assign/{system}/{index}")
	public Space[] assign(@PathVariable String system, @PathVariable int index) {
		if(systems[index] !=null) {
			return systems;
		}
		for(ArrayList<Space> list: model.getPlayerSystems()) {
			for(Space s : list) {
				if(s.toString().equals(system)) {
					systems[index] = s;				
				}
			}
		}
		return systems;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/refresh")
	public Space[] refresh() {
		return systems;
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