//@author Simon Alonso Montenegro Bastias
//Rut 19.794.721-7
//Ultimo Edit: 06/09/2020
//@version 1.8

package laboratorio3_19794721;

import java.util.Scanner;

public class Laboratorio3_19794721 {
    //Funcion main
    public static void main(String[] args) {
        //Bienvenida al usuario y solicitud de opcion
        Scanner input = new Scanner(System.in);
        System.out.println("********************************************************************");
        System.out.println("\t\tBienvenido a la simulación de git.");
        System.out.println("********************************************************************");
        System.out.println("\t\tPara comenzar, debe crear un repositorio.");
        System.out.println("1. Init");
        System.out.println("0. Exit");
        System.out.print("Ingrese su opción:\t");
        //Declaracion de Flag, esto permite que el usuario pueda utilizar la simulación hasta que ingrese la opcion 0. Exit
        Boolean exit = false;
        //try-catch para verificar que ingreso un numero y no un string u otro tipo de dato
        try{
            //Ciclo infinito mientras el usuario no elija exit.
            while(!exit){
                //Solicitud de ingreso de opciones.
                int inicio = input.nextInt();
                if(inicio == 1){
                    Zonas zonas = new Zonas();
                    zonas.gitInit();
                    //Ciclo infinito para mantener el menu de simulacion hasta que el usuario decida salir.
                    while(!exit){
                        System.out.println("********************************************************************");
                        Scanner input2 = new Scanner(System.in);
                        System.out.println("\t\t\tEscoja una opción:");
                        System.out.println("1. Crear Nuevo Archivo");
                        System.out.println("2. Add");
                        System.out.println("3. Commit");
                        System.out.println("4. Push");
                        System.out.println("5. Pull");
                        System.out.println("6. Status");
                        System.out.println("7. Log");
                        System.out.println("0. Exit");
                        System.out.print("Ingrese su opción:\t");
                        int menu = input.nextInt();
                        //Opciones para cada entrada de menu.
                        if(menu == 0){
                            exit = true;
                        }
                        else if(menu == 1){
                            zonas.crearNuevoArchivo();
                        }
                        else if(menu == 2){
                            zonas.gitAdd();                            
                        }
                        else if(menu == 3){
                            zonas.gitCommit();
                        }
                        else if(menu == 4){
                            zonas.gitPush();
                        }
                        else if(menu == 5){
                            zonas.gitPull();
                        }
                        else if(menu == 6){
                            zonas.gitStatus();
                        }
                        else if(menu == 7){
                            zonas.gitLog();
                        }
                        else{
                            System.out.println("********************************************************************");
                            System.out.println("*********************Ingrese una opcion valida.*********************");
                        }
                    }


                }
                else if(inicio == 0){
                    exit = true;
                }
                //Auxiliar que se ejecuta en caso de que la opcion ingresada por el usuario no exista.
                else{
                    System.out.println("********************************************************************");
                    System.out.println("*********************Ingrese una opcion valida.*********************");
                    System.out.println("********************************************************************");
                    System.out.println("1. Init");
                    System.out.println("0. Exit");
                    System.out.print("Ingrese su opción:\t");
                }
            }
            
        //Error de entrada; el usuario ingresa un tipo de dato distinto de un numero.
        }catch(Exception e){
            System.out.println("********************************************************************");
            System.out.println("Error, no se ingresó un caracter valido.");
        }
        //Fin de la simulacion
        System.out.println("********************************************************************");
        System.out.println("\t\t\tSimulación Finalizada.");
        System.out.println("********************************************************************");
    }
    
}


 