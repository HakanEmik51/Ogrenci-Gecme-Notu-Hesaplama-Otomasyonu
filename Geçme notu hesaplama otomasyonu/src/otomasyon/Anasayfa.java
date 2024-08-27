package otomasyon;//21100011062 HAKAN EMİK

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) throws IOException {
		Scanner verial = new Scanner(System.in);
		ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
		ArrayList<Ders> dersler = new ArrayList<Ders>();
		ArrayList<Ders> gecici1 = new ArrayList<Ders>();
		ArrayList<Ders> gecici3 = new ArrayList<Ders>();
		int secim;
		int knt7 = 0;
		int knt = 0;
		int knt6 = 0;
		
		char gecici;
		String txt, txt3;
		String txt2;
		String[] txtbol2;
		String[] txtbol;
		File ders = new File("ders.txt");
		File ogrenci = new File("ogrenci.txt");
		FileReader ders2 = new FileReader(ders);
		BufferedReader ders3 = new BufferedReader(ders2);
		while ((txt = ders3.readLine()) != null) {
			txtbol = txt.split("%");
			dersler.add(new Ders(Integer.parseInt(txtbol[0]), txtbol[1]));

		}
		ders2.close();
		ders3.close();
		int sayac = dersler.get(dersler.size()-1).getDersId()+10;
		FileReader ogr = new FileReader(ogrenci);
		BufferedReader ogr2 = new BufferedReader(ogr);
		ArrayList<Ders> gecici4 = null;
		int knt5 = 0;
		String adsoyad = null;
		int id = 0, yas = 0;
		while ((txt2 = ogr2.readLine()) != null) {

			gecici = txt2.charAt(0);
			txt3 = txt2.substring(1);
			txtbol2 = txt3.split("%");
			if (gecici == '+' && knt5 == 1) {
				ogrenciler.add(new Ogrenci(id, adsoyad, yas, gecici4));
				gecici3.clear();
			}
			if (gecici == '+') {
				knt5 = 1;
				id = Integer.parseInt(txtbol2[0]);
				adsoyad = txtbol2[1];
				yas = Integer.parseInt(txtbol2[2]);

			} else if (gecici == '*') {
				gecici3.add(new Ders(Integer.parseInt(txtbol2[0]), txtbol2[1]));
				gecici4 = (ArrayList<Ders>) gecici3.clone();

			}

		}
		ogrenciler.add(new Ogrenci(id, adsoyad, yas, gecici4));
		while (knt != 1) {
			System.out.println("ders eklemek için 1'e basiniz");
			System.out.println("dersleri listelemek için 2'e basiniz");
			System.out.println("ders adına göre aramak için 3'e basiniz");
			System.out.println("ders adına göre silmek için 4'e basiniz");
			System.out.println("ogrenci eklemek için 5'e basiniz");
			System.out.println("ogrencileri ayrıntılı listelemek için 6'a basiniz");
			System.out.println("ogrencileri listelemek için 7'e basiniz");
			System.out.println("ogrencileri silmek için 8'e basiniz");
			System.out.println("ogrenci ad soyadına gore aramak için 9'a basiniz");
			System.out.println("ogrenci id'sine göre derhane ücreti hesaplamak için 10'a basiniz");
			System.out.println("otomasyondan çıkmak için 11'e basiniz");
			secim = verial.nextInt();
			switch (secim) {
			case 1:
				String dersad = verial.nextLine();
				System.out.println("ders adı giriniz");
				dersad = verial.nextLine();
				dersler.add(new Ders(sayac, dersad));
				sayac += 10;
				break;
			case 2:
				for (Ders temp_ders : dersler) {
					System.out.println("ID: " + temp_ders.getDersId());
					System.out.println("AD: " + temp_ders.getDersAd());

				}
				break;
			case 3:
				String ara_ad = verial.nextLine();
				System.out.println("aranacak dersin adını girinz");
				ara_ad = verial.nextLine();
				for (Ders temp_ders : dersler) {
					if (ara_ad.equals(temp_ders.getDersAd())) {
						System.out.println("ID: " + temp_ders.getDersId());
						System.out.println("AD: " + temp_ders.getDersAd());

					}
				}
				break;
			case 4:
				String sil_ad = verial.nextLine();
				System.out.println("silinecek dersin adını giriniz");
				sil_ad = verial.nextLine();
				for (Ogrenci temp_ogr : ogrenciler) {
					for (int i = 0; i < temp_ogr.alinanDersler.size(); i++) {
						if (temp_ogr.alinanDersler.get(i).getDersAd().equals(sil_ad) && knt6 == 0) {
							System.out.println("bu ders silinemez");
							knt6 = 1;
							break;
						}
					}
				}
				if (knt6 == 0) {
					for (int i = 0; i < dersler.size(); i++) {
						if (dersler.get(i).getDersAd().equals(sil_ad)) {
							dersler.remove(dersler.get(i));
						}

					}
				}

				break;

			case 5:
				System.out.println("eklenecek ogrenci ıdsi");
				int ogr_ıd = verial.nextInt();
				int knt1 = 0;
				String ekle_ad = null;
				ArrayList<Ders> gecici2 = null;
				int ekle_id;
				for (Ogrenci temp_ogr : ogrenciler) {
					if (temp_ogr.getOgrId() == ogr_ıd) {
						knt1 = 1;
					}
				}
				if (knt == 0) {
					String ogradsoy = verial.nextLine();
					System.out.println("eklenecek ogrenci adı soyadı:");
					ogradsoy = verial.nextLine();
					System.out.println("eklenecek ogrenci yası:");
					int ogr_yas = verial.nextInt();
					System.out.println("ogrenci kac ders alıcak");
					int ders_sayisi = verial.nextInt();
					for (Ders temp_ders : dersler) {
						System.out.println("ID: " + temp_ders.getDersId());
						System.out.println("AD: " + temp_ders.getDersAd());

					}

					int knt3 = 0;
					for (int i = 0; i < ders_sayisi; i++) {
						System.out.println("eklemek istediğiniz dersin ıdsini giriniz");
						ekle_id = verial.nextInt();

						for (Ders temp_ders : dersler) {
							if (ekle_id == temp_ders.getDersId()) {
								ekle_ad = temp_ders.getDersAd();
								gecici1.add(new Ders(ekle_id, ekle_ad));
								gecici2 = (ArrayList<Ders>) gecici1.clone();

								knt3 = 1;
								break;
							}

						}

						if (knt3 == 0) {
							System.out.println("ders ıdsi bulunamadı ana menuye yonlendiriliyorsunuz");
							break;
						}
					}
					ogrenciler.add(new Ogrenci(ogr_ıd, ogradsoy, ogr_yas, gecici2));
					gecici1.clear();

				} else {
					System.out.println("id başka bir ogrncide bulunuyor ana meuye yollendiriliyorsunuz");
				}
				break;
			case 6:
				for (Ogrenci temp_ogr : ogrenciler) {
					System.out.println("ID: " + temp_ogr.getOgrId());
					System.out.println("AD: " + temp_ogr.getOgrAdSoyad());
					System.out.println("yas: " + temp_ogr.getOgrYas());
					for (int i = 0; i < temp_ogr.alinanDersler.size(); i++) {
						System.out.println("ders ad:" + temp_ogr.alinanDersler.get(i).getDersAd());
						System.out.println("ders id:" + temp_ogr.alinanDersler.get(i).getDersId());

					}

				}
				break;
			case 7:
				for (Ogrenci temp_ogr : ogrenciler) {
					System.out.println("ID: " + temp_ogr.getOgrId());
					System.out.println("AD SOYAD: " + temp_ogr.getOgrAdSoyad());
					System.out.println("yas :" + temp_ogr.getOgrYas());
				}
				break;
			case 8:

				System.out.println("silmek istediğiniz ogrencinin idsini giriniz");
				int sil = verial.nextInt();
				for (int i = 0; i < ogrenciler.size(); i++) {
					if (ogrenciler.get(i).getOgrId() == sil) {
						ogrenciler.remove(ogrenciler.get(i));
						knt7 = 1;

					}

				}
				if (knt7 == 0) {
					System.out.println("ogrenci bulunamadı");
				}
				break;
			case 9:
				String aranan_ad = verial.nextLine();
				System.out.println("aramak istediğiniz ogrencinin adı ve soyadını giriniz");
				aranan_ad = verial.nextLine();
				for (Ogrenci temp_ogr : ogrenciler) {
					if (temp_ogr.getOgrAdSoyad().equals(aranan_ad)) {
						System.out.println("ID: " + temp_ogr.getOgrId());
						System.out.println("AD SOYAD: " + temp_ogr.getOgrAdSoyad());
						System.out.println("yas: " + temp_ogr.getOgrYas());
						for (int i = 0; i < temp_ogr.alinanDersler.size(); i++) {
							System.out.println("ders ad: " + temp_ogr.alinanDersler.get(i).getDersAd());
							System.out.println("ders id: " + temp_ogr.alinanDersler.get(i).getDersId());

						}

					}

				}
				break;
			case 10:
				System.out.println("dershane ucretini hesapalamak istediğinğiz ogencini id'sini giriniz");
				int ucret_id = verial.nextInt();
				for (Ogrenci temp_ogr : ogrenciler) {
					if (temp_ogr.getOgrId() == ucret_id) {
						int sayi = temp_ogr.alinanDersler.size();
						if (sayi == 2) {
							System.out.println("1. kampanyadan faydalanacaksınız");
							double tutar = (400 * 4) + 4 * (400 - (400 * 0.05));
							System.out.println("dershaneye odeyeceğiniz aylık ücret:" + tutar);
						} else if (sayi == 3) {
							System.out.println("2. kampanyadan faydalanacaksınız");
							double tutar = (400 * 4) + (400 * 4) + 4 * (400 - (400 * 0.15));
							System.out.println("dershaneye odeyeceğiniz aylık ücret:" + tutar);
						} else if (sayi > 3) {
							System.out.println("3. kampanyadan faydalanacaksınız");
							double tutar = sayi * (400 - (400 * 0.1));
							System.out.println("dershaneye odeyeceğiniz aylık ücret:" + tutar);

						} else {
							System.out.println("tek ders alana kanpanya yok");
						}
					}

				}
				break;
			case 11:
				FileWriter dersyaz=new FileWriter(ders);
				BufferedWriter dersyaz1=new BufferedWriter(dersyaz);
				for(Ders temp_ders:dersler) {
					dersyaz1.write(temp_ders.getDersId()+"%"+temp_ders.getDersAd()+"\n");
					
				}
				dersyaz.flush();
				dersyaz1.flush();
				FileWriter ogryaz=new FileWriter(ogrenci);
				BufferedWriter ogryaz1=new BufferedWriter(ogryaz);
				for(Ogrenci temp_ogr:ogrenciler) {
					ogryaz1.write("+"+temp_ogr.getOgrId()+"%"+temp_ogr.getOgrAdSoyad()+"%"+temp_ogr.getOgrYas()+"\n");
					for(int i=0;i<temp_ogr.alinanDersler.size();i++) {
						ogryaz1.write("*"+temp_ogr.alinanDersler.get(i).getDersId()+"%"+temp_ogr.alinanDersler.get(i).getDersAd()+"\n");
						
						
					}
					
				}
				ogryaz.flush();
				ogryaz1.flush();
				knt=1;
				break;
			}
		}
	}

}
