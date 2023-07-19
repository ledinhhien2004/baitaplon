package baitaplonjava;

import java.util.Scanner;

public class Thu {
	 static String[] tenmathang;
	 static String[] donvi;
	 static double[] soluong;
	 static double[] giaban;
	 static double[] thanhtien ;
	 static int n = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char key;
		do {
			inMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print(" ==> Xin Hãy Chọn Chức Năng Thực Hiện: ");
			key = sc.next().charAt(0);
			
			switch(key) {
			case '1':
				n = nhapSLMH();
				tenmathang = new String[n];
				donvi = new String[n];
				soluong = new double[n];
				giaban = new double[n];
				thanhtien = new double[n];
				System.out.print(n);
				nhapTVSL(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '2':
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '3':
				tinhthanhtien(soluong, giaban);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '4':
				sapxepTD(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '5':
				sapxepGD(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case '6':
				timkiemMH(tenmathang, donvi, soluong, giaban, thanhtien);
				inDSMH(tenmathang, donvi, soluong, giaban, thanhtien);
				break;
			case 'Q':
				System.out.println("\\-------------*****------------//");
				System.out.println("||Bạn đã chọn thoát chương trinh||");
				System.out.println("//-------------*****------------\\");
				break;
			case 'q':
				System.out.println("\\\\-------------*****------------//");
				System.out.println("||Bạn đã chọn thoát chương trinh||");
				System.out.println("//-------------*****------------\\\\");
				break;
			}
		}while(key != 'Q' || key != 'q');
	}
	public static void inMenu() {
		System.out.println("\\\\***************************=+=************************//");
		System.out.println("|| 1 : Nhập Dữ Liệu Mặt Hàng                              ||");
		System.out.println("|| 2 : In Danh Sách Mặt Hàng                              ||");
		System.out.println("|| 3 : Thành Tiền                                         ||");
		System.out.println("|| 4 : Sắp Xếp Mặt Hàng Theo Chiều Tăng Dần Của Giá Bán   ||");
		System.out.println("|| 5 : Sắp Xếp Mặt Hàng Theo Chiều Giảm Dần Của Thành Tiền||");
		System.out.println("|| 6 : Tìm Kiếm Mặt Hàng                                  ||");
		System.out.println("|| Q/q : Thoát Chương Trình                	              ||");
		System.out.println("//********************************************************\\\\");
	}
	public static int nhapSLMH() {
		try {
			
			int n;
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.println("Nhập Số Lượng Hàng Hoá ");
				n = sc.nextInt();
				
			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Trong Quá Trình Nhập!");	
			return -1;
		}
	
	}
	public static void nhapTVSL(String[] tenmathang, String[] donvi, double[] soluong,  double[] giaban, double[] thanhtien) {
		System.out.println("|==================================|");
		try {
			for (int i = 0; i < tenmathang.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhập Dữ Liệu Hàng Hoá:  " + (i + 1));
				System.out.print("Tên Mặt Hàng: ");
				tenmathang[i] = sc.nextLine();
				System.out.print("Đơn Vị: ");
				donvi[i] = sc.nextLine();
				System.out.print("Số Lượng: ");
				soluong[i] = sc.nextDouble();
				System.out.print("Giá Bán: ");
				giaban[i] = sc.nextDouble();
				}
			
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Trong Quá Trình Nhập!");
		}
		System.out.println("|==================================|");
	}
	public static void inDSMH(String[] tenmathang, String[] donvi, double[] soluong,  double[] giaban, double[] thanhtien) {
		System.out.println("||_________________________________________________________________________________________________________________________||");
		System.out.println("||------------------------------------------Danh Sách Mặt Hàng-------------------------------------------------------------||");
		for (int i = 0; i < tenmathang.length; i++) {
			System.out.println("||Tên Mặt Hàng: " +tenmathang[i] +"; Đơn Vị: " + donvi[i] + "; Số Lượng: " + soluong[i] + "; Giá Bán: " + giaban[i] + "; Thành Tiền: " + thanhtien[i]+"    ||");
		}
		System.out.println("||_________________________________________________________________________________________________________________________||");
	}
	public static double[] tinhthanhtien(double[] soluong, double[] giaban) {
		
	
		System.out.println("||------------------------------||");
		System.out.println("||			Thành Tiền		||");
		System.out.println("||------------------------------||");
			for (int i = 0; i < thanhtien.length; i++) {
				
				thanhtien[i]= (soluong[i] * giaban[i]);
			}return thanhtien;
		
	}
	public static void sapxepTD(String[] tenmathang, String[] donvi, double[] soluong,  double[] giaban, double[] thanhtien) {
		for (int i = 0; i < giaban.length - 1; i++) {
			for (int j = i + 1; j < giaban.length; j++) {
				if (giaban[i] > giaban[j]) {
					// hoan vi DTB
					double tam = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam;
					// hoan vi Toan
					tam = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam;
					// hoan vi Van
					tam = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam;
					// hoan vi Anh
					String tam2 = donvi[i];
					donvi[i] = donvi[j];
					donvi[j] = tam2;
					// hoan vi hoten
					String tam3 = tenmathang[i];
					tenmathang[i] = tenmathang[j];
					tenmathang[j] = tam3;
				}
			}
		}
	}
	
	public static void sapxepGD(String[] tenmathang, String[] donvi, double[] soluong,  double[] giaban, double[] thanhtien) {
		for (int i = 0; i < thanhtien.length - 1; i++) {
			for (int j = i; j < thanhtien.length; j++) {
				if (thanhtien[i] < thanhtien[j]) {
					// hoán vị Số Lượng
					double tam = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam;
					// hoan vi Giá Bán
					tam = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam;
					// hoan vi thành tiền
					tam = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam;
					// hoan vi đơn vị 
					String tam2 = donvi[i];
					donvi[i] = donvi[j];
					donvi[j] = tam2;
					// hoan vi tên mặt hàng
					String tam3 = tenmathang[i];
					tenmathang[i] = tenmathang[j];
					tenmathang[j] = tam3;
				}
			}
		}
	}
	public static void timkiemMH(String[] tenmathang, String[] donvi, double[] soluong,  double[] giaban, double[] thanhtien) {
		
	}		
}

