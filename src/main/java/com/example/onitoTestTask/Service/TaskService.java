package com.example.onitoTestTask.Service;

import com.example.onitoTestTask.Dto.RequestDto.RequestNewMovieDto;
import com.example.onitoTestTask.Dto.ResponseDto.GenreMoviesWithSubTotalResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetAllMoviesWithLongestDurationResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetTopRatedMoviesResponseDto;

import java.util.List;

public interface TaskService {
    public String addNewMovie(RequestNewMovieDto requestNewMovieDto);

    public List<GetAllMoviesWithLongestDurationResponseDto> getAllMoviesWithLongestDuration();

    public List<GetTopRatedMoviesResponseDto> getTopRatedMovies();

    public String updateRuntimeMinutesOfAllMovies();

    public List<GenreMoviesWithSubTotalResponseDto> getGenreMoviesWithSubtotals();
}
