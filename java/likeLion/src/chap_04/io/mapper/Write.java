package chap_04.io.mapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static chap_04.io.address.output;

public class Write {
    public static void main(String[] args) {
        Member member1 = new Member(2L, "member1");
        Member member2 = new Member(3L, "member2");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output))){
            oos.writeObject(member1);
            oos.writeObject(member2);
            System.out.println("파일 저장완료");

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }


}
