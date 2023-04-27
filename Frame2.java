import javax.swing.*;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 implements ActionListener {

    private JLabel imageLabel;
    private JTextField txtUserId;
    private JPasswordField txtPassword;
    private JButton btnMasuk;
    private JButton btnBatal;
    protected Master Master = new Master();
    private JFrame frame = new JFrame();
    public Frame2() {
        frame.setTitle("Terbang-In Aja!");
        frame.setSize(1366, 768);
        frame.setBackground(new Color(250, 250, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        // Panel untuk menempatkan komponen di tengah
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(1920, 1080));
        panel.setMinimumSize(new Dimension(1366, 768));
        panel.setBackground(new Color(250, 250, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10); // padding
        

        ImageIcon imageIcon = new ImageIcon(Master.logo);
        imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, gbc);

        // Label untuk ID User
        JLabel lblUserId = new JLabel("ID User: ");
        panel.add(lblUserId, gbc);

        // TextField untuk ID User
        txtUserId = new JTextField(50);
        panel.add(txtUserId, gbc);

        // Label untuk Password
        JLabel lblPassword = new JLabel("Password: ");
        panel.add(lblPassword, gbc);

        // PasswordField untuk Password
        txtPassword = new JPasswordField(50);
        panel.add(txtPassword, gbc);
        


        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(250, 250, 250));


        // Button Masuk
        btnMasuk = new JButton("Masuk");
        btnMasuk.setBackground(new Color(26, 107, 217));
        btnMasuk.setForeground(Color.WHITE);
        //gbc.anchor = GridBagConstraints.SOUTHWEST; // Mengatur posisi button ke tengah
        panel3.add(btnMasuk);
        btnMasuk.addActionListener(this);
        
        
        // Button Batal
        btnBatal = new JButton("Batal");
        btnBatal.setBackground(new Color(26, 107, 217));
        btnBatal.setForeground(Color.WHITE);
        //gbc.anchor = GridBagConstraints.SOUTHEAST; // Mengatur posisi button ke tengah
        panel3.add(btnBatal);
        panel.add(panel3, gbc);
        btnBatal.addActionListener(this);
        // Menempatkan panel di tengah frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Menempatkan frame di tengah layar
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnMasuk){
            String myPass = String.valueOf(txtPassword.getPassword());
            if(SQLCon.loginUser(txtUserId.getText(), myPass)==9){
                new FrameAdmin();
                frame.setVisible(false);
            }else if(SQLCon.loginUser(txtUserId.getText(), myPass)==2){
                JOptionPane.showMessageDialog(null, "User telah melakukan check-in", "WARNING", JOptionPane.WARNING_MESSAGE);
            }else if(SQLCon.loginUser(txtUserId.getText(), myPass)==1){
                frame.setVisible(false);
                Master.setUser(txtUserId.getText(), myPass);
                new Frame3();
            }else {
                JOptionPane.showMessageDialog(null, "User atau password salah", "WARNING", JOptionPane.WARNING_MESSAGE);
                txtUserId.setText("");
                txtPassword.setText("");
            }
        } else if(e.getSource()==btnBatal){
            new Frame1();
            frame.setVisible(false);
        }
    }  
}
