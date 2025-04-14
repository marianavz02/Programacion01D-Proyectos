/**
 * Clase para probar los metodos de la clase Batallon
 *
 *
 * @author Mariana
 * @since 8/04/2025
 *https://github.com/marianavz02/Programacion01D-Proyectos
 */


package co.edu.uniquindio.poo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class BatallonTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());
    @Test
    @DisplayName("Prueba Funcionalidades Test")
    public void testUno() {
        LOG.info("Inicio de prueba del metodo testUno");

        // codigo de la prueba


        //Compara que dos metodos sean iguales (Esperado - Resultado)
        assertEquals(4, 4);


        //Compara que dos metodos NO sean iguales
        assertNotEquals(4, "1");


        //compara que una condicion sea TRUE
        assertTrue(1>0);


        //Compara que una condicion sea FALSE
        assertFalse(1<0);


        //Comprueba que un elemnto sea Null
        assertNull(null);


        //Comprueba que un elemnto no sea Null
        assertNotNull(new Batallon ("Cacique Calarca", "08"));



        LOG.info("Fin de prueba del metodo testUno");
    }


//PRUEBAS

    @Test
    @DisplayName("Prueba funcionalidad del metodo buscarSoldadosEspecialidad")
    public void buscarSoldadosEspecialidadTest(){
        LOG.info("Inicio de prueba buscarSoldadosEspecialidad");

        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        Soldado soldado1 = new Soldado(001,"Juan",Rango.CABO, FuncionSoldado.COMUNICACIONES,26,EstadoSoldado.DISPONIBLE);
        Soldado soldado2 = new Soldado(002,"dani", Rango.SOLDADO,FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);
        Soldado soldado3 = new Soldado(003,"lina",Rango.CABO, FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);

        batallonTest.agregarSoldado(soldado1);
        batallonTest.agregarSoldado(soldado2);
        batallonTest.agregarSoldado(soldado3);

        LinkedList<Soldado> resultado = batallonTest.buscarSoldadosEspecialidad("COMUNICACIONES");
        LinkedList<Soldado> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add(soldado1);

        assertEquals(resultadoEsperado,resultado);

        LOG.info("Fim de prueba buscarSoldadosEspecialidad");
    }


    @Test
    @DisplayName("Prueba funcionalidad del metodo edadPromedio")
    public void edadPromedioTest(){
        LOG.info("Inicio de prueba edadPromedio");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        Soldado soldado1 = new Soldado(001,"Juan",Rango.CABO, FuncionSoldado.COMUNICACIONES,36,EstadoSoldado.DISPONIBLE);
        Soldado soldado2 = new Soldado(002,"dani", Rango.SOLDADO,FuncionSoldado.MEDICO,22,EstadoSoldado.DISPONIBLE);
        Soldado soldado3 = new Soldado(003,"lina",Rango.CABO, FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);

        batallonTest.agregarSoldado(soldado1);
        batallonTest.agregarSoldado(soldado2);
        batallonTest.agregarSoldado(soldado3);

        double resultado = batallonTest.edadPromedio();
        double resultadoEsperado = 28;

        assertEquals(resultadoEsperado, resultado);

        LOG.info("Fin de prueba edadPromedio");
    }



    @Test
    @DisplayName("Prueba funcionalidad del metodo buscarSoldadoPorId")
    public void buscarSoldadoPorIdTest(){
        LOG.info("Inicio de prueba buscarSoldadoPorId");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        Soldado soldado1 = new Soldado(001,"Juan",Rango.CABO, FuncionSoldado.COMUNICACIONES,36,EstadoSoldado.DISPONIBLE);
        Soldado soldado2 = new Soldado(002,"dani", Rango.SOLDADO,FuncionSoldado.MEDICO,22,EstadoSoldado.DISPONIBLE);
        Soldado soldado3 = new Soldado(003,"lina",Rango.CABO, FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);

        batallonTest.agregarSoldado(soldado1);
        batallonTest.agregarSoldado(soldado2);
        batallonTest.agregarSoldado(soldado3);

        Soldado resultado = batallonTest.buscarSoldadoPorId(001);
        assertEquals(soldado1,resultado);

        LOG.info("Fin de prueba buscarSoldadoPorId");
    }


    @Test
    @DisplayName("Prueba funcionalidad del metodo soldadoDisponiblePorRango")
    public void soldadoDisponiblePorRangoTest(){
        LOG.info("Inicio de prueba buscarSoldadoPorRango");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        Soldado soldado1 = new Soldado(001,"Juan",Rango.CABO, FuncionSoldado.COMUNICACIONES,36,EstadoSoldado.DISPONIBLE);
        Soldado soldado2 = new Soldado(002,"dani", Rango.SOLDADO,FuncionSoldado.MEDICO,22,EstadoSoldado.DISPONIBLE);
        Soldado soldado3 = new Soldado(003,"lina",Rango.CABO, FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);

        batallonTest.agregarSoldado(soldado1);
        batallonTest.agregarSoldado(soldado2);
        batallonTest.agregarSoldado(soldado3);


        LinkedList<Soldado> resultado = batallonTest.soldadosDiponiblesPorRango("soldado");
        LinkedList<Soldado> resultadoEsperado = new LinkedList<>();
        resultadoEsperado.add(soldado2);

        assertEquals(resultadoEsperado,resultado);


        LOG.info("Fin de prueba buscarSoldadoPorRango");
    }


    @Test
    @DisplayName("Prueba funcionalidad del metodo asignarSoldado")
    public void asignarSoldadoTest(){
        LOG.info("Inicio de prueba asignarSoldado");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        Soldado soldado1 = new Soldado(001,"Juan",Rango.CABO, FuncionSoldado.COMUNICACIONES,36,EstadoSoldado.DISPONIBLE);
        Soldado soldado2 = new Soldado(002,"dani", Rango.SOLDADO,FuncionSoldado.MEDICO,22,EstadoSoldado.DISPONIBLE);
        Soldado soldado3 = new Soldado(003,"lina",Rango.CABO, FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);

        batallonTest.agregarSoldado(soldado1);
        batallonTest.agregarSoldado(soldado2);
        batallonTest.agregarSoldado(soldado3);

        LinkedList<Soldado>personalMision = new LinkedList<>();
        personalMision.add(soldado1);
        personalMision.add(soldado2);


        LocalDate fechaElegida = LocalDate.now();
        boolean estadoMisionActual= true;
        Mision misionTest = new Mision(01,fechaElegida,"CALI", personalMision, estadoMisionActual);
        batallonTest.agregarMision(misionTest);

        boolean resultado = batallonTest.asignarSoldado(003,01);
        assertTrue(resultado);


        LOG.info("Fin de prueba asignarSoldado");
    }




    @Test
    @DisplayName("Prueba de funcionalidad del metodo registarMision (se encuentra en batallon)")
    public void registrarMisionTest(){
        LOG.info("Inicio de registrarMisionTest");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        LinkedList<Soldado> listPersonal = new LinkedList<>();
        Soldado soldado1 = new Soldado(001,"lina",Rango.SOLDADO,FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);
        listPersonal.add(soldado1);


       // batallonTest.registrarMision(LocalDate.of(2025, 8, 4), "Cali",listPersonal, "1");

        Blindado newVehiculoBlindado = new Blindado("1","2000",
                "1999", 1000, 10, Estado.DISPONIBLE);
        batallonTest.vehiculosBlindados.add(newVehiculoBlindado);
        LinkedList listTempo = batallonTest.getMisiones();
        listTempo.add(newVehiculoBlindado);
        batallonTest.setListVehiculos(listTempo);


        boolean estadoMisionActual= true;
        boolean result = batallonTest.registrarMision(LocalDate.of(2025, 8,
                4), "Cali",listPersonal, "2000",estadoMisionActual);

        assertTrue(result);


        LOG.info("Fin de registrarMisionTest");
    }


    @Test
    @DisplayName("Prueba de funcionalidad del metodo actualizarEstadoSoldados")
    public void actualizarEstadoSoldadosTest(){
        LOG.info("Inicio de actualizarEstadoSoldadosTest");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        LinkedList<Soldado> listPersonal = new LinkedList<>();
        Soldado soldado1 = new Soldado(001,"lina",Rango.SOLDADO,FuncionSoldado.MEDICO,26,EstadoSoldado.DISPONIBLE);
        batallonTest.agregarSoldado(soldado1);


        LocalDate fechaElegida = LocalDate.now();
        boolean estadoMisionActual= false;
        Mision misionTest = new Mision(01,fechaElegida,"CALI", listPersonal , estadoMisionActual);
        batallonTest.agregarMision(misionTest);
        batallonTest.asignarSoldado(001,01);

        batallonTest.buscarSoldadoPorId(001);

        boolean resultado = batallonTest.actualizarEstadoSoldados(01);
        assertTrue(resultado);



        LOG.info("Fin de actualizarEstadoSoldadosTest");
    }



    @Test
    @DisplayName("Prueba de funcionalidad del metodo obtenerVehiculosConMasDe50Misiones")
    public void obtenerVehiculosConMasDe50MisionesTest(){
        LOG.info("Inicio de obtenerVehiculosConMasDe50MisionesTest");

        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");

        Blindado newVehiculoBlindado = new Blindado("1","2000",
                "1999", 1000, 10, Estado.DISPONIBLE);
         Blindado newVehiculoBlindado2 = new Blindado("2","2001","1999", 1000, 10, Estado.DISPONIBLE);

        batallonTest.vehiculosBlindados.add(newVehiculoBlindado);
        batallonTest.vehiculosBlindados.add(newVehiculoBlindado2);
        LinkedList<Vehiculo> listTemp = new LinkedList<>();
        listTemp.add(newVehiculoBlindado);
        listTemp.add(newVehiculoBlindado2);
        batallonTest.setListVehiculos(listTemp);
        newVehiculoBlindado.setMisionesCompletadas(60);
        newVehiculoBlindado2.setMisionesCompletadas(45);

        List resultado = batallonTest.obtenerVehiculosConMasDe50Misiones();

        List resultadoEsperado = new ArrayList();
        resultadoEsperado.add(newVehiculoBlindado);

        assertEquals(resultadoEsperado,resultado);


        LOG.info("Fin de obtenerVehiculosConMasDe50MisionesTest");


    }


    @Test
    @DisplayName("Prueba de funcionalidad del metodo filtroVehiculosFabricacion")
    public void obtenerVehiculosFabricacionTest(){
        LOG.info("Inicio de filtroVehiculosFabricacion");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");

        Blindado newVehiculoBlindado = new Blindado("1","2000",
                "1999", 1000, 10, Estado.DISPONIBLE);
        Blindado newVehiculoBlindado2 = new Blindado("2","2001","1999", 1001, 10, Estado.DISPONIBLE);

        batallonTest.vehiculosBlindados.add(newVehiculoBlindado);
        batallonTest.vehiculosBlindados.add(newVehiculoBlindado2);
        LinkedList<Vehiculo> listTemp = new LinkedList<>();
        listTemp.add(newVehiculoBlindado);
        listTemp.add(newVehiculoBlindado2);
        batallonTest.setListVehiculos(listTemp);

        List resultado = batallonTest.filtroVehiculosFabricacion(1000);

        List resultadoEsperado = new ArrayList();
        resultadoEsperado.add(newVehiculoBlindado);

        assertEquals(resultadoEsperado,resultado);
        LOG.info("Inicio de filtroVehiculosFabricacion");
    }


    @Test
    @DisplayName("Prueba de funcionalidad del metodo filtrarMisiones")
    public void filtrarMisionesTest(){
        LOG.info("Inicio de filtroMisiones");
        Batallon batallonTest = new Batallon ("Cacique Calarca", "08");
        LinkedList<Soldado> listPersonal = new LinkedList<>();


        LocalDate fechaElegida1 = LocalDate.now();
        boolean estadoMisionActual1= false;
        Mision misionTest = new Mision(01,fechaElegida1,"CALI", listPersonal , estadoMisionActual1);
        batallonTest.agregarMision(misionTest);


        LocalDate fechaElegida2 = LocalDate.of(2024,12,02);
        boolean estadoMisionActual2= false;
        Mision misionTest2 = new Mision(02,fechaElegida2,"CALI", listPersonal , estadoMisionActual2);
        batallonTest.agregarMision(misionTest2);

        LocalDate  fechaInicio= LocalDate.of(2024,12,01);
        LocalDate  fechaFin= LocalDate.of(2024,12,20);
        List resultado = batallonTest.filtrarMisiones(fechaInicio,fechaFin, "CALI");
        List resultadoEsperado = new ArrayList();
        resultadoEsperado.add(misionTest2);

        assertEquals(resultadoEsperado,resultado);







        LOG.info("Fin de filtroMisiones");
    }






















}