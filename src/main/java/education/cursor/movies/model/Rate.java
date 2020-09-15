package education.cursor.movies.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

    private int rate;
}
