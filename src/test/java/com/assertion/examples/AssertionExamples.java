package com.assertion.examples;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class AssertionExamples {
	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
	}
	
	@Test
	public void test01() {
		given()
		.when()
		.get("/stores")
		.then()
		.body("skip",equalTo(0));
	}
	
	@Test
	public void test02() {
		given()
		.when()
		.get("/stores")
		.then()
		.body("data.name",hasItem("Burnsville"));
	}
	
	@Test
	public void test03() {
		given()
		.when()
		.get("/stores")
		.then()
		.body("data.name",hasItems("Burnsville", "Oakdale"));
	}
	
	@Test
	public void test04() {
		given()
		.when()
		.get("/stores")
		.then()
		.body("data[0].services[0]",hasKey("createdAt"));
	}
	
	@Test
	public void test05() {
		given()
		.when()
		.get("/stores")
		.then()
		.body("data.findAll{it.name=='Northtown'}",hasItem(hasEntry("name","Northtown")));
	}
	
	@Test
	public void test06() {
		given()
		.when()
		.get("/stores")
		.then()
		.body("data.size()", greaterThan(5))
		.body("data.size()", lessThan(11))
		.body("data.size()", lessThanOrEqualTo(10))
		.body("data.size()", greaterThanOrEqualTo(10));;
	}
	
	
	 
}
