package com.anncode.amazonviewer.model;

import java.util.Date;


public interface IVisualizable {
	/**
	 * Este metodo captura el tiempo
	 * de inicio de visualizacion
	 * @param dateI es un objeto {@code Date} con el
	 * tiempo de inicio exacto
	 * @return Devuelve la fecha y la hora capturada
	 * */
	
	Date startToSee(Date dateI);
	
	/**
	 * Este metodo captura el tiempo exacto de inicio y
	 * finalizacion de visualizacion
	 * @param dateI Es un objeto de tipo  {@code Date} con el tiempo de inicio
	 * @param dateF Es un objeto de tipo  {@code Date} con el tiempo de finalizacion
	 * */
	void stopToSee(Date dateI, Date dateF);
	
}
