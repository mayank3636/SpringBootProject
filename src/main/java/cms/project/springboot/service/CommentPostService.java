package cms.project.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.project.springboot.dao.CommentDao;
import cms.project.springboot.model.AjaxForm;
import cms.project.springboot.model.Comments;
import cms.project.springboot.model.Post;
@Service
public class CommentPostService {
@Autowired
CommentDao commentdao;
	public void commentAdd(AjaxForm payload) {
		Comments c= new Comments();
 		c.setComments(payload.getComment());		
 		Post p = new Post();
 		p.setId(payload.getId());
 		p.setImageName(payload.getImageName());
 		p.setStatusText(payload.getStatusText());
 		p.setVideoName(payload.getVideoName());
 		c.setPost(p);
 		c.setUsername(payload.getUserName());
 		commentdao.save(c);
		
	}

}
