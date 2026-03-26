package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> listarTodos();
    List<Usuario> listarActivos();

    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorCodigo(Long codigo);
    Usuario actualizar(Long codigo, Usuario usuario);

    void eliminar(Long codigo);

    boolean existePorCodigo(Long codigo);
}
