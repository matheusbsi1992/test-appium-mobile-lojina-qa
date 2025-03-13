package org.projeto.util;

import org.projeto.base.Base;

import java.time.Duration;

import static org.projeto.base.Base.inicializarApp;

public class Util {

    public static void tempoImplicito() {
        inicializarApp()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofMillis(5000));
    }
}
