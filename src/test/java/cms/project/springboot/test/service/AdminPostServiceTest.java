package cms.project.springboot.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cms.project.springboot.main.Application;
import cms.project.springboot.model.Comments;
import cms.project.springboot.model.Post;
import cms.project.springboot.service.AdminPostService;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class AdminPostServiceTest {
	@Autowired
	AdminPostService postservice;
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc =  MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
		Post p = new Post();
		p.setImageName("null");
		p.setVideoName("null");
		p.setStatusText("Post Test");
		List<Comments> comm= new ArrayList<Comments>();
		Comments c= new Comments();
		c.setPost(p);
		c.setUsername("abxc");
		c.setComments("Test Comment");
		comm.add(c);
		p.setComments(comm);
	postservice.savePost(p, null);
	}
@Test
public void landingPage(){
	try {
		mvc
		.perform(get("/landingpage").with(user("admin").password("admin").roles("ADMIN")))
		.andExpect(new ResultMatcher() {

			@Override
			public void match(MvcResult result) throws Exception {

				MockHttpServletResponse response = result.getResponse();
				String s = response.getContentAsString();
				assertThat(s,notNullValue());
			}
			});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
public void checkValue(){
	try {
		mvc
		.perform(get("/landingpage").with(user("admin").password("admin").roles("ADMIN")))
		.andExpect(new ResultMatcher() {

			@Override
			public void match(MvcResult result) throws Exception {

				MockHttpServletResponse response = result.getResponse();
				String s = response.getContentAsString();
				assertThat(s).contains("Post Test");
				//Assert.contains(s, CoreMatchers.containsString("Post Test"));
			}
			});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
