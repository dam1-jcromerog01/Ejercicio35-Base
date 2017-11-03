import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener{

	private VentanaPrincipal ventana;
	private int posX;
	private int posY;

	public ActionBoton(VentanaPrincipal v, int x, int y) {
		ventana = v;
		posX = x;
		posY = y;
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (ventana.getJuego().abrirCasilla(posX, posY))
		{
			ventana.mostrarFinJuego(true);
		}
		else
		{
			if (ventana.getJuego().esFinJuego())
			{
				ventana.mostrarFinJuego(false);
			}
			else
			{
				ventana.mostrarNumMinasAlrededor(posX, posY);
				ventana.actualizarPuntuacion();
				ventana.refrescarPantalla();
			}
		}
	}

}
