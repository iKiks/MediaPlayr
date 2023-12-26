import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        File audioFile = new File("null");
        MyAudioPlayer audioPlayer = new MyAudioPlayer(audioFile);
        new MyFrame(audioPlayer);
    }
}
