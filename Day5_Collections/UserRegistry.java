import java.util.ArrayList;
import java.util.HashMap;

public class UserRegistry {

    ArrayList<User> userList = new ArrayList<>();
    HashMap<Integer, User> userMap = new HashMap<>();

    // ADD user
    void addUser(int id, String name, String email) {
        try {
                if (userMap.containsKey(id)) {
                    throw new Exception("User with ID " + id + " already exists.");
                }
            User u = new User(id, name, email);
            userList.add(u);
            userMap.put(id, u);
            System.out.println("User added: " + name);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // FIND user by ID
    void findUser(int id) {
        try {
            if (!userMap.containsKey(id)) {
                throw new Exception("User with ID " + id + " not found.");
            }
            System.out.println("-- User Found --");
            userMap.get(id).display();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE user by ID
    void deleteUser(int id) {
        try {
            if (!userMap.containsKey(id)) {
                throw new Exception("User with ID " + id + " not found.");
            }
            User u = userMap.get(id);
            userList.remove(u);
            userMap.remove(id);
            System.out.println("User deleted: " + u.name);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DISPLAY all users
    void displayAll() {
        try {
            if (userList.isEmpty()) {
                throw new Exception("No users in registry.");
            }
            System.out.println("===== All Users =====");
            for (User u : userList) {
                u.display();
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}