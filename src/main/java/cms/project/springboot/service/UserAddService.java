package cms.project.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.project.springboot.dao.userDao;
import cms.project.springboot.model.PersonForm;
@Service
public class UserAddService {
@Autowired
userDao user;
	public void addNewUser(PersonForm personForm) {
		personForm.setRole("user");
        personForm.setEnabled(true);
        user.save(personForm);
		
	}

}
