package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class ConsultsPersons extends Connector{
    PreparedStatement ps;
    ResultSet rs;
    Connection connection = getConnection();

    public boolean insert(Persona person) {
        try{
            ps = connection.prepareStatement("insert into persona (clave,nombre,domicilio,celular,correo_electronico,fecha_nacimiento,genero) values (?,?,?,?,?,?,?)");
            ps.setString(1, person.getKey());
            ps.setString(2, person.getName());
            ps.setString(3, person.getAddress());
            ps.setString(4, person.getTelephone());
            ps.setString(5,person.getMail());
            ps.setDate(6,person.getBithdate());
            ps.setString(7,person.getGender());
            int result = ps.executeUpdate();
            return result > 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Persona search(String key) {
        Persona person = new Persona();
        try {
            ps = connection.prepareStatement("select * from persona where clave=?");
            ps.setString(1, key);
            rs = ps.executeQuery();
            if(rs.next()) {
                person.setIdPersona(rs.getInt("idPersona"));
                person.setKey(rs.getString("clave"));
                person.setName(rs.getString("nombre"));
                person.setAddress(rs.getString("domicilio"));
                person.setTelephone(rs.getString("celular"));
                person.setMail(rs.getString("correo_electronico"));
                person.setBithdate(rs.getDate("fecha_nacimiento"));
                person.setGender(rs.getString("genero"));
            }
            else {
                person.setName("ERROR");
            }
            return person;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int update(Persona person) {
        int result = -1;
        try {
            ps = connection.prepareStatement("select * from persona where clave = ?");
            ps.setString(1,person.getKey());
            rs = ps.executeQuery();

            if (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                ps = connection.prepareStatement("update persona set clave=?,nombre=?,domicilio=?,celular=?,correo_electronico=?,fecha_nacimiento=?,genero=? where idPersona=?");
                ps.setInt(8,idPersona);
                ps.setString(1, person.getKey());
                ps.setString(2, person.getName());
                ps.setString(3, person.getAddress());
                ps.setString(4, person.getTelephone());
                ps.setString(5,person.getMail());
                ps.setDate(6,person.getBithdate());
                ps.setString(7,person.getGender());
                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int delete(String key) {
        try {
            ps = connection.prepareStatement("delete from persona where clave=?");
            ps.setString(1, key);
            int resultado = ps.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
