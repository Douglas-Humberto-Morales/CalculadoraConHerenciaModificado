package org.douglasalvarado.clases;

import org.douglasalvarado.interfaz.OperationGenerals;

public class Division implements OperationGenerals {

    @Override
    public Double operation(Double valor1, Double valor2) {
        return valor2 == 0 ? 0.00 : valor1 / valor2;
    }

    @Override
    public String description() { return "División"; }
}
