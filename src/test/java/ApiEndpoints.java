import entities.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiEndpoints {

    public Response getAllUsers() {
        return given().when().
                get(ConfigPath.USERS_ENDPOINT).
                then().extract().response();
    }

    public Response getPageUsers(long pageNumber) {
        return given().
                pathParam("pageNumber", pageNumber).when().
                get(ConfigPath.PAGE_USERS_ENDPOINT).
                then().
                extract().response();
    }

    public Response getPageAndCountUser(long countNumber) {
        return given().
                when().
                get(ConfigPath.COUNT_USERS_ENDPOINT).
                then().
                extract().response();
    }

    public Response deleteProfile() {
        return given().
                when().
                delete(ConfigPath.LOGIN_ENDPOINT).
                then().
                extract().response();
    }

    public Response putProfile() {
        return given().
                when().
                put(ConfigPath.PROFILE).
                then().
                extract().response();
    }


    public Response getUserById(long id) {
        return given().
                pathParam("userId", id).when().
                get(ConfigPath.USER_BY_ID).
                then().
                extract().response();
    }

    public Response me() {
        return given().
                when().
                get(ConfigPath.LOGIN_ME).then().extract().response();
    }


    public Response loginUser(Login login) {

        return given().
                body(login).
                post(ConfigPath.LOGIN_ENDPOINT).
                then().extract().response();
    }


    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(ConfigPath.BASE_URL)
                .header("API-KEY", ConfigPath.apiToken)
                .contentType(ContentType.JSON);
    }


}
