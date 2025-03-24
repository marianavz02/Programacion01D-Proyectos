import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Consultorio {
    private String nombre;
    private List<Odontologo> odontologos;
    private List<Paciente>pacientes;

    public Consultorio(String nombre) {
        this.nombre = nombre;
        this.odontologos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    //METODOS

    //crea paciente
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    // Crear odontologo
    public void agregarOdontologo(Odontologo odontologo) {
        odontologos.add(odontologo);
    }

    // Obtener lista de odontólogos
    public List<Odontologo> obtenerOdontologos() {
        return odontologos;
    }

    // Buscar odontólogo por ID
    public Odontologo buscarOdontologoPorId(int id) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getId() == id) {
                return odontologo;
            }
        }
        return null; // Retorna null si no se encuentra el odontólogo
    }


    //Buscar paciente por nombre
    public Paciente buscarPacientePorNombre(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.nombre().equalsIgnoreCase(nombre)) {
                return paciente;
            }
        }
        return null;
    }


    // Actualizar odontólogo por ID
    public boolean actualizarOdontologo(int id, String nuevoNombre, String nuevoNumeroLicencia, Especialidad nuevaEspecialidad) {
        Odontologo odontologo = buscarOdontologoPorId(id);
        if (odontologo != null) {
            odontologo.setNombre(nuevoNombre);
            odontologo.setNumeroLicencia(nuevoNumeroLicencia);
            odontologo.setEspecialidad(nuevaEspecialidad);
            return true; // Actualización exitosa
        }
        return false; // No se encontró el odontólogo
    }

    // Eliminar odontólogo por ID
    public boolean eliminarOdontologo(int id) {
        return odontologos.removeIf(odontologo -> odontologo.getId() == id);
    }



    // Método para obtener la lista de pacientes con más de 5 tratamientos
    public List<Paciente> obtenerPacientesConMasDeCincoTratamientos() {
        List<Paciente> pacientesConMasDeCinco = new ArrayList<>();
            for (Paciente paciente : pacientes) {
                if (paciente.cantidadTratamientos() > 5) {
                    pacientesConMasDeCinco.add(paciente);
                }
            }
        return pacientesConMasDeCinco;
    }
}
