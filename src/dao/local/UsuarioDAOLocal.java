package dao.local;

import java.util.List;

import model.jpa.Usuario;

public interface UsuarioDAOLocal 
{
	//Metodo para validarLogin, con parametro de entrada xxxxx
	public abstract Usuario validarUsuario(Usuario obj) throws Exception;
	public abstract Usuario buscarUsuario(Usuario obj) throws Exception;
	public abstract void agregarUsuario(Usuario obj) throws Exception;
	public abstract void modificarUsuario(Usuario obj) throws Exception;
	public abstract List<Usuario> buscarListaUsuario(Usuario obj) throws Exception;
	public abstract void eliminarUsuario(Usuario obj) throws Exception;
	//registrar
	//...ncosas	
}
