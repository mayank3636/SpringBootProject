package cms.project.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="post")
public class Post {

	private int id;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotBlank(message="Please Enter Status this is Mandatory")
	private String statusText;
	private String imageName;
	private String videoName;
	private List<Comments> comments;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@Column(name="comments")
	public List<Comments> getComments() {
		return comments;
	}
	
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@Column(name="statusText")
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	@Column(name="imageName")
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Column(name="videoName")
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	public Post( String statusText, String imageName, String videoName, List<Comments> asa) {
		super();
		this.statusText = statusText;
		this.imageName = imageName;
		this.videoName = videoName;
		this.comments = asa;
	}
	public Post(){
		
	}
}
