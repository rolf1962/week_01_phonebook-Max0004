package phonebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * PhoneBook class to manage contacts.
 *
 * @author urs
 */
public class PhoneBook {

    //TODO add field(s)
    Map<String, BookEntry> phoneBook = new HashMap<>();

    /**
     * Initializes your phone book.
     */
    public PhoneBook() {
        //TODO 

    }

    /**
     * Adds entry to your phone book. If an entry with this name already exists,
     * just an additional phone number is added.
     *
     * @param name of a relative person
     * @param number belonging to the name.
     */
    public void addEntry(String name, String number) {
        //TODO
        //
        //Example for searching with stream
        /*BookEntry bookEntry = phoneBook.entrySet().stream()
                .filter(be->name.equals(be.getValue().getName()))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();*/
        //

        BookEntry bookEntry = phoneBook.get(name);

        if (null == bookEntry) {
            bookEntry = new BookEntry();
            phoneBook.put(name, bookEntry);
            bookEntry.setName(name);
        }

        if (!bookEntry.getNumbers().contains(number)) {
            bookEntry.addNumber(number);
        }
    }

    /**
     * Search your phone book by name and return all information about the
     * person with this name as text.
     *
     * @param name to lookup
     * @return all info about this person, or null if not found
     */
    public String searchByName(String name) {
        //TODO 
        BookEntry bookEntry = phoneBook.get(name);
        if (null == bookEntry) {
            return null;
        }

        return bookEntry.toString();
    }

    /**
     * Search all information belonging to a person with the given phone number.
     *
     * @param number to search
     * @return all info about the belonging person, or null if not found.
     */
    public String searchByNumber(String number) {
        //TODO 
        Optional<BookEntry> bookEntry = phoneBook.entrySet().stream()
                .filter(be -> be.getValue().getNumbers().contains(number))
                .map(Map.Entry::getValue)
                .findFirst();

        if (bookEntry.isPresent()) {
            return bookEntry.get().toString();
        } else {
            return null;
        }
    }

    /**
     * Add address to name. Adds a new address if there is no address yet,
     * otherwise the address is updated.
     *
     * @param name to add address to
     * @param address address to add
     */
    public void addAddress(String name, String address) {
        //TODO 
        BookEntry bookEntry = phoneBook.get(name);

        if (null == bookEntry) {
            bookEntry = new BookEntry();
            phoneBook.put(name, bookEntry);
            bookEntry.setName(name);
        }

        bookEntry.setAddress(address);
    }

    /**
     * Delete entry from phone book.
     *
     * @param name whose entry should be deleted.
     */
    public void deleteEntry(String name) {
        //TODO 

    }
}
