import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    private final String SEPARADOR = ";";
    public static ArrayList<String[]> preguntas = new ArrayList<String[]>();    

    public void leerArchivo(String nombreArchivo) throws IOException {        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nombreArchivo));
            String linea = br.readLine();
            while (null != linea) {
                preguntas.add(linea.split(SEPARADOR));                
                linea = br.readLine();
                //System.out.println(Arrays.toString(preguntas.get(preguntas.size()-1)));
            }
        } catch (IOException e) {                      
      } finally {
         if (null != br) {
                br.close();
            }
        }
    }
}
