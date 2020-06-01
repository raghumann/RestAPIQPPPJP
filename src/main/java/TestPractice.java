import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPractice {

    public static final String GET_BOOK_URI = "Library/GetBook.php";
    public static final String ADD_BOOK_URI = "Library/Addbook.php";
    public static final String UPDATE_EMPLOYEE_URI = "http://dummy.restapiexample.com/api/v1/update/{id}";

    public static void main(String[] args) {

        // http://216.10.245.166/Library/GetBook.php?AuthorName=Priyanka
        RestAssured.baseURI = "http://216.10.245.166";


        //Employee Details update -> http://dummy.restapiexample.com/api/v1/update/{id}

        String actualBody = String.format(InputPayload.getAddBookPayload(),"Harry Potter and Chambers of Secrets","HPCS2","A2312","JK ROWLING");

        given().log().all()
                .contentType(ContentType.JSON)
                .body(actualBody)
                .when()
                .post(ADD_BOOK_URI)
                .then().log().all()
                .assertThat()
                .statusCode(200);

        given().log().all()
                .queryParam("AuthorName","JK ROWLING")
                .contentType(ContentType.JSON)
                .when()
                .get(GET_BOOK_URI)
                .then().log().all()
                .assertThat()
                .statusCode(200);

        given().log().all()
                .pathParam("id","450")
                .contentType(ContentType.JSON)
                .body(InputPayload.getUpdateEmployeePayload())
                .when()
                .put(UPDATE_EMPLOYEE_URI)
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
