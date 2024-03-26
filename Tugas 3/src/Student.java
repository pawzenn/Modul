import java.util.Scanner;

public class Student extends User {
    private String name;
    private String faculty;
    private String nim;
    private String programStudi;

    private Book[] borrowedBooks = new Book[100];
    int borrowedCount = 0;
    int loanDurationInDays;


    public void Student(String name, String faculty, String nim, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.programStudi = programStudi;
    }

    void displayInfo() {
        System.out.println("Nama: " + name);
        System.out.println("Fakultas: " + faculty);
        System.out.println("NIM: " + nim);
        System.out.println("Program Study: " + programStudi);
    }

    public void displayBooks(Book[] bookList, int bookCount) {
        boolean hasBooks = false;
        for (int i = 0; i < bookCount; i++) {
            Book book = bookList[i];
            if (book != null) {
                hasBooks = true;
                System.out.println("ID: " + book.getBookId() + ", Judul: " + book.getTitle() + ", Penulis: " + book.getAuthor() + ", Stok: " + book.getStock());
            }
        }
        if (!hasBooks) {
            System.out.println("Belum ada buku yang ditambahkan, minta tolong admin tambahkan buku terlebih dahulu.");

        }
    }


    void borrowBook(Book[] bookList, int bookCount) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukan Id Buku yang ingin anda pinjam: ");
            String id = scanner.nextLine();
            for (int i = 0; i < bookCount; i++) {
                Book book = bookList[i];
                if (book.getBookId().equals(id)) {
                    if (book.getStock() > 0) {

                        System.out.print("Masukan durasi peminjaman (max 30 hari): ");
                        loanDurationInDays = scanner.nextInt();
                        scanner.nextLine();

                        if (loanDurationInDays > 30) {
                            System.out.println("Maksimumnya 30 hari, kamu berlebihan. Rubah  ke 30 harimaksimal.");
                            loanDurationInDays = 30;
                        }
                        book.setStock(book.getStock() - 1);

                        borrowedBooks[borrowedCount++] = book;
                        System.out.println("Kamu telah meminjam buku : " + book.getTitle() + ".");
                        System.out.println("Jangan lupa di kembalikan sebelum " + loanDurationInDays + " hari yaa.");
                        return;
                    } else {
                        System.out.println("Sorry bolo buku seng iki ndak onog stock e.");
                        break;
                    }
                }
                if (i == bookCount - 1) {
                    System.out.println("Buku dengan id:" + " "+ book.getBookId()+" "+"tidak tersedia" );
                }
            }
        }
    }


    void displayBorrowedBooks() {
        if (borrowedCount == 0) {
            System.out.println("Kamu belum meminjam buku bro, Pinjam dulu .");
            return;
        }
        System.out.println("kamu telan meminjam buku:");
        for (int i = 0; i < borrowedCount; i++) {
            Book book = borrowedBooks[i];
            System.out.println("======================================================================================================");
            System.out.println("Book ID          ||Nama Buku              ||Penulis Buku           ||Durasi            ||");
            System.out.println("======================================================================================================");
            System.out.println(book.getBookId() + "               ||" + book.getTitle() + "             || " + book.getAuthor()+"                    ||:" + " "+loanDurationInDays+" hari"+"            ||");
            System.out.println("=====================================================================================================");



        }
    }


    void logout() {

        System.out.println("Anda telah keluar.");
    }

    void returnBooks(Book[] bookList, int bookCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan  ID buku yang ingub kamu kembalikan: ");
        String id = scanner.nextLine();
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i].getBookId().equals(id)) {
                for (int j = 0; j < bookCount; j++) {
                    if (bookList[j].getBookId().equals(id)) {
                        bookList[j].setStock(bookList[j].getStock() + 1);
                        borrowedBooks[i] = null;
                        System.out.println("Terimakasi kamu sudah mengembalikan buku " + bookList[j].getTitle() + ".");
                        borrowedCount--;
                        return;
                    }
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public String getNim() {
        return nim;
    }
}
