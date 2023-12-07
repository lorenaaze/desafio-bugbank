package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    public Waits waits;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement campoEmailLogin() {
        return waits.visibilityOfElement(By.xpath("//input[@type='email']"));
    }

    public WebElement campoSenhaLogin() {
        return waits.visibilityOfElement(By.name("password"));
    }

    public WebElement botaoAcessar() {
        return waits.visibilityOfElement(By.xpath("//button[contains(text(),'Acessar')]"));
    }

    public WebElement saldoConta1() {
        return waits.visibilityOfElement(By.xpath("//p[@id='textBalance']/span"));
    }

    public WebElement saldoConta2() {
        return waits.visibilityOfElement(By.xpath("//p[@id='textBalance']/span"));
    }
}
