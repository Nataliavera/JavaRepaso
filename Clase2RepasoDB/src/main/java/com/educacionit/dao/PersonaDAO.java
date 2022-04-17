package com.educacionit.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.educacionit.database.Conexion;
import com.educacionit.modelos.PersonaVO;

//CENTRALIZAR LOGICA DE ACCESO A DATOS 
//	CLASE QUE PERMITE EL ACCESO A DAROS 
public class PersonaDAO {

	public void registarPersona(PersonaVO miPersona) {
		Conexion conex = new Conexion();

		try {
//			EL OBJETO ESTATUTO ME SIRVE PARA PROCESAR SENTENCIAL SQL Y OBTENER LOS RESULTADOS DE LA MISMA 
			Statement estatuto = conex.getConnection().createStatement();// o new Statement(argumentos)
			estatuto.execute("INSERT INTO persona (nombre,edad,profesion,telefono)VALUES ('"+miPersona.getNombre()+"','"+ miPersona.getEdad()+"','"+miPersona.getProfesion()+"','"+miPersona.getTelefono()+"')");
			JOptionPane.showMessageDialog(null, "Se ha resgistrado existosamente a "+miPersona.getNombre(), "Informacion ", JOptionPane.INFORMATION_MESSAGE);
			
			estatuto.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo registrar a "+miPersona.getNombre());
		}finally {
			try {
				conex.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
