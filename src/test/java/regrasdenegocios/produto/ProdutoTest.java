package regrasdenegocios.produto;


import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.projeto.core.DSL;
import org.projeto.page.LoginPage;
import org.projeto.page.ProdutoPage;
import org.projeto.util.Util;


import java.time.Duration;
import java.util.Timer;

import static org.projeto.base.Base.desativarApp;
import static org.projeto.base.Base.inicializarApp;
import static org.projeto.util.Util.tempoImplicito;

@DisplayName("Teste do modulo de Produto")
public class ProdutoTest {

    private LoginPage loginPage = new LoginPage();
    private ProdutoPage produtoPage = new ProdutoPage();

    @BeforeEach
    public void iniciarlizarLogin() {
        loginPage.setUsuarioNome("meu usuario");
        loginPage.setUsuarioSenha("minha senha");
        loginPage.clicarBotaoLogin();
        tempoImplicito();
    }

    @AfterEach
    public void encerrarComunicacao() {
        desativarApp();
    }

    @Test
    @DisplayName("Validar valor do produto nao permitido acima de R$ 7.000,00")
    void testValidacaoDoValorDoProdutoAcimaDoLimitePermitido() {
        //clicar no botao de novo
        produtoPage.clicarBotaoNovoProduto();
        //informar produto, valor e cores
        produtoPage.setProdutoNome("Bala Linda Botafoguense");
        produtoPage.setProdutoValor("7.000,01");
        produtoPage.setProdutoCores("preto,branco");
        //clicar no botao de salvar
        produtoPage.clicarBotaoSalvarProduto();
        //validar mensagem
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", produtoPage.obterMensagemProduto());
    }

    @Test
    @DisplayName("Validar valor do produto nao permitido abaixo de R$ 0,01")
    void testValidacaoDoValorDoProdutoAbaixoDoLimitePermitido() {
        //clicar no botao de novo
        produtoPage.clicarBotaoNovoProduto();
        //informar produto, valor e cores
        produtoPage.setProdutoNome("Bala Linda Botafoguense");
        produtoPage.setProdutoValor("0,00");
        produtoPage.setProdutoCores("preto,branco");
        //clicar no botao de salvar
        produtoPage.clicarBotaoSalvarProduto();
        //validar mensagem
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", produtoPage.obterMensagemProduto());
    }
}
