package code.app.books.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails david = User.builder()
//                .username("david")
//                .password("{noop}david")
//                .roles("USER")
//                .build();
//
//        UserDetails robert = User.builder()
//                .username("robert")
//                .password("{noop}robert")
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(david, robert);
//    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager
                .setUsersByUsernameQuery("SELECT username, password, enabled FROM users where username=?");


        jdbcUserDetailsManager
                .setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities where username=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/books", "/books/reviews/**", "/registerUser", "/h2-console/**").permitAll()
                        .requestMatchers("/books/showAddReviewForm").hasRole("USER")
                        .requestMatchers("/books/addReview").hasRole("USER")
                        .requestMatchers("/books/showAddBookForm").hasRole("ADMIN")
                        .requestMatchers("/books/addBook").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )

                .exceptionHandling(
                        configure ->
                                configure.accessDeniedPage("/access-denied")
                )
                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                                .defaultSuccessUrl("/books", true)
                )

                .logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }

}
