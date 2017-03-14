package cms.project.springboot.test.service;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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

import cms.project.springboot.dao.userDao;
import cms.project.springboot.main.Application;
import cms.project.springboot.model.PersonForm;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=Application.class)
public class UserAddServiceTest {

	@Autowired
	userDao user;
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	@Before
	public void setup() {
		mvc =  MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
@Test
public void testAddition(){
	try {
		mvc.perform(get("/registration"))
		.andExpect(new ResultMatcher() {

			@Override
			public void match(MvcResult result) throws Exception {

				MockHttpServletResponse response = result.getResponse();
				String s = response.getContentAsString();
				assert(s).contains("Registration Form");
			}
			});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
public void testAdditionofUser(){
	PersonForm personForm= new PersonForm();
	personForm.setEmail("user1@gmail.com");
	personForm.setEnabled(true);
	personForm.setRole("user");
	personForm.setUsername("user1");
	personForm.setPassword("password");
	user.save(personForm);
	try {
		mvc.perform(get("/landingpage").with(user("user1").password("password").roles("user")))
		.andExpect(new ResultMatcher() {

			@Override
			public void match(MvcResult result) throws Exception {

				MockHttpServletResponse response = result.getResponse();
				String s = response.getContentAsString();
				assert(s).contains("Hello user1");
			}
			});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
