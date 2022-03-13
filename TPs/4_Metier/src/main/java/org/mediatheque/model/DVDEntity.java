package org.mediatheque.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.openapitools.model.CD;
import org.openapitools.model.DVD;
import org.openapitools.model.Media;

import lombok.Data;

/**
 * The persistent class for the DVD database table.
 *
 */

@Entity
@Data
@Table(name="dvd")
@PrimaryKeyJoinColumn(name="idMedia")
public class DVDEntity  extends MediaEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, length=45)
	private String realisateur;
	private Integer duree;

	@Override
	public Media asDto() {
		Media ret = super.asDto();
		DVD dvd = new DVD();
		dvd.setRealisateur(realisateur);
		dvd.setDuree(duree);
		return ret;
	}
}
