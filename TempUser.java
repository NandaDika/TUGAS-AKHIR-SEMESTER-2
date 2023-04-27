

public class TempUser {
    protected static volatile String nama_user = "", nik_user = "", hari = "", bulan = "", tahun = "", kota = "", seat = "", maskapai = "";
    protected volatile String harga = "";
    protected volatile double hargaInt = 0;
    protected static volatile String ID = "", PASS = "";
    double hargaDasar = 300000;
    protected static String tanggal = "";
    public void hitungHarga(){
        double hMaskapai = 0;
        if(maskapai == "Garuda"){
                hMaskapai = hargaDasar + (hargaDasar*0.4);
        }else if(maskapai == "Asia"){
            hMaskapai = hargaDasar + (hargaDasar*0.3);
        }else if(maskapai == "Lion"){
            hMaskapai = hargaDasar + (hargaDasar*0.2);
        } else if(maskapai == "Batik"){
            hMaskapai = hargaDasar + (hargaDasar*0.1);
        }

        double hSeat = 0;
        if(seat == "Premium"){
            hSeat = hargaDasar*0.3;
        }else if(seat == "Bisnis"){
            hSeat = hargaDasar*0.2;
        }else if(seat == "Ekonomi"){
            hSeat = hargaDasar*0.1;
        }

        harga = String.valueOf(hMaskapai+hSeat);
        hargaInt = hMaskapai+hSeat;
    }

    protected void setTanggal(){
        tanggal = hari+" "+bulan+" "+tahun;
    }

    protected void clearData(){
        nama_user = "";
        nik_user = ""; 
        hari = "";
        bulan = "";
        tahun = "";
        kota = "";
        seat = ""; 
        maskapai = "";
        harga = "";
        hargaInt = 0;
        ID = "";
        PASS = "";
        tanggal = "";
    }
}


