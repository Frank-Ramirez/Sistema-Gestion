package com.proyectjava.SistemaGestion.DAO;

import com.proyectjava.SistemaGestion.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository//permite acceder al repositorio de la base de datos (permite la conexion a BD)
@Transactional//otorga funcional a esta clase para poder realizar las consultas sql a la BD (entragmentos de tranccion las va armar y ejecutar)
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
        String query = "From Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario){
        /*String query = "FROM Usuario WHERE email = '+usuario.getEmail+' AND password = '+usuario.getPassword+'";
        Esta forma de validacion es peligrosa ya que permite ataques crossite o inyeccion de codigo Ejemplo:
        --->String email = "' OR 1=1 --"<---*/
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();
        if(lista.isEmpty()){
            return null;
        }
        String passHash = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passHash, usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }
}
