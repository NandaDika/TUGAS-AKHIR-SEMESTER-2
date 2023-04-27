import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Frame4 extends TempUser implements ActionListener{
    private JFrame frame = new JFrame("Terbang-In Aja!");

    Master Master = new Master();
    private JComboBox<Integer> dayCombo;
    private JComboBox<String> monthCombo;
    private JComboBox<Integer> yearCombo;

    private JRadioButton firstClassRadioButton = new JRadioButton();
    private JRadioButton businessClassRadioButton = new JRadioButton();
    private JRadioButton economyClassRadioButton = new JRadioButton();
    JRadioButton premiumEconomyClassRadioButton = new JRadioButton();

    private JButton cancelButton = new JButton("Cancel");
    private JButton orderButton = new JButton("Order");

    private JTextField nameTextField = new JTextField();
    private JTextField idTextField = new JTextField();
    private JComboBox<String> kotaBox;
    private JComboBox<String> cboc;

    public Frame4() {
          // Create JFrame
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
        frame.setLayout(null); // Use null layout manager for manual positioning
        JLabel logo = new JLabel(new ImageIcon(getClass().getResource(Master.menu)));
        logo.setBounds(150, 0, 1000, 200);
        frame.add(logo);

        //Layer Background
        JPanel backPanel = new JPanel();
        JLabel bg = new JLabel(new ImageIcon(getClass().getResource(Master.bg)));
        backPanel.add(bg);
        frame.setContentPane(bg);

        // Create formPanel
        JPanel formPanel = new JPanel();
        formPanel.setBounds(20, 120, 500, 700);
        formPanel.setLayout(null); // Use null layout manager for manual positioning
        formPanel.setOpaque(false);

        // Add title label
        JLabel titleLabel = new JLabel("Menu Pemesanan Tiket:");
        titleLabel.setBounds(20, 20, 300, 30);
        titleLabel.setForeground(Color.WHITE);
        formPanel.add(titleLabel);

        // Add name label and text field
        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(20, 60, 100, 30);
        nameTextField.setBounds(120, 60, 300, 30);
        nameLabel.setForeground(Color.WHITE);
        formPanel.add(nameLabel);
        formPanel.add(nameTextField);

        // Add ID label and text field
        JLabel idLabel = new JLabel("NIK:");
        idLabel.setBounds(20, 100, 100, 30);
        
        idTextField.setBounds(120, 100, 300, 30);
        idLabel.setForeground(Color.WHITE);
        formPanel.add(idLabel);
        formPanel.add(idTextField);

        // Add date label and text field
        JLabel dateLabel = new JLabel("Tanggal:");
        dateLabel.setBounds(20, 140, 100, 30);

        Integer[] days = new Integer[31];
        for (int i = 0; i < days.length; i++) {
            days[i] = i + 1;
        }
        dayCombo = new JComboBox<>(days);
        dayCombo.setBounds(120, 140, 80, 30);
        formPanel.add(dayCombo);
        dayCombo.addActionListener(this);

        String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        monthCombo = new JComboBox<>(months);
        monthCombo.setBounds(220, 140, 90, 30);
        formPanel.add(monthCombo);
        monthCombo.addActionListener(this);


        Integer[] years = new Integer[5];
        int currentYear = LocalDate.now().getYear();
        for (int i = 0; i < years.length; i++) {
        years[i] = currentYear + i;
        }
        yearCombo = new JComboBox<>(years);
        yearCombo.setBounds(330, 140, 90, 30);
        formPanel.add(yearCombo);
        yearCombo.addActionListener(this);
        //JTextField dateTextField = new JTextField();
        //dateTextField.setBounds(120, 140, 300, 30);
        dateLabel.setForeground(Color.WHITE);
        formPanel.add(dateLabel);
        //formPanel.add(dateTextField);

        // Add city label and text field
        JLabel cityLabel = new JLabel("Kota:");
        cityLabel.setBounds(20, 180, 100, 30); 
        
        String routes[] = {"Bali - Jayapura", "Yogyakarta - Banjarmasin", "Manado - Semarang", "Surabaya - Sorong", "Jakarta - Ambon", "Makassar - Lampung", "Balikpapan - Malang", "Palembang - Bengkulu", "Bandung - Palangkaraya", "Medan - Batam", "Padang - Makassar", "Banjarmasin - Lombok", "Denpasar - Bima", "Pontianak - Batam", "Kendari - Ternate"};
        kotaBox = new JComboBox<>(routes);
        kotaBox.setBounds(120, 180, 300, 30);
        cityLabel.setForeground(Color.WHITE);
        kotaBox.setBackground(Color.WHITE);
        formPanel.add(cityLabel);
        formPanel.add(kotaBox);

        //Menu kelas
        JLabel pilLabel = new JLabel("Seat:");
        pilLabel.setBounds(20, 220, 100, 30);
        String pilihan[] = {"Ekonomi", "Bisnis", "Premium"};
        cboc = new JComboBox<>(pilihan);
        cboc.setBounds(120, 220, 300, 30);
        cboc.setBackground(Color.WHITE);
        pilLabel.setForeground(Color.WHITE);
        formPanel.add(pilLabel);
        formPanel.add(cboc);
        cboc.addActionListener(this);

        // Create radioGroupPanel
        JPanel radioGroupPanel = new JPanel();
        radioGroupPanel.setBounds(950, 140, 200, 630);
        radioGroupPanel.setLayout(new BoxLayout(radioGroupPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        radioGroupPanel.setOpaque(false);


        // Add radio group label
        JLabel radioGroupLabel = new JLabel("Maskapai:");
        radioGroupLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the label
        radioGroupPanel.add(radioGroupLabel);

        // Add radio buttons
        
        firstClassRadioButton.addActionListener(this);
        firstClassRadioButton.setIcon(new ImageIcon(getClass().getResource("GarudaNS.png")));
        firstClassRadioButton.setOpaque(false);

        businessClassRadioButton.addActionListener(this);
        businessClassRadioButton.setIcon(new ImageIcon(getClass().getResource("BatikNS.png")));
        businessClassRadioButton.setOpaque(false);

        economyClassRadioButton.addActionListener(this);
        economyClassRadioButton.setIcon(new ImageIcon(getClass().getResource("AsiaNS.png")));
        economyClassRadioButton.setOpaque(false);

        premiumEconomyClassRadioButton.addActionListener(this);
        premiumEconomyClassRadioButton.setIcon(new ImageIcon(getClass().getResource("LionNS.png")));
        premiumEconomyClassRadioButton.setOpaque(false);

        //Set Button Group
        ButtonGroup bgr = new ButtonGroup();
        bgr.add(premiumEconomyClassRadioButton);
        bgr.add(economyClassRadioButton);
        bgr.add(businessClassRadioButton);
        bgr.add(firstClassRadioButton);

        // Add radio buttons to radioGroupPanel
        radioGroupPanel.add(firstClassRadioButton);
        radioGroupPanel.add(businessClassRadioButton);
        radioGroupPanel.add(economyClassRadioButton);
        radioGroupPanel.add(premiumEconomyClassRadioButton);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(900, 650, 400, 100);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Use FlowLayout for right alignment
        buttonPanel.setOpaque(false);
        

        // Add Cancel button
        
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(this);
        
        // Add Order button
        
        orderButton.addActionListener(this);
        buttonPanel.add(orderButton);
        

        // Add panels to the frame
        frame.add(formPanel);
        frame.add(radioGroupPanel);
        frame.add(buttonPanel);

        // Set the frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(firstClassRadioButton.isSelected()){
            firstClassRadioButton.setIcon(new ImageIcon(getClass().getResource("Garuda.png")));
            maskapai = "Garuda";
        }else{
            firstClassRadioButton.setIcon(new ImageIcon(getClass().getResource("GarudaNS.png")));
        }

        if(businessClassRadioButton.isSelected()){
            businessClassRadioButton.setIcon(new ImageIcon(getClass().getResource("Batik.png")));
            maskapai = "Batik";
        }else{
            businessClassRadioButton.setIcon(new ImageIcon(getClass().getResource("BatikNS.png")));
            //maskapai = "";
        }

        if(economyClassRadioButton.isSelected()){
            economyClassRadioButton.setIcon(new ImageIcon(getClass().getResource("Asia.png")));
            maskapai = "Asia";
        }else{
            economyClassRadioButton.setIcon(new ImageIcon(getClass().getResource("AsiaNS.png")));
           // maskapai = "";
        }

        if(premiumEconomyClassRadioButton.isSelected()){
            premiumEconomyClassRadioButton.setIcon(new ImageIcon(getClass().getResource("Lion.png")));
            maskapai = "Lion";
        }else{
            premiumEconomyClassRadioButton.setIcon(new ImageIcon(getClass().getResource("LionNS.png")));
          //  maskapai = "";
        }

        if(e.getSource()==orderButton){

            if(nameTextField.getText().isEmpty() || idTextField.getText().isEmpty() || maskapai == ""){
                JOptionPane.showMessageDialog(null, "Field Harus Diisi", "Peringatan!!!", JOptionPane.WARNING_MESSAGE);
            }else{
                nama_user = nameTextField.getText();
                nik_user = idTextField.getText();
                int hariTemp = (Integer) dayCombo.getSelectedItem();
                hari  = String.valueOf(hariTemp);
                bulan = (String) monthCombo.getSelectedItem();
                int tempTahun = (Integer) yearCombo.getSelectedItem();
                tahun = String.valueOf(tempTahun);
                kota = (String) kotaBox.getSelectedItem();
                seat = (String) cboc.getSelectedItem();
                ID = Master.setID();
                PASS = Master.setPass();
                setTanggal();
                //hitungHarga();
                //SQLCon.setData(nama_user);
                new Frame5();
                frame.setVisible(false);
            }
        }

        if(e.getSource()==cancelButton){
            frame.setVisible(false);
            new Frame1();
        }
    } 
}

