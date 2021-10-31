package ua.nic.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.CreationTimestamp;
import ua.nic.util.serialization.custom.LocalDateTimeDeserializer;
import ua.nic.util.serialization.custom.LocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
)
public class Book implements Serializable {
	private Long id;
	private String name;
	private String series;
	private Long isbn;

	private LocalDateTime createdDate;
	private Publisher publisher;
	private Set<Author> authors;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "series")
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(name = "isbn")
	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}


	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@CreationTimestamp
	@Column(name = "created_date")
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@OneToOne
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(series, book.series) && Objects.equals(isbn, book.isbn) && Objects.equals(createdDate, book.createdDate) && Objects.equals(publisher, book.publisher) && Objects.equals(authors, book.authors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, series, isbn, createdDate, publisher, authors);
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", name='" + name + '\'' +
				", series='" + series + '\'' +
				", isbn=" + isbn +
				", createdDate=" + createdDate +
				", publisher=" + publisher +
				", authors=" + authors +
				'}';
	}
}
