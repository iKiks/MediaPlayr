import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JButton button1;
    JButton button2;
    File file;
    MyAudioPlayer audioPlayer;

    MyFrame(MyAudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Select File");
        button.addActionListener(this);

        button1 = new JButton("Play");
        button1.addActionListener(this);

        button2 = new JButton("Stop");
        button2.addActionListener(this);

        this.add(button);
        this.add(button1);
        this.add(button2);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(".")); 

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                audioPlayer = new MyAudioPlayer(file); 
            }
        }
        if (e.getSource() == button1) {
            audioPlayer.play();

        }
        if (e.getSource() == button2) {
            audioPlayer.pause();
        }
    }
}