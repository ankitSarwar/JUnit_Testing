package com.demo.repo;

import com.demo.entites.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepoTest {  // go to repo->PersonRepo then click ctr+shift+t then it is created automatically

    @Autowired
    private PersonRepo personRepo;

    @Test
    void isPersonExitsById() {
        Person person = new Person(1234, "Durgesh", "Delhi");
        personRepo.save(person);
        Boolean actualResult = personRepo.isPersonExitsById(1234);
        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {  // after isPersonExitsById tearDown is run
        System.out.println("tearing down");
        personRepo.deleteAll();
    }

    @BeforeEach
    void setUp() { // before isPersonExitsById setUp is run
        System.out.println("setting up");
    }
}