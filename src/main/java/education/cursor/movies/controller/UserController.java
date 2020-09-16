package education.cursor.movies.controller;

import com.fasterxml.jackson.annotation.JsonView;
import education.cursor.movies.dto.RateDto;
import education.cursor.movies.error.IncorrectRateValue;
import education.cursor.movies.error.MovieNotFoundException;
import education.cursor.movies.error.RepeatRateException;
import education.cursor.movies.model.Movie;
import education.cursor.movies.model.User;
import education.cursor.movies.model.Views;
import education.cursor.movies.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movie")
@Secured("ROLE_USER")
public class UserController {

    private final MovieService movieService;

    @GetMapping("all")
    @JsonView(Views.ShortMovie.class)
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMovie.class)
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public Movie findById(@PathVariable("id") Movie movie) {
        return movie;
    }

    @GetMapping("category")
    @JsonView(Views.FullMovie.class)
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public List<Movie> findAllByCategory(@RequestParam("category") String category) {
        return movieService.findAllByCategory(category);
    }

    @PostMapping("rate")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity rate(
            @RequestBody RateDto rateDto,
            @AuthenticationPrincipal User user) {
        try {
            movieService.rate(rateDto, user);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.badRequest().body("No movie with this id found");
        } catch (RepeatRateException e) {
            return ResponseEntity.badRequest().body("You have already rate");
        } catch (IncorrectRateValue e) {
            return ResponseEntity.badRequest().body("Incorrect Rate Value. Please enter a number from 1 to 10");
        }
        return ResponseEntity.ok().build();
    }
}
