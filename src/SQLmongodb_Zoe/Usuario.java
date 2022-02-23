package SQLmongodb_Zoe;

public class Usuario {

    private int id;
    private String nombre;
    private String dni;
    private String telefono1;
    private String telefono2;
    private String localidad;
    private int edad;

    public Usuario(int id, String nombre, String dni, String telefono1, String telefono2, String localidad, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.localidad = localidad;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", localidad='" + localidad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
