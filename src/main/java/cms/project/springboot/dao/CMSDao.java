package cms.project.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cms.project.springboot.model.Post;
@Repository
public interface CMSDao extends CrudRepository<Post, Integer> {

}
