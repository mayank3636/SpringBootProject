package cms.project.springboot.test.mockMvc;
 
 import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
 
 public class BrowseFeedsTestImpl extends BrowseFeedsTest{
 
 	
     public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
         response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
     }
 }