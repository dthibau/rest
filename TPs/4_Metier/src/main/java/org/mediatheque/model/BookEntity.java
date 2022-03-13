package org.mediatheque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.openapitools.model.Book;
import org.openapitools.model.Media;

import lombok.Data;

/**
 * The persistent class for the Livre database table.
 *
 */

@Entity
@Data
@Table(name="book")
@PrimaryKeyJoinColumn(name="idMedia")
public class BookEntity extends MediaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, length=45)
	private String ecrivain;
	@Column(nullable=false, length=45)
	private String ISBN;
	
	@Override
	public Media asDto() {
		Media ret = super.asDto();
		Book book = new Book();
		book.setAuteur(ecrivain);
		book.setIsbn(ISBN);
		ret.setBook(book);
		return ret;
	}

	
}
