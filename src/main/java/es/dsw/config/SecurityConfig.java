package es.dsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
/*import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	private static InMemoryUserDetailsManager InMemory;
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    
    			   
		   http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
					          .requestMatchers("/getAll","/getOne","/add").permitAll()
					          .requestMatchers("/autenticacion").hasRole("administrador") //Solo el usuario con roll administrador podrá obtener un token
					          .anyRequest().authenticated()
           )
			.httpBasic(withDefaults());
    			  
        return http.build();
    }
    
    @Bean
	InMemoryUserDetailsManager userDetailsService() {
	
		
    	
		@SuppressWarnings("deprecation")
		UserDetails user1 = User.withDefaultPasswordEncoder()
		    .username("admin") 
            .password("admin123")  
            .roles("administrador") 
            .build();
		
		
       
        InMemory = new InMemoryUserDetailsManager();
        
     
        InMemory.createUser(user1);
      
       
     
        return InMemory;
		
	}

    
}