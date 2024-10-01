
package universidadean.empleo.interfaz;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Es el panel que contiene los botones de extensi�n
 */
public class PanelExtension extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el bot�n 1
     */
    private final String OPCION_1 = "Salir";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    Color amarilloPastel = new Color(255, 255, 210);
    Color amarilloPastel2 = new Color(255, 255, 150);
    /**
     * Es la referencia a la interfaz de la aplicaci�n
     */
    private InterfazBolsaDeEmpleo principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el bot�n 1
     */
    private JButton botonOpcion1;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicaci�n <br>
     * <b>post: </b> Contruy� el panel y principal = interfaz <br>
     * @param interfaz - Referencia a la ventana principal - interfaz!=null
     */
    public PanelExtension(InterfazBolsaDeEmpleo interfaz) {
        principal = interfaz;
        inicializar();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los componentes del panel <br>
     * <b>post: </b> Se inicializaron y se ubicaron los componentes del panel <br>
     */
    private void inicializar() {
        setBorder(new TitledBorder("Opciones del programa"));

        setLayout(new FlowLayout());
        botonOpcion1 = new JButton("Salir");
        botonOpcion1.setActionCommand(OPCION_1);
        botonOpcion1.addActionListener(this);
        botonOpcion1.setBackground(amarilloPastel2); // Agregar esta línea

        add(botonOpcion1);
    }

    /**
     * Este m�todo se llama cuando se presiona uno de los botones
     * @param evento El evento del click en el bot�n. evento!=null
     */
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();
        if (OPCION_1.equals(comando)) {
            principal.reqFuncOpcion1();
        }
    }

}