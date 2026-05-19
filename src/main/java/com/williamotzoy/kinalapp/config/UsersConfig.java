package com.williamotzoy.kinalapp.config;

import com.williamotzoy.kinalapp.entity.Usuario;
import com.williamotzoy.kinalapp.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;


public class UsersConfig implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsersConfig(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> usuarios =usuarioRepository.findByUserName(username);

        if(usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado o inexistente: " + username);
        }

        Usuario usuario = usuarios.get();

        return User.builder().username(usuario.getUserName())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }
}


