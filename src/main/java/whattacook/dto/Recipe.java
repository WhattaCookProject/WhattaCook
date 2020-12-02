package whattacook.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
	
	@Id
	@Column(name="idrecipe") //TODO modified from dev
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="text")
	private String text;
	
	@ManyToMany
	@JoinTable(
			  name = "recipe_ingredient", 
			  joinColumns = @JoinColumn(name = "idrecipe"), 
			  inverseJoinColumns = @JoinColumn(name = "idingredient"))
	private Set<Ingredient> isMadeWith;

	public Recipe() {}

	/*public Recipe(long id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}*/
	
	public Recipe(long id, String title, String text, Set<Ingredient> ing) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.isMadeWith = ing;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", text=" + text + "]";
	}
		
}
