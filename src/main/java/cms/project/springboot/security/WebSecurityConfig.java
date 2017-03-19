package cms.project.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
<<<<<<< HEAD
        .antMatchers("/registration","/registrationsucess","/landingpagepostcomment","file:///D://tempFiles//PerfMonOutput.jpg").permitAll()
=======
        .antMatchers("/registration","/registrationsucess","/landingpagepostcomment","/file.*?").permitAll()
>>>>>>> 457256ae3529d4a9f03dcdcf1ee5cd4ca22e503a
        .antMatchers("/adminlandingpage").hasRole("admin") 
        .antMatchers("/landingpage").authenticated()
        .and()
    .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
    .logout()
        .permitAll();
  
    }
   
    

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("admin");
                auth.inMemoryAuthentication().withUser("user").password("password").roles("user");
                auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                		   "select username,password, enabled from user where username=?")
                		  .authoritiesByUsernameQuery(
                		   "select username, role from user where username=?");
    }
    @Override
    public void configure(WebSecurity security){
<<<<<<< HEAD
        security.ignoring().antMatchers("/css/**","/fonts/**","/js/**","file:///D://tempFiles//PerfMonOutput.jpg");
=======
        security.ignoring().antMatchers("/css/**","/fonts/**","/js/**","file.*?");
>>>>>>> 457256ae3529d4a9f03dcdcf1ee5cd4ca22e503a
        
 
}
}