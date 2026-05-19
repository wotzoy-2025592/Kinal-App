package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Cliente;
import com.williamotzoy.kinalapp.repository.ClienteRepository;
import com.williamotzoy.kinalapp.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RestController = @Controller + @RequestBody
@RequestMapping("/clientes-textito")
//Todas las rutas en este controlador deben empezar con /clientes
public class ClienteController {
    //Inyectamos el SERVICIO y NO el repositorio
    //el controlador solo debe de tener conexión con el servicio
    private final IClienteService clienteService;
    //como buena practica la Inyección de dependencias debe hacerse por el constructor
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Responde peticiones GET
    @GetMapping
    //ResponseEntity nos permite controlar el codigo HTTP y el cuerpo
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = clienteService.listarTodos();
        //delegamos al servicio
        return ResponseEntity.ok(clientes);
        // 200 OK con la lista de clientes
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Cliente>> listarActivos(){
        List<Cliente> clientes = clienteService.listarActivos();
        return ResponseEntity.ok(clientes);
    }

    //{dpi} es una variable de ruta(valor a buscar)
    @GetMapping("/{dpi}")
    public ResponseEntity<Cliente> buscarPorDPI(@PathVariable String dpi){
        //@PathVariable toma el valode de la URL y lo asigna al DPI
        return clienteService.buscarPorDPI(dpi)
                //si Optional tiene valor, devuelve 200 OK con el cliente
                .map(ResponseEntity::ok)
                //Si Optional esta vacio, devuelve 404 NOT FOUND
                .orElse(ResponseEntity.notFound().build());
    }

    //POST crear un nuevo cliente
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Cliente cliente){
        //@RequestBody: Toma el JSON del cuerpo y lo convierte a un objeto de Tipo Cliente
        //<?> significa "tipo generico" puede ser un cliente o un String
        try{
            Cliente nuevoCliente = clienteService.guardar(cliente);
            //Intentamos guardar el cliente pero puede lanzar una excepción
            // de IllegalArgumentException
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
            //201 CREATED(mucho más especifico que el 200 para la creación de un cliente)
        }catch (IllegalArgumentException e){
            //Si hay error de validacion
            //400 BAD REQUEST con el mensaje de error
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    //DELETE elimina un cliente
    @DeleteMapping("/{dpi}")
    public ResponseEntity<Void> eliminar(@PathVariable String dpi){
        //ResponseEntity<void>: No devuelve cuerpo en la respuesta
        try{
            if (!clienteService.existePorDPI(dpi)){
                return ResponseEntity.notFound().build();
                //404 Si no existe
            }
            clienteService.eliminar(dpi);
            return ResponseEntity.noContent().build();
            //204 NO CONTENT (se ejecuto correctamente y no devuelve cuerpo)
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
            //404 NOT FOUND
        }
    }

    //Actualizar cliente a través del DPI
    @PutMapping("/{dpi}")
    public ResponseEntity<?> actualizar(@PathVariable String dpi, @RequestBody Cliente cliente){
        try{
            if(!clienteService.existePorDPI(dpi)){
                //verificar si existe antes de poder actualizar
                return ResponseEntity.notFound().build();
                //404 Not Found
            }
            Cliente clienteActualizado = clienteService.actualizar(dpi, cliente);
            return ResponseEntity.ok(clienteActualizado);
            //200 ok con el cliente ya actualizado

        }catch (IllegalArgumentException e){
            //Error cuando los datos sean incorrectos
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e){
            //Posiblemente cualquier otro error como: cliente no encontrado, etc.
            //404 NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }


}
