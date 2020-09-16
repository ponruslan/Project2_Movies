package education.cursor.movies.service;

import education.cursor.movies.dto.RateDto;
import education.cursor.movies.error.IncorrectRateValue;
import education.cursor.movies.error.MovieNotFoundException;
import education.cursor.movies.error.RepeatRateException;
import education.cursor.movies.model.Movie;
import education.cursor.movies.model.MovieCategory;
import education.cursor.movies.model.Rate;
import education.cursor.movies.model.User;
import education.cursor.movies.repository.MovieRepository;
import education.cursor.movies.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final RateRepository rateRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public Movie update(Movie movieFromDb, Movie movie) {
        String name = movie.getName();
        MovieCategory category = movie.getCategory();
        String director = movie.getDirector();
        String description = movie.getDescription();

        if (name != null) {
            movieFromDb.setName(name);
        }
        if (category != null) {
            movieFromDb.setCategory(category);
        }
        if (director != null) {
            movieFromDb.setDirector(director);
        }
        if (description != null) {
            movieFromDb.setDescription(description);
        }

        return movieRepository.save(movieFromDb);
    }

    public List<Movie> findAllByCategory(String category) {
        try {
            MovieCategory movieCategory = MovieCategory.valueOf(category);
            return movieRepository.getAllByCategory(movieCategory);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }


    public void rate(RateDto rateDto, User user) throws RepeatRateException, MovieNotFoundException, IncorrectRateValue {
        Movie movie = movieRepository.findById(rateDto.getMovie_id()).orElse(null);
        if (movie == null) {
            throw new MovieNotFoundException();
        }

        int rateValue = rateDto.getRate();
        if (rateValue <= 0 || rateValue > 10) {
            throw new IncorrectRateValue();
        }

        if (rateRepository.existsRateByMovieAndUser(movie, user)) {
            throw new RepeatRateException();
        }

        Rate rate = new Rate();
        rate.setRate(rateValue);
        rate.setUser(user);
        rate.setMovie(movie);
        rateRepository.save(rate);
    }
}
