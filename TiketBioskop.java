import java.util.Scanner;
public class TiketBioskop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int HARGA_TIKET = 50000;
        int totalTiketTerjual = 0;
        double totalPenjualan = 0;
        String ulangi;

        System.out.println("==============================================");
        System.out.println("  PROGRAM PENGHITUNG PENJUALAN TIKET BIOSKOP  ");
        System.out.println("==============================================");
        System.out.println("Harga per tiket: Rp " + HARGA_TIKET);

        // Perulangan DO-WHILE untuk mencatat transaksi sampai pengguna selesai
        do {
            int jumlahTiket = 0;
            double diskon = 0;
            double hargaTransaksi;
            
            // Perulangan WHILE untuk validasi input jumlah tiket
            while (true) {
                System.out.print("\nMasukkan jumlah tiket yang dibeli (0 untuk selesai): ");
                
                
                if (sc.hasNextInt()) {
                    jumlahTiket = sc.nextInt();
                    sc.nextLine(); 
                } else {
                    System.out.println("Input tidak valid. Harap masukkan angka.");
                    sc.next(); // membuang input yang salah
                    continue; // lanjut ke awal perulangan while
                }

                // Cek kondisi selesai atau validasi negatif
                if (jumlahTiket == 0) {
                    break; // Keluar dari perulangan validasi, menuju break do-while
                } else if (jumlahTiket < 0) {
                    // Kondisi input tidak valid (negatif)
                    System.out.println("Jumlah tiket tidak valid (tidak boleh negatif). Harap ulangi.");
                    continue; // Meminta input ulang untuk jumlah tiket
                } else {
                    // Input valid (positif)
                    break; // Keluar dari perulangan validasi, lanjutkan ke perhitungan
                }
            }
            
            // Jika input 0, keluar dari perulangan transaksi utama
            if (jumlahTiket == 0) {
                System.out.println("\n*** Pencatatan transaksi selesai ***");
                break; 
            }

            // 1. Menentukan Diskon
            if (jumlahTiket > 10) {
                diskon = 0.15; // 15%
            } else if (jumlahTiket > 4) {
                diskon = 0.10; // 10%
            }
            
            double totalSebelumDiskon = jumlahTiket * HARGA_TIKET;
            double jumlahDiskon = totalSebelumDiskon * diskon;
            hargaTransaksi = totalSebelumDiskon - jumlahDiskon;

            // 2. Update Total Keseluruhan
            totalTiketTerjual += jumlahTiket;
            totalPenjualan += hargaTransaksi;

            // Tampilan Transaksi Saat Ini
            System.out.println("----------------------------------------------");
            System.out.println("Jumlah Tiket : " + jumlahTiket);
            System.out.println("Total Harga Sebelum Diskon : Rp " + (int)totalSebelumDiskon);
            System.out.println("Diskon (" + (int)(diskon * 100) + "%) : Rp " + (int)jumlahDiskon);
            System.out.println("TOTAL HARGA BAYAR : Rp " + (int)hargaTransaksi);
            System.out.println("----------------------------------------------");

        } while (true); // Perulangan akan terus berjalan sampai bertemu 'break'

        // Tampilan Hasil Akhir
        System.out.println("\n========= REKAP PENJUALAN HARI INI =========");
        System.out.println("Total Tiket Terjual : " + totalTiketTerjual + " tiket");
        System.out.println("Total Harga Penjualan : Rp " + (int)totalPenjualan);
        System.out.println("===================================================");
        
        sc.close();
    }
}
    
    

