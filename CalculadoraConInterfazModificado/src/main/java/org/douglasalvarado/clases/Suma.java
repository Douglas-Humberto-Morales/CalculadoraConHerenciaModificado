package org.douglasalvarado.clases;

import org.douglasalvarado.interfaz.OperationGenerals;

public class Suma implements OperationGenerals {

    @Override
    public Double operation(Double valor1, Double valor2) {
        return valor1 + valor2;
    }

    @Override
    public String description() { return "Suma"; }
}
