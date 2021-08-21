package com.proyectjava.SistemaGestion.controllers;

import com.proyectjava.SistemaGestion.DAO.UsuarioDao;
import com.proyectjava.SistemaGestion.models.Usuario;
import com.proyectjava.SistemaGestion.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        Usuario usuarioLogeado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
       if(usuarioLogeado != null){
           String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogeado.getId()),usuarioLogeado.getEmail());
           return tokenJwt;
       }
       return "Fail";
    }
}
