/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greip.api.util.common;

import java.util.ArrayList;
import java.util.List;

public class UtlArray {

	public static String concatenarLista(List<String> lst) {
		String cadena = "";
		for (String s : lst) {
			cadena += s;
		}
		return cadena;
	}

	public static Integer findString(List<String> findArray, String stringSearch){
		int result = -1;
		int cant = 0;
		for(String stringFounded : findArray){
			if(findArray.get(cant).equals(stringSearch)){
				result = cant;
			}
			cant++;
		}
		return result;
	}
	
	public static <E> List<E> toList(Iterable<E> iterable) {
		if (iterable instanceof List) {
			return (List<E>) iterable;
		}
		ArrayList<E> list = new ArrayList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}
}
