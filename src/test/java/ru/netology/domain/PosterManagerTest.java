package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();

    private Film filmOne = new Film(1, "Movie1", "genre");
    private Film filmTwo = new Film(2, "Movie2", "genre");
    private Film filmThree = new Film(3, "Movie3", "genre");
    private Film filmFour = new Film(4, "Movie4", "genre");
    private Film filmFive = new Film(5, "Movie5", "genre");
    private Film filmSix = new Film(6, "Movie6", "genre");
    private Film filmSeven = new Film(7, "Movie7", "genre");
    private Film filmEight = new Film(8, "Movie8", "genre");
    private Film filmNine = new Film(9, "Movie9", "genre");
    private Film filmTen = new Film(10, "Movie10", "genre");

    Film[] expected = {new Film(10, "Movie10", "genre"),
            new Film(9, "Movie9", "genre"),
            new Film(8, "Movie8", "genre"),
            new Film(7, "Movie7", "genre"),
            new Film(6, "Movie6", "genre"),
            new Film(5, "Movie5", "genre"),
            new Film(4, "Movie4", "genre"),
            new Film(3, "Movie3", "genre"),
            new Film(2, "Movie2", "genre"),
            new Film(1, "Movie1", "genre")
    };

    @BeforeEach
    public void setUp() {
        manager.addFilm(filmOne);
        manager.addFilm(filmTwo);
        manager.addFilm(filmThree);
        manager.addFilm(filmFour);
        manager.addFilm(filmFive);
        manager.addFilm(filmSix);
        manager.addFilm(filmSeven);
        manager.addFilm(filmEight);
        manager.addFilm(filmNine);
        manager.addFilm(filmTen);
    }

    @Test
    void shouldShowTenFilms() {
        PosterManager manager = new PosterManager(10);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPositive() {
        PosterManager manager = new PosterManager(6);
        manager.films = this.manager.films;
        Film filmToAdd = new Film(15, "Movie15", "genre");
        manager.addFilm(filmToAdd);

        Film[] actual = manager.getLastAdded();
        Film[] expected = {new Film(15, "Movie15", "genre"),
                new Film(10, "Movie10", "genre"),
                new Film(9, "Movie9", "genre"),
                new Film(8, "Movie8", "genre"),
                new Film(7, "Movie7", "genre"),
                new Film(6, "Movie6", "genre")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        PosterManager manager = new PosterManager(0);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        PosterManager manager = new PosterManager(15);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNegative() {
        PosterManager manager = new PosterManager(-1);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }
}

