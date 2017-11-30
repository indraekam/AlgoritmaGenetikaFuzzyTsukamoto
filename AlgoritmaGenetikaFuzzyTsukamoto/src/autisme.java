/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Uhuuy31
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.text.DecimalFormat;
import java.util.*;

public class autisme {

    Random rand = new Random();
    public int popSize = 0;//50
    public int pKromosom = 18;
    //public int pK = pKromosom + 1;    
    public double pc = 0;//0.8
    public double pm = 0;//0.2
    public int banyakGenerasi = 0;//200
//    public double individu[][] = new double [popSize][pKromosom];
    public double individu[][];
    public double childC[][] = new double[1000][pKromosom];
    public double childM[][] = new double[1000][pKromosom];
    public double child[][] = new double[1000][pKromosom];
    public double input[][] = new double[135][4];
    public double inputTest[][] = new double[20][4];
    public int targetTest[] = new int[20];
    public int hasilS[] = new int[20];
    public int target[] = new int[135];
//    public double fitnessParent[] = new double[popSize];
    public double fitnessParent[];
    public double fitnessChild[] = new double[1000];
    public double fitnessGabungan[] = new double[1000];
    public double kromosomGabungan[][] = new double[1000][pKromosom];
    public int count;
    public int countAkurasi;
    public int anakMutasi = 0;

    double komsosSatu;
    double komsosDua;
    double komsosTiga;
    double komsosEmpat;
    double selisihKomsosRendah;
    double selisihKomsosTinggi;
    double inderaSatu;
    double inderaDua;
    double inderaTiga;
    double inderaEmpat;
    double selisihinderaRendah;
    double selisihinderaTinggi;
    double perilakuSatu;
    double perilakuDua;
    double perilakuTiga;
    double perilakuEmpat;
    double selisihperilakuRendah;
    double selisihperilakuTinggi;
    double pinfoSatu;
    double pinfoDua;
    double pinfoTiga;
    double pinfoEmpat;
    double selisihpinfoRendah;
    double selisihpinfoTinggi;
    double potensiSatu;
    double potensiDua;
    double selisihPotensi;
    double miukomsos1, miukomsos2, miukomsos3;
    double miuindera1, miuindera2, miuindera3;
    double miuperilaku1, miuperilaku2, miuperilaku3;
    double miupinfo1, miupinfo2, miupinfo3;
    double a[] = new double[82];
    double z[] = new double[81];
    double az[] = new double[82];
    double zFinal;
    double min;

//    public autisme(int banyakGenerasi, int popSize, double pm, double pc){
//        this.banyakGenerasi = banyakGenerasi;
//        this.popSize = popSize;
//        this.pm = pm;
//        this.pc = pc;
//    }
    
