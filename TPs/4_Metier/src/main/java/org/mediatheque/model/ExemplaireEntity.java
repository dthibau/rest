package org.mediatheque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.openapitools.model.Emprunt;
import org.openapitools.model.Exemplaire;

import lombok.Data;

@Entity
@Table(name = "exemplaire")
@Data
public class ExemplaireEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dateEntree;
	
	@ManyToOne
	private MediaEntity media;
	
	@ManyToOne
	@JoinTable(name = "emprunt_exemplaires", joinColumns = @JoinColumn(name="id_exemplaire")
	, inverseJoinColumns = @JoinColumn(name="id_emprunt"))
	private EmpruntEntity emprunt;
	
	public Exemplaire asDto() {
		Exemplaire ret = new Exemplaire();
		ret.setDateEntree(dateEntree.toString());
		ret.setMedia(media.asDto());
		
		return ret;
	}
	
	@Override
	public String toString() {
		return "ExemplaireEntity [id=" + id + ", dateEntree=" + dateEntree + "]";
	}
}
