package projeto.spring.data.aula.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String tipo;
	
	@Column(nullable = false)
	private String numero;
	
	@ManyToOne(optional = false)
	private UsuarioSpringData usuarioSpringData; // mapear em usuarioSpringData -> @OneToMany(mappedBy = "usuarioSpringData")
	                                            // mapear em usuarioSpringData -> private List<Telefone> telefones;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UsuarioSpringData getUsuarioSpringData() {
		return usuarioSpringData;
	}

	public void setUsuarioSpringData(UsuarioSpringData usuarioSpringData) {
		this.usuarioSpringData = usuarioSpringData;
	}
	
	

}
