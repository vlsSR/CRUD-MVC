package vista;

import modelo.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {
    private ArrayList<String> return_value = new ArrayList<>();
    private String temp;
    private Scanner sc = new Scanner(System.in);
    public ArrayList<String> menu() {
        loop:
        while (true) {
            System.out.println("What do you want to do:\n" +
                    "1.Create\n" +
                    "2.Read\n" +
                    "3.Update\n" +
                    "4.Delete\n" +
                    "5.Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    return_value.add("1");
                    System.out.println("Insert the key");
                    sc.nextLine();
                    temp = sc.nextLine();
                    return_value.add(temp);
                    return ask_data();
                case 2:
                    return_value.add("2");
                    System.out.println("Insert the key you want to search");
                    sc.nextLine();
                    temp = sc.nextLine();
                    return_value.add(temp);
                    return return_value;
                case 3:
                    return_value.add("3");
                    System.out.println("Insert the key to edit");
                    sc.nextLine();
                    temp = sc.nextLine();
                    return_value.add(temp);
                    return ask_data();
                case 4:
                    return_value.add("4");
                    System.out.println("Insert the key you want to delete");
                    sc.nextLine();
                    temp = sc.nextLine();
                    return_value.add(temp);
                    return return_value;
                case 5:
                    break loop;
                default:
                    System.out.println("Incorrect option");
            }
        }
        return null;
    }

    public ArrayList <String> ask_data() {
        System.out.println("Insert the name");
        temp = sc.nextLine();
        return_value.add(temp);
        System.out.println("Insert the address");
        temp = sc.nextLine();
        return_value.add(temp);
        System.out.println("Insert the telephone number");
        temp = sc.nextLine();
        return_value.add(temp);
        System.out.println("Insert the mail");
        temp = sc.nextLine();
        return_value.add(temp);
        System.out.println("Insert the birthdate");
        temp = sc.nextLine();
        return_value.add(temp);
        System.out.println("Insert the gender");
        temp = sc.nextLine();
        return_value.add(temp);
        return return_value;
    }

    public void showPerson(Persona person){
        System.out.println("Key: "+ person.getKey());
        System.out.println("Name: "+ person.getName());
        System.out.println("Address: "+ person.getAddress());
        System.out.println("Telephone Number: "+ person.getTelephone());
        System.out.println("Mail: "+ person.getMail());
        System.out.println("Birthdate: "+ person.getBithdate());
        System.out.println("Gender: "+ person.getGender());
    }

    public void registerCorrectly() {
        System.out.println("Registro insertado correctamente");
    }

    public void registerError() {
        System.out.println("Error al insertar registro");
    }

    public void noPerson() {
        System.out.println("No person exist with that key");
    }

    public void deleteCorrectly() {
        System.out.println("Registro borrado correctamente");
    }

    public void deleteError() {
        System.out.println("Error al borrar registro");
    }
}



