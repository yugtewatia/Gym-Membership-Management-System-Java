import java.util.*;

abstract class Membership {
    String membershipName;
    double monthlyFee;

    public Membership(String name, double fee) {
        this.membershipName = name;
        this.monthlyFee = fee;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public abstract double CalculateFee();
}

class BasicMembership extends Membership {
    public BasicMembership() {
        super("Basic", 1000);
    }

    public double CalculateFee() {
        return monthlyFee;
    }
}

class PremiumMembership extends Membership {
    public PremiumMembership() {
        super("Premium", 2000);
    }

    public double CalculateFee() {
        return monthlyFee + 500;
    }
}

class Member {
    private int memberId;
    private String memberName;
    private int memberAge;
    private Membership membership;

    public Member(int memberId, String memberName, int memberAge) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberAge = memberAge;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public int getMemberId() {
        return memberId;
    }

    public void display() {
        System.out.println("\n--- Member Details ---");
        System.out.println("ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.println("Age: " + memberAge);

        if (membership != null) {
            System.out.println("Membership: " + membership.getMembershipName());
            System.out.println("Membership Fee: " + membership.CalculateFee());
        } else {
            System.out.println("Membership: Unassigned");
        }
    }
}

class WorkoutPlan {
    void showPlan() {
        System.out.println("\n--- Weekly Workout Plan ---");
        System.out.println("Monday: Chest");
        System.out.println("Tuesday: Back");
        System.out.println("Wednesday: Legs");
        System.out.println("Thursday: Shoulders");
        System.out.println("Friday: Arms");
        System.out.println("Saturday: Cardio");
        System.out.println("Sunday: Rest");
    }
}

public class GymManagement {

    static ArrayList<Member> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== GYM MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Member");
            System.out.println("2. View All Members");
            System.out.println("3. Assign Membership");
            System.out.println("4. Show Workout Plan");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    assignMembership();
                    break;
                case 4:
                    WorkoutPlan wp = new WorkoutPlan();
                    wp.showPlan();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void registerMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Member m = new Member(id, name, age);
        members.add(m);

        System.out.println("Member added successfully!");
    }

    public static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found!");
            return;
        }

        for (Member m : members) {
            m.display();
        }
    }

    public static void assignMembership() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();

        Member found = null;

        for (Member m : members) {
            if (m.getMemberId() == id) {
                found = m;
                break;
            }
        }

        if (found == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.println("Select Membership:");
        System.out.println("1. Basic");
        System.out.println("2. Premium");

        int type = sc.nextInt();

        if (type == 1) {
            found.setMembership(new BasicMembership());
        } else if (type == 2) {
            found.setMembership(new PremiumMembership());
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("Membership assigned successfully!");
    }
}
