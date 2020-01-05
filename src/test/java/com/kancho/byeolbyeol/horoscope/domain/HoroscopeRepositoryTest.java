package com.kancho.byeolbyeol.horoscope.domain;

import com.kancho.byeolbyeol.horoscope.domain.constant.Exercise;
import com.kancho.byeolbyeol.horoscope.domain.constant.Numeral;
import com.kancho.byeolbyeol.horoscope.domain.constant.Stylist;
import com.kancho.byeolbyeol.horoscope.domain.constant.Word;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class HoroscopeRepositoryTest {

    @Autowired
    HoroscopeRepository horoscopeRepository;

    @After
    public void cleanup() {
        horoscopeRepository.deleteAll();
    }

    @Test
    public void 운세_저장하고_불러오기() {
        //given
        String contentTestData = "활기찬 한 주가 되겠네요. 한 주를 시작하는 월요일부터 기운이 넘치는 주간입니다.\n" +
                "유난히 친구를 많이 만나게 됩니다.\n\n" +
                "즐거운 시간이 많겠지만 건강관리는 좀 하셔야 합니다. 특정한 목적을 가진 만남은 좋지 않습니다. 취미나 동호회활동은 약간 기대에 모자란 정도입니다.";

        horoscopeRepository.save(Horoscope.builder()
                .constellationsId(1L)
                .date("2019년 12월 3일")
                .content(contentTestData)
                .stylist(Stylist.SCARF)
                .numeral(Numeral.FIVE)
                .word(Word.COFFEE)
                .exercise(Exercise.BICYCLE)
                .build());

        //when
        List<Horoscope> horoscopeList = horoscopeRepository.findAll();

        //then
        Horoscope horoscope = horoscopeList.get(0);
        assertThat(horoscope.getConstellationsId(), is(1L));
        assertThat(horoscope.getDate(), is("2019년 12월 3일"));
        assertThat(horoscope.getContent(), is(contentTestData));
        assertThat(horoscope.getStylist(), is(Stylist.SCARF));
        assertThat(horoscope.getNumeral(), is(Numeral.FIVE));
        assertThat(horoscope.getWord(), is(Word.COFFEE));
        assertThat(horoscope.getExercise(), is(Exercise.BICYCLE));
    }
}