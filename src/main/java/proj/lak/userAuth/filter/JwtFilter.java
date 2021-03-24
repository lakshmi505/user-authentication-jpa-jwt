package proj.lak.userAuth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import proj.lak.userAuth.service.UsrDetailsService;
import proj.lak.userAuth.util.JwtUtil;

/**
 * @author LAKSHMI
 */
@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtill;
	
	@Autowired
	private UsrDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String autherizationHeader = request.getHeader("Authorization");
		String token = null;
		String username=null;
		if(autherizationHeader !=null && autherizationHeader.startsWith("Bearer"))
		{
			token = autherizationHeader.substring(7);
			username = jwtUtill.extractUsername(token);
		}
			if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null)
			{
				UserDetails userDetails = service.loadUserByUsername(username);
				
				if (jwtUtill.validateToken(token, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			filterChain.doFilter(request, response);
			}

}
