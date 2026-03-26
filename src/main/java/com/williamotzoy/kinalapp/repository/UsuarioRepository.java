package com.williamotzoy.kinalapp.repository;

import com.williamotzoy.kinalapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
