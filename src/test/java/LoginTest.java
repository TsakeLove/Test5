import entities.Login;
import entities.Profile;
import org.hamcrest.Matchers;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void verifyLoginExistedUserAndReturn200() {
        Login login = new Login();
        login.setEmail("tsake.love@gmail.com");
        login.setPassword("Aa123456");
        new ApiEndpoints().loginUser(login).then().statusCode(200);
    }

    @Test
    public void getMtProfileWithCode200() {
        new ApiEndpoints().me().then().statusCode(200);
    }

    @Test
    public void verifyLoginNonExistedUserAndReceiveError() {


        Login login = new Login();
        login.setEmail("NotExisted@gmail.com");
        login.setPassword("123456");
        new ApiEndpoints().loginUser(login).then().assertThat().body(Matchers.notNullValue());

    }

    @Test
    public void verifyNonAuthorizationUserAndReceiveError() {

        Profile message = new ApiEndpoints().putProfile().as(Profile.class);
        assertEquals("Authorization has been denied for this request.", message.message);

    }

    @Test
    public void LogOut() {

        new ApiEndpoints().deleteProfile().then().statusCode(200);

    }

}
