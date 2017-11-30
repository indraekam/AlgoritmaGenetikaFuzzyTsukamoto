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
import java.util.*;

public class autismeChat {

    Random rand = new Random();
    public int popSize = 10;
    public int pKromosom = 6;
    public double pc = 0.9;
    public double pm = 0.1;
    public int banyakGenerasi = 100;
    public double individu[][];
    public double childC[][] = new double[9999][pKromosom];
    public double childM[][] = new double[9999][pKromosom];
    public double child[][] = new double[9999][pKromosom];
    public double input[][] = new double[30][2];
    public int target[] = new int[30];
    public int hasilS[] = new int[30];
    public double fitnessParent[];
    public double fitnessChild[] = new double[9999];
    public double fitnessGabungan[] = new double[1000];
    public double kromosomGabungan[][] = new double[1000][pKromosom];
    public int count;
    public int countAkurasi;
    public int anakMutasi = 0;

    public double aloSatu;
    public double aloDua;
    public double pengamatanSatu;
    public double pengamatanDua;
    public double potensiSatu;
    public double potensiDua;
    public double selisihAlo;
    public double selisihPengamatan;
    public double selisihPotensi;
    public double miuAlo1, miuAlo2;
    public double miuPengamatan1, miuPengamatan2;
    double a[] = new double[5];
    double z[] = new double[4];
    double az[] = new double[5];
    double zFinal;
    double min;

    public void input(int banyakGenerasi, int popSize, double pc, double pm) {
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
            double bBawah, bAtas, random;;
            if (i == 0) {//Alo Anamnesis
                bBawah = 0;
                bAtas = 5;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 1) {
                bBawah = 5;
                bAtas = 9;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 2) {//Pengamatan
                bBawah = 0;
                bAtas = 3;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 3) {//Pengamatan
                bBawah = 3;
                bAtas = 5;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 4) {//Autisme
                bBawah = 0;
                bAtas = 7;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }
            if (i == 5) {//Autisme
                bBawah = 7;
                bAtas = 14;
                random = Math.random() * (bAtas - bBawah);
                temp[i] = bBawah + random;
            }

        }
        double swap;
        if (temp[0] > temp[1]) {
            swap = temp[0];
            temp[0] = temp[1];
            temp[1] = swap;
        }
        if (temp[2] > temp[3]) {
            swap = temp[2];
            temp[2] = temp[3];
            temp[3] = swap;
        }
        if (temp[4] > temp[5]) {
            swap = temp[4];
            temp[4] = temp[5];
            temp[5] = swap;
        }

        return temp;
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
                    child1 = crossover(random1, random2);
                    for (int k = 0; k < 2; k++) {
                        childC[count] = child1[k];
                        count++;
                    }
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

    public double[] mutasi(int data1) {
        double[] p1 = new double[pKromosom];
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
        if (random1 < 2) {//Alo Anamnesis
            hasil1 = tamp1 + (alpha * (9 - 0));
            child[random1] = hasil1;
        }
        if (random1 > 1 && random1 < 4) {//Pengamatan
            hasil1 = tamp1 + (alpha * (5 - 0));
            child[random1] = hasil1;
        }
        if (random1 > 3 && random1 < 6) {//Autisme
            hasil1 = tamp1 + (alpha * (14 - 0));
            child[random1] = hasil1;
        }

        return child;
    }

    public void pMutasi() {
        int random1;
        int offspring = (int) Math.ceil(pm * popSize);
        double tampung[][] = new double[offspring][pKromosom];
        tampung = individu;
        double[] child1 = new double[pKromosom];
        //System.out.println("offs :" + offspring);
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
            BufferedReader br = new BufferedReader(new FileReader(new File("inputChat1.txt")));
            String line;
            int baris = 0;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                for (int j = 0; j < data.length; j++) {
                    input[baris][j] = Double.parseDouble(data[j]);
                    System.out.print(input[baris][j]);
                }
                System.out.println("");
                baris++;
            }

        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

