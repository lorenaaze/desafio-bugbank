package TestCases;

import Framework.TestBase;
import Tasks.CadastroTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Description;

public class CriarDuasContasEFazerTransferencia extends TestBase {

    private WebDriver driver = this.getDriver();

    CadastroTask cadastroTask = new CadastroTask(driver);

    @Description("Testando a criação de duas contas e transferência de uma para outra")
    @Test
    public void criarDuasContasEFazerTransferencia() throws InterruptedException{
        cadastroTask.criarConta();
        cadastroTask.realizarLogin();
        cadastroTask.realizarTransferenciaEntreContas();
        cadastroTask.validarSaldoDasContas();
    }

}
