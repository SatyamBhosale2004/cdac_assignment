
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Encrypt {
	public static void main(String args[]) {
		String pathOg = "D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\assignment\\Original.txt";
		String pathEncrypt = "D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\assignment\\EncrptDecrypt.txt";
		boolean flag = true;
		try(FileOutputStream out = new FileOutputStream(pathOg)){
			String data = "Hello bhai";
			out.write(data.getBytes());
			
		}catch(FileNotFoundException e ) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		while(flag) {
			System.out.println("======================Menu======================");
			System.out.println("1. Encrypt");
			System.out.println("2. Decrypt");
			System.out.println("3. Exit");
			int choice = ConsoleInput.getInt();
			final int ENCRYPT = 1;
			final int DECRYPT = 2;
			final int EXIT = 3;
			switch(choice) {
				case ENCRYPT:
					try(FileInputStream in = new FileInputStream(pathOg);
						FileOutputStream out = new FileOutputStream(pathEncrypt)) {
						File file = new File(pathOg);
						byte buffer[] = new byte[(int) file.length()];
						in.read(buffer);
						for(int iTmp=0;iTmp<buffer.length;iTmp++) {
							buffer[iTmp] += 3;
						}
						out.write(buffer);
						System.out.println("Conetnts have been encrypte");
					}catch(FileNotFoundException e ) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case DECRYPT:
					try(FileInputStream in = new FileInputStream(pathEncrypt)){
						File file = new File(pathEncrypt);
						byte buffer[] = new byte[(int) file.length()];
						in.read(buffer);
						for(int iTmp=0;iTmp<buffer.length;iTmp++) {
							buffer[iTmp] -=3;
						}
						System.out.println(new String(buffer));
					}catch(FileNotFoundException e ) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case EXIT:
					flag = false;
					break;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}
