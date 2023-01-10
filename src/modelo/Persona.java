package modelo;

import java.sql.Date;

public class Persona {
    private int idPersona;
    private String key;
    private String name;
    private String address;
    private String telephone;
    private String mail;
    private Date bithdate;
    private String gender;

    public int getIdPersona() {
        return idPersona;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }

    public Date getBithdate() {
        return bithdate;
    }

    public String getGender() {
        return gender;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setBithdate(Date bithdate) {
        this.bithdate = bithdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
