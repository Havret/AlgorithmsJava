import org.junit.jupiter.api.*;

import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

class BoggleTest {
    @Test
    void should_throw_exception_if_wrong_number_of_letters_provided() {
        String[] dictionary = {"word"};
        var letters = new char[0];

        assertThrows(IllegalArgumentException.class, () -> new Boggle(dictionary, letters));
    }

    @Test
    void should_throw_exception_if_dictionary_is_empty() {
        String[] dictionary = {};
        char[] letters;
        letters = new char[]{
                'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p'
        };

        assertThrows(IllegalArgumentException.class, () -> new Boggle(dictionary, letters));
    }

    @Test
    void should_instantiate_Boggle() {
        String[] dictionary = {"word"};
        char[] letters = {
                'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p'
        };
        new Boggle(dictionary, letters);
    }

    @Test
    void should_find_all_words_in_the_dictionary_that_can_be_made_by_following_path_of_adjacent_tiles() {
        String[] dictionary = {
                "darth",
                "vader",
                "word"
        };
        char[] letters = {
                'd', 'v', 'c', 'd',
                'a', 'f', 'a', 'd',
                'r', 'j', 'k', 'e',
                't', 'h', 'o', 'r'
        };
        var boggle = new Boggle(dictionary, letters);

        assertTrue(StreamSupport.stream(boggle.getWords().spliterator(), false).anyMatch(x -> x.equals("darth")));
        assertTrue(StreamSupport.stream(boggle.getWords().spliterator(), false).anyMatch(x -> x.equals("vader")));
    }

    @Test
    void should_find_no_words_if_provided_tiles_do_not_make_any_words_from_dictionary() {
        String[] dictionary = {
                "darth",
                "vader",
                "word"
        };
        char[] letters = {
                'e', 'v', 'c', 'd',
                'a', 'f', 'a', 'l',
                'r', 'j', 'k', 'e',
                'v', 'h', 'o', 'r'
        };
        var boggle = new Boggle(dictionary, letters);

        assertEquals(0, StreamSupport.stream(boggle.getWords().spliterator(), false).count());
    }
}