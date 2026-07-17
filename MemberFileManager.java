import java.io.*;
import java.util.ArrayList;

class MemberFileManager {

    private static final String FILE_NAME = "members.dat";

    public static void saveMembers(ArrayList<Member> members) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(members);
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Member> loadMembers() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Member>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading members: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}