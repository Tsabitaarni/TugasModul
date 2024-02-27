import java.util.Scanner;

public class TugasModul1 {
    void Student(long nomer){
        long Nim[] = {202310370311194L, 202310370311172L, 202310370311203L};
        for (long i : Nim){
            if (i == nomer){
                System.out.println("Succesful login as Student.");
                break;
            } else {
                System.out.println("User not found.");
                break;

            }
        }
    }

    void Admin(String user, String password){
        String userr = "admin";
        String pw = "adm1n";

        if (userr.equals(user) && pw.equals(password)){
            System.out.println("Succesful login as Admin.");
        } else {
            System.out.println("User not found.");
        }
    }

    public static void main(String[] args){
        TugasModul1 lb = new TugasModul1();
        Scanner inp = new Scanner(System.in);

        System.out.println("====== Library System ======");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("pilih salah satu (1-3): ");
        int pilih = inp.nextInt();

        switch (pilih){
            case 1:
                System.out.print("Enter your NIM: ");
                long nim = inp.nextLong();
                lb.Student(nim);
                break;
            case 2:
                System.out.print("Enter your username: ");
                String user = inp.next();
                System.out.print("Enter your password: ");
                String pass = inp.next();
                lb.Admin(user,pass);
                break;
            case 3:
                break;
            default:
                System.out.println("inputan anda salah.");
                break;
        }
    }
}