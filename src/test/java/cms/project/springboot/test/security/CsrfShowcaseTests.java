package cms.project.springboot.test.security;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cms.project.springboot.main.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=Application.class)
public class CsrfShowcaseTests {

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
public void checkSecurity(){
	try {
		mvc
		.perform(post("/landingpage").with(csrf()))
.andExpect(unauthenticated());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
@Test
public void checkSecurityWithUser(){
	try {
		mvc
		.perform(get("/adminlandingpage").with(user("admin").password("admin").roles("ADMIN")))
		.andExpect(authenticated());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
public void formBasedSecurity(){
	try {
		mvc
		.perform(formLogin("/login").user("admin").password("admin"))
		.andExpect(authenticated());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
public void testLogin(){
	try {
		mvc
		.perform(formLogin().password("invalid"))
		.andExpect(unauthenticated());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
