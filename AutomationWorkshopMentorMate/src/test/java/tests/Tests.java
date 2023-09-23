package tests;

import common.TestObject;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends TestObject {

    @Test
    public void signUpTest() throws InterruptedException {
        String username = "victor" + System.currentTimeMillis();
        //Open website
        driver.get("https://demoblaze.com/");
        //Find and click sign up button
        driver.findElement(By.id("signin2")).click();

        //Wait for form to appear
        wait.waitForElementToBeVisible(By.id("sign-username"));
        Thread.sleep(2000);
        //Find and send input to username field
        driver.findElement(By.id("sign-username")).sendKeys(username);
        Thread.sleep(2000);
        //Find and send input to password field
        driver.findElement(By.id("sign-password")).sendKeys("123456");
        Thread.sleep(2000);
        //Find and click sign up button in form
        driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();

        //Wait for alert to appear
        Thread.sleep(2000);
        wait.waitForAlertToBePresent();
        //Assert that the user was successfully created
        Assert.assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");

    }

    @Test
    public void logInTest() {
        String username = "Steven" + System.currentTimeMillis();
        //Open website
        RestAssured.given().
                header("Content-Type","application/json").
                body(new JSONObject().put("user-name",username).put("password","MTIzNDU2").toString()).

                when().post("https://api.demoblaze.com/signup").

                then().statusCode(200);

        //Find and click log in button


        //Wait for form to appear.


        //Find and send input to username field


        //Find and send input to password field


        //Find and click log in button in form


        //Assert that the username that is displayed is the same as the one that we used to log in


    }
}
