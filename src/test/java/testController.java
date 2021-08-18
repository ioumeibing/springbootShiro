import com.how2java.springboot.Application;
import com.how2java.springboot.pojo.Person;
import com.how2java.springboot.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class testController {
    @Autowired
    PersonService personService;
    @Autowired
    CacheManager cacheManager;
    @Test
    public void test(){
        System.out.println("缓存"+cacheManager.getClass());
        List<Person> personList = personService.GetAll();
        System.out.println("第一次获取");
        List<Person> personList1 = personService.GetAll();
        System.out.println("第二次获取");
    }

}