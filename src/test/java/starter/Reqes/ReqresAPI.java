package starter.Reqes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String URL ="https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String GET_LIST_USER=URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER=URL+"/api/users/{data.id}";
    public static String GET_LIST_RESOURCE=URL+"/api/unknown/{id}";
    public static String POST_CREATE_NEW_USER=URL+"/api/users";
    public static String POST_REGISTER=URL+"/api/register";
    public static String POST_LOGIN=URL+"/api/login";
    public static String PUT_UPDATE_USER=URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER=URL+"/api/users/{id}";
    public static String DELETE_USER=URL+"/api/users/{id}";
    public static String DELAY_RESPONSE=URL+"/api/users?delay={waktu}";

    @Step("Get list user")
    public void getListUser(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("data.id", id);
    }

    @Step("Get list resource")
    public void getListSingleResource(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Register")
    public void postRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Patch update user")
    public void patchUpdateUser(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delay response")
    public void delayResponse(int waktu){
        SerenityRest.given().pathParam("waktu",waktu);
    }

}
