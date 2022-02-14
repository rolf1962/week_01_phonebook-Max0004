package phonebook;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author urs
 */
public class PhoneBookTest {

    //TODO write tests
    PhoneBook phonebook = new PhoneBook();

    @Test
    public void phonebookSearchByNameNotFound() {
        assertThat(phonebook.searchByName("Jukka"))
                .as("Person not present should return null")
                .isNull();
    }

    @Test
    public void phonebookAddsEntry() {
        phonebook.addEntry("Pekka", "040-123456");
        String searchResult = phonebook.searchByName("Pekka");
        assertThat(searchResult)
                .as("An added person, phone number should be found")
                .contains("040-123456");
    }

    @Test
    public void phonebookSearchAddress() {
        phonebook.addEntry("Pekka", "040-123456");
        phonebook.addAddress("Pekka", "Hulsterweg 6, Venlo");
        assertThat(phonebook.searchByName("Pekka"))
                .as("after add, parts of the address required")
                .contains("Hulsterweg 6", "Venlo");
    }
    
    @Test
    public void phonebookSearchByNumber(){
        String searchResult = null;
        phonebook.addEntry("Pekka", "040-123456");
        
        searchResult = phonebook.searchByNumber("02-444123");
        assertThat(searchResult)
                .as("An added person, should not be found by incorrect phone number")
                .isNull();

        searchResult = phonebook.searchByNumber("040-123456");
        assertThat(searchResult)
                .as("An added person, should be found by correct phone number")
                .contains("Pekka");
        
    }
}
