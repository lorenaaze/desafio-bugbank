package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaEntreContasPage {
    public WebDriver driver;
    public Waits waits;

    public TransferenciaEntreContasPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement botaoTransferencia() {
        return waits.visibilityOfElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement campoNumeroDaConta() {
        return waits.visibilityOfElement(By.xpath("//input[@type='accountNumber']"));
    }

    public WebElement campoDigitoDaConta() {
        return waits.visibilityOfElement(By.xpath("//input[@type='digit']"));
    }

    public WebElement campoValorTransferencia() {
        return waits.visibilityOfElement(By.xpath("//input[@type='transferValue']"));
    }

    public WebElement campoDescricaoTransferencia() {
        return waits.visibilityOfElement(By.xpath("//input[@type='description']"));
    }

    public WebElement botaoRealizarTransferencia() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public WebElement botaoFecharConfirmacaoTransferencia() {
        return waits.visibilityOfElement(By.xpath("//a[@id='btnCloseModal']"));
    }

    public WebElement sairDaConta() {
        return waits.visibilityOfElement(By.id("btnExit"));
    }
}
