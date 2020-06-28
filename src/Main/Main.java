package Main;

import Vista.*;
import Controlador.*;
import Modelo.*;

public class Main {

    public static void main(String[] args) {
        VentanaBienvenida miV = new VentanaBienvenida();
        miV.setVisible(true);
    }
    
    public void empezarAplicacion(){
        ControladorPrincipal miControl = new ControladorPrincipal();
        VentanaGrafo miVentana = new VentanaGrafo(miControl);
        miVentana.inicializarVentana();
        miVentana.setVisible(true);
    }

}
