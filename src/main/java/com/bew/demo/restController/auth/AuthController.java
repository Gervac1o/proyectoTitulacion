package com.bew.demo.restController.auth;

import com.bew.demo.dto.UsuarioDTO;
import com.bew.demo.exception.MailRepetidoException;
import com.bew.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsuarioService usuarioService;


    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(final UsuarioDTO user) throws IOException, MailRepetidoException {
        try {
            usuarioService.saveUsuario(user);
            return ResponseEntity.ok(user);
        } catch (MailRepetidoException e) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.TEXT_HTML);

            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.FORBIDDEN);
        }


    }

    @RequestMapping(value = "/validation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> validate(final UsuarioDTO user) throws IOException, MailRepetidoException {
        try {

            return ResponseEntity.ok(usuarioService.findByUser(user));
        } catch (Exception e) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.TEXT_HTML);

            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}