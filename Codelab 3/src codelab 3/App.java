import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Balok balok = new Balok("balok");
        Kubus kubus = new Kubus("kubus");
        Tabung tabung = new Tabung("tabung");

        int pilihan;

        do {
            System.out.println("Pilih bangun ruang:");
            System.out.println("1. Balok");
            System.out.println("2. Kubus");
            System.out.println("3. Tabung");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    balok.inputNilai();
                    balok.luasPermukaan();
                    balok.volume();
                    break;
                case 2:
                    kubus.inputNilai();
                    kubus.luasPermukaan();
                    kubus.volume();
                    break;
                case 3:
                    tabung.inputNilai();
                    tabung.luasPermukaan();
                    tabung.volume();
                    break;
                case 4:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
