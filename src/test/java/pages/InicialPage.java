package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicialPage extends BasePage {

    public InicialPage(WebDriver navegador) {
        super(navegador);

    }

    public Cadastropage acessarTelaCadastro() {
        navegador.findElement(By.linkText("Cadastre-se para fazer entregas")).click();
        return new Cadastropage(navegador);

    }
}
