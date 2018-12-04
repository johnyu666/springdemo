package cn.johnyu.dao;

import cn.johnyu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate template;
    @Value("insert into BOOKS (bname) values(?)")
    private String addBookSql;
    @Value("select * from BOOKS")
    private String querySql;
    @Override
    public int addBook(Book book) {
       return template.update(addBookSql,new Object[]{"John"});
    }

    @Override
    public List<Book> findAllBooks() {

        return template.query(querySql,(rs,index)->{
            Book book=new Book();
            book.setId(rs.getInt("id"));
            book.setBname(rs.getString("bname"));
            return book;
        });
    }
}
