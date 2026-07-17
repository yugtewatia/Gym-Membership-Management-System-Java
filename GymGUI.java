import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GymGUI {

    static ArrayList<Member> members = MemberFileManager.loadMembers();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gym Management System");
        frame.setSize(650, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        JButton addBtn = new JButton("Add Member");
        JButton viewBtn = new JButton("View Members");
        JButton workoutBtn = new JButton("Show Workout Plan");
        JButton deleteMembershipBtn = new JButton("Delete Membership");
        JButton updateMembershipBtn = new JButton("Update Membership");

        addBtn.setPreferredSize(new Dimension(160, 40));
        viewBtn.setPreferredSize(new Dimension(160, 40));
        workoutBtn.setPreferredSize(new Dimension(180, 40));
        deleteMembershipBtn.setPreferredSize(new Dimension(180, 40));
        updateMembershipBtn.setPreferredSize(new Dimension(180, 40));

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(workoutBtn);
        frame.add(deleteMembershipBtn);
        frame.add(updateMembershipBtn);

        addBtn.addActionListener(e -> openAddMemberForm());
        viewBtn.addActionListener(e -> showMembers());
        workoutBtn.addActionListener(e -> showWorkoutPlanForMember());
        deleteMembershipBtn.addActionListener(e -> deleteMembership());
        updateMembershipBtn.addActionListener(e -> updateMembership());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void openAddMemberForm() {
        JFrame form = new JFrame("Add Member");
        form.setSize(350, 300);
        form.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel idLabel = new JLabel("Member ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel membershipLabel = new JLabel("Membership Type:");

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();

        String[] membershipOptions = {"Basic", "Premium"};
        JComboBox<String> membershipBox = new JComboBox<>(membershipOptions);

        JButton submitBtn = new JButton("Submit");

        form.add(idLabel);
        form.add(idField);
        form.add(nameLabel);
        form.add(nameField);
        form.add(ageLabel);
        form.add(ageField);
        form.add(membershipLabel);
        form.add(membershipBox);
        form.add(new JLabel(""));
        form.add(submitBtn);

        submitBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Name cannot be empty.");
                    return;
                }

                for (Member member : members) {
                    if (member.getMemberId() == id) {
                        JOptionPane.showMessageDialog(form, "Member ID already exists.");
                        return;
                    }
                }

                Membership membership;
                String selectedType = (String) membershipBox.getSelectedItem();

                if ("Basic".equals(selectedType)) {
                    membership = new BasicMembership();
                } else {
                    membership = new PremiumMembership();
                }

                Member member = new Member(id, name, age, membership);
                members.add(member);

                MemberFileManager.saveMembers(members);

                JOptionPane.showMessageDialog(form, "Member added and saved successfully.");
                form.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(form, "Please enter valid numeric values for ID and Age.");
            }
        });

        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }

    public static void showMembers() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No members added yet.");
            return;
        }

        StringBuilder details = new StringBuilder();

        for (Member member : members) {
            details.append(member.getMemberDetails())
                   .append("\n----------------------\n");
        }

        JTextArea textArea = new JTextArea(details.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 250));

        JOptionPane.showMessageDialog(null, scrollPane, "Member Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showWorkoutPlanForMember() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No members available.");
            return;
        }

        String input = JOptionPane.showInputDialog(null, "Enter Member ID to view workout plan:");

        if (input == null) {
            return;
        }

        try {
            int id = Integer.parseInt(input.trim());

            for (Member member : members) {
                if (member.getMemberId() == id) {
                    JTextArea textArea = new JTextArea(WorkoutPlan.getWorkoutPlan(member.getMembership()));
                    textArea.setEditable(false);
                    textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

                    JOptionPane.showMessageDialog(
                        null,
                        new JScrollPane(textArea),
                        "Workout Plan for " + member.getName(),
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Member not found.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.");
        }
    }

    public static void deleteMembership() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No members available.");
            return;
        }

        String input = JOptionPane.showInputDialog(null, "Enter Member ID to delete membership:");

        if (input == null) {
            return;
        }

        try {
            int id = Integer.parseInt(input.trim());

            for (Member member : members) {
                if (member.getMemberId() == id) {
                    if (member.getMembership() == null) {
                        JOptionPane.showMessageDialog(null, "This member already has no membership assigned.");
                        return;
                    }

                    member.setMembership(null);
                    MemberFileManager.saveMembers(members);

                    JOptionPane.showMessageDialog(null, "Membership deleted successfully for member ID: " + id);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Member not found.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.");
        }
    }

    public static void updateMembership() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No members available.");
            return;
        }

        String input = JOptionPane.showInputDialog(null, "Enter Member ID to update membership:");

        if (input == null) {
            return;
        }

        try {
            int id = Integer.parseInt(input.trim());

            for (Member member : members) {
                if (member.getMemberId() == id) {

                    String currentMembership;
                    if (member.getMembership() == null) {
                        currentMembership = "No membership assigned";
                    } else {
                        currentMembership = member.getMembership().getMembershipName();
                    }

                    String[] options = {"Basic", "Premium"};
                    String newType = (String) JOptionPane.showInputDialog(
                            null,
                            "Current Membership: " + currentMembership + "\nSelect new membership:",
                            "Update Membership",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    if (newType == null) {
                        return;
                    }

                    if ("Basic".equals(newType)) {
                        member.setMembership(new BasicMembership());
                    } else {
                        member.setMembership(new PremiumMembership());
                    }

                    MemberFileManager.saveMembers(members);

                    JOptionPane.showMessageDialog(
                            null,
                            "Membership updated successfully for member ID: " + id
                    );
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Member not found.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID.");
        }
    }
}