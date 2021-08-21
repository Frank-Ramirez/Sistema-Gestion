package com.proyectjava.SistemaGestion.DAO;

import com.proyectjava.SistemaGestion.models.Usuario;

import java.util.List;

//DAO: data access object
//una interface es un archivo en el que se indica que funciones deberia tener una clase
//la clase que implemente esta interfaz esta obligada a contener los metodos que aqui contenga
public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
