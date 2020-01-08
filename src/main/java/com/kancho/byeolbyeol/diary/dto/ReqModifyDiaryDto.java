package com.kancho.byeolbyeol.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqModifyDiaryDto {

    @NotNull
    private Long diaryId;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
