import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
public class Frame3 extends JFrame implements ActionListener
//membuat objek
{
private JLabel label;
private JTextArea tArea;
private JButton btnKembali, btnBatal, btnIn;
private String isiTextArea;
public Frame3()
{
super("MENGGUNAKAN TEXT AREA");
setSize(400,500);
//menugaskan objek

SQLCon.getData();
isiTextArea = "ID Pengguna: "+Master.dataTemp[0]+"\nNama: "+Master.dataTemp[1]+"\nNama Maskapai: "+Master.dataTemp[2]+"\nTanggal Keberangkatan: "+Master.dataTemp[3]+"\nTujuan: "+Master.dataTemp[4];

label = new JLabel("Rincian Pesanan");
tArea = new JTextArea(25,20);
tArea.setText(isiTextArea);
btnKembali = new JButton("Kembali");
btnBatal = new JButton("Batal Tiket");
btnIn = new JButton("Check-In");

btnBatal.setBackground(new Color(26, 107, 217));
btnIn.setBackground(new Color(26, 107, 217));
btnKembali.setBackground(new Color(26, 107, 217));

btnBatal.setForeground(Color.WHITE);
btnIn.setForeground(Color.WHITE);
btnKembali.setForeground(Color.WHITE);
//meletakkan objek pada Jpanel
JPanel p1 = new JPanel();
JPanel p2 = new JPanel();
JPanel p3 = new JPanel();
//mengatur posisi Jpanel pada frame
tArea.setEditable(false);
p1.add(label);
p2.add(tArea);
p3.add(btnKembali);
p3.add(btnBatal);
p3.add(btnIn);
add("North", p1);
add("Center", p2);
add("South", p3);

btnKembali.addActionListener(this);
btnBatal.addActionListener(this);
btnIn.addActionListener(this);
setVisible(true);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}


public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnKembali){
            setVisible(false);
            new Frame2();
        } else if(e.getSource()==btnBatal){
            SQLCon.setCekin();
            JOptionPane.showMessageDialog(null, "Tiket Berhasil Dibatalkan", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Frame1();
        } else if(e.getSource()==btnIn){
            SQLCon.setCekin2();
            JOptionPane.showMessageDialog(null, "Berhasil Melakukan Check-In", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Frame1();
        }
    }
}