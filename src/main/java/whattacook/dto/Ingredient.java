package whattacook.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ingredient")
public class Ingredient {
	
	@Id
	@Column(name="id_ingredient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "isMadeWith")
	private Set<Recipe> isUsedIn;

	public Ingredient() {
	}

	public Ingredient(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Recipe> getIsUsedIn() {
		return isUsedIn;
	}

	public void setIsUsedIn(Set<Recipe> isUsedIn) {
		this.isUsedIn = isUsedIn;
	}	
	
}

