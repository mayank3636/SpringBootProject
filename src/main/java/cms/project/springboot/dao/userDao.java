package cms.project.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import cms.project.springboot.model.PersonForm;

public interface userDao extends CrudRepository<PersonForm, Integer> {

}
