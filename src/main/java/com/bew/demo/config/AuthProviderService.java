package com.bew.demo.config;

import com.bew.demo.dao.UsuarioRepository;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AuthProviderService implements AuthenticationProvider {

    private static final Logger logger = LogManager.getLogger(AuthProviderService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        String login = auth.getName();
        String password = DigestUtils.md5DigestAsHex(auth.getCredentials().toString().getBytes());
        Usuario usuario = null;
        try {
            usuario = usuarioRepository.findByEmail(login).orElseThrow(() -> new EmptyResultException("Sin Resultados"));
        } catch (EmptyResultException e) {

            throw new UsernameNotFoundException("Usuario o Contraseña no validos");
        }

        if (usuario.getPassword().equals(password)) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if(usuario.getTipoUsuario()){
                authorities.add(new SimpleGrantedAuthority("ADMIN"));
            }else {
                authorities.add(new SimpleGrantedAuthority("USER"));
            }
            return new UsernamePasswordAuthenticationToken(usuario, password, authorities);

        } else {
            throw new UsernameNotFoundException("Usuario o Contraseña no validos");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
         return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}