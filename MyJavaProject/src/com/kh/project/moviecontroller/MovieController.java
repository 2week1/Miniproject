package com.kh.project.moviecontroller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kh.project.movie.Movie;
import com.kh.project.moviedao.MovieDAO;

public class MovieController {
    private MovieDAO dao = new MovieDAO();

    public void addMovie(Movie movie) {
        dao.addMovie(movie);
    }

    public void updateMovie(Movie movie) {
        dao.updateMovie(movie);
    }

    public void deleteMovie(int id) {
        dao.deleteMovie(id);
    }

    public Movie getMovieById(int id) {
        return dao.findMovieById(id);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return dao.findMoviesByTitle(title);
    }

    public List<Movie> searchMoviesByGenre(String genre) {
        return dao.findMoviesByGenre(genre);
    }

    public List<Movie> searchMoviesByActor(String actor) {
        return dao.findMoviesByActor(actor);
    }

    public List<Movie> getRecommendations(String genre, String actor) {
        Set<Movie> recommendations = new HashSet<>();
        recommendations.addAll(dao.findMoviesByGenre(genre));
        recommendations.addAll(dao.findMoviesByActor(actor));
        return new ArrayList<>(recommendations);
    }
}
