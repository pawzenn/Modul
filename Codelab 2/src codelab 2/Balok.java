import java.util.Scanner;

public class Balok extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double panjang;
    private double lebar;
    private double tinggi;

    Balok(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input panjang Balok: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar Balok: ");
        lebar = scanner.nextDouble();
        System.out.println("Input tinggi Balok: ");
        tinggi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 2 * (panjang * lebar) + (panjang * tinggi) + (lebar* tinggi);
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan Balok: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = panjang*lebar*tinggi;
        super.volume();
        System.out.println("Hasil volume Balok: " + hasil);
    }

}
