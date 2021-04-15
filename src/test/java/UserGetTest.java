import entities.Message;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserGetTest {

    @Test
    public void verifyAllUsers() {
        new ApiEndpoints().
                getAllUsers().
                then().statusCode(200).
                assertThat().
                body(Matchers.notNullValue());
    }

    @Test
    public void verifyPageOfUsers() {
        new ApiEndpoints().
                getPageUsers(2).
                then().statusCode(200).
                assertThat().
                body(Matchers.notNullValue());
    }
    @Test
    public void verifyNotExistingUser(){
        new ApiEndpoints().
                getPageAndCountUser(-3).
                then().statusCode(404).
                assertThat().
                body(Matchers.notNullValue());
    }
    @Test
    public void verifyNotExist(){
        new ApiEndpoints().
                getUserById(123).
                then().log().body().statusCode(500);
    }

    @Test
    public void verifyMe(){
        new ApiEndpoints().getUserById(15945).then().log().body().statusCode(200).assertThat().body(Matchers.notNullValue());
    }


}
