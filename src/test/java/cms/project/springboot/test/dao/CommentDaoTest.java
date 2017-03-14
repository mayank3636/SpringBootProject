package cms.project.springboot.test.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import cms.project.springboot.dao.CommentDao;
import cms.project.springboot.main.Application;
import cms.project.springboot.model.Comments;
import cms.project.springboot.model.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@DataJpaTest
public class CommentDaoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CommentDao repository;
	
	@Test
	public void testInsertionOfComment(){
           Comments c= new Comments();
           c.setComments("HIIII");
           c.setPost(null);
           c.setUsername("ABC");
           c.setId(1);
           this.entityManager.merge(c);
	        
		 Comments user = this.repository.findOne(1);
	      assertThat(user.getComments()).isEqualTo("HIIII");
	        assertThat(user.getUsername()).isEqualTo("ABC");
	}
}
