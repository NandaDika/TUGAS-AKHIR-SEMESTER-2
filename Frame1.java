import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 implements ActionListener {

    private static JButton pesanButton;
    private static JButton cekinButton;
    private JFrame frame;
    protected Master Master = new Master();
    public Frame1(){
        frame = new JFrame("Terbang-In Aja!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
        frame.setBackground(new Color(250, 250, 250));
        
        
        //Membuat panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Tempat menambahkan gambar 
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(Master.logo)); // Ubah "gambar.png" sesuai dengan lokasi dan nama file gambar Anda
        JLabel imageLabel = new JLabel(imageIcon);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 10, 50, 10);
        panel.add(imageLabel, constraints);

        pesanButton = new JButton("Pesan  Tiket");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 10, 40, 5);
        pesanButton.setBackground(new Color(26, 107, 217));
        pesanButton.setForeground(Color.WHITE);
        panel.add(pesanButton, constraints);
        pesanButton.addActionListener(this);

        cekinButton = new JButton("   Login   ");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 10, 150, 5);
        cekinButton.setBackground(new Color(26, 107, 217));
        cekinButton.setForeground(Color.WHITE);
        panel.add(cekinButton, constraints);
        cekinButton.addActionListener(this);
        //Menambahkan panel ke frame
        panel.setBackground(new Color(250, 250, 250));
        frame.add(panel);
        frame.setLocationRelativeTo(null); // Untuk menempatkan frame di tengah layar
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==pesanButton){
            new Frame4();
            frame.setVisible(false);
        }else if(e.getSource()==cekinButton){
            new Frame2();
            frame.setVisible(false);
        }
    }    
}
