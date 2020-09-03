insert into movie (id, name, category, description, director) values
    ( 1,  'The Shawshank Redemption', 'DRAMA', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'Frank Darabont'),
    ( 2, 'The Godfather', 'CRIME', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'Francis Ford Coppola'),
    ( 3, 'The Godfather: Part II', 'CRIME', 'The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.', 'Francis Ford Coppola'),
    ( 4, 'The Dark Knight', 'ACTION', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 'Christopher Nolan'),
    ( 5, '12 Angry Men', 'CRIME', 'A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.', 'Sidney Lumet'),
    ( 6, 'Schindlers List', 'HISTORY', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'Steven Spielberg'),
    ( 7, 'The Lord of the Rings: The Return of the King', 'ADVENTURE', 'Gandalf and Aragorn lead the World of Men against Saurons army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.', 'Peter Jackson'),
    ( 8, 'Pulp Fiction', 'CRIME', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'Quentin Tarantino');

insert into user (id, password, username) values
    (1, 'admin', 'admin'),
    (2, 'userOne', 'userOne'),
    (3, 'userSecond', 'userSecond');

insert into user_role (user_id, roles) values
    (1, 'ADMIN'),
    (1, 'USER'),
    (2, 'USER'),
    (3, 'USER');

insert into review (id, liked, review_message, movie_id, user_id) values
    (1, true, 'If you love Shawshank then it''s a love that lasts a lifetime. Every viewing brings the same array of emotions - anger - revilement - happiness - sadness - inspiration and a warmth that can reduce the most hardened into misty eyed wonderment. Above all else, though, Shawshank offers hope - not just for characters in a movie - but for a better life and a better world for all of us. 10/10', 1, 2),
    (2, true, 'The Shawshank Redemption and To Kill a Mockingbird are the best movies I have ever seen. I do not judge it by it''s technical merits - I don''t really care about that. I have read that Citizen Kane or The Godfather or this or that movie is the best movie ever made. They may have the best technique or be the most influential motion pictures ever made, but not the best. The best movies are ones that touch the soul. It takes a movie like The Shawshank Redemption to touch the soul.', 1, 3),
    (3, true, 'The writing was phenomenal and breathtaking. As mentioned before there has been no movie quoted more than this. It is not even the quotes though that makes the writing in here so perfect. It is the symbolism and meaning that went into every scene. There are countless symbols, messages and lines in here that are so memorable yet it is as realistic as a movie could get.', 2, 2),
    (4, true, 'One of the all time greats. Or probably the alone greatest thing ever made in the history of cinematography. This movie is both "prequel" and "sequel" of the first godfather movie. I have never watched anything like this in my entire life. This movie has explained the life of underworld people in a great way. It also shows how vengeance eradicates happiness from your life. People don''t even care about their family in greed of power. It''s a masterpiece that can never be written off even after centuries. Even if you are not into these kind of movies, I will suggest to watch it for atleast once in your life or you''ll be deprived of one of the greatest things to watch that have been ever made.', 3, 2);