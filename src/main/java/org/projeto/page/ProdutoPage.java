package org.projeto.page;

import org.openqa.selenium.By;
import org.projeto.core.DSL;
import org.projeto.util.Util;

public class ProdutoPage {

    DSL dsl = new DSL();

    public void setProdutoNome(String produtoNome) {
        dsl.clicarBotao(By.id("com.lojinha:id/productName"));
        dsl.informarValor(By.id("com.lojinha:id/productName")
                , By.id("com.lojinha:id/editText")
                , produtoNome);
    }

    public void setProdutoValor(String produtoValor) {
        dsl.clicarBotao(By.id("com.lojinha:id/productValue"));
        dsl.informarValor(By.id("com.lojinha:id/productValue")
                , By.id("com.lojinha:id/editText")
                , produtoValor);
    }

    public void setProdutoCores(String produtoCores) {
        dsl.clicarBotao(By.id("com.lojinha:id/productColors"));
        dsl.informarValor(By.id("com.lojinha:id/productColors")
                , By.id("com.lojinha:id/editText")
                , produtoCores);
    }

    public void clicarBotaoNovoProduto() {
        dsl.clicarBotao(By.id("com.lojinha:id/floatingActionButton"));
    }

    public void clicarBotaoSalvarProduto() {
        dsl.clicarBotao(By.id("com.lojinha:id/button"));
    }

    public String obterMensagemProduto(){
        return dsl.obterTexto(By.xpath("//android.widget.Toast"));
    }
}
