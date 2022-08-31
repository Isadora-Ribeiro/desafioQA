package suportes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static  WebDriver createChrome(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\isado\\ferramentas\\chromedriver.exe");
       WebDriver navegador = new ChromeDriver();

        //Navegando  para a página do Buguer-Eats
        navegador.get("https://buger-eats.vercel.app/");

        navegador.manage().window().maximize();

        return navegador;
    }
}
