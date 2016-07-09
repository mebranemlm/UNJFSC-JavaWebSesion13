package dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import Utilitarios.Conexion;
import model.jpa.Usuario;
import dao.local.UsuarioDAOLocal;

public class UsuarioDAOImpl implements UsuarioDAOLocal
{
	Conexion cn=new Conexion();	
	@Override
	public Usuario validarUsuario(Usuario obj) throws Exception 
	{
		cn.abrir();
		Usuario objusu=new Usuario();
		try 
		{			
			Query q1=cn.em.createQuery("select a from Usuario a where a.usuario= :p1 and a.clave=:p2");
			q1.setParameter("p1", obj.getUsuario());
			q1.setParameter("p2", obj.getClave());
			List<Usuario>lista1=q1.getResultList();
			for (Usuario usuario : lista1) {
				objusu=lista1.get(0);
			}			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return objusu;
	}
	@Override
	public Usuario buscarUsuario(Usuario obj) throws Exception {
		cn.abrir();
		Usuario objusu=new Usuario();
		try 
		{
			objusu=cn.em.find(Usuario.class, obj.getUsuario());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return objusu;
	}
	
	@Override
	public void agregarUsuario(Usuario obj) throws Exception {
		cn.abrir();
		Usuario objusu=new Usuario();
		try 
		{
			objusu.setUsuario(obj.getUsuario());
			objusu.setClave(obj.getClave());
			objusu.setEstado(obj.getEstado());
			objusu.setF_registro(obj.getF_registro());
			cn.em.getTransaction().begin();
			cn.em.persist(objusu);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	@Override
	public List<Usuario> buscarListaUsuario(Usuario obj) throws Exception 
	{
		cn.abrir();
		List<Usuario>lista1=null;
		try 
		{
			//Query q1=cn.em.createQuery("select a from Usuario a where a.usuario= :p1");
			//q1.setParameter("p1", obj.getUsuario());
			Query q1=cn.em.createQuery("select a from Usuario a where a.clave= :p1");
			q1.setParameter("p1", obj.getClave());
			lista1=q1.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return lista1;
	}
	@Override
	public void modificarUsuario(Usuario obj) throws Exception 
	{
		cn.abrir();
		Usuario objusu=new Usuario();
		try 
		{
			objusu.setUsuario(obj.getUsuario());
			objusu.setClave(obj.getClave());
			objusu.setEstado(obj.getEstado());
			objusu.setF_registro(obj.getF_registro());
			cn.em.getTransaction().begin();
			cn.em.merge(objusu);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
	}
	@Override
	public void eliminarUsuario(Usuario obj) throws Exception 
	{
		cn.abrir();
		Usuario objusu=new Usuario();
		try 
		{
			objusu=cn.em.find(Usuario.class, obj.getUsuario());
			cn.em.getTransaction().begin();
			cn.em.remove(objusu);
			cn.em.getTransaction().commit();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
	}
}
