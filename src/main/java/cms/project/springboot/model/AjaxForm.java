package cms.project.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxForm {
@JsonProperty("comment")
String comment;
@JsonProperty("id")
int id;
@Override
public String toString() {
	return "AjaxForm [comment=" + comment + ", id=" + id + ", statusText=" + statusText + ", imageName=" + imageName
			+ ", videoName=" + videoName + ", userName=" + userName + "]";
}
public AjaxForm(String comment, int id, String statusText, String imageName, String videoName, String userName) {
	super();
	this.comment = comment;
	this.id = id;
	this.statusText = statusText;
	this.imageName = imageName;
	this.videoName = videoName;
	this.userName = userName;
}
@JsonProperty("statusText")
String statusText;
@JsonProperty("imageName")
String imageName;
@JsonProperty("videoName")
String videoName;
@JsonProperty("userName")
String userName;
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatusText() {
	return statusText;
}
public void setStatusText(String statusText) {
	this.statusText = statusText;
}
public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	this.imageName = imageName;
}
public String getVideoName() {
	return videoName;
}
public void setVideoName(String videoName) {
	this.videoName = videoName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public AjaxForm() {
	super();
	// TODO Auto-generated constructor stub
}

}
