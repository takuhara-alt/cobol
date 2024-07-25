import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentRecord {
    private static final String FILE_PATH = "/Users/takuhara-alt/Desktop/meike-it/cobol/covol-conv-java/students.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean eof = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            while (!eof) {
                System.out.print("学籍番号を入力してください。(終了するにはendと入力してください): ");
                String studentId = scanner.nextLine();
                
                if ("end".equalsIgnoreCase(studentId)) {
                    eof = true;
                } else {
                    System.out.print("名前を入力してください。: ");
                    String studentName = scanner.nextLine();
                    
                    System.out.print("借りた日を入力してください (YYYYMMDD): ");
                    String borrowDate = scanner.nextLine();
                    
                    // データのフォーマットを整えてファイルに書き込む
                    String record = String.format("%-10s%-40s%-10s", studentId, studentName, borrowDate);
                    writer.write(record);
                    writer.newLine(); // 改行を追加
                }
            }
            
            System.out.println("プログラムが終了しました。");
        } catch (IOException e) {
            System.err.println("ファイルの書き込み中にエラーが発生しました: " + e.getMessage());
        }
        
        scanner.close();
    }
}
