import entities.Error;
import entities.Message;
import entities.Profile;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersTest {
    @Test
    public void getUserByBadId(){
        long id = 1;
        new ApiEndpoints().getUserById(id).then().statusCode(500);
    }

    @Test
    public void getUserByGoodId(){
        long id = 5000;
        new ApiEndpoints().getUserById(id).then().statusCode(200);
    }


    @Test
    public void getUserThatNotExist(){
        long id = 101;
        Message message = new ApiEndpoints().getUserById(id).as(Message.class);
        assertEquals("An error has occurred.",message.getMessage());
    }
}
