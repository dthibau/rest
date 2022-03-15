package org.mediatheque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.openapitools.model.CD;
import org.openapitools.model.Media;

import lombok.Data;

/**
 * The persistent class for the CD database table.
 * 
 * L’annotation @DiscriminatorValue permet de préciser
 *  la valeur dans la colonne discriminante qui permet d’identifier 
 *  un objet du type de cette classe.
 */

@Entity
@Data
@Table(name="cd")
@PrimaryKeyJoinColumn(name="idMedia")
public class CDEntity  extends MediaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, length=45)
	private String artiste;
	
	private Integer duree;
	
	private int nbTitres;

	@Override
	public Media asDto() {
		Media ret = super.asDto();
		CD cd = new CD();
		cd.setArtiste(artiste);
		cd.setDuree(duree);
		cd.setNbTitres(nbTitres);
		return ret;
	}
}
