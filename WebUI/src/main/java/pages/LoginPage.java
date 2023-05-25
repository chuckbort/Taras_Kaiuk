package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page{

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.usernameField = driver.findElement(By.name("username"));
        this.passwordField = driver.findElement(By.name("password"));
        this.loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
    }

    public void fillUsername(String username) {
        fillField(usernameField, username);
    }

    public void fillPassword(String password) {
        fillField(passwordField, password);
    }

    public void login(){
        clickButton(loginButton);
    }
}
