package calculos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaSepararStockDiario;

/**
 * 
 * Esta clase sirve para controlar el menú de la pantalla de inicio
 * 
 * @author pablofernandezmartinez
 *
 */
public class AccionesBotonesMenuInicio implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String texto_boton_pulsado = arg0.getActionCommand();

		switch (texto_boton_pulsado) {
		case "Eliminar secciones del fichero de stock diario":
			VentanaSepararStockDiario frame = new VentanaSepararStockDiario();
			frame.setVisible(true);
			System.out.println(arg0.getActionCommand());
			
			break;

		case "Calcular el stock previsto":
			System.out.println(arg0.getActionCommand());
			break;

		case "Calcular secciones por replanificar":
			System.out.println(arg0.getActionCommand());
			break;

		case "Salir":
			System.out.println(arg0.getActionCommand());
			System.exit(0);
			
			
			break;

		default:
			break;
		}

	}

}
