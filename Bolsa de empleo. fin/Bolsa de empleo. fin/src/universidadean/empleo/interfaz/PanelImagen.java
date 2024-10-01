

package universidadean.empleo.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Es el panel donde se muestra una imagen decorativa
 */
public class PanelImagen extends JPanel {

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Imagen del titulo
     */
    private JLabel imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    Color amarilloPastel = new Color(255, 255, 204);
    /**
     * Constructor del panel
     */
    public PanelImagen() {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        //
        // Carga la imagen
        ImageIcon icono = new ImageIcon("data/titulo.png");

        // La agrega a la etiqueta
        imagen = new JLabel("");
        imagen.setIcon(icono);
        imagen.setBackground(amarilloPastel);
        add(imagen);
        //
        // Color de fondo blanco
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
    }
}