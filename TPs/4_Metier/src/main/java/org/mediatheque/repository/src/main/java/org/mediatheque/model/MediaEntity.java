package org.mediatheque.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.openapitools.model.Media;

import lombok.Data;

/**
 * The persistent class for the Mediatheque database table.
 * La stratégie JOINED permet de représenter en base de données
 *  un héritage avec une table par entité
 *
 */

@Entity
@Data
@Table(name="media")
@Inheritance(strategy = InheritanceType.JOINED)
public class MediaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(nullable=false, length=45)
	private String titre;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_parution;
	

	public Media asDto() {
		Media ret = new Media();
		ret.setTitre(titre);
		ret.setDateParution(date_parution.toString());
		return ret;
	}
}
