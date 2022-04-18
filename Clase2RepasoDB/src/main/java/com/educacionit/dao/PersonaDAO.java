package com.educacionit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
			estatuto.execute("INSERT INTO persona (nombre,edad,profesion,telefono)VALUES ('" + miPersona.getNombre()
					+ "','" + miPersona.getEdad() + "','" + miPersona.getProfesion() + "','" + miPersona.getTelefono()
					+ "')");
			JOptionPane.showMessageDialog(null, "Se ha resgistrado existosamente a " + miPersona.getNombre(),
					"Informacion ", JOptionPane.INFORMATION_MESSAGE);

			estatuto.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo registrar a " + miPersona.getNombre());
		} finally {
			try {
				conex.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void eliminarPersona(Integer Id) {
		Conexion connection = new Conexion();

		if (Id != null) {
			try {
				if (validarExistencia(Id)) {
					Statement estatuto = connection.getConnection().createStatement();
					estatuto.execute("DELETE FROM persona WHERE Id =" + Id);
					JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el usuario", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"No se ha eliminado correctamente el usuario con el id: " + Id + " .No existe en la DB",
							"Informacion", JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se ejecutó validarExistencia con el Id: " + Id);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha eliminado correctamnete porque el ID es null", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public boolean validarExistencia(Integer Id) {
		Conexion connection = new Conexion();
		boolean encontrado = false;
		Statement estatuto = null;

		if (Id != null) {
			try {
				estatuto = connection.getConnection().createStatement();
				ResultSet resultSet = estatuto.executeQuery("SELECT count(*) FROM persona WHERE Id = " + Id);
// RESULTSET -> TODOS LOS REGISTROS QUE ENCUENTRA 
				if (resultSet.next()) {
					if (resultSet.getInt(1) > 0) {
						encontrado = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se ejecutó validarExistencia con el Id: " + Id);
			} finally {
				try {
					connection.getConnection().close();
					estatuto.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return encontrado;

	}
}
