package ua.nic.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ua.nic.util.serialization.custom.LocalDateTimeDeserializer;
import ua.nic.util.serialization.custom.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
)
public class Author {
	private int id;
	private String firstName;
	private String lastName;
	private LocalDateTime birth;
	private LocalDateTime createdDate;
	private String email;

	private List<Book> books;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "birth")
	public LocalDateTime getBirth() {
		return birth;
	}

	public void setBirth(LocalDateTime birth) {
		this.birth = birth;
	}

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize( using = LocalDateTimeDeserializer.class)
	@Column(name = "created_date")
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "books_authors",
			joinColumns = { @JoinColumn(name = "author_id") },
			inverseJoinColumns = { @JoinColumn(name = "books_id") }
	)
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Author author = (Author) o;
		return id == author.id && firstName.equals(author.firstName) && lastName.equals(author.lastName) && birth.equals(author.birth) && email.equals(author.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, birth, email);
	}

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birth=" + birth +
				", createdDate=" + createdDate +
				", email='" + email + '\'' +
				", books=" + books +
				'}';
	}
}
