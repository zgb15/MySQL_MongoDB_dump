package SQLmongodb_Zoe;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {

            // creamos la lista para hacer el volcado
            ArrayList<Usuario>listaUsuarios = new ArrayList<>();

            // MYSQL
            Mysql mysql = new Mysql();
            mysql.cogerSQL(listaUsuarios);

            // MONGODB
            Mongodb mongo = new Mongodb();
            mongo.inyectarUsuarios(listaUsuarios);
            mongo.buscador();

        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
