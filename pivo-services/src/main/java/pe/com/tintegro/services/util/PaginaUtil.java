package pe.com.tintegro.services.util;

import java.util.ArrayList;
import java.util.List;

import pe.com.tintegro.dominio.Pagina;

public class PaginaUtil {
	public List<Pagina> procesarData(List<Pagina> data) {

		List<Pagina> opcionList = data;
		List<Pagina> opcionRelacionadoList = new ArrayList<Pagina>();
		for (Pagina opcion : opcionList) {
			if (opcion.getIdPadre() == 0) {
				Pagina encontrado = null;
				encontrado = buscarOpcionHijo(data, opcion.getIdPagina(), opcion);
				opcionRelacionadoList.add(encontrado);
			}
		}

		return opcionRelacionadoList;
	}

	public Pagina buscarOpcionHijo(List<Pagina> data, Integer idOpcionPadre, Pagina opcionPadre) {
		List<Pagina> opcionList = data;

		for (Pagina opcion : opcionList) {
			if (opcion.getIdPadre() != 0) {
				// System.out.println("Es "+opcion.getIdOpcionPadre()+" == "+idOpcionPadre+"
				// ?");
				if (opcion.getIdPadre() != 0 && idOpcionPadre != 0) {
					if (opcion.getIdPadre().equals(idOpcionPadre)) {
						if (opcionPadre.getListHijos() == null) {
							opcionPadre.setListHijos(new ArrayList<Pagina>());
						}
						opcionPadre.getListHijos().add(opcion);
						if (opcion.isSeleccionado()) {
							opcionPadre.getListHijosSeleccionado().add(opcion.getIdPagina());
						}
						// System.out.println("El padre "+opcionPadre.getIdPagina()+" ha agregado al
						// hijo" + opcion.getIdPagina()+" "+opcion.isSeleccionado());
						if (opcion != null) {
							buscarOpcionHijo(data, opcion.getIdPagina(), opcion);
						}

					}
				}
			}
		}

		return opcionPadre;
	}

	public static List<Pagina> interseccion(List<Pagina> paginas1, List<Pagina> paginas2) {
		List<Pagina> mostrar = new ArrayList<Pagina>();
		mostrar.clear();
		List<Pagina> listaBase = (paginas1.size() > paginas2.size()) ? paginas1 : paginas2;
		for (int i = 0; i < listaBase.size(); i++) {
			if (existeIdPagina(paginas1, listaBase.get(i).getIdPagina())
					&& existeIdPagina(paginas2, listaBase.get(i).getIdPagina())) {
				listaBase.get(i).setSeleccionado(true);
				// mostrar.add(interseccion.get(i));
			}
		}

		return listaBase;
	}

	public static boolean existeIdPagina(List<Pagina> paginas, Integer idPagina) {
		boolean valida = false;
		for (int i = 0; i < paginas.size(); i++) {
			if (paginas.get(i).getIdPagina() == idPagina) {
				valida = true;
				break;
			}
		}
		return valida;
	}
}
