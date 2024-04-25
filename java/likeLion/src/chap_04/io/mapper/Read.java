package chap_04.io.mapper;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import static chap_04.io.address.output;

public class Read {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(output))) {
            while (true) { // 무한 루프로 변경
                try {
                    Member member = (Member) ois.readObject();
                    System.out.println("member = " + member);
                } catch (EOFException e) {
                    // 파일의 끝에 도달하면 EOFException이 발생하고 루프를 종료합니다.
                    System.out.println("더 이상 읽을 객체가 없습니다.");
                    break;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
