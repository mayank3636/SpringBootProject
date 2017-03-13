package cms.project.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import cms.project.springboot.model.Comments;

public interface CommentDao extends CrudRepository<Comments, Integer> {

}
