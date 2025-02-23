public class Main {
    public static void main(String[] args) {


        //CREAR EMPRESA
        Empresa empresa = new Empresa(18292873, "Claro");


        //CREAR EMPLEADOS
        Empleado empleado1 = new Empleado("123445", "Maria Zapata", "Junio 2022", "Lider", "maria@gmail.com", "314567899");
        Empleado empleado2 = new Empleado("12345678", "Lina Gomez", "Abril 2023", "Gestion", "lina@gmail.com", "31678923");
        Empleado empleado3 = new Empleado("17643333", "Sabrina Cardona", "agosto 2024", "Administracio", "sabrina@gmail.com", "315778006");


        //AGREAGR EMPLEADOS
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        empresa.agregarEmpleado(empleado3);


        //ElIMINAR EMPLEADO
        empresa.eliminarEmpleado(empleado1);


        //MOSTRAR MENSAJE
        empresa.mostrarMensaje(empresa.toString());




    }
}
