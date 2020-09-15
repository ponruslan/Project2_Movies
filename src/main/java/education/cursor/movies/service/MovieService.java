package education.cursor.movies.service;

import education.cursor.movies.model.Movie;
import education.cursor.movies.model.MovieCategory;
import education.cursor.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static education.cursor.movies.model.MovieCategory.*;

@Service
@RequiredArgsConstructor
public abstract class MovieService {

    private final MovieRepository movieRepository;

    private final MovieCategory movieCategory;

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

    public List<Movie> getAllMovieByCategory(Movie movie) {
        return movieRepository.getAllByCategory(movie.getCategory());
    }
}