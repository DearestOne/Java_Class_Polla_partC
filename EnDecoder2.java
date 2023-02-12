import java.util.Scanner;
class Encoder {
    String[] word;
    int[] id;
    Encoder(String[] word,int[] id){
        this.word = java.util.Arrays.copyOf(word,word.length);
        this.id = java.util.Arrays.copyOf(id,id.length);
    }
    private int encodeWord(String vocab){
        for(int i=0;i<word.length;i++){
            if(vocab.equals(word[i])){
                return id[i];
            }
        }
        return -1;
    }
    int[] encodeMsg(String[] vocab){
        int[] result = new int[vocab.length];
        for(int i=0;i<vocab.length;i++){
            result[i] = encodeWord(vocab[i]);
        }
        return result;
    }
}
class Decoder{
    String[] word;
    int[] id;
    Decoder(String[] word,int[] id){
        this.word = java.util.Arrays.copyOf(word,word.length);
        this.id = java.util.Arrays.copyOf(id,id.length);
    }
    private String decodeWord(int ID){
        for(int i=0;i<word.length;i++){
            if(ID == id[i]){
                return word[i] + " ";
            }
        }
        return "? ";
    }
    String decodeMsg(int[] ID){
        String result = "";
        for(int i=0;i<ID.length;i++){
            result += decodeWord(ID[i]);
        }
        return result;
    }
}
public class EnDecoder2 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        String[] word = new String[n];
        int[] id = new int[n];
        for(int i=0;i<n;i++){
            word[i] = scan.next();
        }
        for(int i=0;i<n;i++){
            id[i] = scan.nextInt();
        }
        Encoder en = new Encoder(word, id);
        Decoder de = new Decoder(word, id);
        int k = scan.nextInt();
        String[] vocab = new String[k];
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            vocab[i] = scan.next();
        }
        result = en.encodeMsg(vocab); // encoded to int[]
        System.out.println(de.decodeMsg(result));
    }
}
