package homework;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTest {
    private Homework homework = new Homework();

    @Test
    public void exercise_onSimpleText_shouldReturnExpectedOutput(){
        //given
        String inputText = "ala ma kota, kot koduje w Javie Kota ";
        //when
        String result = homework.exercise(inputText);
        //then
        assertEquals("a: ala, javie, kota, ma\n" +
                "d: koduje\n" +
                "e: javie, koduje\n" +
                "i: javie\n" +
                "j: javie, koduje\n" +
                "k: koduje, kot, kota\n" +
                "l: ala\n" +
                "m: ma\n" +
                "o: koduje, kot, kota\n" +
                "t: kot, kota\n" +
                "u: koduje\n" +
                "v: javie\n" +
                "w: w\n", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exercise_onNull_throwsIllegalArgumentException(){
        //given
        String inputText = null;
        //when
        homework.exercise(inputText);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exercise_onEmptyString_throwsIllegalArgumentException(){
        //given
        String inputText = " ";
        //when
        homework.exercise(inputText);
    }

    @Test(expected = MyExceptionForOnlySpecialCharacters.class )
    public void exercise_onSpecialCharacters_throwsMyExceptionForOnlySpecialCharacters(){
        //given
        String inputText = ":,";
        //when
        homework.exercise(inputText);
    }

}