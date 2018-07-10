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
	public void search(@RequestParam(value = "numPlayers", defaultValue = "4") final int numPlayers) {	
		if(++counter==1)
			model.PlayerSetup(numPlayers);
		String output = "" + counter;
		System.out.println(output);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/create/{color}/{race}")
	public PlayerObject submit(@PathVariable String color, @PathVariable String race) {
		
		String output = color + " and " + race;
		System.out.println(color);
		PlayerObject p = new PlayerObject(++counter, color, race);
		return p;
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