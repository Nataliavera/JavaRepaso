package com.educacionit.programa;

import javax.swing.JOptionPane;

import com.educacionit.dao.PersonaDAO;
import com.educacionit.modelos.PersonaVO;

public class AppPrincipal {

	public static void main(String[] args) {

		PersonaVO p1 = new PersonaVO("Alex",27, "Profesor", 213141413);
		
		PersonaDAO pdao = new PersonaDAO();
		pdao.registarPersona(p1);
		
		int opcion; 
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion deseada: \n 1) Agregar persona \n 2) Borrar persona"));
			switch (opcion) {
			case 1:
				JOptionPane.showMessageDialog(null, "Ingrese la opcion 1");
//				PEDIR LOS DATOS PARA CARGAR UN OBJETO PERSONA 
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Ingrese la opcion 2");
//				PEDIR UN ID PARA BORRAR UUN OBJETO PERSONA (VALIDAR QUE EL ID EXISTA EN LA DB)
				break;	
			default:
				break;
			}
			
		}while(opcion != 1 && opcion !=2);
		
	}

}
