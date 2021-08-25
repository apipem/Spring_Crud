package com.asset.tema2.controller;

import com.asset.tema2.modelo.Trabajador;
import com.asset.tema2.modelo.TrabajadorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trabajador")
public class TrabajadorController {

    @Autowired
    private TrabajadorDao trabajadorDao;

    /***
     * Metodo que retorno todos los registros de la BBDD sin paginacion
     * @return
     */
    @GetMapping("/all")
    private Iterable<Trabajador> listar()
    {
        return trabajadorDao.findAll();
    }

    /***
     * Metodo que retorna un objeto de la persona consultada
     * @param cedula
     * @return
     */
    @GetMapping("/{cedula}")
    private Trabajador consultar(@PathVariable int cedula){
        return consulta_trabajador(cedula);
    }

    /***
     * Metodo para almacenar un trabajador
     * @param trabajador
     * @return
     */
    @PostMapping("")
    private String guardar(@RequestBody Trabajador trabajador){
        trabajadorDao.save(trabajador);
        return "ok";
    }

    /***
     * Metodo para modificar un trabajador
     * @param trabajador
     * @return
     */
    @PutMapping("")
    private String modificar(@RequestBody Trabajador trabajador){
        trabajadorDao.save(trabajador);
        return "ok";
    }

    /***
     * Metodo para eliminar un trabajador
     * @return
     */
    @DeleteMapping("/{cedula}")
    private void eliminar(@PathVariable int cedula){
        Trabajador trabajador = consulta_trabajador(cedula);
        if (trabajador != null){
            trabajadorDao.delete(trabajador);
        }
    }

    /***
     * Metodo para consultar por la cedula del trabajador
     * @param cedula
     * @return Trabajador
     */
    private Trabajador consulta_trabajador(int cedula){
        Trabajador trabajador = new Trabajador();
        for (Trabajador trabajadores: trabajadorDao.findAll()) {
            if (trabajadores.getCedula() == cedula){
                trabajador = trabajadores;
            }
        }
        return trabajador;
    }
}
