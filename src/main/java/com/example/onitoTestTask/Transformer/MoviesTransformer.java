package com.example.onitoTestTask.Transformer;

import com.example.onitoTestTask.Dto.RequestDto.RequestNewMovieDto;
import com.example.onitoTestTask.Dto.ResponseDto.GenreMoviesWithSubTotalResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetAllMoviesWithLongestDurationResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetTopRatedMoviesResponseDto;
import com.example.onitoTestTask.Entity.Movies;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MoviesTransformer {

    public static Movies RequestMoviesDtoToMovies(RequestNewMovieDto requestNewMovieDto)
    {
        return Movies.builder()
                .tconst(requestNewMovieDto.getTconst())
                .titleType(requestNewMovieDto.getTitleType())
                .primaryTitle(requestNewMovieDto.getPrimaryTitle())
                .runtimeMinutes(requestNewMovieDto.getRuntimeMinutes())
                .genres(requestNewMovieDto.getGenres())
                .build();
    }

    public static GetAllMoviesWithLongestDurationResponseDto MoviesToGetTopTenMovies(Movies movies)
    {
        return GetAllMoviesWithLongestDurationResponseDto.builder()
                .tconst(movies.getTconst())
                .primaryTitle(movies.getPrimaryTitle())
                .runtimeMinutes(movies.getRuntimeMinutes())
                .genres(movies.getGenres())
                .build();
    }

    public static GetTopRatedMoviesResponseDto MoviesToTopRatedMoviesResponseDto(Movies movies)
    {
        return GetTopRatedMoviesResponseDto.builder()
                .tconst(movies.getTconst())
                .primaryTitle(movies.getPrimaryTitle())
                .averageRating(movies.getRatings().getAverageRating())
                .genres(movies.getGenres())
                .build();
    }

    public static GenreMoviesWithSubTotalResponseDto ObjectToGenreMoviesWithSubtotalResponseDto(String genres, String primaryTitle, int numVotes)
    {
        return GenreMoviesWithSubTotalResponseDto.builder()
                .genres(genres)
                .primaryTitle(primaryTitle)
                .numVotes(numVotes)
                .build();
    }

    public static GenreMoviesWithSubTotalResponseDto ObjectToGenreMovieTotal(int numVotes)
    {
        return GenreMoviesWithSubTotalResponseDto.builder()
                .genres("")
                .primaryTitle("Total")
                .numVotes(numVotes)
                .build();
    }
}
