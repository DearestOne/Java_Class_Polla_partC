import java.util.Scanner;
class Encoder {
    String[] word;
    int[] id;
    Encoder(String[] word,int[] id){
        this.word = java.util.Arrays.copyOf(word,word.length);
        this.id = id;
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
public class EnDecoder1 {
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
        int k = scan.nextInt();
        String[] vocab = new String[k];
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            vocab[i] = scan.next();
        }
        result = en.encodeMsg(vocab);
        for(int i=0;i<k;i++){
            System.out.print(result[i] + " ");
        }
    }
}
