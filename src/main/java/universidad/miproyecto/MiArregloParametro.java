package universidad.miproyecto;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author henry
 */
public class MiArregloParametro {

       static String Menu() 
       {
             String[] opciones = {"llenar arreglo aleatoriamente", "ordenar arreglo ascendente", "ordenar arreglo descendente", "mostrar arreglo","salir"};         
             String menu = (String) JOptionPane.showInputDialog(null,"Escoga la opción que quiere evaluar", "Menu", JOptionPane.PLAIN_MESSAGE, null, opciones,opciones[3]);

             return menu;
       }

       static void miLoop(int arreglo[]) 
       {
          String salida= " "; 
           for(int i=0; i < arreglo.length;i++)
              {
                        salida= salida+"-"+(arreglo[i] );
              } 
       }
       
       static String llenarArreglo(int arreglo[]) 
       {   
            String salida= " ";
             Random aleatorioNum =  new Random();
             for(int i=0; i < arreglo.length;i++)
             {
                 arreglo[i]=aleatorioNum.nextInt(0 + 100)+0;
             }
             salida='\n'+"****ARREGLO SIN ORDENAR****"+'\n'; 
              miLoop(arreglo); 
             return  salida;
                     }           
                     
       static String ordenarAsc()
       {
           String salida= " ";
           for(int x=0; x < arreglo.length;x++)
             {  
                    for(int i=0; i < arreglo.length;i++)
                    {
                        if ( i <  arreglo.length -1)
                        {   
                            if ( arreglo[i] > arreglo[i+1] ) 
                            {

                                int a=arreglo[i];
                                arreglo[i]=arreglo[i+1];
                                arreglo[i+1]=a;
                            }
                        }   

                    }
             }
              salida= salida+'\n'+"***ARREGLO ORDENADO ASCENDENTEMENTE***"+'\n';        
              miLoop(arreglo); 
             return  salida;    
       }       


       static String  ordenarDesc() 
       {
            String salida= " ";
              for(int x=0; x < arreglo.length;x++)
             {  
                    for(int i=0; i <arreglo.length;i++)
                    {
                        if ( i <  arreglo.length -1)
                        {   
                            if ( arreglo[i] < arreglo[i+1] ) 
                            {

                                int a=arreglo[i+1];
                                arreglo[i+1]=arreglo[i];
                                arreglo[i]=a;
                            }
                        }   

                    }
             }
              salida= salida+'\n'+"***ARREGLO ORDENADO DESCENDENTEMENTE***"+'\n';        
              miLoop(arreglo); 
           return  salida;  
       }

       static void  imprimirArreglo(String output) 
       {
            int sum = Arrays.stream(arreglo).sum();
             if ( sum ==0)
             {
                 JOptionPane.showMessageDialog(null, "Arreglo sin elementos ", "miArreglo", JOptionPane.INFORMATION_MESSAGE);
                   output= output+'\n'; 
              }
             else
             {   
               JOptionPane.showMessageDialog(null,  output, "miArreglo", JOptionPane.PLAIN_MESSAGE);
                output= output+'\n'; 
             }  
           //return  varGlobal.salida;                                 
       }


         public static void main(String[] args) 
         {
            int miArreglo[] =new int[10];   
            String salir=null;   
            String salida= " ";
            while (salir !="salir") 
            {         
                 switch (Menu()) 
                 {
                     case "llenar arreglo aleatoriamente":                                       
                             salida=llenarArreglo(miArreglo);
                              break;
                     case "ordenar arreglo ascendente":
                               salida=ordenarAsc(miArreglo);
                              break;
                     case "ordenar arreglo descendente": 
                               salida=ordenarDesc(miArreglo);  
                              break;
                     case "mostrar arreglo":  
                               imprimirArreglo(salida);
                                break;      
                     case "salir": 
                             salir="salir";
                              break;
                  }
             } 

          }
}

