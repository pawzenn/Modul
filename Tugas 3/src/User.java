import java.util.Scanner;

public class User {
    public int bookCount;
    protected Book[] bookList;
    protected Scanner scanner;

    public User(Book[] bookList) {
        this.bookList = bookList;
        this.scanner = new Scanner(System.in);
    }

    public User() {

    }
    int generateId() {
        return bookCount;
    }

    void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih kategori buku:");
        System.out.println("1. Buku Sejarah");
        System.out.println("2. Buku Cerita");
        System.out.println("3. Buku Pelajaran");
        System.out.print("Masukkan pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Mengonsumsi karakter newline

        System.out.print("Masukkan ID buku: ");
        String bookId = scanner.nextLine();
        System.out.print("Masukkan judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan penulis: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan stok: ");
        int stock = scanner.nextInt();

        switch (choice) {
            case 1:
                HistoryBook historyBook = new HistoryBook(bookId, title, author, stock, "History");
                bookList[bookCount++] = historyBook;
                break;
            case 2:
                StoryBook storyBook = new StoryBook(bookId, title, author, stock, "Story");
                bookList[bookCount++] = storyBook;
                break;
            case 3:
                TextBook textBook = new TextBook(bookId, title, author, stock, "Text");
                bookList[bookCount++] = textBook;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }


    void displayBooks() {
        boolean booksAdded = false;
        for (int i = 0; i < bookList.length; i++) {
            Book book = bookList[i];
            if (book != null) {
                booksAdded = true;
                System.out.println("ID: " + book.getBookId()+"||" + "Judul: " + book.getTitle() + "||"+"Penulis: " + book.getAuthor() +"||"+ "Stok: " + book.getStock()+"||");
            }
        }
        if (!booksAdded) {
            System.out.println("Belum ada buku yang ditambahkan, tolong tambahkan buku terlebih dahulu.");
        }
    }


}
