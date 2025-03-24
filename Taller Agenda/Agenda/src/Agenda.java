public class Agenda {
    private Contacto[] listaContactos;
    private Grupo[] listaGrupos;
    private Reunion[] listaReuniones;

    public Agenda() {
        listaContactos = new Contacto[10];
        listaGrupos = new Grupo[10];
        listaReuniones = new Reunion[10];
    }



    //GETTERS Y SETTERS


    public Contacto[] getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    public Grupo[] getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(Grupo[] listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public Reunion[] getListaReuniones() {
        return listaReuniones;
    }

    public void setListaReuniones(Reunion[] listaReuniones) {
        this.listaReuniones = listaReuniones;
    }




    //METODOS REQUERIDOS PARA EL PROGRAMA



    //CONTACTOS

    //buscar nombre  (se usa en eliminar y en actualizar
    public int buscarNombre(String nombre){
        for (int i = 0; i < listaContactos.length; i++){
            if (listaContactos[i].getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }

    //Eliminar contacto
    public boolean eliminarContacto (String nombreEliminar, Contacto contactoEliminado){
        int indiceContacto = buscarNombre(nombreEliminar);

        if (indiceContacto != -1){
            listaContactos[indiceContacto] = null;
            return true;
        }
        return false;
    }


    //actualizar/modificar Contacto
    public boolean actualizarContacto (String nombreActualizar, Contacto contactoActualizar){
        int indiceContacto = buscarNombre(nombreActualizar);

        if (indiceContacto != -1){
            listaContactos[indiceContacto] = contactoActualizar;
            return true;
        }
        return false;
    }



    //CREAR CONTACTO
    public boolean crearContacto(Contacto newContacto) {
        int indice = encontrarPosicionValida();

        if (verificarTelefono(newContacto.getTelefono())
                && (verificarNombre(newContacto.getNombre()))
                && indice != -1) {
            listaContactos[indice] = newContacto;
            return true;
        }
        return false;
    }


    //Encontrar posicion vacia en lista de contactos
    public int encontrarPosicionValida(){
        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] == null) {
                return i;
            }
        }
        return -1;
    }


    //Verificar que no exista el mismo numero de telefono
    public boolean verificarTelefono(String telefono) {
        boolean telefonoFlag = true;
        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i].getTelefono().equals(telefono)) {
                telefonoFlag = false;
                break;
            }
        }
        return telefonoFlag;
    }

    //verificar que no exista el mismo nombre
    public boolean verificarNombre(String nombre) {
        boolean nombreFlag = true;
        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i].getNombre().equals(nombre)) {
                nombreFlag = false;
                break;
            }
        }
        return nombreFlag;
    }


    public Contacto buscarContacto(String nombre) {
        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i].getNombre().equals(nombre)) {
                return listaContactos[i];
            }
        }
        return null;
    }




    //GRUPOS
    //ENUM categoria: OFICINA, FIESTA, AMIGOS, FAMILIA;
    //CREAR GRUPOS

    public boolean crearGrupo(Grupo newGrupo) {
        int indice = encontrarPosicionValidaNewGrupo();
        if (indice != -1) {
            listaGrupos[indice] = newGrupo;
            return true;
        }
        return false;
    }

    public int encontrarPosicionValidaNewGrupo() {
        for (int i = 0; i < listaGrupos.length; i++) {
            if (listaGrupos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean eliminarGrupo(String grupoEliminar, Grupo grupoEliminado) {
        int indiceGrupo = buscarGrupo(grupoEliminar);
        if (indiceGrupo != -1){
            listaGrupos[indiceGrupo] = null;
            return true;
        }
        return false;
    }

    public int buscarGrupo(String nombreGrupo) {
        for (int i = 0; i < listaGrupos.length; i++) {
            if(listaGrupos[i].getNombreGrupo().equalsIgnoreCase(nombreGrupo)){
                return i;
            }
        }
        return -1;
    }

    public boolean actualizarGrupo(String grupoActualizar, Grupo grupoActualizado) {
        int indiceGrupo = buscarGrupo(grupoActualizar);
        if (indiceGrupo != -1){
            listaGrupos[indiceGrupo] = grupoActualizado;
            return true;
        }
        return false;
    }


    public Grupo obtenerGrupo(String nombre) {
        for (Grupo grupo : listaGrupos) {
            if (grupo != null && grupo.getNombreGrupo().equalsIgnoreCase(nombre)) {
                return grupo;
            }
        }
        return null;
    }







    //REUNIONES
    //CREAR REUNION
    public boolean crearReunion(String descripcion, String fecha, String hora, int tamano) {
        int indice = encontrarPosicionValidaNewReunion();
        if (indice != -1) {
            listaReuniones[indice] = new Reunion(descripcion, fecha, hora, tamano);
            return true;
        }
        return false;

    }

    public int encontrarPosicionValidaNewReunion() {
        for (int i = 0; i < listaReuniones.length; i++) {
            if (listaReuniones[i] == null) {
                return i;
            }
        }
        return -1;
    }



    public boolean eliminarReunion(String reunionEliminar, Reunion reunionEliminado) {
        int indiceReunion = buscarReunion(reunionEliminar);
        if (indiceReunion != -1){
            listaReuniones[indiceReunion] = null;
            return true;
        }
        return false;
    }

    public int buscarReunion(String nombreReunion) {
        for (int i = 0; i<listaReuniones.length; i++) {
            if(listaReuniones[i].getDescripcion().equalsIgnoreCase(nombreReunion)){
                return i;
            }
        }
        return -1;
    }


    public boolean actualizarReunion(String descripcion, Reunion reunionActualizada) {
        int indice = buscarReunion(descripcion);
        if (indice != -1) {
            listaReuniones[indice] = reunionActualizada;
            return true;
        }
        return false;
    }



    public Reunion obtenerReunion(String descripcion) {
        int indice = buscarReunion(descripcion);
        if (indice != -1) {
            return listaReuniones[indice];
        }
        return null; // No se encontró la reunión
    }





}
