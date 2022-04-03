package mundo;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public final class TipoEnemigoFactory {

	static Map<String, TipoEnemigo> tipoEnemigo = new HashMap<>();

	public static TipoEnemigo getTipoEnemigo(Enemigo enemigo) {
		TipoEnemigo result = tipoEnemigo.get(enemigo.getClass().getSimpleName()+"-"+enemigo.getEstadoActual()+"-"+enemigo.getFrameActual());
		if(result == null) {
			Formatter formato = new Formatter();
			String url = "/img/" + enemigo.getClass().getSimpleName() + "/" + enemigo.getEstadoActual() + "/" + formato.format("%02d",enemigo.getFrameActual()) + ".png";
			Image img = Toolkit.getDefaultToolkit().getImage(enemigo.getClass().getResource(url));
			result = new TipoEnemigo(img);
			tipoEnemigo.put(enemigo.getClass().getSimpleName()+"-"+enemigo.getEstadoActual()+"-"+enemigo.getFrameActual(), result);
		}
		return result;
	}

}