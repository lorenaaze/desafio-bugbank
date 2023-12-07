package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPage {

    public WebDriver driver;
    public Waits waits;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement botaoCadastro() {
        return driver.findElement(By.xpath("(//button[@type='button'])[2]"));
    }

    public WebElement campoEmail() {
        return waits.visibilityOfElement(By.xpath("(//input[@name='email'])[2]"));
    }

    public WebElement campoNome() {
        return waits.visibilityOfElement(By.name("name"));
    }

    public WebElement campoSenha() {
        return waits.visibilityOfElement(By.xpath("(//input[@type='password'])[2]"));
    }

    public WebElement campoConfirmarSenha() {
        return waits.visibilityOfElement(By.xpath("//input[@name='passwordConfirmation']"));
    }

    public WebElement selecionarContaComSaldo() {
        return driver.findElement(By.id("toggleAddBalance"));
    }

    public WebElement botaoCadastrar() {
        return waits.visibilityOfElement(By.xpath("//button[contains(text(),'Cadastrar')]"));
    }

    public WebElement numeroConta() {
        return waits.visibilityOfElement(By.id("modalText"));
    }

    public WebElement botaoFechar() {
        return waits.visibilityOfElement(By.id("btnCloseModal"));
    }

}
