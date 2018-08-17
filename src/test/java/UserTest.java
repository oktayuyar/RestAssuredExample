import com.oktay.restAssured.service.UserService;
import org.junit.Test;

/*
 *  Created by oktayuyar on 17.08.2018
 */
public class UserTest {

    public UserService userService= new UserService();

    @Test
    public void unBlockUser(){
        userService.unBlockUser("testp1");
    }
}
