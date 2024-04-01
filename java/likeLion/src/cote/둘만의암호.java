package cote;

public class 둘만의암호 {
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String alphabet = allAlphabet();

        // 알파벳에서 skip부분을 뺌
        for (int i = 0; i < skip.length(); i++) {
            alphabet = alphabet.replace(Character.toString(skip.charAt(i)),"");
        }
        for (int i = 0; i < s.length(); i++) {
            int tmp = alphabet.indexOf(s.charAt(i))+index; // 알파벳에서 s의 위치에 + index
            answer.append(alphabet.charAt(tmp % alphabet.length()));
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        String s= "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println("solution(s,skip,index) = " + solution(s, skip, index));

    }
    private static String allAlphabet() {
        StringBuilder alphabet = new StringBuilder();


        for (int charCode = 97; charCode <= 122; charCode++) {
            alphabet.append((char) charCode);
        }

        return alphabet.toString();

    }
}
