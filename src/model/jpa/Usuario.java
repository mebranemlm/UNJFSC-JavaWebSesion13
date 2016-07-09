package model.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_usuario")

public class Usuario 
{
	@Id
	private String usuario;
	
	private String clave;
	
	@Temporal(TemporalType.DATE)
	@Column(name="f_regstro")
	private Date f_registro;
	
	private Integer estado;
	
	@OneToMany(mappedBy="tblUsuario")
	private List<Docente>tblDocentes;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public List<Docente> getTblDocentes() {
		return tblDocentes;
	}

	public void setTblDocentes(List<Docente> tblDocentes) {
		this.tblDocentes = tblDocentes;
	}
	
}
