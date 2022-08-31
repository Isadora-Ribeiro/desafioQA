package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.InicialPage;
import suportes.Web;

public class entrarNoBuguerEatsPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }
    @Test
    public void testCadastroDeEntregadorCompleto() throws InterruptedException {
        new InicialPage(navegador)
                .acessarTelaCadastro()
                .preencherDados()
                .preencherEndereco()
                .selecionarMetodoDeEntrega()
                .enviarFotoCNH()
                .finalizarCadastro()
                .validarMensagemDeCadastroDeSucesso();
    }

    @Test
    public void testCadastroSemDados() throws InterruptedException {
        new InicialPage(navegador)
                .acessarTelaCadastro()
                .preencherEndereco()
                .selecionarMetodoDeEntrega()
                .enviarFotoCNH()
                .finalizarCadastro()
                .validarMensagemdeDadosInvalido();
    }

    @Test
    public void testCadastroSemEndereco() throws InterruptedException {
        new InicialPage(navegador)
                .acessarTelaCadastro()
                .preencherDados()
                .selecionarMetodoDeEntrega()
                .enviarFotoCNH()
                .finalizarCadastro()
                .validarMensagemdeEnderecoInvalido();

        //Esse teste falha pois, existe um bug na aplicação,
        // os campos Cep e Número são obrigatórios porém, ele permite cadastrar sem preenche-los.
    }

    @After
    public void tearDown(){
       navegador.close();
    }
}
