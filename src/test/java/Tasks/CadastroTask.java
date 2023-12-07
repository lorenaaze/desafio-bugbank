package Tasks;

import org.openqa.selenium.WebDriver;
import PageObjects.CadastroPage;
import PageObjects.LoginPage;
import PageObjects.TransferenciaEntreContasPage;

public class CadastroTask {

    private static WebDriver driver;
    private CadastroPage cadastroPage;
    private LoginPage loginPage;
    private TransferenciaEntreContasPage transferenciaEntreContasPage;

    private String apenasNumeroDaConta1;
    private String apenasDigitoDaConta1;
    private String apenasNumeroDaConta2;
    private String apenasDigitoDaConta2;
    public CadastroTask(WebDriver driver) {
        this.driver = driver;
        cadastroPage = new CadastroPage(this.driver);
        loginPage = new LoginPage(this.driver);
        transferenciaEntreContasPage = new TransferenciaEntreContasPage(this.driver);
    }


    public void criarConta() throws InterruptedException{
        //criação da primeira conta
        Thread.sleep(3000);
        cadastroPage.botaoCadastro().click();
        cadastroPage.campoEmail().sendKeys("testeconta1@gmail.com");
        cadastroPage.campoNome().sendKeys("Lorena da Silva Azevedo");
        cadastroPage.campoSenha().sendKeys("abc");
        cadastroPage.campoConfirmarSenha().sendKeys("abc");
        cadastroPage.selecionarContaComSaldo().click();
        Thread.sleep(3000);
        cadastroPage.botaoCadastrar().click();
        Thread.sleep(4000);
        String numeroConta = cadastroPage.numeroConta().getText();
        cadastroPage.botaoFechar().click();

        String[] separarNumeroDaConta = numeroConta.split("-");

        for (int i = 0; i < separarNumeroDaConta.length; i++) {
            String parte = separarNumeroDaConta[i];
            String apenasDigitos = parte.replaceAll("[^0-9]", "");

            if (i == 0) {
                apenasNumeroDaConta1 = apenasDigitos;
            } else if (i == 1) {
                apenasDigitoDaConta1 = apenasDigitos;
            }
        }


        //criação da segunda conta
        cadastroPage.botaoCadastro().click();
        Thread.sleep(3000);
        cadastroPage.campoEmail().clear();
        cadastroPage.campoNome().clear();
        cadastroPage.campoSenha().clear();
        cadastroPage.campoConfirmarSenha().clear();
        cadastroPage.campoEmail().sendKeys("testesconta2@gmail.com");
        cadastroPage.campoNome().sendKeys("Lorena teste");
        cadastroPage.campoSenha().sendKeys("abc");
        cadastroPage.campoConfirmarSenha().sendKeys("abc");
        Thread.sleep(3000);
        cadastroPage.botaoCadastrar().click();
        Thread.sleep(4000);
        String numeroConta2 = cadastroPage.numeroConta().getText();
        cadastroPage.botaoFechar().click();

        String[] separarNumeroDaConta2 = numeroConta2.split("-");

        for (int i = 0; i < separarNumeroDaConta2.length; i++) {
            String parte = separarNumeroDaConta2[i];
            String apenasDigitos = parte.replaceAll("[^0-9]", "");

            if (i == 0) {
                apenasNumeroDaConta2 = apenasDigitos;
            } else if (i == 1) {
                apenasDigitoDaConta2 = apenasDigitos;
            }
        }


    }

    public void realizarLogin() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.campoEmailLogin().sendKeys("testeconta1@gmail.com");
        loginPage.campoSenhaLogin().sendKeys("abc");
        Thread.sleep(2000);
        loginPage.botaoAcessar().click();
        Thread.sleep(1000);
    }

    public void realizarTransferenciaEntreContas() throws InterruptedException {
        transferenciaEntreContasPage.botaoTransferencia().click();
        Thread.sleep(2000);
        transferenciaEntreContasPage.campoNumeroDaConta().sendKeys(apenasNumeroDaConta2);
        transferenciaEntreContasPage.campoDigitoDaConta().sendKeys(apenasDigitoDaConta2);
        transferenciaEntreContasPage.campoValorTransferencia().sendKeys("500");
        transferenciaEntreContasPage.campoDescricaoTransferencia().sendKeys("Transferência de teste");
        Thread.sleep(2000);
        transferenciaEntreContasPage.botaoRealizarTransferencia().click();
        transferenciaEntreContasPage.botaoFecharConfirmacaoTransferencia().click();
        transferenciaEntreContasPage.sairDaConta().click();
    }

    public void validarSaldoDasContas() throws InterruptedException{
        loginPage.campoEmailLogin().sendKeys("testeconta1@gmail.com");
        loginPage.campoSenhaLogin().sendKeys("abc");
        Thread.sleep(2000);
        loginPage.botaoAcessar().click();
        Thread.sleep(1000);
        String saldoConta1 = loginPage.saldoConta1().getText();
        System.out.println("O saldo da conta que realizou a transferência é " + saldoConta1);
        transferenciaEntreContasPage.sairDaConta().click();

        loginPage.campoEmailLogin().sendKeys("testesconta2@gmail.com");
        loginPage.campoSenhaLogin().sendKeys("abc");
        Thread.sleep(2000);
        loginPage.botaoAcessar().click();
        Thread.sleep(1000);
        String saldoConta2 = loginPage.saldoConta1().getText();
        System.out.println("O saldo da conta que recebeu a transferência é " + saldoConta2);
    }

}
