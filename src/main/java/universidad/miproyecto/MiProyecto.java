
package universidad.miproyecto;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;
/**
 *
 * @author henry
 */
public class MiProyecto {

  class varGlobal
        {
             static int miArreglo[] =new int[10];  
             static String salida= " "; 
        }

       static String Menu() 
       {
             String[] opciones = {"llenar arreglo aleatoriamente", "ordenar arreglo ascendente", "ordenar arreglo descendente", "mostrar arreglo","salir"};         
             String menu = (String) JOptionPane.showInputDialog(null,"Escoga la opción que quiere evaluar", "Menu", JOptionPane.PLAIN_MESSAGE, null, opciones,opciones[3]);

             return menu;
       }

       static void miLoop() 
       {
            for(int i=0; i < varGlobal.miArreglo.length;i++)
              {
                        varGlobal.salida= varGlobal.salida+"-"+(varGlobal.miArreglo[i] );
              } 
       }
       
       static void llenarArreglo() 
       {   
             Random aleatorioNum =  new Random();
             for(int i=0; i < varGlobal.miArreglo.length;i++)
             {
                 varGlobal.miArreglo[i]=aleatorioNum.nextInt(0 + 100)+0;
             }
             varGlobal.salida='\n'+"****ARREGLO SIN ORDENAR****"+'\n'; 
              miLoop(); 
             //return  varGlobal.salida;    
       }

       static String ordenarAsc()
       {
              for(int x=0; x < varGlobal.miArreglo.length;x++)
             {  
                    for(int i=0; i < varGlobal.miArreglo.length;i++)
                    {
                        if ( i <  varGlobal.miArreglo.length -1)
                        {   
                            if ( varGlobal.miArreglo[i] > varGlobal.miArreglo[i+1] ) 
                            {

                                int a=varGlobal.miArreglo[i];
                                varGlobal.miArreglo[i]=varGlobal.miArreglo[i+1];
                                varGlobal.miArreglo[i+1]=a;
                            }
                        }   

                    }
             }
              varGlobal.salida= varGlobal.salida+'\n'+"***ARREGLO ORDENADO ASCENDENTEMENTE***"+'\n';        
              miLoop(); 
             return  varGlobal.salida;    
       }       


       static String  ordenarDesc() 
       {

              for(int x=0; x < varGlobal.miArreglo.length;x++)
             {  
                    for(int i=0; i <varGlobal. miArreglo.length;i++)
                    {
                        if ( i <  varGlobal.miArreglo.length -1)
                        {   
                            if ( varGlobal.miArreglo[i] < varGlobal.miArreglo[i+1] ) 
                            {

                                int a=varGlobal.miArreglo[i+1];
                                varGlobal.miArreglo[i+1]=varGlobal.miArreglo[i];
                                varGlobal.miArreglo[i]=a;
                            }
                        }   

                    }
             }
              varGlobal.salida= varGlobal.salida+'\n'+"***ARREGLO ORDENADO DESCENDENTEMENTE***"+'\n';        
              miLoop(); 
           return  varGlobal.salida;  
       }

       static String  imprimirArreglo() 
       {
            int sum = Arrays.stream(varGlobal.miArreglo).sum();
             if ( sum ==0)
             {
                 JOptionPane.showMessageDialog(null, "Arreglo sin elementos ", "miArreglo", JOptionPane.INFORMATION_MESSAGE);
                   varGlobal.salida= varGlobal.salida+'\n'; 
              }
             else
             {   
               JOptionPane.showMessageDialog(null,  varGlobal.salida, "miArreglo", JOptionPane.PLAIN_MESSAGE);
                varGlobal.salida= varGlobal.salida+'\n'; 
             }  
           return  varGlobal.salida;                                 
       }


         public static void main(String[] args) 
         {
            String salir=null;          
            while (salir !="salir") 
            {         
                 switch (Menu()) 
                 {
                     case "llenar arreglo aleatoriamente":                                       
                             llenarArreglo();
                              break;
                     case "ordenar arreglo ascendente":
                               ordenarAsc();
                              break;
                     case "ordenar arreglo descendente": 
                               ordenarDesc();  
                              break;
                     case "mostrar arreglo":  
                               imprimirArreglo();
                                break;      
                     case "salir": 
                             salir="salir";
                              break;
                  }
             } 

          }
}
