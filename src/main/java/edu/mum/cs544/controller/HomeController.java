package edu.mum.cs544.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.domain.Actor;
import edu.mum.cs544.domain.Director;
import edu.mum.cs544.domain.Genre;
import edu.mum.cs544.domain.MovieCharacter;
import edu.mum.cs544.service.ActorService;
import edu.mum.cs544.service.CharacterService;
import edu.mum.cs544.service.DirectorService;
import edu.mum.cs544.service.GenreService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private GenreService genreService;
	@Autowired
	private ActorService actorService;
	@Autowired
	private CharacterService characterService;
	@Autowired
	private DirectorService directorService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//	@PostConstruct
	private void createGenres(){
		Genre commedy = new Genre();
		commedy.setType("Comedy");
		commedy.setDescription("Hilarious movies");
		
		logger.info("New Genre Id: " + genreService.saveGenre(commedy));
		
		Genre action = new Genre();
		action.setType("Action");
		action.setDescription("Action movies");
		
		logger.info("Action Genre Id: " + genreService.saveGenre(action));
	
		Actor a = new Actor();
		a.setFirstname("Denzel");
		a.setLastname("Washington");
		a.setBirthdate(new GregorianCalendar(1954, 11, 28).getTime());
		a.setBiography("Denzel Washington was given the name Denzel Washington Jr. at birth.");
		
		actorService.saveActor(a);
		
		MovieCharacter c = new MovieCharacter();
		c.setName("Dr. Jerome Davenport");
		c.setDescription("A sailor with an explosive attitude, with the help of a Navy psychiatrist, finds the courage to stop fighting... and start healing.");
		c.setActor(a);
		
		characterService.saveCharactere(c);
		
		MovieCharacter c1 = new MovieCharacter();
		c1.setName("Nahum");
		c1.setDescription("A sailor with an explosive attitude, with the help of a Navy psychiatrist, finds the courage to stop fighting... and start healing.");
		c1.setActor(a);
		
		characterService.saveCharactere(c1);
		
		Director director = new Director();
		director.setFirstname("Orson");
		director.setLastname("Welles");
		director.setBirthdate(new GregorianCalendar(1954, 11, 28).getTime());
		director.setBiography("He changed the movies. With one genius stroke, his first film, CITIZEN KANE, inaugurated a new depth — both visually (Gregg Toland’s deep-focus camera work made previous movies look 2-D) and emotionally ");
		
		directorService.saveDirector(director);
		
		Director director2 = new Director();
		director2.setFirstname("James");
		director2.setLastname("Lee");
		director2.setBirthdate(new GregorianCalendar(1954, 11, 28).getTime());
		director2.setBiography("He changed the movies. With one genius stroke, his first film, CITIZEN KANE, inaugurated a new depth — both visually (Gregg Toland’s deep-focus camera work made previous movies look 2-D) and emotionally ");
		
		directorService.saveDirector(director2);
		
		//2 Actors
		//2 Characters
		//2 Directors
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	public ActorService getActorService() {
		return actorService;
	}

	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}

	public CharacterService getCharacterService() {
		return characterService;
	}

	public void setCharacterService(CharacterService characterService) {
		this.characterService = characterService;
	}

}
