
import java.util.Scanner;
import java.util.regex.Pattern;

public class PendaftaranJalurPendaki {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM PENDAFTARAN PENDAKIAN GUNUNG SEBATUNG ===");
        System.out.println("Silakan isi formulir di bawah ini:\n");

        String regexID = "^SBT202[0-9]\\d{4}$";
        String idPendaki = getValidInput(input, "ID Pendaki (Contoh: SBT20240001)", regexID,
                "ID harus diawali 'SBT', diikuti tahun 202x, dan 4 angka unik.");

        String regexPhone = "^\\+62[0-9]{10,13}$";
        String phone = getValidInput(input, "2. Masukkan No. Telepon Darurat (Contoh: +628123456789): ", regexPhone,
                "Nomor harus diawali '+62' dan diikuti 10-13 digit angka.");

        String regexJalur = "^[A-Z][0-9]{2}$";
        String kodeJalur = getValidInput(input, "Kode Jalur (Contoh: B01)", regexJalur,
                "Kode jalur harus 1 huruf kapital diikuti 2 angka (misal: A05).");

        System.out.println("\n=== PENDAFTARAN BERHASIL ===");
        System.out.println("ID Pendaki : " + idPendaki);
        System.out.println("No. Telp   : " + phone);
        System.out.println("Kode Jalur : " + kodeJalur);
        System.out.println("============================");

        System.out.println("\n=======================================================");
        System.out.println("Terima kasih telah menggunakan sistem validasi Gunung SEBATUNG.");
        input.close();
    }

    public static String getValidInput(Scanner sc, String label, String regex, String errorMsg) {
        String userInput;
        while (true) {
            System.out.print("Masukkan " + label + ": ");
            userInput = sc.nextLine();

            if (Pattern.matches(regex, userInput)) {
                System.out.println("   > Status: [ VALID ]\n");
                break; 
            } else {
                System.out.println("   > Status: [ TIDAK VALID ]");
                System.out.println("     Pesan: " + errorMsg);
                System.out.println("     Silakan coba lagi.\n");
            }
        }
        return userInput;
    }
}
