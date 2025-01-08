package mysql;

import java.sql.ResultSet;
import java.util.Scanner;

public class MainConnect {
    public static void main(String[] args) {
        try {
            MySqlConnect conn = new MySqlConnect();
            Scanner scanner = new Scanner(System.in);
            String name, email;
            String age, id;
            for (; ; ) {

                System.out.println("Options:\n1. Output all\n2. Add user\n3. Update User\n4. Delete user");

                switch (scanner.nextLine()) {
                    case "1":
                        ResultSet rs = conn.getUsersTable();
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    ", Name: " + rs.getString("name") +
                                    ", Email: " + rs.getString("email") +
                                    ", Age: " + rs.getString("age")
                            );
                        }
                        break;
                    case "2":
                        System.out.println("Enter name:");
                        name = scanner.nextLine();
                        System.out.println("Enter email:");
                        email = scanner.nextLine();
                        System.out.println("Enter age:");
                        age = scanner.nextLine();
                        try {
                            conn.addUser(name, email, Integer.parseInt(age));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "3":
                        System.out.println("Enter id:");
                        id = scanner.nextLine();
                        System.out.println("Enter name:");
                        name = scanner.nextLine();
                        System.out.println("Enter email:");
                        email = scanner.nextLine();
                        System.out.println("Enter age:");
                        age = scanner.nextLine();
                        try {
                            conn.updateById(Integer.parseInt(id), name, email, Integer.parseInt(age));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "4":
                        System.out.println("Enter id:");
                        id = scanner.nextLine();
                        try {
                            conn.removeById(Integer.parseInt(id));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Command not found!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
