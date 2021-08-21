package com.proyectjava.SistemaGestion.controllers;

/*tipos de errores
* 500 error en el servidor
* 400 falta algun dato por recivir (bad rquest)
* 404 pagina no encontrada
* 401 no tiene autorizacion*/
import com.proyectjava.SistemaGestion.DAO.UsuarioDao;
import com.proyectjava.SistemaGestion.models.Usuario;
import com.proyectjava.SistemaGestion.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController//anotacion para indicar que esta clase va aser un controlador (manejo de urls)
public class UsuarioController {
    //inyeccion de dependencias ------- >
    @Autowired//esta anotacion crea un objeto de la clase UsuarioDao y lo guarda en la variable
    private UsuarioDao usuarioDao;// <-----
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET) //<- url del servidor, (metodo get por defecto sino se define el metodo)
    public Usuario getUsuario(@PathVariable Long id){
         Usuario usuario =  new Usuario();
         usuario.setId(id);
         usuario.setNombre("Luis");
         usuario.setApellido("Ramirez");
         usuario.setEmail("wicho305.lv@gmail.com");
         usuario.setTelefono("5584604903");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET) //<- url del servidor, (metodo get)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)){return null;}
        return usuarioDao.getUsuarios();
    }
    private boolean validarToken(String token){
        String idUsr = jwtUtil.getKey(token);
        return idUsr != null;
    }

    @RequestMapping(value = "api/usuarios/{id}", method =  RequestMethod.DELETE) //<- url del servidor
    //utilizar delete no significa que se va a eliminar algo, solo es la direccion
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(!validarToken(token)){return;}
        usuarioDao.eliminar(id);
    }
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

}
