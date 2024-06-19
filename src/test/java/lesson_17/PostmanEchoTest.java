package lesson_17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void whenGetRequest_thenStatus200AndResponseBodyCorrect() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void whenPostRequest_thenStatus200AndResponseBodyCorrect() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"test\":\"value\"}")
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("json.test", equalTo("value"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void whenPutRequest_thenStatus200AndResponseBodyCorrect() {
        given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void whenPatchRequest_thenStatus200AndResponseBodyCorrect() {
        given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void whenDeleteRequest_thenStatus200AndResponseBodyCorrect() {
        given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
