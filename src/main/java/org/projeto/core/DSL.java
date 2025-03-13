package org.projeto.core;

import org.openqa.selenium.By;

import static org.projeto.base.Base.inicializarApp;

public class DSL {

    public void informarCampo(By by) {
        inicializarApp().findElement(by);
    }

    public void informarValor(By bya, By byb, String nome) {
        inicializarApp().findElement(bya).findElement(byb).sendKeys(nome);
    }

    public void clicarBotao(By by) {
        inicializarApp().findElement(by).click();
    }

    public String obterTexto(By by){
        return inicializarApp().findElement(by).getText();
    }

}
