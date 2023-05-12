package com.example.onitoTestTask.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class GetAllMoviesWithLongestDurationResponseDto {

    String tconst;
    String primaryTitle;
    int runtimeMinutes;
    String genres;
}
