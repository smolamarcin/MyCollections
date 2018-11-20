package com.smola;

import com.smola.array.MarcinArrayListImpl;
import com.smola.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListImplTest {
    private MarcinArrayListImpl<Person> myList = new MarcinArrayListImpl<>();

    @Test
    public void shouldReturnTrue_whenAddedElementToList() {
        Person person = new Person("Marcin");
        boolean added = myList.add(person);
        assertTrue(added);
        assertEquals(1, myList.size());
    }

    @Test
    void shouldReturnMethodOnSpecificIndex() {
        myList.add(new Person("Marcin"));
        myList.add(new Person("Artem"));
        myList.add(new Person("Blabla"));

        Person person = myList.get(1);
        assertEquals("Artem",person.getName());

        Person person1 = myList.get(2);
        assertEquals("Blabla",person1.getName());
    }

    @Test
    void sizeShouldEqualToZero_whenListWasCleaned() {
        Person person = new Person("Marcin");
        myList.add(person);
        myList.clear();
        assertEquals(0, myList.size());
    }

    @Test
    void referencesShouldBeNulled_whenListWasCleaned() {
        Person person = new Person("Marcin");
        myList.add(person);
        myList.clear();
        myList.forEach(Assertions::assertNull);
    }


    @Test
    void shouldIncreaseArraySize_whenAddedMultipleElements() {
        addMultipleElementsToList(myList, 1000);
        assertEquals(1000,myList.size());
    }

    @Test
    void shouldReturnTrue_whenListContainsObject() {
        Person person = new Person("Marcin");
        myList.add(person);
        assertTrue(myList.contains(person));
    }

    @Test
    void shouldReturnFalse_whenListDoesNotContainsObject() {
        Person person = new Person("Marcin");
        myList.add(person);
        assertFalse(myList.contains(new Person("asdasdasd")));
    }

    @Test
    void shouldRemoveElementFromList() {
        Person person = new Person("Marcin");
        Person person2 = new Person("Artem");
        myList.add(person);
        myList.add(person2);
        boolean actual = myList.remove(person);
        assertTrue(actual);
        assertEquals(1,myList.size());
        assertFalse(myList.contains(person));
    }

//    @Test
//    void shouldRemoveMultipleElementsFromList() {
//        addMultipleElementsToList(myList,70);
//        for (int i = 0; i < 30; i++) {
//            myList.remove(new Person(String.valueOf(i)));
//        }
    //TODO: NPE :(
//    }


    @Test
    void shouldRemoveElementOnSpecificIndex() {
        myList.add(new Person("Marcin"));
        myList.add(new Person("Artem"));
        myList.add(new Person("Blabla"));

        Person removedElement = myList.remove(1);

        assertEquals("Artem", removedElement.getName());
        assertEquals(2,myList.size());
    }

    @Test
    void shouldReturnIndexOfElement() {
        myList.add(new Person("Marcin"));
        myList.add(new Person("Artem"));
        myList.add(new Person("Blabla"));

        int index = myList.indexOf(new Person("Blabla"));
        assertEquals(2, index);
        assertEquals("Blabla",myList.get(2).getName());
    }

    @Test
    void shouldThrowException_whenNotFoundElementIndex() {
        myList.add(new Person("Marcin"));

        RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
            myList.indexOf(new Person("Xasdasdsd"));
        });

        assertEquals("Index does not exist.",expectedException.getMessage());
    }

    private void addMultipleElementsToList(MarcinList list, int nbOfElements) {
        for (int i = 0; i < nbOfElements; i++) {
            list.add(new Person(String.valueOf(i)));
        }
    }
}