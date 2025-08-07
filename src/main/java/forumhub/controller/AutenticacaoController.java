package forumhub.controller;

import forumhub.Infra.security.DadosTokenJWT;
import forumhub.Infra.security.TokenService;
import forumhub.usuario.DadosAutenticacao;
import forumhub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
