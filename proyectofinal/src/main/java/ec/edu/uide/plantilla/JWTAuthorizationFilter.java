/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uide.plantilla;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author dante
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    public static final String AUTORIZATION = "Authorization";
    public static final String PERMISOS = "permisos";
    private static final String SIGNATURE_ERROR = "Error en la firma";

    public static final String BEARER = "Bearer";
    public static final String KEY_APP = "1029384756";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        if (request.getMethod().equals("OPTIONS")
                || request.getMethod().equals("DELETE")
                || request.getMethod().equals("PUT")
                || request.getMethod().equals("PATCH")
                || request.getMethod().equals("TRACK")
                || request.getMethod().equals("TRACE")
                || request.getMethod().equals("CONNECT")) {
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            try {
                if (existeJWTToken(request)) {
                    Claims claims = validateToken(request);
                    if (claims != null) {
                        setUpSpringAuthentication(claims);
                    } else {
                        SecurityContextHolder.clearContext();
                    }
                } else {
                    SecurityContextHolder.clearContext();
                }
                chain.doFilter(request, response);
            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_BAD_REQUEST, SIGNATURE_ERROR);
            }
        }
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(AUTORIZATION).replace(BEARER, "");
        return Jwts.parser().setSigningKey(KEY_APP.getBytes()).parseClaimsJws(jwtToken).getBody();
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     *
     * @param claims
     */
    private void setUpSpringAuthentication(Claims claims) {
        List<String> authorities = (List) claims.get(PERMISOS);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    private boolean existeJWTToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(AUTORIZATION);
        return !(authenticationHeader == null || !authenticationHeader.startsWith(BEARER));
    }
}
