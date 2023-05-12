package com.example.onitoTestTask.Service.impl;

import com.example.onitoTestTask.Dto.RequestDto.RequestNewMovieDto;
import com.example.onitoTestTask.Dto.ResponseDto.GenreMoviesWithSubTotalResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetAllMoviesWithLongestDurationResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetTopRatedMoviesResponseDto;
import com.example.onitoTestTask.Entity.Movies;
import com.example.onitoTestTask.Entity.Ratings;
import com.example.onitoTestTask.Repository.MoviesRepository;
import com.example.onitoTestTask.Service.TaskService;
import com.example.onitoTestTask.Transformer.MoviesTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    MoviesRepository moviesRepository;
    @Override
    public String addNewMovie(RequestNewMovieDto requestNewMovieDto) {

        //first convert requestNewMovieDto to movie through movies transformer
        Movies movies = MoviesTransformer.RequestMoviesDtoToMovies(requestNewMovieDto);

        //set the ratings of corresponding movies
        Ratings ratings = new Ratings();
        ratings.setAverageRating(0.0);
        ratings.setNumVotes(0);
        ratings.setMovies(movies);

        movies.setRatings(ratings);
        //saving the movie to database
        moviesRepository.save(movies);
        return "success";
    }

    @Override
    public List<GetAllMoviesWithLongestDurationResponseDto> getAllMoviesWithLongestDuration() {

        //get the top ten movies with longest time
        List<Movies> moviesList = moviesRepository.findAllMoviesWithLongestDurationTime();

        //store all top ten movies and return
        List<GetAllMoviesWithLongestDurationResponseDto> getTopTenMovies = new ArrayList<>();

        //prepare response of each movies and add to the list
        for(Movies movies : moviesList)
        {
            GetAllMoviesWithLongestDurationResponseDto getAllMoviesWithLongestDurationResponseDto = MoviesTransformer.MoviesToGetTopTenMovies(movies);
            getTopTenMovies.add(getAllMoviesWithLongestDurationResponseDto);
        }
        return getTopTenMovies;
    }

    @Override
    public List<GetTopRatedMoviesResponseDto> getTopRatedMovies() {

        //get the top rating movies greater than 6.0
        List<Movies> moviesList = moviesRepository.findTopRatedMovies();

        //store all top rated movies and return
        List<GetTopRatedMoviesResponseDto> getTopRatingMovies = new ArrayList<>();

        //prepare response of each movies and add to the list
        for(Movies movies : moviesList)
        {
            GetTopRatedMoviesResponseDto getTopRatedMoviesResponseDto = MoviesTransformer.MoviesToTopRatedMoviesResponseDto(movies);
            getTopRatingMovies.add(getTopRatedMoviesResponseDto);
        }

        return getTopRatingMovies;
    }

    @Override
    public String updateRuntimeMinutesOfAllMovies() {

        moviesRepository.updateRuntimeMinutesOfAllMovies();
        return "success";
    }

    @Override
    public List<GenreMoviesWithSubTotalResponseDto> getGenreMoviesWithSubtotals() {

        List<Object[]> genreMoviesWithSubtotal = moviesRepository.findGenreMoviesWithSubTotal();

        List<GenreMoviesWithSubTotalResponseDto> allMoviesSubtotal = new ArrayList<>();
        for(Object[] genreMovies : genreMoviesWithSubtotal)
        {
            String genres = (String) genreMovies[0];
            String primaryTitle = (String) genreMovies[1];
            int numVotes = ((BigDecimal)genreMovies[2]).intValue();

            if(primaryTitle==null)
            {
                GenreMoviesWithSubTotalResponseDto genreMoviesWithSubTotalResponseDto = MoviesTransformer.ObjectToGenreMovieTotal(numVotes);
                allMoviesSubtotal.add(genreMoviesWithSubTotalResponseDto);
            }
            else {
                GenreMoviesWithSubTotalResponseDto genreMoviesWithSubTotalResponseDto = MoviesTransformer.ObjectToGenreMoviesWithSubtotalResponseDto(genres, primaryTitle, numVotes);
                allMoviesSubtotal.add(genreMoviesWithSubTotalResponseDto);
            }

        }
        return allMoviesSubtotal;
    }
}
