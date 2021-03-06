package com.kancho.daily_question;

import com.kancho.entity_converter.LocalDatePersistenceConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "daily_questions")
@Entity
public class DailyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate date;

    private String content;

    @Builder
    private DailyQuestion(LocalDate date, String content) {
        this.date = date;
        this.content = content;
    }
}
