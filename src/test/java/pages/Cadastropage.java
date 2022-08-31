package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Cadastropage extends BasePage {


    public Cadastropage(WebDriver navegador) {
        super(navegador);
    }

    public Cadastropage preencherDados() {
        navegador.findElement(By.xpath("//input[@name='name']")).sendKeys("Isadora Ribeiro");
        navegador.findElement(By.xpath("//input[@name='cpf']")).sendKeys("08562471245");
        navegador.findElement(By.xpath("//input[@name='email']")).sendKeys("isadorasantosriberio4@gmail.com");
        navegador.findElement(By.xpath("//input[@name='whatsapp']")).sendKeys("+5571981189002");

        return this;
    }

    public Cadastropage preencherEndereco(){
        navegador.findElement(By.xpath("//input[@name='postalcode']")).sendKeys("41180-540");
        navegador.findElement(By.xpath("//input[@type='button']")).click();
        navegador.findElement(By.xpath("//input[@name='address-number']")).sendKeys("11");
        navegador.findElement(By.xpath("//input[@name='address-details']")).sendKeys("1ºandar");

        return this;
    }
    public Cadastropage selecionarMetodoDeEntrega() throws InterruptedException {
        navegador.findElement(By.xpath("//img[@alt='Moto']")).click();
        aguardar10Segundos();

        return this;
    }
    public Cadastropage enviarFotoCNH(){

        WebElement escolherArquivo = navegador.findElement(By.xpath("//p"));
        escolherArquivo.sendKeys("C:\\dtar\\testIsadora\\imgs\\img.jpg");

        return this;
    }

    public Cadastropage finalizarCadastro(){
        navegador.findElement(By.xpath("//button[@class='button-success']")).click();

        return this;

    }
     public Cadastropage validarMensagemDeCadastroDeSucesso(){
         WebElement cadastro = navegador.findElement(By.id("swal2-html-container"));
         String cadastroRealizado = cadastro.getText();
         assertEquals("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.", cadastroRealizado);

         return this;
     }

    public Cadastropage validarMensagemdeDadosInvalido(){
        WebElement nome = navegador.findElement(By.xpath("/html/body/div/div/form/fieldset[1]/div[1]/div[1]/span"));
        String validaCampoNome = nome.getText();
        assertEquals("É necessário informar o nome", validaCampoNome);

        WebElement cpf = navegador.findElement(By.xpath("/html/body/div/div/form/fieldset[1]/div[1]/div[2]/span"));
        String validaCampoCPF = cpf.getText();
        assertEquals("É necessário informar o CPF", validaCampoCPF);

        WebElement email = navegador.findElement(By.xpath("/html/body/div/div/form/fieldset[1]/div[2]/div[1]/span"));
        String validaCampoEmail = email.getText();
        assertEquals("É necessário informar o email", validaCampoEmail);

        return this;
    }
    public Cadastropage validarMensagemdeEnderecoInvalido() {
        WebElement cep = navegador.findElement(By.xpath("/html/body/div/div/form/fieldset[2]/div[1]/div[1]/span"));
        String validaCampoCep = cep.getText();
        assertEquals("É necessário informar o CEP", validaCampoCep);

        WebElement numero = navegador.findElement(By.xpath("/html/body/div/div/form/fieldset[2]/div[3]/div[1]/span"));
        String validaCampoNumero = numero.getText();
        assertEquals("É necessário informar o número do endereço", validaCampoNumero);

        return this;
    }
}
