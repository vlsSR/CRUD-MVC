import controlador.ControladorPersona;
import modelo.ConsultsPersons;
import modelo.Persona;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        Persona persona = new Persona();
        ConsultsPersons modelo = new ConsultsPersons();
        ControladorPersona controlador = new ControladorPersona(vista,persona,modelo);

        controlador.start();
    }
}