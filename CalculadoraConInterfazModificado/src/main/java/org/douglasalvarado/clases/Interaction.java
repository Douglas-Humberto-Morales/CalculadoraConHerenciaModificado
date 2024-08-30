package org.douglasalvarado.clases;

import java.util.Scanner;

public class Interaction {

    // Declaración de Clases de uso para las operaciones matematicas
    Suma suma = new Suma();
    Rest rest = new Rest();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Scanner scanner = new Scanner(System.in);

    //Declaración de Variables en uso
    private String signOperate;  // Variable para almacenar la selección del usuario
    private Double amountOne;  // Primer valor introducido por el usuario
    private Double amountTwo;  // Segundo valor introducido por el usuario

    public void options (){
        //Obtenemos la opcion que desea el usuario para setearlo en signOperate
        System.out.println("¿Qué operación desea realizar?");
        System.out.println("1. Sumar +\n2. Restar -\n3. Multiplicar *\n4. Dividir /");
        signOperate = scanner.nextLine();
    }

    public void selection(){
        //Obtenemos los valores a operar segun signOperate
        System.out.println("Introduzca los valores");
        System.out.println("Valor 1 = ");
        amountOne = scanner.nextDouble();
        System.out.println("Valor 2 = ");
        amountTwo = scanner.nextDouble();
    }

    public Double operation(){
        // Ejecutar la operación seleccionada utilizando operadores ternarios
        // mandando los valores establecidos
        // Variable para almacenar el resultado de la operación
        return signOperate.equals("+") ? suma.operation(amountOne, amountTwo) :
                signOperate.equals("-") ? rest.operation(amountOne, amountTwo) :
                        signOperate.equals("*") ? multiplication.operation(amountOne, amountTwo) :
                                signOperate.equals("/") ? division.operation(amountOne, amountTwo) : null;
    }

    public String textToReturn(Double incomeResult){
        //Retornamos el valor si es una opcion valida
        return incomeResult == null ? "Seleecion no valida" : ("El resultado es: " + incomeResult);
    }

    public Boolean continuerTheProcesses(){
        //Verificamos si el usuario desea volver a operara
        System.out.println("Desea continuar?");
        System.out.println("Y/N");
        String exit = scanner.nextLine();
        while (!(exit.equals("Y") || exit.equals("y")) &&
                !(exit.equals("N") || exit.equals("n")))
        {
            System.out.println("Seleccione una opcion valida porfavor");
            exit = scanner.nextLine();
        }
        return !exit.equals("N") && !exit.equals("n");
    }

    public void combination(){
        //Llamamos todos los metodos a usar segun el orden que deseemos
        do{
            options();
            selection();
            System.out.println(textToReturn(operation()));
        }while (continuerTheProcesses());
    }

    public void setSignOperate(String signOperate) {
        this.signOperate = signOperate;
    }

    public void setAmountOne(Double amountOne) {
        this.amountOne = amountOne;
    }

    public void setAmountTwo(Double amountTwo) {
        this.amountTwo = amountTwo;
    }
}
