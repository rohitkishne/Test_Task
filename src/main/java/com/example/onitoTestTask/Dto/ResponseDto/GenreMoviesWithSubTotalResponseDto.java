package com.example.onitoTestTask.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class GenreMoviesWithSubTotalResponseDto {

    String genres;
    String primaryTitle;
    int numVotes;

}
