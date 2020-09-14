package education.cursor.movies.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/movie/**").hasRole("USER")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/movie").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/movie/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/movie/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/movie/**").hasRole("ADMIN")
                .and()
                .formLogin().disable();
    }
}