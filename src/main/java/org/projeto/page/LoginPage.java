package org.projeto.page;

import org.openqa.selenium.By;
import org.projeto.core.DSL;

public class LoginPage {

    private DSL dsl = new DSL();

    public void setUsuarioNome(String usuarioNome) {
        dsl.clicarBotao(By.id("com.lojinha:id/user"));
        dsl.informarValor(By.id("com.lojinha:id/user")
                , By.id("com.lojinha:id/editText")
                , usuarioNome);
    }

    public void setUsuarioSenha(String senhaUsuario) {
        dsl.clicarBotao(By.id("com.lojinha:id/password"));
        dsl.informarValor(By.id("com.lojinha:id/password")
                , By.id("com.lojinha:id/editText")
                , senhaUsuario);
    }

    public void clicarBotaoLogin() {
        dsl.clicarBotao(By.id("com.lojinha:id/loginButton"));
    }

}