
package logica;

import grafica.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class controlador {
    
    public static ArrayList<String> contadores;
    
    public static void main(String[] args) throws InterruptedException {
        Recuperar();
        GUI_principal p = new GUI_principal(contadores);
        do{
            Thread.sleep(100);
        }while(p.estado==0);
        Guardar();
    }
        
    public static void Guardar(){
        String archivo = "registro.txt";
        try{
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(archivo));
            ob.writeObject(contadores);
            ob.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }   
    }
    
    public static void Recuperar(){
        String archivo = "registro.txt";
        contadores = new ArrayList<String>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(archivo));
            contadores = (ArrayList<String>) is.readObject(); 
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
    
}
