package cms.project.springboot.test.mockMvc;


import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cms.project.springboot.controller.LoginController;
import cms.project.springboot.main.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=Application.class)
@Transactional
public class BrowseFeedsTest {
	@LocalServerPort
    private int port;
	BrowseFeedsTestImpl authenticationEntryPoint;


    private LoginController controller;

@Before
public void setUp() {
    authenticationEntryPoint = new BrowseFeedsTestImpl();
}

@Test
public void commence() throws IOException, ServletException {
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    AuthenticationException ex = new AuthenticationCredentialsNotFoundException("");

    authenticationEntryPoint.commence(request, response, ex);
    assertEquals(HttpServletResponse.SC_UNAUTHORIZED, response.getStatus());
}

	

}
