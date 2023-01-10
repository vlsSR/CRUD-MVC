package controlador;

import modelo.ConsultsPersons;
import modelo.Persona;
import vista.VistaConsola;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;

public class ControladorPersona {
    private VistaConsola vista;
    private Persona person;
    private ConsultsPersons modelo;
    private ArrayList<String> data;

    public ControladorPersona(VistaConsola vista, Persona person, ConsultsPersons modelo) {
        this.vista = vista;
        this.person = person;
        this.modelo = modelo;

    }

    public void start() {
        data = vista.menu();
        switch (data.get(0)) {
            case "1":
                create();
            break;
            case "2":
                search();
            break;
            case "3":
                edit();
            break;
            case "4":
                delete();
            break;
        }
    }

    public void create() {
        person.setKey(data.get(1));
        person.setName(data.get(2));
        person.setAddress(data.get(3));
        person.setTelephone(data.get(4));
        person.setMail(data.get(5));
        person.setBithdate(Date.valueOf(data.get(6)));
        person.setGender(data.get(7));

        if (modelo.insert(person)) {
            vista.registerCorrectly();
        }
        else {
            vista.registerError();
        }
    }

    public void search() {
        person = modelo.search(data.get(1));
        if (person.getName().equals("ERROR")) {
            vista.noPerson();
        }
        else {
            vista.showPerson(person);
        }
    }

    public void edit() {
        person.setKey(data.get(1));
        person.setName(data.get(2));
        person.setAddress(data.get(3));
        person.setTelephone(data.get(4));
        person.setMail(data.get(5));
        person.setBithdate(Date.valueOf(data.get(6)));
        person.setGender(data.get(7));
        if (modelo.update(person) > 0) {
            vista.registerCorrectly();
        }
        else {
            vista.registerError();
        }
    }

    public void delete() {
        if (modelo.delete(data.get(1)) > 0) {
            vista.deleteCorrectly();
        }
        else {
            vista.deleteError();
        }
    }
}
