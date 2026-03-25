package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    /*
    * Interfaz: Es un contrato que dice QUÉ métodos debe tener
    * cualquier servicio de Clientes. No tiene
    * Implementación, solo la definición de los métodos.
    * */

    //Metodo que devuelve una lista de todos los Clientes
    List<Cliente> listarTodos();
    List<Cliente> listarActivos();
    /*
    * List<Cliente> lo que hace es devolver una lista
    * de objetos de la entidad clientes
    * */

    //Metodo que guarda un cliente en la base de datos
    Cliente guardar(Cliente cliente);
    //Parámetros: Recibe un objeto Cliente con los datos a
    //guardar

    //Optional - Contenedor que puede o no tener valor
    //Evita el error de NullPointerException
    Optional<Cliente> buscarPorDPI(String dpi);


    //Metodo que actualiza un Cliente
    Cliente actualizar(String dpi, Cliente cliente);
    /*
    * Parámetros - dpi: DPI del cliente a actualizar
    * Cliente cliente: Objeto con los datos nuevos
    * Retorna un objeto de tipo Cliente ya actualizado
    * */

    /*
    * Metodo de tipo void para eliminar a un Cliente
    * void: no retorna ningun valor o dato
    * Elimina un Cliente por su DPI
    * */
    void eliminar(String dpi);

    //boolean - Retorna true si existe y false si no existe
    boolean existePorDPI(String dpi);
}
