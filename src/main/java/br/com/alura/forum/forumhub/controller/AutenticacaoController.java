package br.com.alura.forum.forumhub.controller;

import br.com.alura.forum.forumhub.Infra.security.DadosTokenJWT;
import br.com.alura.forum.forumhub.Infra.security.TokenService;
import br.com.alura.forum.forumhub.usuario.DadosAutenticacao;
import br.com.alura.forum.forumhub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager maneger;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.Senha());
        var authentication = maneger.authenticate(authenticationtoken);
        var tokenJWT = tokenService.gerarTpken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }


}
