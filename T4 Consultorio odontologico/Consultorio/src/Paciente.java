import java.time.LocalDate;

public record Paciente(String numeroHistoriaClinica, String nombre, int edad, String telefono,
                       String direccion, String fechaUltimaConsulta, int cantidadTratamientos,
                       Odontologo odontologo) {



}