        //untuk target
        System.out.println("Target  : ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("outputChat1.txt")));
            String line;
            int baris = 0;
            while ((line = br.readLine()) != null) {
                target[baris] = Integer.parseInt(line);
                System.out.println(target[baris]);
                baris++;
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

    }

    public void fuzzyfikasiAwal(int childNumber) {
        aloSatu = 3;
        aloDua = 6;
        selisihAlo = aloDua - aloSatu;

        pengamatanSatu = 2;
        pengamatanDua = 4;
        selisihPengamatan = pengamatanDua - pengamatanSatu;

        potensiSatu = 4;
        potensiDua = 10;
        selisihPotensi = potensiDua - potensiSatu;

    }

    public void fuzzyfikasi(int childNumber) {
        aloSatu = individu[childNumber][0];
        aloDua = individu[childNumber][1];
        selisihAlo = aloDua - aloSatu;

        pengamatanSatu = individu[childNumber][2];
        pengamatanDua = individu[childNumber][3];
        selisihPengamatan = pengamatanDua - pengamatanSatu;

        potensiSatu = individu[childNumber][4];
        potensiDua = individu[childNumber][5];
        selisihPotensi = potensiDua - potensiSatu;

    }

    public void fuzzyfikasiChild(int childNumber) {
        aloSatu = child[childNumber][0];
        aloDua = child[childNumber][1];
        selisihAlo = aloDua - aloSatu;

        pengamatanSatu = child[childNumber][2];
        pengamatanDua = child[childNumber][3];
        selisihPengamatan = pengamatanDua - pengamatanSatu;

        potensiSatu = child[childNumber][4];
        potensiDua = child[childNumber][5];
        selisihPotensi = potensiDua - potensiSatu;

    }

    public double aloSedikit(double x) {
        if (x >= aloDua) {
            miuAlo1 = 0;
        } else if (x > aloSatu && x < aloDua) {
            miuAlo1 = (aloDua - x) / selisihAlo;
        } else if (x <= aloSatu) {
            miuAlo1 = 1;
        }
        return miuAlo1;

    }

    public double aloBanyak(double x) {
        if (x <= aloSatu) {
            miuAlo2 = 0;
        } else if (x > aloSatu && x < aloDua) {
            miuAlo2 = (x - aloSatu) / selisihAlo;
        } else if (x >= aloDua) {
            miuAlo2 = 1;
        }
        return miuAlo2;

    }

    public double pengamatanSedikit(double x) {
        if (x >= pengamatanDua) {
            miuPengamatan1 = 0;
        } else if (x > pengamatanSatu && x < pengamatanDua) {
            miuPengamatan1 = (pengamatanDua - x) / selisihPengamatan;
        } else if (x <= pengamatanSatu) {
            miuPengamatan1 = 1;
        }
        return miuPengamatan1;

    }

    public double pengamatanBanyak(double x) {
        if (x <= pengamatanSatu) {
            miuPengamatan2 = 0;
        } else if (x > pengamatanSatu && x < pengamatanDua) {
            miuPengamatan2 = (x - pengamatanSatu) / selisihPengamatan;
        } else if (x >= pengamatanDua) {
            miuPengamatan2 = 1;
        }
        return miuPengamatan2;

    }

    private double Min(double x, double y) {
        if (x < y) {
            min = x;
        } else {
            min = y;
        }
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
        //System.out.println("non : " + y);
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
        // System.out.println("Autis : " + y);
        return y;
    }

    public double rule(double x, double y) {
        double hasil;
        double dNon;
        double dAutisme;
        for (int i = 0; i < 4; i++) {
            a[i] = 0.0;
            z[i] = 0.0;
            az[i] = 0.0;

        }
        a[4] = 0.0;
        az[4] = 0.0;

//        System.out.println("tabel az sebelum : ");
//        for (int i = 0; i < 4; i++) {
//            System.out.print(a[i] + "\t" + z[i] + "\t" + az[i]);
//            System.out.println("");
//        }
        a[0] = Min(aloSedikit(x), pengamatanSedikit(y));
        z[0] = potensiNon(a[0]);
        az[0] = a[0] * z[0];

        a[1] = Min(aloSedikit(x), pengamatanBanyak(y));
        z[1] = potensiAutis(a[1]);
        az[1] = a[1] * z[1];

        a[2] = Min(aloBanyak(x), pengamatanSedikit(y));
        z[2] = potensiAutis(a[2]);
        az[2] = a[2] * z[2];

        a[3] = Min(aloBanyak(x), pengamatanBanyak(y));
        z[3] = potensiAutis(a[3]);
        az[3] = a[3] * z[3];

//        System.out.println("tabel az: ");
//        for (int i = 0; i < 4; i++) {
//            System.out.print(a[i] + "\t" + z[i] + "\t" + az[i]);
//            System.out.println("");
//        }
        for (int i = 0; i < 4; i++) {
            a[4] += a[i];
        }
//        System.out.println("a* : " + a[4]);
        for (int i = 0; i < 4; i++) {
            az[4] += az[i];
        }
//        System.out.println("az* : " + az[4]);
        zFinal = az[4] / a[4];

        return zFinal;
    }

    public double fitness(double a) {
        double fitt;
        fitt = a / 30;
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
        for (int i = 0; i < total + popSize; i++) {
            System.out.println("Fitness " + i + " : " + fitnessGabungan[i]);
        }
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
        //autismeChat b = new autismeChat();

        for (int i = 0; i < popSize; i++) {
            individu[i] = inisialisasi();
        }
//        for (int i = 0; i < 10; i++) {
//
//        }
        for (int i = 0; i < popSize; i++) {
            for (int j = 0; j < pKromosom; j++) {
                System.out.print(individu[i][j] + " ");
            }
            System.out.println("");
        }
        for (int z = 0; z < banyakGenerasi; z++) {

            pCross();
            pMutasi();
            penggabungan();

            //System.out.println("anakan");
            for (int i = 0; i < count + anakMutasi; i++) {
                for (int j = 0; j < pKromosom; j++) {
                    System.out.print(child[i][j] + " ");
                }
                System.out.println("");
            }
            file();
            for (int i = 0; i < popSize; i++) {
                fuzzyfikasi(i);
                
                double temp = 0;
                countAkurasi = 0;
                for (int j = 0; j < 30; j++) {
                    int x = 0;
                    temp = rule(input[j][0], input[j][1]);
                    double A = defuzifikasiAutis(temp);
                    double N = defuzifikasiNon(temp);
                    if (A >= N) {
//                    System.out.println("Y : " + x);
//                    System.out.print("Autisme : ");
                        x = 1;
                        System.out.println("Prediksi : " + x);
                    } else {
//                    System.out.println("Y : " + x);
//                    System.out.print("Non Autisme : ");
                        x = 0;
                        System.out.println("Prediksi : " + x);

                    }

                    if (x == target[j]) {
                        System.out.println("Benar");
                        countAkurasi++;
                    } else {
                        System.out.println("Salah");

                    }

                }
               // System.out.println("total Benar : " + b.countAkurasi);

                //System.out.println("Fitness " + i + " : " + +b.fitness(b.countAkurasi));
                System.out.println(fitness(countAkurasi));
                fitnessParent[i] = fitness(countAkurasi);

            }
            //child
            for (int i = 0; i < count + anakMutasi; i++) {
                fuzzyfikasiChild(i);
                
                double tempChild = 0;
                countAkurasi = 0;
                for (int j = 0; j < 30; j++) {
                    int xChild = 0;
                    tempChild = rule(input[j][0], input[j][1]);
                    double A = defuzifikasiAutis(tempChild);
                    double N = defuzifikasiNon(tempChild);
                    if (A > N) {
//                    System.out.println("Y : " + x);
//                    System.out.print("Autisme : ");
                        xChild = 1;
                        System.out.println("Prediksi : " + xChild);
                    } else {
//                    System.out.println("Y : " + x);
//                    System.out.print("Non Autisme : ");
                        xChild = 0;
                        System.out.println("Prediksi : " + xChild);

                    }

                    if (xChild == target[j]) {
                        System.out.println("Benar");
                        countAkurasi++;
                    } else {
                        System.out.println("Salah");

                    }

                }
                System.out.println("total Benar : " + countAkurasi);

                //System.out.println("Fitness child " + i + " : " + +b.fitness(b.countAkurasi));
                System.out.println(fitness(countAkurasi));
                fitnessChild[i] = fitness(countAkurasi);

            }

            gabungFitness();
            seleksi();
        }
        //Pengujian
//        fuzzyfikasiAwal(0);
//        int x = 0;
//        double temp = 0;
//        countAkurasi = 0;
//        for (int j = 0; j < 30; j++) {
//
//            temp = rule(input[j][0], input[j][1]);
//            double A = defuzifikasiAutis(temp);
//            double N = defuzifikasiNon(temp);
//            if (A > N) {
//                    System.out.println("Y : " + x);
//                    System.out.print("Autisme : ");
//                x = 1;
//                hasilS[j] = x;
//                System.out.println("Prediksi : " + x);
//            } else {
//                    System.out.println("Y : " + x);
//                    System.out.print("Non Autisme : ");
//                hasilS[j] = x;
//                x = 0;
//                System.out.println("Prediksi : " + x);
//
//            }
//
//            if (x == target[j]) {
//                System.out.println("Benar");
//                countAkurasi++;
//            } else {
//                System.out.println("Salah");
//
//            }
//
//        }
//        System.out.println("total Benar : " + countAkurasi);
//
//        System.out.println("Fitness " + i + " : " + +b.fitness(b.countAkurasi));
//        System.out.println(fitness(countAkurasi));
        //b.fitnessParent[i] = b.fitness(b.countAkurasi);

    }

    public void jalankanData(int a) {
        //Pengujian
        fuzzyfikasi(a);
        
        
        countAkurasi = 0;
        for (int j = 0; j < 30; j++) {
            double temp = 0;
            int x = 0;
            temp = rule(input[j][0], input[j][1]);
            double A = defuzifikasiAutis(temp);
            double N = defuzifikasiNon(temp);
            if (A > N) {
//                    System.out.println("Y : " + x);
//                    System.out.print("Autisme : ");
                x = 1;
                hasilS[j] = x;
                System.out.println("Prediksi : " + x);
            } else {
//                    System.out.println("Y : " + x);
//                    System.out.print("Non Autisme : ");
                hasilS[j] = x;
                x = 0;
                System.out.println("Prediksi : " + x);

            }

            if (x == target[j]) {
                System.out.println("Benar");
                countAkurasi++;
            } else {
                System.out.println("Salah");

            }

        }
        System.out.println("total Benar : " + countAkurasi);

        //System.out.println("Fitness " + i + " : " + +b.fitness(b.countAkurasi));
        //System.out.println(fitness(countAkurasi));
        //b.fitnessParent[i] = b.fitness(b.countAkurasi);

    }

    public void masukan(int banyakGenerasi, int popSize, double pm, double pc) {
        this.banyakGenerasi = banyakGenerasi;
        this.popSize = popSize;
        this.pm = pm;
        this.pc = pc;
    }

    public static void main(String[] args) {
        autismeChat a = new autismeChat();
        a.jalankan();

//        for (int i = 0; i < a.popSize; i++) {
//            a.individu[i] = a.inisialisasi();
//        }
//
//        for (int i = 0; i < a.popSize; i++) {
//            for (int j = 0; j < a.pKromosom; j++) {
//                System.out.print(a.individu[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        a.pCross();
//        a.pMutasi();
//        a.penggabungan();
//        a.file();
    }

}
