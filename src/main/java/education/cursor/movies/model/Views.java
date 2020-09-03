package education.cursor.movies.model;

public final class Views {
    public interface ShortReview {}
    public interface FullReview extends ShortReview {}

    public interface ShortMovie extends ShortReview, ShortUser {}
    public interface FullMovie extends ShortMovie {}

    public interface ShortUser {}
}
