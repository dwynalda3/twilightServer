package twilightServer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BaseController {

	private static int counter = 0;
	Model model = new Model();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/start")
	public void start(@RequestParam(value = "numPlayers", defaultValue = "4") final int numPlayers) {	
		System.out.println(counter);
		if(counter==0) {
			model.PlayerSetup(numPlayers);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/create/{color}/{race}")
	public Player create(@PathVariable String color, @PathVariable String race) {
		int id = ++counter;
		Color c = Color.valueOf(color.toUpperCase());
		model.setPlayer(counter-1, new Player(counter, c, race, model.getPlayerSystems().get(counter-1)));
		return model.getPlayer(counter-1);
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