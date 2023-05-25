public class Hilo extends Thread {
    private Archivo datos;    
    private String respuesta;
    private int contador;
    
    public Hilo(Archivo datos) {
        this.datos = datos;
        this.contador = 0;
        this.respuesta = "";
    }
    
    public void setRespuesta(String respuesta){
        this.respuesta = respuesta;        
    }

    @Override
    public void run() {
        String preguntaActual, respuestaActual, historia;
        while (true) {
            try {        
                if (contador >= datos.preguntas.size()){
                    MainJFrame.jtaHistorial.append("\nCompleted questionnaire");
                    MainJFrame.jlPregunta.setText("Completed questionnaire");
                    break;
                }
                preguntaActual = datos.preguntas.get(contador)[0];
                respuestaActual = datos.preguntas.get(contador)[1];
                MainJFrame.jlPregunta.setText(preguntaActual + " ___________");
                Thread.sleep(500);
                
                if(!"".equals(respuesta)){                    
                    historia = "\n\nYou: " + preguntaActual + " " + respuesta.toLowerCase();
                    if(respuesta.toLowerCase().equals(respuestaActual))
                        historia += "\nBOT: Your answer is correct :)";
                    else {
                        historia += "\nBOT: Your answer is not correct :(";
                        historia += "\nBOT: The correct answer is";
                        historia += "\nBOT: " + preguntaActual + " " + respuestaActual;
                    }
                    MainJFrame.jtaHistorial.append(historia);
                    respuesta = "";                    
                    contador ++;
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
