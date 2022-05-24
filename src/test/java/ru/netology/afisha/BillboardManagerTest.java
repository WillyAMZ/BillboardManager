package ru.netology.afisha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillboardManagerTest {

    @Test
    void shouldAddMovie() {
        BillboardManager manager = new BillboardManager();

        String[] moviesListTestData = new String[]{"Film1", "Film2", "Film3", "Film4"};
        manager.setMoviesList(moviesListTestData);
        String[] expected = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5"};

        String addMovie = "Film5";
        manager.add(addMovie);
        String[] actual = manager.getMoviesList();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayedLatestMovies() {
        BillboardManager manager = new BillboardManager();

        String[] moviesListTestData = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5"};
        manager.setMoviesList(moviesListTestData);
        String[] expected = new String[]{"Film5", "Film4", "Film3", "Film2", "Film1"};

        manager.findLast();
        String[] actual = manager.getMoviesList();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayedLatestMoviesWithLimit() {
        BillboardManager manager = new BillboardManager(3);

        String[] moviesListTestData = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5"};
        manager.setMoviesList(moviesListTestData);
        String[] expected = new String[]{"Film5", "Film4", "Film3"};

        manager.findLast();
        String[] actual = manager.getMoviesList();

        assertArrayEquals(expected, actual);
    }
}