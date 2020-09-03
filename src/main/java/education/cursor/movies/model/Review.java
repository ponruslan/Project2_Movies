package education.cursor.movies.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonView(Views.ShortReview.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean liked;
    @Column(columnDefinition = "LONGTEXT")
    private String reviewMessage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonView(Views.FullReview.class)
    private Movie movie;
}
