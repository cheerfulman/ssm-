import com.zhu.dao.BookMapper;
import com.zhu.pojo.Books;
import com.zhu.service.BookServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void  Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("BookServiceImpl");
        Books books = bookServiceImpl.queryBookByName("SQL");
        System.out.println(books);

    }
}
