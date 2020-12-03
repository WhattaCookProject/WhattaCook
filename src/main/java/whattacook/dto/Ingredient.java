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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idingredient;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "isMadeWith")
	private Set<Recipe> isUsedIn;

	public Ingredient() {
	}

	public Ingredient(long idingredient, String name) {
		this.idingredient = idingredient;
		this.name = name;
	}

	public long getIdingredient() {
		return idingredient;
	}

	public void setIdingredient(long idingredient) {
		this.idingredient = idingredient;
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

