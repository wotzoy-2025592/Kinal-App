package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.Usuario;
import com.williamotzoy.kinalapp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarActivos() {
        return usuarioRepository.findByEstado(1L);
    }

    @Override
    public Usuario guardar(Usuario usuario){
        validarUsuario(usuario);
        if (usuario.getEstado() == 0)
            usuario.setEstado(1L);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorCodigo(Long codigo){
        return usuarioRepository.findById(codigo);
    }

    @Override
    public Usuario actualizar(Long codigo, Usuario usuario){
        if(!usuarioRepository.existsById(codigo)){
            throw new RuntimeException("El usuario no se pudo encontrar con el codigo: " + codigo);
        }
        usuario.setCodigoUsuario(codigo);
        validarUsuario(usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long codigo){
        if(!usuarioRepository.existsById(codigo)){
            throw new RuntimeException("El usuario no se encontró con el código: " + codigo);
        }
        usuarioRepository.deleteById(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorCodigo(Long codigo){
        return usuarioRepository.existsById(codigo);
    }

    private void validarUsuario(Usuario usuario){

        if (usuario.getUserName() == null || usuario.getUserName().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo de nombre de usuario es obligatorio.");
        }
        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo de contraseña es un campo obligatorio.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo de correo es obligatorio");
        }
        if (usuario.getRol() == null || usuario.getRol().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo de rol es un campo obligatorio");
        }
    }

}
