package Funciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author yaser
 */


public class Llave {

    public int llave;
    RandomAccessFile file;
    
    public void escribir(RandomAccessFile file) throws IOException{
        file.writeInt(this.llave);
    }
    
    public void leer(RandomAccessFile file) throws IOException{
        this.llave = file.readInt();
    }

    public int getLlave() {
        return this.llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }
    
    
    
}
