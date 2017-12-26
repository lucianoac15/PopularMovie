package br.com.luciano.popularmovies;

interface OnTaskCompleted {
    void onFetchMoviesTaskCompleted(MovieObject[] movies);
}