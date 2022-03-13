package org.mediatheque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.openapitools.model.Emprunt;
import org.openapitools.model.Exemplaire;

import lombok.Data;

/**
 * The persistent class for the Emprunt database table.
  *
 */

@Entity
@Data
@Table(name="emprunt")
public class EmpruntEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date date_emprunt;
	@Temporal(TemporalType.DATE)
	private Date date_limite;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity user;

	
	//bi-directional many-to-one association to Media
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "emprunt")
	private List<ExemplaireEntity> exemplaires;

	public Emprunt asDto() {
		Emprunt ret = new Emprunt();
		ret.setDateEmprunt(date_emprunt.toString());
		ret.setDateRetour(date_limite.toString());
		List<Exemplaire> ex = new ArrayList<>();
		exemplaires.stream().forEach(e -> ex.add(e.asDto()));
		ret.setExemplaires(ex);
		
		return ret;
	}

}
