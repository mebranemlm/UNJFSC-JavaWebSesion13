package model.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_docente")
public class Docente 
{
	@Id
	private String id_docente;
	
	private String nombre,apellido;
	
	@Temporal(TemporalType.DATE)
	private Date f_registro;
	
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario tblUsuario;

	public String getId_docente() {
		return id_docente;
	}

	public void setId_docente(String id_docente) {
		this.id_docente = id_docente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getF_registro() {
		return f_registro;
	}

	public void setF_registro(Date f_registro) {
		this.f_registro = f_registro;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Usuario getTblUsuario() {
		return tblUsuario;
	}

	public void setTblUsuario(Usuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}
	
	

}
