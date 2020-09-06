package laboratorio3_19794721;

import java.util.Scanner;

public class Laboratorio3_19794721 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("********************************************************************");
        System.out.println("\t\tBienvenido a la simulación de git.");
        System.out.println("********************************************************************");
        System.out.println("\t\tPara comenzar, debe crear un repositorio.");
        System.out.println("1. Init");
        System.out.println("0. Exit");
        System.out.print("Ingrese su opción:\t");
        Boolean exit = false;
        try{    
            while(!exit){
                int inicio = input.nextInt();
                if(inicio == 1){
                    System.out.println("********************************************************************");
                    Zonas zonas = new Zonas();
                    zonas.gitInit();
                    while(!exit){
                        System.out.println("********************************************************************");
                        Scanner input2 = new Scanner(System.in);
                        System.out.println("\t\t\tEscoja una opción:");
                        System.out.println("1. Crear Nuevo Archivo");
                        System.out.println("2. Add");
                        System.out.println("3. Commit");
                        System.out.println("4. Push");
                        System.out.println("5. Status");
                        System.out.println("6. Log");
                        System.out.println("0. Exit");
                        System.out.print("Ingrese su opción:\t");
                        int menu = input.nextInt();
                        if(menu == 0){
                            exit = true;
                        }
                        else if(menu == 1){
                            zonas.crearNuevoArchivo();
                            System.out.println("********************************************************************");
                            System.out.println("******************* Archivo creado correctamente *******************");
                        }
                        else if(menu == 2){
                            if(zonas.workSpace.archivos.size() > 0){
                                zonas.gitAdd();
                                System.out.println("********************************************************************");
                                System.out.println("***************** Add realizado satisfactoriamente *****************");
                            }
                            else {
                                System.out.println("********************************************************************");
                                System.out.println("\tNo hay archivos para añadir, intente crear un archivo.");
                            }
                            
                        }
                        else if(menu == 3){
                            if(zonas.index.archivos.size() > 0){
                                zonas.gitCommit();
                                System.out.println("********************************************************************");
                                System.out.println("*************** Commit realizado satisfactoriamente ****************");
                            }
                            else {
                                System.out.println("********************************************************************");
                                System.out.println("\tNo hay archivos suficientes para realizar un commit.");
                            }
                        }
                        else if(menu == 4){
                            if(zonas.localRepository.commits.size() > 0){
                                zonas.gitPush();
                                System.out.println("********************************************************************");
                                System.out.println("***************** Push realizado satisfactoriamente ****************");
                            }
                            else {
                                System.out.println("********************************************************************");
                                System.out.println("No hay commits en el repositorio local, intente generar un commit.");
                            }
                        }
                        else if(menu == 5){
                            System.out.println("********************************************************************");
                            System.out.println("********************************************************************");
                            zonas.gitStatus();
                            System.out.println("********************************************************************");
                        }
                        else if(menu == 6){
                            System.out.println("********************************************************************");
                            System.out.println("********************************************************************");
                            zonas.gitLog();
                            System.out.println("********************************************************************");
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
                else{
                    System.out.println("********************************************************************");
                    System.out.println("*********************Ingrese una opcion valida.*********************");
                    System.out.println("********************************************************************");
                    System.out.println("1. Init");
                    System.out.println("0. Exit");
                    System.out.print("Ingrese su opción:\t");
                }
            }
            
        }catch(Exception e){
            System.out.println("********************************************************************");
            System.out.println("Error, no se ingresó un caracter valido.");
        }
        System.out.println("********************************************************************");
        System.out.println("\t\t\tSimulación Finalizada.");
        System.out.println("********************************************************************");
        /*Zonas zonas = new Zonas();
        zonas.gitInit();
        zonas.crearNuevoArchivo();
        zonas.crearNuevoArchivo();
        zonas.crearNuevoArchivo();
        zonas.gitAdd();
        zonas.gitCommit();
        zonas.gitPush();
        zonas.gitStatus();
        zonas.gitLog();*/
    }
    
}


 