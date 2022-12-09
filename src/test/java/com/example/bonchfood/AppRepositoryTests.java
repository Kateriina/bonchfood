package com.example.bonchfood;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AppRepositoryTests {


    @Autowired
    private AppRepository repo;

    @Test
    public void testCreateDish(){
        Dishes savedDishes = repo.save(new Dishes("Морковь", 3));

        assertThat(savedDishes.getId()).isGreaterThan(0);

    }
}