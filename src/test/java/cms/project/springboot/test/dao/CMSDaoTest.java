package cms.project.springboot.test.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cms.project.springboot.dao.CMSDao;
import cms.project.springboot.main.Application;
import cms.project.springboot.model.Comments;
import cms.project.springboot.model.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DataJpaTest
public class CMSDaoTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CMSDao repository;

	@Test
	public void testInsertionOfComment() {
		Post p = new Post();
		p.setComments(null);
		p.setId(1);
		p.setImageName("Test Image name");
		p.setVideoName("Test Video name");
		p.setStatusText("Mandatory");
		this.entityManager.merge(p);

		Post user = this.repository.findOne(1);
		assertThat(user.getImageName()).isEqualTo("Test Image name");
		assertThat(user.getVideoName()).isEqualTo("Test Video name");
		assertThat(user.getStatusText()).isEqualTo("Mandatory");
	}
}
