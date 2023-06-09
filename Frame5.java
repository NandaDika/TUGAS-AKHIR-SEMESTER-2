import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

public class Frame5 extends Master implements ActionListener{
    private JButton cancelButton = new JButton("Cancel");
    private JFrame frame = new JFrame();
    private JButton confirmButton = new JButton("Confirm");
    private TempUser userData  = new TempUser();
    JTextField paymentTextField = new JTextField(10);
    JTextArea billTextArea = new JTextArea();

    public Frame5() {
        
        frame.setTitle("TerbangIn-Aja!");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1366, 768));
        frame.setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());
        frame.setResizable(false);

        /*JLabel titleLabel = new JLabel("Bill Payment Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(0, 10, 500, 30);
        frame.add(titleLabel);*/

        JPanel backPanel = new JPanel();
        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("Background2.png")));
        backPanel.add(bg);
        frame.setContentPane(bg);

      
        billTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(billTextArea);
        scrollPane.setBounds(443, 150, 465, 300);
        frame.add(scrollPane);

        JLabel paymentLabel = new JLabel("Dibayarkan: ");
        paymentLabel.setBounds(553, 460, 80, 30);
        frame.add(paymentLabel);

       
        paymentTextField.setBounds(643, 460, 180, 30);
        frame.add(paymentTextField);

        
        cancelButton.setBounds(690, 600, 80, 30);
        cancelButton.addActionListener(this);
        frame.add(cancelButton);

        
        confirmButton.setBounds(593, 600, 80, 30);
        confirmButton.addActionListener(this);
        frame.add(confirmButton);

        userData.hitungHarga();

        dataUpload();

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public void dataUpload(){
        String jamTerbang = "";
        if(TempUser.maskapai=="Batik"){
            jamTerbang = "16:00:00";
        }else if(TempUser.maskapai == "Asia"){
            jamTerbang = "19:00:00";
        }else if (TempUser.maskapai == "Garuda"){
            jamTerbang = "06:00:00";
        }else if(TempUser.maskapai == "Lion"){
            jamTerbang = "12:00:00";
        }
        String isiText = "ID:"+TempUser.ID+"\nPassword: "+TempUser.PASS+"\nNama: "+TempUser.nama_user+"\nNIK: "+TempUser.nik_user+"\nMaskapai: "+TempUser.maskapai+"\nTanggal Keberangkatan: "+TempUser.hari+" "+TempUser.bulan+" "+TempUser.tahun+"\nTipe Kursi: "+TempUser.seat+"\nRute: "+TempUser.kota+"\nJam Keberangkatan:"+jamTerbang+"\nTotal Harga Tiket: "+userData.harga;
        billTextArea.append(isiText);

        
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancelButton){
            userData.clearData();
            new Frame4();
            frame.setVisible(false);
        } else if(e.getSource()==confirmButton){

            if(isNumeric(paymentTextField.getText())){
                if(Integer.parseInt(paymentTextField.getText())<userData.hargaInt){
                    JOptionPane.showMessageDialog(null, "Maaf, Uang yang anda masukkan kurang.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    SQLCon.setData(TempUser.nama_user);
                    if(SQLCon.sqlState != null && SQLCon.sqlState.equals("45000")){
                        JOptionPane.showMessageDialog(null, "MAAF DATA ANDA SUDAH TERDAFTAR", "DUPLIKASI DATA", JOptionPane.WARNING_MESSAGE);
                   }else{
                        double HargaTemp = Integer.parseInt(paymentTextField.getText())-userData.hargaInt;
                        JOptionPane.showMessageDialog(null, "Terimakasih \nData Kamu Sudah Tersimpan\nSisa Kembalian: "+HargaTemp);
                        frame.setVisible(false);
                        userData.clearData();
                        new Frame1();
                    }
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "Maaf, Input uang salah.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
    }   

}
