package Funciones;

import java.io.*;
import javax.swing.JOptionPane;

public class LecturaDeArchivo {
    RandomAccessFile raFile;
    
    public void escribirTxtDat(String ruta, String nombreArchivo){
        int n = 0;
        try{
           raFile = new RandomAccessFile(nombreArchivo, "rw");
           raFile.seek(raFile.length());
           File file = new File(ruta);
           FileReader fr = new FileReader(file);
           BufferedReader br = new BufferedReader(fr);
           while(br.ready()){
               n = Integer.parseInt(br.readLine());
               Llave per = new Llave();
               per.setLlave(n);
               per.escribir(raFile);
           }
           raFile.close();
           br.close();
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+e);
        }
    }
    
    public void reporte(String nombreArchivo) throws IOException{
        raFile = new RandomAccessFile(nombreArchivo, "r");
        Llave llave = new Llave();
        String mensaje = "";
        while(raFile.getFilePointer()<raFile.length()){
            llave.leer(raFile);
            mensaje = mensaje + llave.getLlave()+"\n";
        }
        System.out.println(mensaje);
        raFile.close();
    }
    
    public void escribirDat(String nombreArchivo, int key) throws FileNotFoundException, IOException{
        raFile = new RandomAccessFile(nombreArchivo, "rw");
        raFile.seek(raFile.length());
        Llave per = new Llave();
        per.setLlave(key);
        per.escribir(raFile);
        raFile.close();
    }
}
