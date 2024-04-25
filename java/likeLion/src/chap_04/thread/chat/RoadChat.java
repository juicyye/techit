package chap_04.thread.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static chap_04.thread.chat.ChatMain.address;

public class RoadChat {
    public List<String> road(){
        String str = "";
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(address))) {
            while((str=br.readLine())!=null){
                list.add(str);
            }
            return list;
        } catch (EOFException e) {
            // 파일의 끝에 도달하면 EOFException이 발생하고 루프를 종료합니다.
            System.out.println("오류 발생");
            throw new IllegalArgumentException(e);
        }catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