    public void input(int banyakGenerasi, int popSize, double pc, double pm){
        this.popSize = popSize;
        this.banyakGenerasi = banyakGenerasi;
        this.pm = pm;
        this.pc = pc;
        individu = new double[popSize][pKromosom];
        fitnessParent = new double[popSize];
    }
    public double[] inisialisasi() {
        double[] temp = new double[pKromosom];
        for (int i = 0; i < pKromosom; i++) {
            double bBawah, bAtas;
            double random;

            if (i == 0) {//KOMSOS
                bBawah = 0;
                bAtas = 4;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 1) {//KOMSOS
                bBawah = 1;
                bAtas = 8;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 2) {//KOMSOS
                bBawah = 8;
                bAtas = 12;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 3) {//KOMSOS
                bBawah = 12;
                bAtas = 15;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 4) {//INDERA
                bBawah = 0;
                bAtas = 4;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 5) {//INDERA
                bBawah = 1;
                bAtas = 8;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 6) {//INDERA
                bBawah = 8;
                bAtas = 12;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 7) {//INDERA
                bBawah = 12;
                bAtas = 15;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 8) {//PERILAKU
                bBawah = 0;
                bAtas = 4;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 9) {//PERILAKU
                bBawah = 1;
                bAtas = 8;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 10) {//PERILAKU
                bBawah = 8;
                bAtas = 12;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 11) {//PERILAKU
                bBawah = 12;
                bAtas = 15;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 12) {//PINFO
                bBawah = 0;
                bAtas = 2;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 13) {//PINFO
                bBawah = 2;
                bAtas = 4;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 14) {//PINFO
                bBawah = 4;
                bAtas = 6;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 15) {//PINFO
                bBawah = 6;
                bAtas = 8;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 16) {//POTENSI
                bBawah = 10;
                bAtas = 25;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 17) {//POTENSI
                bBawah = 25;
                bAtas = 40;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }

        }
        double swap;
        for (int i = 0; i < 4; i++) {//KOMSOM
            for (int j = 0; j < 4 - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < 4; i++) {//INDERA
            for (int j = 4; j < 8 - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < 4; i++) {//PERILAKU
            for (int j = 8; j < 12 - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < 4; i++) {//P.INFO
            for (int j = 12; j < 16 - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < 2; i++) {//POTESNSI
            for (int j = 16; j < 18 - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }
        return temp;
    }

    public void pCross() {
        int random1, random2;

        int offspring = (int) Math.ceil(pc * popSize);
        int sisa = offspring % 2;
        if (sisa == 1) {
            offspring = offspring + 1;
        }
        int proses = offspring / 2;
        count = 0;
        for (int i = 0; i < proses; i++) {
            random1 = rand.nextInt(popSize);
            random2 = rand.nextInt(popSize);
            int j = 0;
            double[][] child1 = new double[2][pKromosom];

            while (j < 1) {
                if (random1 == random2) {
                    random1 = rand.nextInt(popSize);
                    random2 = rand.nextInt(popSize);
                } else {
                    //System.out.println("hasil crossover : ");
                    child1 = crossover(random1, random2);
                    for (int k = 0; k < 2; k++) {
                        childC[count] = child1[k];
                        count++;
                    }
                    //System.out.println(crossover(random1, random2));
                    j++;
                }
            }
        }
//        System.out.println("crossover : ");
//        for (int i = 0; i < offspring; i++) {
//            for (int j = 0; j < pKromosom; j++) {
//                System.out.print(childC[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

    public double[][] crossover(int data1, int data2) {
        double[] p1 = new double[pKromosom];
        double[] p2 = new double[pKromosom];
        double[][] child = new double[2][pKromosom];
        for (int i = 0; i < pKromosom; i++) {
            p1[i] = individu[data1][i];
            child[0][i] = individu[data1][i];
        }
        for (int i = 0; i < pKromosom; i++) {
            p2[i] = individu[data2][i];
            child[1][i] = individu[data2][i];
        }
        for (int i = 0; i < pKromosom; i++) {
            double tampa = Math.random() * (1.25 - (-0.25));
            double alpha = -0.25 + tampa;
            double tamp1 = p1[i];
            double tamp2 = p2[i];
            double hasil1, hasil2;
            hasil1 = tamp1 + (alpha * (tamp2 - tamp1));
            hasil2 = tamp2 + (alpha * (tamp1 - tamp2));
            child[0][i] = hasil1;
            child[1][i] = hasil2;
        }
        //System.out.println("child");
        return child;
    }

    public double[] mutasi(int data1) {
        double[] p1 = new double[pKromosom];
        //double[] p2 = new double[pKromosom];
        double[] child = new double[pKromosom];
        for (int i = 0; i < pKromosom; i++) {
            p1[i] = individu[data1][i];
            child[i] = individu[data1][i];
        }
        int random1;
        random1 = rand.nextInt(pKromosom);
        //System.out.println("random " + random1);
        double tampa = Math.random() * (0.1 - (-0.1));
        double alpha = -0.1 + tampa;
        double tamp1 = p1[random1];
        double hasil1;
        if (random1 < 4) {//KOMSOS
            hasil1 = tamp1 + (alpha * (18 - 0));
            child[random1] = hasil1;
        }
        if (random1 > 3 && random1 < 8) {//INDERA
            hasil1 = tamp1 + (alpha * (18 - 0));
            child[random1] = hasil1;
        }
        if (random1 > 7 && random1 < 12) {//PERILAKU
            hasil1 = tamp1 + (alpha * (18 - 0));
            child[random1] = hasil1;
        }
        if (random1 > 11 && random1 < 16) {//P.INFO
            hasil1 = tamp1 + (alpha * (8 - 0));
            child[random1] = hasil1;
        }
        if (random1 > 15 && random1 < 18) {//POTENSI
            hasil1 = tamp1 + (alpha * (55 - 0));
            child[random1] = hasil1;
        }
        return child;
    }

    public void pMutasi() {
        boolean ganjil = true;
        int random1;

        int offspring = (int) Math.ceil(pm * popSize);
        double tampung[][] = new double[offspring][pKromosom];
        tampung = individu;
        double[] child1 = new double[pKromosom];
        // System.out.println("offs :" + offspring);
        anakMutasi = offspring;
        for (int i = 0; i < offspring; i++) {
            random1 = rand.nextInt(popSize);
            //System.out.println("random m : " + random1);
            child1 = mutasi(random1);
            childM[i] = child1;
        }
//        System.out.println("mutasi : ");
//        for (int i = 0; i < offspring; i++) {
//            for (int j = 0; j < pKromosom; j++) {
//                System.out.print(childM[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

    public void penggabungan() {
        for (int i = 0; i < count; i++) {
            child[i] = childC[i];
        }
        int total = count + anakMutasi;
        for (int i = count; i < total; i++) {
            child[i] = childM[i - count];
        }
//        System.out.println("gabungan : ");
//        for (int i = 0; i < count + anakMutasi; i++) {
//            for (int j = 0; j < pKromosom; j++) {
//                System.out.print(child[i][j] + " ");
//
//            }
//            System.out.println("");
//        }
    }

    public void file() {
        //untuk input
        System.out.println("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("dataCarsInput.txt")));
            String line;
            int baris = 0;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                for (int j = 0; j < data.length; j++) {
                    input[baris][j] = Double.parseDouble(data[j]);
                    //System.out.print(input[baris][j]);
                }
                //System.out.println("");
                baris++;

            }

        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

        //untuk target
        System.out.println("Target  : ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("dataCarsOutput.txt")));
            String line;
            int baris = 0;
            while ((line = br.readLine()) != null) {
                target[baris] = Integer.parseInt(line);
                //System.out.println(target[baris]);
                baris++;
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

    }

    public void file2() {
        //untuk input
        System.out.println("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("carsInputBaru.txt")));
            String line;
            int baris = 0;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                for (int j = 0; j < data.length; j++) {
                    inputTest[baris][j] = Double.parseDouble(data[j]);
                   // System.out.print(inputTest[baris][j]);
                }
               // System.out.println("");
                baris++;

            }

        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

        //untuk target
        System.out.println("Target  : ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("carsOutputBaru.txt")));
            String line;
            int baris = 0;
            while ((line = br.readLine()) != null) {
                targetTest[baris] = Integer.parseInt(line);
                //System.out.println(targetTest[baris]);
                baris++;
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

    }
    public void fuzzyfikasiAwal(int childNumber) {

        komsosSatu = 2;
        komsosDua = 6;
        komsosTiga = 10;
        komsosEmpat = 14;
//        System.out.println("kom");
//        System.out.println(komsosSatu);
//        System.out.println(komsosDua);
        selisihKomsosRendah = komsosDua - komsosSatu;
        selisihKomsosTinggi = komsosEmpat - komsosTiga;

        inderaSatu = 2;
        inderaDua = 6;
        inderaTiga = 10;
        inderaEmpat = 14;
        selisihinderaRendah = inderaDua - inderaSatu;
        selisihinderaTinggi = inderaEmpat - inderaTiga;

        perilakuSatu = 2;
        perilakuDua = 6;
        perilakuTiga = 10;
        perilakuEmpat = 14;
        selisihperilakuRendah = perilakuDua - perilakuSatu;
        selisihperilakuTinggi = perilakuEmpat - perilakuTiga;

        pinfoSatu = 1;
        pinfoDua = 3;
        pinfoTiga = 5;
        pinfoEmpat = 7;
        selisihpinfoRendah = pinfoDua - pinfoSatu;
        selisihpinfoTinggi = pinfoEmpat - pinfoTiga;

        potensiSatu = 15;
        potensiDua = 35;
        selisihPotensi = potensiDua - potensiSatu;
    }



    public void fuzzyfikasi(int childNumber) {

        komsosSatu = individu[childNumber][0];
        komsosDua = individu[childNumber][1];
        komsosTiga = individu[childNumber][2];
        komsosEmpat = individu[childNumber][3];
//        System.out.println("kom");
//        System.out.println(komsosSatu);
//        System.out.println(komsosDua);
        selisihKomsosRendah = komsosDua - komsosSatu;
        selisihKomsosTinggi = komsosEmpat - komsosTiga;

        inderaSatu = individu[childNumber][4];
        inderaDua = individu[childNumber][5];
        inderaTiga = individu[childNumber][6];
        inderaEmpat = individu[childNumber][7];
        selisihinderaRendah = inderaDua - inderaSatu;
        selisihinderaTinggi = inderaEmpat - inderaTiga;

        perilakuSatu = individu[childNumber][8];
        perilakuDua = individu[childNumber][9];
        perilakuTiga = individu[childNumber][10];
        perilakuEmpat = individu[childNumber][11];
        selisihperilakuRendah = perilakuDua - perilakuSatu;
        selisihperilakuTinggi = perilakuEmpat - perilakuTiga;

        pinfoSatu = individu[childNumber][12];
        pinfoDua = individu[childNumber][13];
        pinfoTiga = individu[childNumber][14];
        pinfoEmpat = individu[childNumber][15];
        selisihpinfoRendah = pinfoDua - pinfoSatu;
        selisihpinfoTinggi = pinfoEmpat - pinfoTiga;

        potensiSatu = individu[childNumber][16];
        potensiDua = individu[childNumber][17];
        selisihPotensi = potensiDua - potensiSatu;
    }

    public void fuzzyfikasiChild(int x) {
        komsosSatu = child[x][0];
        komsosDua = child[x][1];
        komsosTiga = child[x][2];
        komsosEmpat = child[x][3];
        selisihKomsosRendah = komsosDua - komsosSatu;
        selisihKomsosTinggi = komsosEmpat - komsosTiga;

        inderaSatu = child[x][4];
        inderaDua = child[x][5];
        inderaTiga = child[x][6];
        inderaEmpat = child[x][7];
        selisihinderaRendah = inderaDua - inderaSatu;
        selisihinderaTinggi = inderaEmpat - inderaTiga;

        perilakuSatu = child[x][8];
        perilakuDua = child[x][9];
        perilakuTiga = child[x][10];
        perilakuEmpat = child[x][11];
        selisihperilakuRendah = perilakuDua - perilakuSatu;
        selisihperilakuTinggi = perilakuEmpat - perilakuTiga;

        pinfoSatu = child[x][12];
        pinfoDua = child[x][13];
        pinfoTiga = child[x][14];
        pinfoEmpat = child[x][15];
        selisihpinfoRendah = pinfoDua - pinfoSatu;
        selisihpinfoTinggi = pinfoEmpat - pinfoTiga;

        potensiSatu = child[x][16];
        potensiDua = child[x][17];
        selisihPotensi = potensiDua - potensiSatu;

    }

    public double komsosRingan(double x) {
        if (x <= komsosSatu) {
            miukomsos1 = 1;
        } else if (x > komsosSatu && x < komsosDua) {
            miukomsos1 = (komsosDua - x) / selisihKomsosRendah;
        } else if (x >= komsosDua) {
            miukomsos1 = 0;
        }
        return miukomsos1;
    }

    public double komsosSedang(double x) {
        if (x >= komsosDua && x <= komsosTiga) {
            miukomsos2 = 1;
        } else if (x > komsosSatu && x < komsosDua) {
            miukomsos2 = (x - komsosSatu) / selisihKomsosRendah;
        } else if (x > komsosTiga && x < komsosEmpat) {
            miukomsos2 = (komsosEmpat - x) / selisihKomsosTinggi;
        } else {
            miukomsos2 = 0;
        }
        return miukomsos2;
    }

    public double komsosTinggi(double x) {
        if (x >= komsosEmpat) {
            miukomsos3 = 1;
        } else if (x > komsosTiga && x < komsosEmpat) {
            miukomsos3 = (x - komsosTiga) / selisihKomsosTinggi;
        } else if (x <= komsosTiga) {
            miukomsos3 = 0;
        }
        return miukomsos3;
    }

    public double inderaRingan(double x) {
        if (x <= inderaSatu) {
            miuindera1 = 1;
        } else if (x > inderaSatu && x < inderaDua) {
            miuindera1 = (inderaDua - x) / selisihinderaRendah;
        } else if (x >= inderaDua) {
            miuindera1 = 0;
        }
        return miuindera1;
    }

    public double inderaSedang(double x) {
        if (x >= inderaDua && x <= inderaTiga) {
            miuindera2 = 1;
        } else if (x > inderaSatu && x < inderaDua) {
            miuindera2 = (x - inderaSatu) / selisihinderaRendah;
        } else if (x > inderaTiga && x < inderaEmpat) {
            miuindera2 = (inderaEmpat - x) / selisihinderaTinggi;
        } else {
            miuindera2 = 0;
        }
        return miuindera2;
    }

    public double inderaTinggi(double x) {
        if (x >= inderaEmpat) {
            miuindera3 = 1;
        } else if (x > inderaTiga && x < inderaEmpat) {
            miuindera3 = (x - inderaTiga) / selisihinderaTinggi;
        } else if (x <= inderaTiga) {
            miuindera3 = 0;
        }
        return miuindera3;
    }

    public double perilakuRingan(double x) {
//        System.out.println("nilai x perilaku Ringan : " + x);
//        System.out.println("perilaku 1 : " + perilakuSatu);
//        System.out.println("perilaku 2 : " + perilakuDua);
//        System.out.println("perilaku 3 : " + perilakuTiga);
//        System.out.println("perilaku 4 : " + perilakuEmpat);
        if (x <= perilakuSatu) {
            miuperilaku1 = 1;
            //System.out.println("masuk if 1");
        } else if (x > perilakuSatu && x < perilakuDua) {
            miuperilaku1 = (perilakuDua - x) / selisihperilakuRendah;
            //System.out.println("masuk if 2");
        } else if (x >= perilakuDua) {
            //System.out.println("masuk if 3");
            miuperilaku1 = 0;
        }
        // System.out.println("miu perilaku ringan : " + miuperilaku1);
        return miuperilaku1;
    }

    public double perilakuSedang(double x) {
//        System.out.println("nilai x perilaku Sedang : " + x);
//        System.out.println("perilaku 1 : " + perilakuSatu);
//        System.out.println("perilaku 2 : " + perilakuDua);
//        System.out.println("perilaku 3 : " + perilakuTiga);
//        System.out.println("perilaku 4 : " + perilakuEmpat);
        if (x >= perilakuDua && x <= perilakuTiga) {
            miuperilaku2 = 1;
            //System.out.println("masuk if 1");
        } else if (x > perilakuSatu && x < perilakuDua) {
            //System.out.println("masuk if 2");
            miuperilaku2 = (x - perilakuSatu) / selisihperilakuRendah;
        } else if (x > perilakuTiga && x < perilakuEmpat) {
            //System.out.println("masuk if 3");
            miuperilaku2 = (perilakuEmpat - x) / selisihperilakuTinggi;
        } else {
            //System.out.println("masuk else");
            miuperilaku2 = 0;
        }
        //System.out.println("miut prilaku sedang : " + miuperilaku2);
        return miuperilaku2;
    }

    public double perilakuTinggi(double x) {
//        System.out.println("nilai x perilaku Tinggi : " + x);
//        System.out.println("perilaku 1 : " + perilakuSatu);
//        System.out.println("perilaku 2 : " + perilakuDua);
//        System.out.println("perilaku 3 : " + perilakuTiga);
//        System.out.println("perilaku 4 : " + perilakuEmpat);
        if (x >= perilakuEmpat) {
            miuperilaku3 = 1;
            //System.out.println("masuk if 1");
        } else if (x > perilakuTiga && x < perilakuEmpat) {
            //System.out.println("masuk if 2");
            miuperilaku3 = (x - perilakuTiga) / selisihperilakuTinggi;
        } else if (x <= perilakuTiga) {
            miuperilaku3 = 0;
            //System.out.println("masuk if 3");
        }
        //System.out.println("miu perilaku tinggi : " + miuperilaku3);
        return miuperilaku3;
    }

    public double pinfoRingan(double x) {
        if (x <= pinfoSatu) {
            miupinfo1 = 1;
        } else if (x > pinfoSatu && x < pinfoDua) {
            miupinfo1 = (pinfoDua - x) / selisihpinfoRendah;
        } else if (x >= pinfoDua) {
            miupinfo1 = 0;
        }
        return miupinfo1;
    }

    public double pinfoSedang(double x) {
        if (x >= pinfoDua && x <= pinfoTiga) {
            miupinfo2 = 1;
        } else if (x > pinfoSatu && x < pinfoDua) {
            miupinfo2 = (x - pinfoSatu) / selisihpinfoRendah;
        } else if (x > pinfoTiga && x < pinfoEmpat) {
            miupinfo2 = (pinfoEmpat - x) / selisihpinfoTinggi;
        } else {
            miupinfo2 = 0;
        }
        return miupinfo2;
    }

    public double pinfoTinggi(double x) {
        if (x >= pinfoEmpat) {
            miupinfo3 = 1;
        } else if (x > pinfoTiga && x < pinfoEmpat) {
            miupinfo3 = (x - pinfoTiga) / selisihpinfoTinggi;
        } else if (x <= pinfoTiga) {
            miupinfo3 = 0;
        }
        return miupinfo3;
    }

    public double Min(double a, double b, double c, double d) { //salah

        // System.out.println(a + "\t" + b + "\t" + c + "\t" + d);
        if (a <= b && a <= c && a <= d) {
            min = a;
        } else if (b <= a && b <= c && b <= d) {
            min = b;
        } else if (c <= a && c <= b && c <= d) {
            min = c;
        } else if (d <= a && d <= b && d <= c) {
            min = d;
        } else {
            min = a;
        }

        // System.out.println("Min : " + min);
        return min;
    }

    public double potensiNon(double miu) {
        double x = potensiDua - (miu * selisihPotensi);
        return x;
    }

    public double potensiAutis(double miu) {
        double x = potensiSatu + (miu * selisihPotensi);
        return x;
    }

    public double defuzifikasiNon(double x) {
        double y;
        if (x <= potensiSatu) {
            y = 1;
        } else if (x > potensiSatu && x < potensiDua) {
            y = (potensiDua - x) / selisihPotensi;
        } else {
            y = 0;
        }
        return y;
    }

    public double defuzifikasiAutis(double x) {
        double y;
        if (x >= potensiDua) {
            y = 1;
        } else if (x > potensiSatu && x < potensiDua) {
            y = (x - potensiSatu) / selisihPotensi;
        } else {
            y = 0;
        }
        return y;
    }

    public double rule(double v, double w, double x, double y) {
        for (int i = 0; i < 81; i++) {
            a[i] = 0.0;
            z[i] = 0.0;
            az[i] = 0.0;

        }
        a[81] = 0.0;
        az[81] = 0.0;

        a[0] = Min(komsosRingan(v), inderaRingan(w), perilakuRingan(x), pinfoRingan(y));
        z[0] = potensiNon(a[0]);
        az[0] = z[0] * a[0];

        a[1] = Min(komsosRingan(v), inderaRingan(w), perilakuRingan(x), pinfoSedang(y));
        z[1] = potensiNon(a[1]);
        az[1] = z[1] * a[1];

        a[2] = Min(komsosRingan(v), inderaRingan(w), perilakuRingan(x), pinfoTinggi(y));
        z[2] = potensiNon(a[2]);
        az[2] = z[2] * a[2];

        a[3] = Min(komsosRingan(v), inderaRingan(w), perilakuSedang(x), pinfoRingan(y));
        z[3] = potensiNon(a[3]);
        az[3] = z[3] * a[3];

        a[4] = Min(komsosRingan(v), inderaRingan(w), perilakuSedang(x), pinfoSedang(y));
        z[4] = potensiAutis(a[4]);
        az[4] = z[4] * a[4];

        a[5] = Min(komsosRingan(v), inderaRingan(w), perilakuSedang(x), pinfoTinggi(y));
        z[5] = potensiAutis(a[5]);
        az[5] = z[5] * a[5];

        a[6] = Min(komsosRingan(v), inderaRingan(w), perilakuTinggi(x), pinfoRingan(y));
        z[6] = potensiAutis(a[6]);
        az[6] = z[6] * a[6];

        a[7] = Min(komsosRingan(v), inderaRingan(w), perilakuTinggi(x), pinfoSedang(y));
        z[7] = potensiAutis(a[7]);
        az[7] = z[7] * a[7];

        a[8] = Min(komsosRingan(v), inderaRingan(w), perilakuTinggi(x), pinfoTinggi(y));
        z[8] = potensiAutis(a[8]);
        az[8] = z[8] * a[8];

        a[9] = Min(komsosRingan(v), inderaSedang(w), perilakuRingan(x), pinfoRingan(y));
        z[9] = potensiNon(a[9]);
        az[9] = z[9] * a[9];

        a[10] = Min(komsosRingan(v), inderaSedang(w), perilakuRingan(x), pinfoSedang(y));
        z[10] = potensiAutis(a[10]);
        az[10] = z[10] * a[10];

        a[11] = Min(komsosRingan(v), inderaSedang(w), perilakuRingan(x), pinfoTinggi(y));
        z[11] = potensiAutis(a[11]);
        az[11] = z[11] * a[11];

        a[12] = Min(komsosRingan(v), inderaSedang(w), perilakuSedang(x), pinfoRingan(y));
        z[12] = potensiAutis(a[12]);
        az[12] = z[12] * a[12];

        a[13] = Min(komsosRingan(v), inderaSedang(w), perilakuSedang(x), pinfoSedang(y));
        z[13] = potensiAutis(a[13]);
        az[13] = z[13] * a[13];

        a[14] = Min(komsosRingan(v), inderaSedang(w), perilakuSedang(x), pinfoTinggi(y));
        z[14] = potensiAutis(a[14]);
        az[14] = z[14] * a[14];

        a[15] = Min(komsosRingan(v), inderaSedang(w), perilakuTinggi(x), pinfoRingan(y));
        z[15] = potensiAutis(a[15]);
        az[15] = z[15] * a[15];

        a[16] = Min(komsosRingan(v), inderaSedang(w), perilakuTinggi(x), pinfoSedang(y));
        z[16] = potensiAutis(a[16]);
        az[16] = z[16] * a[16];

        a[17] = Min(komsosRingan(v), inderaSedang(w), perilakuTinggi(x), pinfoTinggi(y));
        z[17] = potensiAutis(a[17]);
        az[17] = z[17] * a[17];

        a[18] = Min(komsosRingan(v), inderaTinggi(w), perilakuRingan(x), pinfoRingan(y));
        z[18] = potensiAutis(a[18]);
        az[18] = z[18] * a[18];

        a[19] = Min(komsosRingan(v), inderaTinggi(w), perilakuRingan(x), pinfoSedang(y));
        z[19] = potensiAutis(a[19]);
        az[19] = z[19] * a[19];

        a[20] = Min(komsosRingan(v), inderaTinggi(w), perilakuRingan(x), pinfoTinggi(y));
        z[20] = potensiAutis(a[20]);
        az[20] = z[20] * a[20];

        a[21] = Min(komsosRingan(v), inderaTinggi(w), perilakuSedang(x), pinfoRingan(y));
        z[21] = potensiAutis(a[21]);
        az[21] = z[21] * a[21];

        a[22] = Min(komsosRingan(v), inderaTinggi(w), perilakuSedang(x), pinfoSedang(y));
        z[22] = potensiAutis(a[22]);
        az[22] = z[22] * a[22];

        a[23] = Min(komsosRingan(v), inderaTinggi(w), perilakuSedang(x), pinfoTinggi(y));
        z[23] = potensiAutis(a[23]);
        az[23] = z[23] * a[23];

        a[24] = Min(komsosRingan(v), inderaTinggi(w), perilakuTinggi(x), pinfoRingan(y));
        z[24] = potensiAutis(a[24]);
        az[24] = z[24] * a[24];

        a[25] = Min(komsosRingan(v), inderaTinggi(w), perilakuTinggi(x), pinfoSedang(y));
        z[25] = potensiAutis(a[25]);
        az[25] = z[25] * a[25];

        a[26] = Min(komsosRingan(v), inderaTinggi(w), perilakuTinggi(x), pinfoTinggi(y));
        z[26] = potensiAutis(a[26]);
        az[26] = z[26] * a[26];

        a[27] = Min(komsosSedang(v), inderaRingan(w), perilakuRingan(x), pinfoRingan(y));
        z[27] = potensiNon(a[27]);
        az[27] = z[27] * a[27];

        a[28] = Min(komsosSedang(v), inderaRingan(w), perilakuRingan(x), pinfoSedang(y));
        z[28] = potensiAutis(a[28]);
        az[28] = z[28] * a[28];

        a[29] = Min(komsosSedang(v), inderaRingan(w), perilakuRingan(x), pinfoTinggi(y));
        z[29] = potensiAutis(a[29]);
        az[29] = z[29] * a[29];

        a[30] = Min(komsosSedang(v), inderaRingan(w), perilakuSedang(x), pinfoRingan(y));
        z[30] = potensiAutis(a[30]);
        az[30] = z[30] * a[30];

        a[31] = Min(komsosSedang(v), inderaRingan(w), perilakuSedang(x), pinfoSedang(y));
        z[31] = potensiAutis(a[31]);
        az[31] = z[31] * a[31];

        a[32] = Min(komsosSedang(v), inderaRingan(w), perilakuSedang(x), pinfoTinggi(y));
        z[32] = potensiAutis(a[32]);
        az[32] = z[32] * a[32];

        a[33] = Min(komsosSedang(v), inderaRingan(w), perilakuTinggi(x), pinfoRingan(y));
        z[33] = potensiAutis(a[33]);
        az[33] = z[33] * a[33];

        a[34] = Min(komsosSedang(v), inderaRingan(w), perilakuTinggi(x), pinfoSedang(y));
        z[34] = potensiAutis(a[34]);
        az[34] = z[34] * a[34];

        a[35] = Min(komsosSedang(v), inderaRingan(w), perilakuTinggi(x), pinfoTinggi(y));
        z[35] = potensiAutis(a[35]);
        az[35] = z[35] * a[35];

        a[36] = Min(komsosSedang(v), inderaSedang(w), perilakuRingan(x), pinfoRingan(y));
        z[36] = potensiAutis(a[36]);
        az[36] = z[36] * a[36];

        a[37] = Min(komsosSedang(v), inderaSedang(w), perilakuRingan(x), pinfoSedang(y));
        z[37] = potensiAutis(a[37]);
        az[37] = z[37] * a[37];

        a[38] = Min(komsosSedang(v), inderaSedang(w), perilakuRingan(x), pinfoTinggi(y));
        z[38] = potensiAutis(a[38]);
        az[38] = z[38] * a[38];

        a[39] = Min(komsosSedang(v), inderaSedang(w), perilakuSedang(x), pinfoRingan(y));
        z[39] = potensiAutis(a[39]);
        az[39] = z[39] * a[39];

        a[40] = Min(komsosSedang(v), inderaSedang(w), perilakuSedang(x), pinfoSedang(y));
        z[40] = potensiAutis(a[40]);
        az[40] = z[40] * a[40];

        a[41] = Min(komsosSedang(v), inderaSedang(w), perilakuSedang(x), pinfoTinggi(y));
        z[41] = potensiAutis(a[41]);
        az[41] = z[41] * a[41];

        a[42] = Min(komsosSedang(v), inderaSedang(w), perilakuTinggi(x), pinfoRingan(y));
        z[42] = potensiAutis(a[42]);
        az[42] = z[42] * a[42];

        a[43] = Min(komsosSedang(v), inderaSedang(w), perilakuTinggi(x), pinfoSedang(y));
        z[43] = potensiAutis(a[43]);
        az[43] = z[43] * a[43];

        a[44] = Min(komsosSedang(v), inderaSedang(w), perilakuTinggi(x), pinfoTinggi(y));
        z[44] = potensiAutis(a[44]);
        az[44] = z[44] * a[44];

        a[45] = Min(komsosSedang(v), inderaTinggi(w), perilakuRingan(x), pinfoRingan(y));
        z[45] = potensiAutis(a[45]);
        az[45] = z[45] * a[45];

        a[46] = Min(komsosSedang(v), inderaTinggi(w), perilakuRingan(x), pinfoSedang(y));
        z[46] = potensiAutis(a[46]);
        az[46] = z[46] * a[46];

        a[47] = Min(komsosSedang(v), inderaTinggi(w), perilakuRingan(x), pinfoTinggi(y));
        z[47] = potensiAutis(a[47]);
        az[47] = z[47] * a[47];

        a[48] = Min(komsosSedang(v), inderaTinggi(w), perilakuSedang(x), pinfoRingan(y));
        z[48] = potensiAutis(a[48]);
        az[48] = z[48] * a[48];

        a[49] = Min(komsosSedang(v), inderaTinggi(w), perilakuSedang(x), pinfoSedang(y));
        z[49] = potensiAutis(a[49]);
        az[49] = z[49] * a[49];

        a[50] = Min(komsosSedang(v), inderaTinggi(w), perilakuSedang(x), pinfoTinggi(y));
        z[50] = potensiAutis(a[50]);
        az[50] = z[50] * a[50];

        a[51] = Min(komsosSedang(v), inderaTinggi(w), perilakuTinggi(x), pinfoRingan(y));
        z[51] = potensiAutis(a[51]);
        az[51] = z[51] * a[51];

        a[52] = Min(komsosSedang(v), inderaTinggi(w), perilakuTinggi(x), pinfoSedang(y));
        z[52] = potensiAutis(a[52]);
        az[52] = z[52] * a[52];

        a[53] = Min(komsosSedang(v), inderaTinggi(w), perilakuTinggi(x), pinfoTinggi(y));
        z[53] = potensiAutis(a[53]);
        az[53] = z[53] * a[53];

        a[54] = Min(komsosTinggi(v), inderaRingan(w), perilakuRingan(x), pinfoRingan(y));
        z[54] = potensiAutis(a[54]);
        az[54] = z[54] * a[54];

        a[55] = Min(komsosTinggi(v), inderaRingan(w), perilakuRingan(x), pinfoSedang(y));
        z[55] = potensiAutis(a[55]);
        az[55] = z[55] * a[55];

        a[56] = Min(komsosTinggi(v), inderaRingan(w), perilakuRingan(x), pinfoTinggi(y));
        z[56] = potensiAutis(a[56]);
        az[56] = z[56] * a[56];

        a[57] = Min(komsosTinggi(v), inderaRingan(w), perilakuSedang(x), pinfoRingan(y));
        z[57] = potensiAutis(a[57]);
        az[57] = z[57] * a[57];

        a[58] = Min(komsosTinggi(v), inderaRingan(w), perilakuSedang(x), pinfoSedang(y));
        z[58] = potensiAutis(a[58]);
        az[58] = z[58] * a[58];

        a[59] = Min(komsosTinggi(v), inderaRingan(w), perilakuSedang(x), pinfoTinggi(y));
        z[59] = potensiAutis(a[59]);
        az[59] = z[59] * a[59];

        a[60] = Min(komsosTinggi(v), inderaRingan(w), perilakuTinggi(x), pinfoRingan(y));
        z[60] = potensiAutis(a[60]);
        az[60] = z[60] * a[60];

        a[61] = Min(komsosTinggi(v), inderaRingan(w), perilakuTinggi(x), pinfoSedang(y));
        z[61] = potensiAutis(a[61]);
        az[61] = z[61] * a[61];

        a[62] = Min(komsosTinggi(v), inderaRingan(w), perilakuTinggi(x), pinfoTinggi(y));
        z[62] = potensiAutis(a[62]);
        az[62] = z[62] * a[62];

        a[63] = Min(komsosTinggi(v), inderaSedang(w), perilakuRingan(x), pinfoRingan(y));
        z[63] = potensiAutis(a[63]);
        az[63] = z[63] * a[63];

        a[64] = Min(komsosTinggi(v), inderaSedang(w), perilakuRingan(x), pinfoSedang(y));
        z[64] = potensiAutis(a[64]);
        az[64] = z[64] * a[64];

        a[65] = Min(komsosTinggi(v), inderaSedang(w), perilakuRingan(x), pinfoTinggi(y));
        z[65] = potensiAutis(a[65]);
        az[65] = z[65] * a[65];

        a[66] = Min(komsosTinggi(v), inderaSedang(w), perilakuSedang(x), pinfoRingan(y));
        z[66] = potensiAutis(a[66]);
        az[66] = z[66] * a[66];

        a[67] = Min(komsosTinggi(v), inderaSedang(w), perilakuSedang(x), pinfoSedang(y));
        z[67] = potensiAutis(a[67]);
        az[67] = z[67] * a[67];

        a[68] = Min(komsosTinggi(v), inderaSedang(w), perilakuSedang(x), pinfoTinggi(y));
        z[68] = potensiAutis(a[68]);
        az[68] = z[68] * a[68];

        a[69] = Min(komsosTinggi(v), inderaSedang(w), perilakuTinggi(x), pinfoRingan(y));
        z[69] = potensiAutis(a[69]);
        az[69] = z[69] * a[69];

        a[70] = Min(komsosTinggi(v), inderaSedang(w), perilakuTinggi(x), pinfoSedang(y));
        z[70] = potensiAutis(a[70]);
        az[70] = z[70] * a[70];

        a[71] = Min(komsosTinggi(v), inderaSedang(w), perilakuTinggi(x), pinfoTinggi(y));
        z[71] = potensiAutis(a[71]);
        az[71] = z[71] * a[71];

        a[72] = Min(komsosTinggi(v), inderaTinggi(w), perilakuRingan(x), pinfoRingan(y));
        z[72] = potensiAutis(a[72]);
        az[72] = z[72] * a[72];

        a[73] = Min(komsosTinggi(v), inderaTinggi(w), perilakuRingan(x), pinfoSedang(y));
        z[73] = potensiAutis(a[73]);
        az[73] = z[73] * a[73];

        a[74] = Min(komsosTinggi(v), inderaTinggi(w), perilakuRingan(x), pinfoTinggi(y));
        z[74] = potensiAutis(a[74]);
        az[74] = z[74] * a[74];

        a[75] = Min(komsosTinggi(v), inderaTinggi(w), perilakuSedang(x), pinfoRingan(y));
        z[75] = potensiAutis(a[75]);
        az[75] = z[75] * a[75];

        a[76] = Min(komsosTinggi(v), inderaTinggi(w), perilakuSedang(x), pinfoSedang(y));
        z[76] = potensiAutis(a[76]);
        az[76] = z[76] * a[76];

        a[77] = Min(komsosTinggi(v), inderaTinggi(w), perilakuSedang(x), pinfoTinggi(y));
        z[77] = potensiAutis(a[77]);
        az[77] = z[77] * a[77];

        a[78] = Min(komsosTinggi(v), inderaTinggi(w), perilakuTinggi(x), pinfoRingan(y));
        z[78] = potensiAutis(a[78]);
        az[78] = z[78] * a[78];

        a[79] = Min(komsosTinggi(v), inderaTinggi(w), perilakuTinggi(x), pinfoSedang(y));
        z[79] = potensiAutis(a[79]);
        az[79] = z[79] * a[79];

        a[80] = Min(komsosTinggi(v), inderaTinggi(w), perilakuTinggi(x), pinfoTinggi(y));
        z[80] = potensiAutis(a[80]);
        az[80] = z[80] * a[80];

        for (int i = 0; i < 81; i++) {
            a[81] += a[i];
        }

        for (int i = 0; i < 81; i++) {
            az[81] += az[i];
        }
        zFinal = az[81] / a[81];
        return zFinal;
    }

    public double fitness(double a) {
        double fitt;
        fitt = a / 135;
        return fitt;
    }

    public void gabungFitness() {
        for (int i = 0; i < popSize; i++) {
            fitnessGabungan[i] = fitnessParent[i];
            kromosomGabungan[i] = individu[i];
        }
        int total = count + anakMutasi;
        for (int i = 0; i < total; i++) {
            fitnessGabungan[i + popSize] = fitnessChild[i];
            kromosomGabungan[i + popSize] = child[i];
        }
//        for (int i = 0; i < total + popSize; i++) {
//            System.out.println("Fitness " + i + " : " + fitnessGabungan[i]);
//        }
    }

    public void seleksi() {
        double swap;
        double[][] swap2 = new double[1][pKromosom];;
        for (int i = 0; i < popSize + count + anakMutasi; i++) {
            for (int j = 0; j < popSize + count + anakMutasi - 1; j++) {
                if (fitnessGabungan[j] < fitnessGabungan[j + 1]) {
                    swap = fitnessGabungan[j];
                    fitnessGabungan[j] = fitnessGabungan[j + 1];
                    fitnessGabungan[j + 1] = swap;
                    swap2[0] = kromosomGabungan[j];
                    kromosomGabungan[j] = kromosomGabungan[j + 1];
                    kromosomGabungan[j + 1] = swap2[0];
                }
            }
        }
        for (int i = 0; i < popSize + count + anakMutasi; i++) {
            System.out.print("Fitness " + i + " : " + fitnessGabungan[i]);
            for (int j = 0; j < pKromosom; j++) {
                System.out.print(" " + kromosomGabungan[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < popSize; i++) {
            individu[i] = kromosomGabungan[i];
        }

    }

    public void jalankan() {
        //autisme b = new autisme();

        for (int i = 0; i < popSize; i++) {
            individu[i] = inisialisasi();
        }
        System.out.println("inisialisasi awal : ");
        for (int i = 0; i < popSize; i++) {
            for (int j = 0; j < pKromosom; j++) {
                System.out.print(individu[i][j] + " ");
            }
            System.out.println("");
        }
        int testing = 0;
        for (int z = 0; z < banyakGenerasi; z++) {

            pCross();
            pMutasi();
            penggabungan();

//            System.out.println("anakan");
//            for (int i = 0; i < b.count + b.anakMutasi; i++) {
//                for (int j = 0; j < b.pKromosom; j++) {
//                    System.out.print(b.child[i][j] + " ");
//                }
//                System.out.println("");
//            }
            file();
            for (int i = 0; i < popSize; i++) {
                fuzzyfikasi(i);
                
                double temp = 0;
                countAkurasi = 0;
                for (int j = 0; j < 135; j++) {
                    int x = 0;
                    temp = rule(input[j][0], input[j][1], input[j][2], input[j][3]);
                    double A = defuzifikasiAutis(temp);
                    double N = defuzifikasiNon(temp);
                    if (A > N) {
//                    System.out.println("Y : " + x);
//                    System.out.print("Autisme : ");
                        x = 1;
                        //System.out.println("Prediksi : " + x);
                    } else {
//                    System.out.println("Y : " + x);
//                    System.out.print("Non Autisme : ");
                        x = 0;
                        //System.out.println("Prediksi : " + x);

                    }

                    if (x == target[j]) {
                        //System.out.println("Benar");
                        countAkurasi++;
                    } else {
                        //System.out.println("Salah");

                    }

                }
                //System.out.println("total benar : " + b.countAkurasi);
//
//                System.out.println("Fitness " + i + " : " + +b.fitness(b.countAkurasi));
//                System.out.println(b.fitness(b.countAkurasi));
                fitnessParent[i] = fitness(countAkurasi);

            }
            //child
            for (int i = 0; i < count + anakMutasi; i++) {
                fuzzyfikasiChild(i);
                

               countAkurasi = 0;
                for (int j = 0; j < 135; j++) {
                    double tempChild = 0;
                    int xChild = 0;
                    tempChild = rule(input[j][0], input[j][1], input[j][2], input[j][3]);
                    double A = defuzifikasiAutis(tempChild);
                    double N = defuzifikasiNon(tempChild);
                    if (A > N) {
//                    System.out.println("Y : " + x);
//                    System.out.print("Autisme : ");
                        xChild = 1;
                        //System.out.println("Prediksi : " + xChild);
                    } else {
//                    System.out.println("Y : " + x);
//                    System.out.print("Non Autisme : ");
                        xChild = 0;
                        //System.out.println("Prediksi : " + xChild);

                    }

                    if (xChild == target[j]) {
                        //System.out.println("Benar");
                        countAkurasi++;
                    } else {
                        //System.out.println("Salah");

                    }

                }
                // System.out.println("total benar : " + b.countAkurasi);
//
//                System.out.println("Fitness child " + i + " : " + +b.fitness(b.countAkurasi));
//                System.out.println(b.fitness(b.countAkurasi));
                fitnessChild[i] = fitness(countAkurasi);

            }
            testing++;
            gabungFitness();
            seleksi();
        }
        System.out.println("perulangan : " + testing);
        //Testing data
        

    }
    
    public void jalankanData(int a){
        fuzzyfikasi(a);
        file2();
        countAkurasi = 0;
        for (int i = 0; i < 20; i++) {
            int x = 0; 
            double temp = 0;
                temp = rule(inputTest[i][0], inputTest[i][1], inputTest[i][2], inputTest[i][3]);
                double A = defuzifikasiAutis(temp);
                double N = defuzifikasiNon(temp);
                System.out.println("Autisme : " + A);
                System.out.println("Non Autisme : "+ N);
                if (A > N) {                  
                    x = 1;
                    hasilS[i] = x;
                    System.out.println("Prediksi : " + x);
                } else {
                    x = 0;
                    hasilS[i] = x;
                    System.out.println("Prediksi : " + x);
                }

                if (x == targetTest[i]) {
                    System.out.println("Benar");
                    countAkurasi++;
                } else {
                    System.out.println("Salah");
                }
                
            
        }
        System.out.println("total benar : " + countAkurasi);
    }


    public static void main(String[] args) {
        autisme a = new autisme();
        a.jalankan();
//        System.out.println("Individu :   ");
//        for (int i = 0; i < a.popSize; i++) {
//            a.individu[i] = a.inisialisasi();
//        }
//        for (int i = 0; i < a.popSize; i++) {
//            for (int j = 0; j < a.pKromosom; j++) {
//                System.out.print(a.individu[i][j] + " ");
//            }
//            System.out.println("");
//        }
//
//        a.pCross();
//        a.pMutasi();
//        System.out.println("FILE");
//        a.file();
//
        //int offspring = (int) Math.ceil(a.pc * a.popSize);
        //System.out.println(" tes : " + offspring);
//        int random = a.rand.nextInt(a.popSize);
//        System.out.println("rand : " + random);
//        int sisa = 1 % 2;
//        System.out.println("sisa " + sisa);
//        int random1, random2;
//        random1 = a.rand.nextInt(a.popSize);
//        random2 = a.rand.nextInt(a.popSize);
//        int uhu = (int) Math.ceil(a.popSize * a.pm);
//        System.out.println("cup");
//        System.out.println(uhu);
//        System.out.println(random1);
//        System.out.println(random2);
    }
}
