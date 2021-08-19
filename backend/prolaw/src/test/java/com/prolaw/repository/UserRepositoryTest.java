package com.prolaw.repository;

import com.prolaw.domain.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

//import java.util.List;

//Test Passed
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    private final User gustavoMojica = new User("1192894877","Gustavo","Mojica","3228056671","gmojica@unal.edu.co","1234");
    private final User camiloCardona = new User("10100127202","Camilo","Cardona","3208612601","ancardonac@unal.edu.co","1234");
    
		

    @BeforeEach
    public void fillSomeDataIntroOurDb() {
        //Add new users to DB
        entityManager.persist(gustavoMojica);
        entityManager.persist(camiloCardona); 
    }

    @Test
    public void testFindByLastName() throws Exception {
        //Search specific User in DB according to lastname
        User userWithLasstNameMojica = users.findByLastNameUser("Mojica");
        //assertThat(userWithLasstNameMojica,contains(gustavoMojica.toString()));
        assertTrue(userWithLasstNameMojica.equals(gustavoMojica));
    }

    @Test
    public void testFindByEmailUser() throws Exception {
        //Search specific User in DB according to email
        User userWithEmailUser = users.findByEmailUser("ancardonac@unal.edu.co");
        //assertThat(userWithEmailUser.contains(camiloCardona));
        assertTrue(userWithEmailUser.equals(camiloCardona));
    }

}
