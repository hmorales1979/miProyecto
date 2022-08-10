package universidad.miproyecto;
import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Menu
{
      
    static int numeroMenor (int primero, int segundo, int tercero)
        {
            int menor=0;
            if (primero < segundo ) {
                if (primero < tercero) {
                     menor = primero;
                } else{
                     menor = tercero;
                }
            } else if (segundo < primero) {
                if (segundo < tercero ){
                     menor = segundo;
                } else {
                     menor = tercero;
                }
            }
            return menor;
        }

    static String CaracterMedio (String miCaracter){ //determino el largo de la palabra y luego la mitad 
        String Subcadena="";
        double stringLength = miCaracter.length(); 
        double mitad =stringLength%2; //evaluo si hay modulo de divir en dos
        if (mitad >0 ){
            stringLength=stringLength/2;
            stringLength=Math.floor(stringLength) +1 ; //mitad en palabras con cantidad impares de letras
            Subcadena = miCaracter.substring((int)stringLength-1 ,(int)stringLength);
        } else {
            stringLength=stringLength/2;
            Subcadena = miCaracter.substring((int)stringLength-1 ,(int)stringLength +1); //mitar de palabras con cantidad pares
        }
        return  Subcadena;
    }

    static int cuentaVolcales (String palabra) { //comparo las letras de la palabra con las vocales y hago conteo
        int cont = 0;
        String[] vocales = {"a", "e", "i", "o", "u","A","E","I","O","U"};
        for (int i = 0; i < palabra.length(); i++)
        {
            for (int x = 0; x < vocales.length; x++)
            {
                String letraPalabra=String.valueOf(palabra.charAt(i));
                String letraVocal=String.valueOf(vocales[x]);
                if (letraPalabra.equals(letraVocal))
                {
                    cont = cont + 1;
                }
            }
        }
        return cont;
    }

    static String validaPassword (String palabra) { //valido estructura del pasword
        String validacion="";
        int cont=0;
        if (palabra.length()>=8){

            if (palabra.length()>=8){
                if (palabra.matches(".*[0-9].*")){
                    if (palabra.matches(".*[a-z].*") ||  palabra.matches(".*[A-Z].*")  )
                    {
                        int digitos[]={0,1,2,3,4,5,6,7,8,9};
                        for (int x=0; x < digitos.length; x++)
                        {
                            for (int i = 0; i < palabra.length(); i++)
                            {
                                String letraPalabra=String.valueOf(palabra.charAt(i));
                                String digit=String.valueOf(x);
                                if (letraPalabra.equals(digit))
                                {
                                    cont = cont + 1;
                                }
                            }
                        }
                        if (cont >=2 )
                        {
                            validacion="pasword valido ";
                        } else {
                            validacion="pasword debe tener al menos 2 digitos";
                        }

                    } else {
                        validacion="el pasword no contiene letras";
                    }
                } else  {
                    validacion="el pasword no contiene numeros";
                }
            }
        }else{
             validacion="pasword debe tener al menos 8 caracteres";
        }
        return validacion;
    }

    static   double[]  arreglo (  ) {//lleno arreglo aleatoriamente y regreso el promedio, maximo y minimo
        int miArreglo[] =new int[10];
        double sum=0;
        Random aleatorioNum =  new Random();
        for(int i=0; i < 10;i++)
        {
            miArreglo[i]=aleatorioNum.nextInt(0 + 100)+0;
            sum=sum+miArreglo[i];
        }
        double promedio= sum/miArreglo.length;
        for(int i=0; i < miArreglo.length;i++)
        {
            System.out.print(miArreglo[i]+",");
        }

        for(int x=0; x < miArreglo.length;x++)
        {
            for(int i=0; i < miArreglo.length;i++)
            {
                if ( i <  miArreglo.length -1)
                {
                    if ( miArreglo[i] > miArreglo[i+1] )
                    {
                        int a=miArreglo[i];
                        miArreglo[i]=miArreglo[i+1];
                        miArreglo[i+1]=a;
                    }
                }
            }
        }
        int maximo=miArreglo[miArreglo.length-1];
        int minimo=miArreglo[0];
        System.out.println("");
        return new double[]{promedio, maximo, minimo};

    }

    static void miMenu()//imprimo el menu
    {
        String[] opciones = {"Numero mas pequeño",
                "Caracter del medio",
                "Cuenta vocales",
                "Valida Password",
                "Promedio arreglo",
                "Maximo y minimo arreglo",
                "salir"};
        System.out.println("===============================");
        for(int i=0; i < opciones.length;i++)
        {
            System.out.println(i+1+") "+opciones[i]);
        }
        System.out.println("==============================");
    }

    
    static public void presioneletraContinuar() // hago pausa y solicito una accion de usuario
        {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("presione alguna letra para continuar...");
        try
        {
            seguir = teclado.nextLine();
        }
        catch(Exception e)
        {}
       }

    static void limpiar( ) { //imprimo lineas en blanco para simular clear de pantalla
       
        for (int i=0; i < 100; i++)
        {
            System.out.println("");
        }
    }
        

    public static void main(String[] args) {

        Scanner opcion = new Scanner(System.in);  //Scanner object
        Scanner numero= new Scanner(System.in);   //Scanner object
        String id_op=null;
        double[] miArreglo = new double[3];
       

        while (id_op!="7") {
            limpiar();
            miMenu();
            System.out.println("Seleccione opcion ");
            id_op = opcion.nextLine();  // Read user input

            switch (id_op)
            {
                case "1":
                    System.out.print("Ingrese primer numero ");
                    int  primerNumero =numero.nextInt();
                    System.out.print("Ingrese segundo numero ");
                    int  segundoNumero =numero.nextInt();
                    System.out.print("Ingrese tercero numero ");
                    int  tercerNumero =numero.nextInt();
                    int menor=numeroMenor(primerNumero,segundoNumero,tercerNumero);
                    System.out.println("");
                    System.out.println("EL NUMERO MENOR ES  "+menor);
                    presioneletraContinuar();
                    break;
                case "2":
                    System.out.print("Ingrese una palabra  ");
                    String palabra = opcion.nextLine();
                    System.out.println("");
                    System.out.println("LA MITAD DE LA PALABARA ES : "+CaracterMedio(palabra));
                    presioneletraContinuar();
                    break;
                case "3":
                    System.out.print("Ingrese una palabra  ");
                    palabra = opcion.nextLine();
                    System.out.println("");
                    System.out.println("TOTAL VOCALES EN : ' " + palabra + " ' VOCALES "+cuentaVolcales(palabra));
                    presioneletraContinuar();
                    break;
                case "4":
                    System.out.print("Ingrese una palabra  ");
                    palabra = opcion.nextLine();
                    System.out.println("");
                    System.out.println("RESULTADO VALIDACION PASWORD :"+validaPassword(palabra) );                   
                    presioneletraContinuar();
                    break;
                case "5":
                    miArreglo=arreglo();
                    System.out.println("");
                    System.out.println("");
                    System.out.println(" PROMEDIO DEL ARREGLO ES : "+ miArreglo[0]  );
                    presioneletraContinuar();
                    break;
                case "6":
                    miArreglo=arreglo();
                    System.out.println("");
                    System.out.println(" MAXIMO ARREGLO : "+  (int) Math.round(miArreglo[1] ) + "  MINIMO ARREGLO : "+(int) Math.round(+miArreglo[2] ) );
                    presioneletraContinuar();
                    break;
                case "7":
                    id_op="7";
                    System.out.println(id_op);
                    break;
                default:
                    System.out.println("opcion invalida");
                     presioneletraContinuar();   
                    break;

            }


        }
    }

}