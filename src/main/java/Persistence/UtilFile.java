package Persistence;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class UtilFile {

    public static void saveFile(String ruta,String contenido, Boolean flagAnexarContenido) throws IOException {
        FileWriter fw = new FileWriter(ruta,flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }

    public static ArrayList<String> readFile(String route) throws IOException {
        ArrayList<String> content = new ArrayList<String>();
        FileReader fr = new FileReader(route);
        BufferedReader bfr=new BufferedReader(fr);
        String linea="";
        while((linea = bfr.readLine())!=null)
        {
            content.add(linea);
        }
        bfr.close();
        fr.close();
        return content;
    }

    public static Object loadSerializedResource(String routeFile) throws Exception {
        Object aux = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(routeFile));
            aux = ois.readObject();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ois != null)
                ois.close();
        }
        return aux;
    }

    public static void saveSerializedResource(String routeFile, Object object)	throws Exception {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(routeFile));
            oos.writeObject(object);
        } catch (Exception e) {
            throw e;
        } finally {
            if (oos != null)
                oos.close();
        }
    }

    public static Object loadSerializedResourceXML(String routeFile) throws IOException {
        XMLDecoder decodificadorXML;
        Object objetoXML;
        decodificadorXML = new XMLDecoder(new FileInputStream(routeFile));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;
    }

    public static void saveSerializedResourceXML(String routeFile, Object object) throws IOException {
        XMLEncoder codificatorXML;
        codificatorXML = new XMLEncoder(new FileOutputStream(routeFile));
        codificatorXML.writeObject(object);
        codificatorXML.close();

    }
}
