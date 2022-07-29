/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ec.edu.uide.plantilla;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;


@SpringBootApplication
public class Plantilla {

    public static void main(String[] args) {
        SpringApplication.run(Plantilla.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .cors().configurationSource(
                            request -> {
                                CorsConfiguration cors = new CorsConfiguration();
                                cors.setAllowedMethods(
                                        Arrays.asList(
                                                HttpMethod.GET.name(),
                                                HttpMethod.POST.name()
                                        ));
                                cors.applyPermitDefaultValues();
                                return cors;
                            }).and()
                   
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/**").permitAll()
//                    .antMatchers(HttpMethod.POST, "/partidos/*").permitAll()
//                    .antMatchers(HttpMethod.GET, "/partidos/*").permitAll()
//                    .antMatchers(HttpMethod.POST, "/equipos/*").permitAll()
//                    .antMatchers(HttpMethod.GET, "/equipos/*").permitAll()
//                    .antMatchers(HttpMethod.POST, "/personas/*").permitAll()
//                    .antMatchers(HttpMethod.GET, "/personas/*").permitAll()
////                    .antMatchers(HttpMethod.POST, "/autentication/login").permitAll()
////                   .antMatchers(HttpMethod.POST, "/autentication/registrar").permitAll()
////                    .antMatchers(HttpMethod.POST, "/autentication/disponible").hasAuthority(ADMINISTRADOR.name())
//                   .mvcMatchers(HttpMethod.OPTIONS, "/**").denyAll()
//                    .mvcMatchers(HttpMethod.PUT, "/**").denyAll()
//                    .mvcMatchers(HttpMethod.DELETE, "/**").denyAll()
//                    .mvcMatchers(HttpMethod.PATCH, "/**").denyAll()
//                    .mvcMatchers(HttpMethod.HEAD, "/**").denyAll()
//                   .mvcMatchers(HttpMethod.TRACE, "/**").denyAll()
//                   .mvcMatchers(HttpMethod.GET, "/**").denyAll()
                    .anyRequest().authenticated()
                    .and().headers().xssProtection()
                    .and().cacheControl()
                    .and().contentTypeOptions()
                    .and().httpStrictTransportSecurity()
                    .includeSubDomains(true).maxAgeInSeconds(31536000)
                    .and().frameOptions().sameOrigin()
                    .addHeaderWriter(
                            new StaticHeadersWriter("X-Content-Security-Policy",
                                    "script-src 'self'"))
                    .addHeaderWriter(
                            new XFrameOptionsHeaderWriter(
                                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                    .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.SAME_ORIGIN);
        }

    }
}
