package SQLmongodb_Zoe;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mongodb {

    Scanner sc = new Scanner(System.in);

    public void escribirMongo(Usuario usuario) {

        try {
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            DB basedatos=mongoClient.getDB("bdmongo");
            DBCollection datos= basedatos.getCollection("datos");

            BasicDBObject nuevo = new BasicDBObject();
            nuevo.put("id",usuario.getId());
            nuevo.put("nombre", usuario.getNombre());
            nuevo.put("dni",usuario.getDni());
            nuevo.put("telefono1",usuario.getTelefono1());
            nuevo.put("telefono2",usuario.getTelefono2());
            nuevo.put("localidad",usuario.getLocalidad());
            nuevo.put("edad",usuario.getEdad());

            datos.insert(nuevo);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inyectarUsuarios(ArrayList<Usuario> listaUsuarios){
        try{
            for (Usuario usuario : listaUsuarios) {
                escribirMongo(usuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Se han insertado los usuarios a la tabla de MongoDB");
        }
    }

    public void leerMongo() {
        try {
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            DB basedatos=mongoClient.getDB("bdmongo");
            DBCollection datos= basedatos.getCollection("datos");

            DBCursor cursor=datos.find();

            while(cursor.hasNext()) {
                System.out.println(cursor.next());

            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void buscador(){

        int opcion = 0;
        try{
            while(opcion!=2) {
                System.out.println("PULSE 1 SI DESEA VER TODOS LOS DATOS DE LA TABLA, PULSE 2 SI DESEA SALIR");
                opcion=sc.nextInt();
                switch (opcion) {
                    case 1 -> leerMongo();
                    case 2 -> System.out.println("SALIENDO...");
                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
