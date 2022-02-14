package phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author urs
 */
public class BookEntry {

    //TODO
    private String name;
    private String address;
    private List<String> numbers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public void addNumber(String number) {
        if (numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }

    public String toString() {
        String name = "Name: " + getName();
        String address = "Address: " + getAddress();
        String numbers = "Numbers: " + String.join(", ", getNumbers());
        return String.join("; ", name, address, numbers);
    }
}
