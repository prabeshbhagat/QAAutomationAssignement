package PostAPI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;


public class createUserWithPOJOTest {
	
	
	public static String getRandomEmailId() {
		return "apiAuto"+System.currentTimeMillis()+"@testmail.com";
	}
	
	@Test
	public void addUserTest() {
		
		RestAssured.baseURI="https://gorest.co.in";
		User user= new User("Prabesh", getRandomEmailId(),"Male", "active");
				
		
		int user_ID=
		given().log().all()
			.header("Authorization", "Bearer d4176ed674fe764cb7b27dbf32d481b4fb0c8b4b0721a2aa12583d0d60c3d26b")
			.contentType(ContentType.JSON)
			.body(user)
		.when().log().all()
			.post("/public/v2/users")
		.then().log().all()
			.assertThat()
			.statusCode(201)
			.and()
			.extract()
			.path("id");
		
		System.out.println("User Id is:"+user_ID);
		
		//2.get the same user and verify
		
		given().log().all()
			.header("Authorization", "Bearer d4176ed674fe764cb7b27dbf32d481b4fb0c8b4b0721a2aa12583d0d60c3d26b")
			.contentType(ContentType.JSON)
		.when()
			.get("/public/v2/users/"+user_ID)
		.then()
			.assertThat()
			.statusCode(200);

	}

}
