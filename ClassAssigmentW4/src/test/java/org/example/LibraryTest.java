package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    //Arrange
    Library lib;
    String myBookOne = "AliceInWonderland";
    String myBookTwo = "Bob";

    @BeforeEach
    void setUpAndAdd() {
        lib = new Library();
        lib.addBook(myBookOne);
        lib.addBook(myBookTwo);
    }

    @Test
    void addAndGetBook() {
        //Arrange
        Integer expected_result_two = 2;

        //Act
        lib.addBook("");

        // Assert
        assertEquals(expected_result_two, lib.getBooks().size());
        assertEquals(myBookOne, lib.getBooks().getFirst());
    }

    @Test
    void removeAndGetBook() {
        //Arrange
        Integer expected_result_one = 1;

        //Act
        lib.removeBook(myBookOne);

        //Assert
        assertEquals(expected_result_one, lib.getBooks().size());
        assertEquals(myBookTwo, lib.getBooks().getFirst());
    }


}