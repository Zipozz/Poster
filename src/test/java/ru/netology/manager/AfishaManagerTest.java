package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTestNoEmpty {
    private AfishaManager manager = new AfishaManager();
    Movie first = new Movie(1, "img1.jpg", "Name 1", "Comedy" );
    Movie second = new Movie(2, "img1.jpg", "Name 2", "Drama" );
    Movie third = new Movie(3, "img1.jpg", "Name 3", "Documentary" );
    Movie fourth = new Movie(4, "img1.jpg", "Name 4", "Fantastic" );
    Movie fifth = new Movie(5, "img1.jpg", "Name 5", "Detective" );
    Movie sixth = new Movie(6, "img1.jpg", "Name 6", "Cartoon" );
    Movie seventh = new Movie(7, "img1.jpg", "Name 7", "Anime" );
    Movie eighth = new Movie(8, "img1.jpg", "Name 8", "Romantic" );
    Movie ninth = new Movie(9, "img1.jpg", "Name 9", "Horror" );
    Movie tenth = new Movie(10, "img1.jpg", "Name 10", "Historical" );
    Movie eleventh = new Movie(11, "img1.jpg", "Name 11", "Comedy" );


    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    void ShouldShowWhenZero() {
        manager = new AfishaManager(0);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldShowAllTen() {
        manager.add(tenth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldShowLessThanTen() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldShowMoreThanTen() {
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldAddOneMovie() {
        manager = new AfishaManager(1);
        manager.add(first);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldAddTenMovies() {
        manager = new AfishaManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldAddMoreThanTenMovies() {
        manager = new AfishaManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}