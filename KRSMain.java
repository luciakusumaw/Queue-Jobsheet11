import java.util.Scanner;

public class KRSMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KRSQueue queueKrs = new KRSQueue(10);
        int choice;

        do {
            System.out.println("\n--- KRS Approval System ---");
            System.out.println("1. Register Student (Enqueue)");
            System.out.println("2. Process Approval (Dequeue 2)");
            System.out.println("3. Display All in Queue");
            System.out.println("4. Show First Two Students");
            System.out.println("5. Show Last Student");
            System.out.println("6. Check System Stats");
            System.out.println("7. Clear Queue");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("NIM: "); 
                    String nim = sc.nextLine();
                    System.out.print("Name: "); 
                    String name = sc.nextLine();
                    System.out.print("Study Program: "); 
                    String prog = sc.nextLine();
                    System.out.print("Class: "); 
                    String cls = sc.nextLine();
                    queueKrs.enqueue(new KRS(nim, name, prog, cls));
                    break;
                case 2: 
                    queueKrs.dequeueTwo(); 
                    break;
                case 3: 
                    queueKrs.printAll(); 
                    break;
                case 4: 
                    queueKrs.peekFirstTwo(); 
                    break;
                case 5: 
                    queueKrs.peekRear(); 
                    break;
                case 6: 
                    queueKrs.displayStats(); 
                    break;
                case 7: 
                    queueKrs.clear(); 
                    break;
            }
        } while (choice != 0);
    }
}