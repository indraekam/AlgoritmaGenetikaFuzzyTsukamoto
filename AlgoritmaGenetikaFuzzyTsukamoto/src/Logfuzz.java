/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Indra Eka M
 */
public class Logfuzz {

    /**
     * @param args the command line arguments
     */
    //input permintaan
    int permintaanSatu = 3000;
    int permintaanDua = 6000;
    int permintaanTiga = 9000;
    int permintaanEmpat = 12000;
    int permintaanLima = 15000;
    int selisihPermintaan = 3000;

    //input persediaan 
    int persediaanSatu = 200;
    int persediaanDua = 600;
    int persediaanTiga = 1000;
    int persediaanEmpat = 1400;
    int persediaanLima = 1800;
    int selisihPersediaan = 400;

    //output produksi
    int produksiSatu = 3000;
    int produksiDua = 6000;
    int produksiTiga = 9000;
    int produksiEmpat = 12000;
    int produksiLima = 15000;
    int selisihProduksi = 3000;

    //variabel yang digunakan dalam perhitungan : 
    double miupr1, miupr2, miupr3, miupr4, miupr5;
    double miupd1, miupd2, miupd3, miupd4, miupd5;

    double alpha1, alpha2, alpha3, alpha4, alpha5, alpha6, alpha7, alpha8;
    double alpha9, alpha10, alpha11, alpha12, alpha13, alpha14, alpha15, alpha16;
    double alpha17, alpha18, alpha19, alpha20, alpha21, alpha22, alpha23, alpha24, alpha25;
    double alphaTot;

    double z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16;
    double z17, z18, z19, z20, z21, z22, z23, z24, z25;

    static double az1, az2, az3, az4, az5, az6, az7, az8, az9, az10, az11, az12, az13, az14, az15, az16, az17, az18, az19, az20, az21, az22, az23, az24, az25;
    double azTot, zFinal;
    

    //hitung permintaan 
    public double permintaanSSedikit(double x) {
        if (x < permintaanSatu) {
            miupr1 = 1;
        } else if (x >= permintaanSatu && x < permintaanDua) {
            miupr1 = (permintaanDua - x) / selisihPermintaan;

        } else if (x >= permintaanDua) {
            miupr1 = 0;
        }

        return miupr1;
    }

    public double permintaanSedikit(double x) {
        if (x == permintaanDua) {
            miupr2 = 1;

        } else if (x > permintaanSatu && x < permintaanDua) {
            miupr2 = (x - permintaanSatu) / selisihPermintaan;
        } else if (x > permintaanDua && x < permintaanTiga) {
            miupr2 = (permintaanTiga - x) / selisihPermintaan;

        } else if (x >= permintaanTiga && x < permintaanSatu) {
            miupr2 = 0;
        }
        return miupr2;
    }

    public double permintaanSedang(double x) {
        if (x == permintaanTiga) {
            miupr3 = 1;

        } else if (x > permintaanDua && x < permintaanTiga) {
            miupr3 = (x - permintaanDua) / selisihPermintaan;

        } else if (x > permintaanTiga && x < permintaanEmpat) {
            miupr3 = (permintaanEmpat - x) / selisihPermintaan;

        } else {
            miupr3 = 0;
        }

        return miupr3;
    }

    public double permintaanBanyak(double x) {
        if (x == permintaanEmpat) {
            miupr4 = 1;

        } else if (x > permintaanTiga && x < permintaanEmpat) {
            miupr4 = (x - permintaanTiga) / selisihPermintaan;

        } else if (x > permintaanEmpat && x < permintaanLima) {
            miupr4 = (permintaanLima - x) / selisihPermintaan;
        } else if (x >= permintaanLima && x < permintaanTiga) {
            miupr4 = 0;
        }
        return miupr4;
    }

    public double permintaanSBanyak(double x) {
        if (x >= permintaanLima) {
            miupr5 = 1;
        } else if (x > permintaanEmpat && x < permintaanLima) {
            miupr5 = (x - permintaanEmpat) / selisihPermintaan;
        } else {
            miupr5 = 0;
        }
        return miupr5;

    }

    public double persediaanSSedikit(double x) {
        if (x <= persediaanSatu) {
            miupd1 = 1;
        } else if (x > persediaanSatu && x <= persediaanDua) {
            miupd1 = (persediaanDua - x) / selisihPersediaan;
        } else {
            miupd1 = 0;
        }

        return miupd1;
    }

