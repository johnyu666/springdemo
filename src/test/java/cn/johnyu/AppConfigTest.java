package cn.johnyu;

import cn.johnyu.dao.BookDao;
import cn.johnyu.pojo.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=AppConfig.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ActiveProfiles("production")
public class AppConfigTest {
    @Autowired
    private BookDao bookDao;
    @Test
    public void testAddBook(){
        Book book=new Book();
        book.setBname("Harry");
        int m=bookDao.addBook(book);
        Assert.assertTrue(m==1);
    }
    @Test
    public void testFindAllBooks(){
        List<Book> list=bookDao.findAllBooks();
        list.forEach(book-> System.out.println(book.getBname()));
    }

}
