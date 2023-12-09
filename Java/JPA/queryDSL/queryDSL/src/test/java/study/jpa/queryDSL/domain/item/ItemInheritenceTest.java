package study.jpa.queryDSL.domain.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ItemInheritenceTest {

    @Autowired
    EntityManager em;


    @Test
    @Transactional
    public void CheckInheritance(){
        Book book = new Book();
        book.setName("개미");
        book.setAuthor("베르나르베르베르");
        book.setPrice(10000);
        book.setIsbn(1234);
        em.persist(book);

        em.flush();
        em.clear();

        Book result = em.find(Book.class, book.getId());



    }

}