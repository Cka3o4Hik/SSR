package ua.nic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "publishers")
public class Publisher implements Serializable {
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "city")
	private String city;

	public Publisher(Long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Publisher() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Publisher publisher = (Publisher) o;
		return Objects.equals(id, publisher.id) && Objects.equals(name, publisher.name) && Objects.equals(city, publisher.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, city);
	}

	@Override
	public String toString() {
		return "Publisher{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