    public double persediaanSedikit(double x) {
        if (x == persediaanDua) {
            miupd2 = 1;

        } else if (x > persediaanSatu && x < persediaanDua) {
            miupd2 = (x - persediaanSatu) / selisihPersediaan;
        } else if (x > persediaanDua && x < persediaanTiga) {
            miupd2 =  (persediaanTiga - x) / selisihPersediaan;
        } else {
            miupd2 = 0;
        }
        return miupd2;

    }

    public double persediaanSedang(double x) {
        if (x == persediaanTiga) {
            miupd3 = 1;
        } else if (x > persediaanDua && x < persediaanTiga) {
            miupd3 = (x - persediaanDua) / selisihPersediaan;
        } else if (x > persediaanTiga && x < persediaanEmpat) {
            miupd3 = (persediaanEmpat - x) / selisihPersediaan;
        } else {
            miupd3 = 0;
        }

        return miupd3;
    }

    public double persediaanBanyak(double x) {
        if (x == persediaanEmpat) {
            miupd4 = 1;
        } else if (x > persediaanTiga && x < persediaanEmpat) {
            miupd4 = (x - persediaanTiga) / selisihPersediaan;
        } else if (x > persediaanEmpat && x < persediaanLima) {
            miupd4 = (persediaanLima - x) / selisihPersediaan;
        } else {
            miupd4 = 0;
        }

        return miupd4;
    }

    public double persediaanSBanyak(double x) {
        if (x >= persediaanLima) {
            miupd5 = 1;
        } else if (x > persediaanEmpat && x < persediaanLima) {
            miupd5 = (x - persediaanEmpat) / selisihPersediaan;
        } else {
            miupd5 = 0;
        }

        return miupd5;

    }

