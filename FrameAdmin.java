import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAdmin implements ActionListener {
    private JLabel newPasswordLabel;
    private JTextField newPasswordTextField;
    private JButton updateButton, backButton;
    private JTable dataTable;
    private JFrame frame;

    public FrameAdmin() {
        // Set the size of the frame
        frame = new JFrame("TerbangIn-Aja!");
        frame.setSize(1366, 768);
        frame.setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());
        frame.setResizable(false);

        // Create a panel for the top of the frame
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        

        // Create a label and a text field for the new password
        newPasswordLabel = new JLabel("New Password:");
        newPasswordTextField = new JTextField(20);

        // Add the label and text field to the top panel
        topPanel.add(newPasswordLabel);
        topPanel.add(newPasswordTextField);

        // Create a button to update the password
        updateButton = new JButton("Update Password");

        // Add the button to the top panel
        topPanel.add(updateButton);

        // Create a table to display some data
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("NIK");
        model.addColumn("Rute");
        model.addColumn("Maskapai");
        model.addColumn("Status");

        dataTable = new JTable(model);

        SQLCon.setTable(model);

        JScrollPane scpane = new JScrollPane(dataTable);
        scpane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
        "Data Pembelian dan Status Pengguna",
        TitledBorder.CENTER,
        TitledBorder.TOP));

        // Add the table to the center of the frame
        frame.add(scpane, BorderLayout.CENTER);

        // Add the top panel to the top of the frame
        frame.add(topPanel, BorderLayout.NORTH);

        backButton = new JButton("Kembali");
        dataTable.setEnabled(false);
        frame.add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(this);
        updateButton.addActionListener(this);

        // Set the default close operation and make the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==backButton){
            new Frame1();
            frame.setVisible(false);
        }
        if(e.getSource()==updateButton){

            if(newPasswordTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Field Harus Diisi", "Peringatan!!!", JOptionPane.WARNING_MESSAGE);
            }else{
                SQLCon.updateAdmin(newPasswordTextField.getText());
                JOptionPane.showMessageDialog(null, "Password berhasil diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                newPasswordTextField.setText("");
            }
            
        }
    }
}
