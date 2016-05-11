package edu.mum.cs544.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.cs544.domain.Director;
import edu.mum.cs544.domain.Movie;
import edu.mum.cs544.domain.MovieCharacter;
import edu.mum.cs544.domain.MovieReview;
import edu.mum.cs544.service.CharacterService;
import edu.mum.cs544.service.DirectorService;
import edu.mum.cs544.service.MovieReviewService;
import edu.mum.cs544.service.MovieService;

@Controller
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;
	@Autowired
	private DirectorService directorService;
	@Autowired
	private CharacterService characterService;
	@Autowired
	private MovieReviewService movieReviewService;
	
	//@RequestMapping(value="/movies", method=RequestMethod.GET)
	@RequestMapping(value = {"/","/movies"}, method = RequestMethod.GET)
	public String getAllMovies(Locale locale, Model model, HttpServletRequest request){
		String name = request.getParameter("name");
		if (name != null){
			logger.info("Movies size with some name: " + name + "  is  :" + movieService.findByName("name").size(), locale);
			model.addAttribute("movies", movieService.findByName("name"));
		}else{
			model.addAttribute("movies", movieService.findAll());
		}
		logger.info("Movies Size: " + movieService.findAll().size(), locale);
		return "movies";
	}
	
	@RequestMapping(value="/newmovie", method=RequestMethod.GET)
	public String addMovie(Model model){
		Movie m = new Movie();
		List<Director> d =directorService.findAll();
		List<MovieCharacter> c = characterService.findAll();
		m.setDirectors(d);
		m.setMovieCharacters(c);
		
		model.addAttribute("newMovie", m);
		model.addAttribute("directors", d);
		model.addAttribute("movieCharacter", c);
		return "newMovie";
	}
	
	
	@RequestMapping(value = "/newmovie", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newMovie") Movie newMovie, BindingResult result,
			HttpServletRequest request) {
		String[] suppresedFields = result.getSuppressedFields();
		if (suppresedFields.length > 0) {
			throw new RuntimeException(
					"Attempting to bind disallowd fields:" + StringUtils.arrayToCommaDelimitedString(suppresedFields));
		}
		MultipartFile poster = newMovie.getPoster();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootDirectory);
		if (poster != null && !poster.isEmpty()) {
			try {
				poster.transferTo(
						new File(rootDirectory + "resources\\" + newMovie.getId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		movieService.saveMovie(newMovie);
		return "redirect:/movies";

	}
	
	@RequestMapping(value="/movies/{id}/comments", method=RequestMethod.GET)
	public String newComment(@ModelAttribute("comment") MovieReview movieReview, @PathVariable("id") Long id){
		movieReview.setMovie(movieService.findOne(id));
		return "addComment";
	}
	
	@RequestMapping(value="/movies/{id}/comments", method=RequestMethod.POST)
	public String addComment(@ModelAttribute("comment") MovieReview movieReview){
		movieReview.setDate(new Date());
		movieReviewService.save(movieReview);
		return "redirect:/movies";
	}
	
}