    //menghitung minimal
    private double Min(double x, double y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }

    }

    //hitung output produksi
    public double produksiSSedikit(double miu) {
        double x = produksiDua - (miu * selisihProduksi);
        return x;
    }

    public double produksiSedikit(double miu) {
        double x = produksiSatu + (miu * selisihProduksi);
        return x;
    }

    public double produksiSedang(double miu) {
        double x = produksiDua + (miu * selisihProduksi);
        return x;
    }

    public double produksiBanyak(double miu) {
        double x = produksiTiga + (miu * selisihProduksi);
        return x;
    }

    public double produksiSBanyak(double miu) {
        double x = produksiEmpat + (miu * selisihProduksi);
        return x;
    }

    //hitung a, z, dan a*z
    public void rules(int x, int y) {
        //ss-ss-ss
        alpha1 = Min(permintaanSSedikit(x), persediaanSSedikit(y));
        z1 = produksiSSedikit(alpha1);
        az1 = z1 * alpha1;
        //ss-s-ss
        alpha2 = Min(permintaanSSedikit(x), persediaanSedikit(y));
        z2 = produksiSSedikit(alpha2);
        az2 = z2 * alpha2;
        //ss-sd-ss
        alpha3 = Min(permintaanSSedikit(x), persediaanSedang(y));
        z3 = produksiSSedikit(alpha3);
        az3 = z3 * alpha3;
        //ss-b-ss
        alpha4 = Min(permintaanSSedikit(x), persediaanBanyak(y));
        z4 = produksiSSedikit(alpha4);
        az4 = z4 * alpha4;
        //ss-sd-ss
        alpha5 = Min(permintaanSSedikit(x), persediaanSBanyak(y));
        z5 = produksiSSedikit(alpha5);
        az5 = z5 * alpha5;
        
        //s-ss-(s - ss + 2000)
        alpha6 = Min(permintaanSedikit(x), persediaanSSedikit(y));
        //z6 = produksiSSedikit(alpha6);
        z6 = (x - y) + 2000;
        az6 = z6 * alpha6;
        
        //s-s-( s - ss + 2000)
        alpha7 = Min(permintaanSedikit(x), persediaanSedikit(y));
        //z7 = produksiSSedikit(alpha7);
        z7 = (x - y) + 2000;
        az7 = z7 * alpha7;
        
        //s-sd-( s - sd + 2000)
        alpha8 = Min(permintaanSedikit(x), persediaanSedang(y));
        //z8 = produksiSSedikit(alpha8);
        z8 = (x - y) + 2000;
        az8 = z8 * alpha8;
        
        //s-b-(s - b + 2000)
        alpha9 = Min(permintaanSedikit(x), persediaanBanyak(y));
        //z9 = produksiSSedikit(alpha9);
        z9 = (x - y) + 2000;
        az9 = z9 * alpha9;
        
        //s-sb-( s - sb + 2000);
        alpha10 = Min(permintaanSedikit(x), persediaanSBanyak(y));
        //z10 = produksiSSedikit(alpha10);
        z10 = (x - y) + 2000;
        az10 = z10 * alpha10;
        
        //sd-ss-sd
        alpha11 = Min(permintaanSedang(x), persediaanSSedikit(y));
        z11 = (x - y) + 3700;
        az11 = z11 * alpha11;
        //sd-s-sd
        alpha12 = Min(permintaanSedang(x), persediaanSedikit(y));
        z12 = (x - y) + 3700;
        az12 = z12 * alpha12;
        //sd-sd-s
        alpha13 = Min(permintaanSedang(x), persediaanSedang(y));
        z13 = (x - y) + 3700;
        az13 = z13 * alpha13;
        //sd-b-s
        alpha14 = Min(permintaanSedang(x), persediaanBanyak(y));
        z14 = (x - y) + 3700;
        az14 = z14 * alpha14;
        //sd-sb-s
        alpha15 = Min(permintaanSedang(x), persediaanSBanyak(y));
        z15 = (x - y) + 3700;
        az15 = z15 * alpha15;
        //b-ss-b
        alpha16 = Min(permintaanBanyak(x), persediaanSSedikit(y));
        z16 = (x - y) + 564;
        az16 = z16 * alpha16;
        //b-s-b
        alpha17 = Min(permintaanBanyak(x), persediaanSedikit(y));
        z17 = (x - y) + 564;
        az17 = z17 * alpha17;
        //b-sd-b
        alpha18 = Min(permintaanBanyak(x), persediaanSedang(y));
        z18 = (x - y) + 564;
        az18 = z18 * alpha18;
        //b-b-sd
        alpha19 = Min(permintaanBanyak(x), persediaanBanyak(y));
        z19 = (x - y) + 564;
        az19 = z19 * alpha19;
        //b-sb-sd
        alpha20 = Min(permintaanBanyak(x), persediaanSBanyak(y));
        z20 = (x - y) + 564;
        az20 = z20 * alpha20;
        //sb-ss-sb
        alpha21 = Min(permintaanSBanyak(x), persediaanSSedikit(y));
        z21 = produksiSBanyak(alpha21);
        az21 = z21 * alpha21;
        //sb-s-sb
        alpha22 = Min(permintaanSBanyak(x), persediaanSedikit(y));
        z22 = produksiSBanyak(alpha22);
        az22 = z22 * alpha22;
        //sb-sd-b
        alpha23 = Min(permintaanSBanyak(x), persediaanSedang(y));
        z23 = produksiBanyak(alpha23);
        az23 = z23 * alpha23;
        //sb-b-b
        alpha24 = Min(permintaanSBanyak(x), persediaanBanyak(y));
        z24 = produksiBanyak(alpha24);
        az24 = z24 * alpha24;
        //sb-sb-ss
        alpha25 = Min(permintaanSBanyak(x), persediaanSBanyak(y));
        z25 = produksiSSedikit(alpha25);
        az25 = z25 * alpha25;

        alphaTot = alpha1 + alpha2 + alpha3 + alpha4 + alpha5 + alpha6 + alpha7 + alpha8 + alpha9 + alpha10 + alpha11 + alpha12 + alpha13 + alpha14 + alpha15 + alpha16 + alpha17 + alpha18 + alpha19 + alpha20 + alpha21 + alpha22 + alpha23 + alpha24 + alpha25;
        azTot = az1 + az2 + az3 + az4 + az5 + az6 + az7 + az8 + az9 + az10 + az11 + az12 + az13 + az14 + az15 + az16 + az17 + az18 + az19 + az20 + az21 + az22 + az23 + az24 + az25;
        zFinal = azTot/alphaTot;
    }
    
    public static void main(String[] args) {
        Logfuzz a = new Logfuzz();
        a.rules(4080, 600);
        
        
        System.out.println("miu Permintaan ss " + a.miupr1 );
        System.out.println("miu Permintaan s " + a.miupr2);
        System.out.println("miu Permintaan sd " + a.miupr3);
        System.out.println("miu Permintaan b " + a.miupr4);
        System.out.println("miu Permintaan sb " + a.miupr5);
        System.out.println("");
        System.out.println("miu Persediaan ss " + a.miupd1);
        System.out.println("miu Persediaan s " + a.miupd2);
        System.out.println("miu Persediaan sd " + a.miupd3);
        System.out.println("miu Persediaan b " + a.miupd4);
        System.out.println("miu Persediaan sb " + a.miupd5);
        System.out.println("jumlah produksi yang disarankan: " + a.zFinal);
    }
}
