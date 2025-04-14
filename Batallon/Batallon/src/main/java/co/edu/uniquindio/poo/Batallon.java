package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Batallon {
    private String nombre;
    private String id;
    private List<Apoyo> vehiculosApoyo;
    public List<Blindado> vehiculosBlindados;
    private List<TransporteTropa> vehiculosTransporteTropa;
    private LinkedList<Mision> misiones;
    private LinkedList<Vehiculo> listVehiculos;
    private LinkedList<Soldado> listSoldados;

    public Batallon(String nombre, String id) {
        this.misiones = new LinkedList<>();
        this.vehiculosApoyo = new ArrayList<Apoyo>();
        this.vehiculosBlindados = new ArrayList<Blindado>();
        this.vehiculosTransporteTropa = new ArrayList<TransporteTropa>();
        this.listVehiculos = new LinkedList<>();
        this.listSoldados = new LinkedList<>();
        this.nombre = nombre;
        this.id = id;
    }


    //METODOS SOLDADO


    //Asignar solado a una mision
    //Agrega un soldado a la lista de personal de una misión si está disponible. Cambia su estado a no disponible
    public boolean asignarSoldado(int idSoldadoAsignar, int idMisionAsignar) {
        boolean flag = false;
        for (Mision mision : misiones) {
            if (mision.getIdMision() == idMisionAsignar) {
                for (Soldado soldado : listSoldados) {
                    if (soldado.getId() == idSoldadoAsignar && soldado.getEstadoSoldado() == EstadoSoldado.DISPONIBLE) {
                        LinkedList<Soldado> listaModificada = new LinkedList<>();
                        LinkedList<Soldado> listaInicial = mision.getPersonal();
                        listaModificada.addAll(listaInicial);
                        listaModificada.add(soldado);
                        mision.setPersonal(listaModificada);

                        for (Soldado soldado2 : mision.getPersonal()) {
                            if (soldado2.getEstadoSoldado() == EstadoSoldado.DISPONIBLE) {
                                soldado2.setEstadoSoldado(EstadoSoldado.NO_DISPONIBLE);
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }


    //Liberar soldados al finalizar una misión
    //Recorre todos los soldados de una misión y
    // márcalos como disponibles una vez que la misión haya terminado.
    public boolean actualizarEstadoSoldados(int idMisionBuscar) {
        boolean flag = false;
        for(Mision mision : misiones){
            if(mision.getIdMision() == idMisionBuscar && mision.getEstadoMision() == false){
                for (Soldado soldado : mision.getPersonal()) {
                    soldado.setEstadoSoldado(EstadoSoldado.DISPONIBLE);
                    flag = true;
                }
            }
        }return flag;
    }



    //Buscar soldados por especialidad/funcion
    public LinkedList buscarSoldadosEspecialidad(String buscar) {
        LinkedList soldadosEncontrados = new LinkedList<>();
        FuncionSoldado especialidadBuscar = null;

        String medico = "medico";
        String comunicaciones = "comunicaciones";
        String logistica = "logistica";

        if (buscar.equalsIgnoreCase(medico)) {
            especialidadBuscar = FuncionSoldado.MEDICO;
        }
        if (buscar.equalsIgnoreCase(comunicaciones)) {
            especialidadBuscar = FuncionSoldado.COMUNICACIONES;
        }
        if (buscar.equalsIgnoreCase(logistica)) {
            especialidadBuscar = FuncionSoldado.LOGISTICA;
        }

        for (Soldado soldado : listSoldados) {
            if (soldado.getFuncionSoldado() == (especialidadBuscar)) {
                soldadosEncontrados.add(soldado);
            }
        }
        return soldadosEncontrados;
    }

    //Buscar soldados disponibles por rango
    public LinkedList soldadosDiponiblesPorRango(String buscar) {
        LinkedList soldadosDisponibles = new LinkedList<>();
        Rango rangoBuscar = null;
        String soldadoString = "soldado";
        String cabo = "cabo";
        String sargento = "sargento";

        if (buscar.equalsIgnoreCase(soldadoString)) {
            rangoBuscar = Rango.SOLDADO;
        }
        if (buscar.equalsIgnoreCase(cabo)) {
            rangoBuscar = Rango.CABO;
        }
        if (buscar.equalsIgnoreCase(sargento)) {
            rangoBuscar = Rango.SARGENTO;
        }

        for (Soldado soldado : listSoldados) {
            if (soldado.getRango().equals(rangoBuscar)) {
                soldadosDisponibles.add(soldado);
            }
        }
        return soldadosDisponibles;
    }

    //Calcular edad promedio
    public double edadPromedio() {
        double edadPromedio = 0;
        int sumatoria = 0;
        int contador = 0;

        for (Soldado soldado : listSoldados) {
            sumatoria += soldado.getEdad();
            contador++;
            if (contador == listSoldados.size()) {
                edadPromedio = sumatoria / contador;
            }
        }
        return edadPromedio;
    }

    //Buscar soldados por id
    public Soldado buscarSoldadoPorId(int idBuscar) {
        Soldado soldadoEncontrado = null;
        for (Soldado soldado : listSoldados) {
            if (soldado.getId() == idBuscar) {
                soldadoEncontrado = soldado;
                break;
            } else {
                soldadoEncontrado = null;
            }
        }
        return soldadoEncontrado;
    }


    // vehículos con más de 50 misiones completadas
    public List<Vehiculo> obtenerVehiculosConMasDe50Misiones() {
        List<Vehiculo> vehiculosConMasDe50 = new ArrayList<>();
        for(Vehiculo vehiculo : listVehiculos){
            if(vehiculo.getMisionesCompletadas()>50){
                vehiculosConMasDe50.add(vehiculo);
            }
        }return vehiculosConMasDe50;
    }


    //Metodo registrar mision
    public Boolean registrarMision(LocalDate fecha, String ubicacion, LinkedList<Soldado> ListPersonal, String idVehiculoMision, boolean estado) {
        Boolean flag = false;

        //anterior String cantMisionesActuales= String.valueOf(misiones.size()+1);
        int cantMisionesActuales = (misiones.size() + 1);
        Mision newMision = new Mision(cantMisionesActuales, fecha, ubicacion, ListPersonal, estado);

        for (Vehiculo vehiculo : vehiculosApoyo) {
            if (vehiculo.getId().equals(idVehiculoMision)) {
                newMision.setVehiculosAsignados(vehiculo);

                LinkedList<Mision> listTempo = vehiculo.getListaMisiones();
                listTempo.add(newMision);

                vehiculo.setListaMisiones(listTempo);
                misiones.add(newMision);
                flag = true;

            }
            break;

        }
        for (Vehiculo vehiculo : vehiculosBlindados) {
            if (vehiculo.getId().equals(idVehiculoMision)) {
                newMision.setVehiculosAsignados(vehiculo);

                LinkedList<Mision> listTempo = vehiculo.getListaMisiones();
                listTempo.add(newMision);

                vehiculo.setListaMisiones(listTempo);
                misiones.add(newMision);
                flag = true;

            }
            break;

        }

        for (Vehiculo vehiculo : vehiculosTransporteTropa) {
            if (vehiculo.getId().equals(idVehiculoMision)) {
                newMision.setVehiculosAsignados(vehiculo);

                LinkedList<Mision> listTempo = vehiculo.getListaMisiones();
                listTempo.add(newMision);

                vehiculo.setListaMisiones(listTempo);
                misiones.add(newMision);
                flag = true;

            }
            break;

        }

        if (flag == true) {
            misiones.add(newMision);
        }
        return flag;
    }


    //METODO KILIMETRAJE CORREGIDO
    public String kmPromedioOptimizado() {
        int sumatoriaApoyo = 0;
        int sumatoriaBlindado = 0;
        int sumatoriaTransporte = 0;

        int contadorApoyo = 0;
        int contadorBlindado = 0;
        int contadorTransporte = 0;

        for (Vehiculo vehiculo : vehiculosApoyo) {
            sumatoriaApoyo += vehiculo.getKilometraje();
            contadorApoyo++;
        }

        for (Vehiculo vehiculo : vehiculosBlindados) {
            sumatoriaBlindado += vehiculo.getKilometraje();
            contadorBlindado++;
        }

        for (Vehiculo vehiculo : vehiculosTransporteTropa) {
            sumatoriaTransporte += vehiculo.getKilometraje();
            contadorTransporte++;
        }

        int promedioApoyo = (contadorApoyo > 0) ? sumatoriaApoyo / contadorApoyo : 0;
        int promedioBlindado = (contadorBlindado > 0) ? sumatoriaBlindado / contadorBlindado : 0;
        int promedioTransporte = (contadorTransporte > 0) ? sumatoriaTransporte / contadorTransporte : 0;

        return "Promedio transporte tropas: " + promedioTransporte +
                ", Promedio blindados: " + promedioBlindado +
                ", Promedio apoyo: " + promedioApoyo;
    }

    //Metodo Kilometraje promedio por tipo de vehiculo
    public String kmPromedio() {
        double promedioApoyo = 0;
        double promedioBlindado = 0;
        double promedioTransporte = 0;


        double contadorApoyo = 0;
        double sumatoriaApoyo = 0;
        for (Vehiculo vehiculo : vehiculosApoyo) {

            sumatoriaApoyo += vehiculo.getKilometraje();
            contadorApoyo++;
            if (contadorApoyo == vehiculosApoyo.size()) {
                promedioApoyo = sumatoriaApoyo / contadorApoyo;
            }
            break;
        }

        double contadorBlindado = 0;
        double sumatoriaBlindado = 0;
        for (Vehiculo vehiculo : vehiculosBlindados) {

            sumatoriaBlindado += vehiculo.getKilometraje();
            contadorBlindado++;
            if (contadorBlindado == vehiculosBlindados.size()) {
                promedioBlindado = sumatoriaBlindado / contadorBlindado;
            }
            break;
        }


        double contadorTransporte = 0;
        double sumatoriaTransporte = 0;
        for (Vehiculo vehiculo : vehiculosTransporteTropa) {

            sumatoriaTransporte += vehiculo.getKilometraje();
            contadorTransporte++;
            if (contadorTransporte == vehiculosTransporteTropa.size()) {
                promedioTransporte = sumatoriaTransporte / contadorTransporte;
            }
            break;
        }

        String txtPromTransporte = String.valueOf(promedioTransporte);
        String txtPromBlindado = String.valueOf(promedioBlindado);
        String txtPromApoyo = String.valueOf(promedioApoyo);

        String resultado = "Promedio transporte tropas: " + txtPromTransporte + "promedio blindados: " + txtPromBlindado + "promedio apoyo: " + txtPromApoyo;
        return resultado;
    }


    //Metodo vehiculo mas misiones optimizado
    public Vehiculo vehiculoMasMisionesCompletadasOpti() {
        Vehiculo vehiculoMasMisiones = null;
        int maxMisiones = -1;

        // Recorremos todas las listas de vehículos
        List<Vehiculo> todosVehiculos = new ArrayList<>();
        todosVehiculos.addAll(vehiculosApoyo);
        todosVehiculos.addAll(vehiculosTransporteTropa);
        todosVehiculos.addAll(vehiculosBlindados);

        for (Vehiculo vehiculo : todosVehiculos) {
            if (vehiculo.getMisionesCompletadas() > maxMisiones) {
                maxMisiones = vehiculo.getMisionesCompletadas();
                vehiculoMasMisiones = vehiculo;
            }
        }

        return vehiculoMasMisiones;
    }


    // Metodo vehiculo mayor cantidad misiones completadas
    public Vehiculo vehiculoMasMisionesCompletadas() {
        int cantMisionesApoyo = 0;
        int cantMisionesTransporte = 0;
        int cantMisionesBlindado = 0;
        Vehiculo vehiculoMasMisiones = null;
        Vehiculo apoyoMasMisiones = null;
        Vehiculo transporteMasMisiones = null;
        Vehiculo blindadosMasMisiones = null;


        for (Vehiculo vehiculo : vehiculosApoyo) {
            if (vehiculo.getMisionesCompletadas() > cantMisionesApoyo) {
                cantMisionesApoyo = vehiculo.getMisionesCompletadas();
                apoyoMasMisiones = vehiculo;
            }
        }

        for (Vehiculo vehiculo : vehiculosTransporteTropa) {
            if (vehiculo.getMisionesCompletadas() > cantMisionesTransporte) {
                cantMisionesTransporte = vehiculo.getMisionesCompletadas();
                transporteMasMisiones = vehiculo;
            }
        }


        for (Vehiculo vehiculo : vehiculosBlindados) {
            if (vehiculo.getMisionesCompletadas() > cantMisionesBlindado) {
                cantMisionesBlindado = vehiculo.getMisionesCompletadas();
                blindadosMasMisiones = vehiculo;
            }
        }


        if (cantMisionesApoyo > cantMisionesTransporte && cantMisionesApoyo > cantMisionesBlindado) {
            vehiculoMasMisiones = apoyoMasMisiones;
        }
        if (cantMisionesTransporte > cantMisionesBlindado && cantMisionesTransporte > cantMisionesApoyo) {
            vehiculoMasMisiones = transporteMasMisiones;
        }
        if (cantMisionesBlindado > cantMisionesApoyo && cantMisionesBlindado > cantMisionesTransporte) {
            vehiculoMasMisiones = blindadosMasMisiones;
        }
        return vehiculoMasMisiones;
    }


    //Metodo filtrar misiones por fecha y ubicacion
    //BEFORE ANTES
    //AFTER DESPUES
    public List filtrarMisiones(LocalDate fechaInicio, LocalDate fechaFin, String ubicacionBuscar) {
        List misionesEncontradas = new ArrayList();
        for (Mision mision : misiones) {
            if (mision.getFecha().isAfter(fechaInicio) && mision.getFecha().isBefore(fechaFin) && mision.getUbicacion().equals(ubicacionBuscar)) {
                misionesEncontradas.add(mision);
            }
        }

        for (Mision mision : misiones) {
            if (mision.getFecha().equals(fechaInicio) || mision.getFecha().equals(fechaFin)) {
                if (mision.getUbicacion().equals(ubicacionBuscar)) {
                    misionesEncontradas.add(mision);
                }
            }
        }
        return misionesEncontradas;
    }


    //Metodo buscar vehiculos por año de fabricacion

    public List filtroVehiculosFabricacion(int añoBuscar) {
        List misionesEncontradas = new ArrayList();


        for (Vehiculo vehiculo : vehiculosApoyo) {
            if (vehiculo.getAñoFabricacion() == añoBuscar) {
                misionesEncontradas.add(vehiculo);
            }
        }

        for (Vehiculo vehiculo : vehiculosTransporteTropa) {
            if (vehiculo.getAñoFabricacion() == añoBuscar) {
                misionesEncontradas.add(vehiculo);
            }
        }
        for (Vehiculo vehiculo : vehiculosBlindados) {
            if (vehiculo.getAñoFabricacion() == añoBuscar) {
                misionesEncontradas.add(vehiculo);
            }
        }

        return misionesEncontradas;
    }


    //Ordenar vehículos por misiones completadas (de mayor a menor)
    public List<Vehiculo> obtenerVehiculosOrdenados() {
        List<Vehiculo> todosLosVehiculos = new ArrayList<>();

        todosLosVehiculos.addAll(vehiculosApoyo);
        todosLosVehiculos.addAll(vehiculosBlindados);
        todosLosVehiculos.addAll(vehiculosTransporteTropa);

        // Ordenar por tipo y luego por misiones completadas (de mayor a menor)
        todosLosVehiculos.sort((v1, v2) -> {
            // Comparación por tipo de clase (nombre)
            int tipo = v1.getClass().getSimpleName().compareTo(v2.getClass().getSimpleName());

            // Si el tipo es igual, compara por misiones completadas
            if (tipo == 0) {
                return Integer.compare(v2.getMisionesCompletadas(), v1.getMisionesCompletadas());
            } else {
                return tipo;
            }
        });

        return todosLosVehiculos;
    }


    //Metodo modificar estado de los vehiculos
    public String actualizarEstadoOperativoVehiculos() {
        final int UMBRAL_KILOMETRAJE = 10000;
        LocalDate hoy = LocalDate.now();

        int enMantenimiento = 0;
        int enMision = 0;
        int disponibles = 0;

        List<Vehiculo> todosLosVehiculos = new ArrayList<>();
        todosLosVehiculos.addAll(vehiculosApoyo);
        todosLosVehiculos.addAll(vehiculosBlindados);
        todosLosVehiculos.addAll(vehiculosTransporteTropa);

        for (Vehiculo v : todosLosVehiculos) {
            Estado nuevoEstado;

            if (v.getKilometraje() > UMBRAL_KILOMETRAJE) {
                nuevoEstado = Estado.MANTENIMIENTO;
                enMantenimiento++;
            } else if (tieneMisionActiva(v, hoy)) {
                nuevoEstado = Estado.MISION;
                enMision++;
            } else {
                nuevoEstado = Estado.DISPONIBLE;
                disponibles++;
            }

            v.setEstadoOperativo(nuevoEstado);
        }

        String resumen = "Resumen de estados operativos actualizados:\n" +
                "EN_MANTENIMIENTO: " + enMantenimiento + "\n" +
                "EN_MISION: " + enMision + "\n" +
                "DISPONIBLE: " + disponibles;

        return resumen;
    }


    //Metodo para verificar si hay una mision activa
    private boolean tieneMisionActiva(Vehiculo vehiculo, LocalDate fechaActual) {
        for (Mision m : misiones) {
            if (m.getVehiculosAsignados().equals(vehiculo) && (m.getEstadoMision() == true)) {
            }
        }
        return true;
    }



    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Apoyo> getVehiculosApoyo() {
        return vehiculosApoyo;
    }

    public void setVehiculosApoyo(List<Apoyo> vehiculosApoyo) {
        this.vehiculosApoyo = vehiculosApoyo;
    }

    public List<Blindado> getVehiculosBlindados() {
        return vehiculosBlindados;
    }

    public void setVehiculosBlindados(List<Blindado> vehiculosBlindados) {
        this.vehiculosBlindados = vehiculosBlindados;
    }

    public List<TransporteTropa> getVehiculosTransporteTropa() {
        return vehiculosTransporteTropa;
    }

    public void setVehiculosTransporteTropa(List<TransporteTropa> vehiculosTransporteTropa) {
        this.vehiculosTransporteTropa = vehiculosTransporteTropa;
    }

    public LinkedList<Mision> getMisiones() {
        return misiones;
    }

    public void setMisiones(LinkedList<Mision> misiones) {
        this.misiones = misiones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(LinkedList<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    public LinkedList<Soldado> getListSoldados() {
        return listSoldados;
    }

    public void setListSoldados(LinkedList<Soldado> listSoldados) {
        this.listSoldados = listSoldados;
    }




    //CRUD MISIONES
    public void agregarMision(Mision mision) {
        misiones.add(mision);
    }

    public boolean actualizarMision(int idBuscar, Boolean nuevoEstado) {
        boolean actualizado = false;
        for (Mision mision : misiones) {
            if (mision.getIdMision() == idBuscar) {
                mision.setEstadoMision(nuevoEstado);
                actualizado = true;
            }
        }
        return actualizado;
    }

    public Mision obtenerMision(int idBuscar) {
        Mision misionEncontrada = null;
        for (Mision mision : misiones) {
            if (mision.getIdMision() == idBuscar) {
                misionEncontrada = mision;
            }
        }
        return misionEncontrada;
    }

    public boolean eliminarMision(int idMision) {
        boolean eliminado = false;
        for (Mision mision : misiones) {
            if (mision.getIdMision() == idMision) {
                misiones.remove(mision);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public List<Mision> obtenerMisiones() {
        return misiones;
    }


    //CRUD SOLDADO
    public void agregarSoldado(Soldado soldado) {
        listSoldados.add(soldado);
    }

    public boolean crearSoldado(int id, String nombre, Rango rango, FuncionSoldado funcionSoldado, int edad, EstadoSoldado estadoSoldado) {
        boolean flag = false;
        Soldado nuevoSoldado = new Soldado(id, nombre, rango, funcionSoldado, edad, estadoSoldado);
        if (buscarSoldadoPorId(id) == null) {
            listSoldados.add(nuevoSoldado);
            flag = true;
        }return flag;
    }

    public boolean eliminarSoldado(int id) {
        boolean flag = false;
        if (buscarSoldadoPorId(id) != null) {
            listSoldados.remove(buscarSoldadoPorId(id));
        }return flag;
    }

    public boolean actualizarSoldado(int id,Rango rango, FuncionSoldado funcionSoldado) {
        boolean flag = false;
        if (buscarSoldadoPorId(id) != null) {
            buscarSoldadoPorId(id).setRango(rango);
            buscarSoldadoPorId(id).setFuncionSoldado(funcionSoldado);
            flag = true;
        }return flag;
    }

    public List<Soldado> obtenerSoldados(){

        return listSoldados;
    }



    //CRUD VEHICULOS BLINDADOS
    public boolean agragarVehiculoBlindado(String nivelBlindaje, String id, String modelo, int añoFabricacion, int kilometraje, Estado estadoOperativo) {
        boolean flag = true;
        for(Blindado blindado : vehiculosBlindados){
            if(blindado.getId().equals(id)){
                flag = false;
                break;
            }
        }
        if(flag){
            Blindado newBlindado = new Blindado(nivelBlindaje,  id, modelo, añoFabricacion, kilometraje, estadoOperativo);
            vehiculosBlindados.add(newBlindado);
        }return flag;
    }

    public Blindado buscarBlindado(String id) {
        for (Blindado blindado : vehiculosBlindados) {
            if (blindado.getId().equals(id)) {
                return blindado;
            }
        }return  null;
    }

    public boolean elimianrVehiculoBlindado(String id){
        boolean flag = false;
        if(buscarBlindado(id) != null){
            vehiculosBlindados.remove(buscarBlindado(id));
            flag = true;
        }return flag;
    }

    //CRUD VEHICULOS APOYO
    public boolean agregarVehiculoApoyo(String id, String modelo, int añoFabricacion, int kilometraje, Estado estadoOperativo,Funcion tipoFuncion){
        boolean flag = true;
        for (Apoyo apoyo : vehiculosApoyo) {
            if(apoyo.getId().equals(id)){
                flag = false;
                break;
            }
        }
        if (flag) {
            Apoyo newApoyo = new Apoyo(id, modelo, añoFabricacion,kilometraje, estadoOperativo, tipoFuncion);
            vehiculosApoyo.add(newApoyo);
        }return flag;
    }

    public Apoyo buscarApoyo(String idVehiculoBuscar) {
        for (Apoyo apoyo : vehiculosApoyo) {
            if (apoyo.getId().equals(idVehiculoBuscar)) {
                return apoyo;
            }
        }return  null;
    }

    public boolean eliminarApoyo(String idVehiculo) {
        boolean flag = false;
        if(buscarApoyo(idVehiculo) != null){
            vehiculosApoyo.remove(buscarApoyo(idVehiculo));
            flag = true;
        }return flag;
    }

    //CRUD VEHICULOS TRANSPORTE TROPA
    public boolean agregarVehiculoTransporteTropas(String id, String modelo, int añoFabricacion, int kilometraje, Estado estadoOperativo, int capacidadSoldados){
        boolean flag = true;
        for(TransporteTropa transporte: vehiculosTransporteTropa){
            if(transporte.getId().equals(id)){
                flag = false;
                break;
            }
        }
        if(flag){
            TransporteTropa newTransporte = new TransporteTropa(id, modelo, añoFabricacion, kilometraje, estadoOperativo, capacidadSoldados);
            vehiculosTransporteTropa.add(newTransporte);
        }return flag;
    }

    public TransporteTropa buscarVehiculoTransporteTropas(String idVehiculoBuscar){
        for (TransporteTropa vehiculoTransporteTropa : vehiculosTransporteTropa) {
            if (vehiculoTransporteTropa.getId().equals(idVehiculoBuscar)) {
                return vehiculoTransporteTropa;
            }
        }return null;
    }

    public boolean eliminarVehiculoTransporteTropas(String id) {
        boolean flag = false;
        if(buscarVehiculoTransporteTropas(id) != null){
            vehiculosTransporteTropa.remove(buscarVehiculoTransporteTropas(id));
            flag = true;
        }return flag;
    }







}
