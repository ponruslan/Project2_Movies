package education.cursor.movies.repository;

import education.cursor.movies.model.Movie;
import education.cursor.movies.model.Rate;
import education.cursor.movies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Long> {
    boolean existsRateByMovieAndUser(Movie movie, User user);
}
