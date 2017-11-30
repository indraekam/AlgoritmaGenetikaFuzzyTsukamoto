/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
/**
 *
 * @author Uhuuy31
 */
import java.util.*;

public class ProjekAlev {

    Random a = new Random();
    public int maxIterasi = 50;
    public static int populasi = 8;
    public static int atribut = 10;
    public static double pc = 0.3;
    public static double pm = 0.08;
    static double probCross = pc * populasi;
    public static int jumlahCross = (int) Math.ceil(probCross);
    public static double probM = pm * populasi;
    public static int jumlahMutasi = (int) Math.ceil(probM);
    public static double[][] input = new double[populasi][atribut + 1];
    public double tampung[][] = new double[populasi][atribut];

    public static double[][] crossover = new double[20][atribut + 1];
    public static double[][] mutasi = new double[jumlahMutasi][atribut + 1];
    double fitness;

    public void inisialisasi() {
        for (int i = 0; i < populasi; i++) {

            input[i][0] = Math.ceil(Math.random() * 3);
            input[i][1] = Math.ceil(Math.random() * 6);
            input[i][2] = Math.ceil(Math.random() * 2);
            input[i][3] = Math.ceil(Math.random() * 6);
            input[i][4] = Math.ceil(Math.random() * 2);
            input[i][5] = Math.ceil(Math.random() * 3);
            input[i][6] = Math.ceil(Math.random() * 6);
            input[i][7] = Math.ceil(Math.random() * 2);
            input[i][8] = Math.ceil(Math.random() * 6);
            input[i][9] = Math.ceil(Math.random() * 2);

        }
        //System.out.println("Populasi Awal  :");
        //System.out.println("Nilai : ");
//        for (int i = 0; i < populasi; i++) {
//            int z = i + 1;
//            System.out.print(z + "\t");
//            for (int j = 0; j < atribut; j++) {
//
//                System.out.print(input[i][j] + "\t");
//            }
//
//            System.out.println("");
//        }

    }

    public void hitungFitness(double[][] data) {
        double tampung = 0.0;

        for (int i = 0; i < data.length; i++) {
            if (data[i][0] == data[i][5]) {
                tampung += 1;
            }
            if (data[i][1] == data[i][6]) {
                tampung += 1;
            }
            if (data[i][2] == data[i][7]) {
                tampung += 1;
            }
            if (data[i][3] == data[i][8]) {
                tampung += 1;
            }
            if (data[i][4] == data[i][9]) {
                tampung += 1;
            }
            fitness = 1 / (1 + tampung);
            int z = i + 1;

            data[i][10] = fitness;
            // System.out.println("Nilai fitness " + z + " = " + data[i][10]);
        }

    }

    public void crossOver() {
        int sisa = jumlahCross % 2;
        if (sisa == 1) {
            jumlahCross = jumlahCross + 1;
        }
        double[][] tampungArray = new double[jumlahCross][atribut + 1];
        int jumlahCrossB = jumlahCross / 2;
        for (int i = 0; i < jumlahCrossB; i++) {
            int rand = a.nextInt(populasi);//untuk pemilihan individu yang di crossover
            int rand2 = a.nextInt(populasi);//untuk pemilihan individu yang di crossover
            int rand3 = a.nextInt(atribut - 1);//untuk pemotongan individu

            if (rand == rand2) {
                do {
                    rand = a.nextInt(populasi);
                    rand2 = a.nextInt(populasi);
                } while (rand != rand2);

            }
            if (rand != rand2) {
                int q = 0;
                for (int j = 0; j < rand3; j++) {
                    tampungArray[q][j] = input[rand][j];
                    tampungArray[q + 1][j] = input[rand2][j];

                }
                System.out.println("individu : " + rand);
                System.out.println("individu2 : " + rand2);
                System.out.println("rand 3 : " + rand3);

                int r = 0;
                for (int j = rand3; j < atribut; j++) {
                    tampungArray[r][j] = input[rand2][j];
                    tampungArray[r + 1][j] = input[rand][j];
                }

            }
            int z = 0;
            int x = 0;
            for (int k = z; k < z + 2; k++) {
                for (int j = 0; j < atribut; j++) {

                    crossover[k][j] = tampungArray[x][j];
                    System.out.print(crossover[k][j] + "\t");

                }
                x++;
                System.out.println("");
            }
            x = 0;
            z = z + 2;

        }

    }

    public void mutasi() {

        double tampung;
        System.out.println("Jumlah Mutasi " + jumlahMutasi);
        for (int i = 0; i < jumlahMutasi; i++) {
            int rand = a.nextInt(populasi);//untuk pemilihan individu yang di Mutasi
            int rand3 = a.nextInt(atribut / 2);//untuk pemotongan individu

            if (rand3 == 0) {
                tampung = input[rand][rand3];
                input[rand][rand3] = input[rand][5];
                input[rand][5] = tampung;
                for (int j = 0; j < atribut; j++) {
                    mutasi[i][j] = input[rand][j];
                }

            }
            if (rand3 == 1) {
                tampung = input[rand][rand3];
                input[rand][rand3] = input[rand][6];
                input[rand][6] = tampung;
                for (int j = 0; j < atribut; j++) {
                    mutasi[i][j] = input[rand][j];
                }
            }
            if (rand3 == 2) {
                tampung = input[rand][rand3];
                input[rand][rand3] = input[rand][7];
                input[rand][7] = tampung;
                for (int j = 0; j < atribut; j++) {
                    mutasi[i][j] = input[rand][j];
                }
            }
            if (rand3 == 3) {
                tampung = input[rand][rand3];
                input[rand][rand3] = input[rand][8];
                input[rand][8] = tampung;
                for (int j = 0; j < atribut; j++) {
                    mutasi[i][j] = input[rand][j];
                }
            }
            if (rand3 == 4) {
                tampung = input[rand][rand3];
                input[rand][rand3] = input[rand][9];
                input[rand][9] = tampung;
                for (int j = 0; j < atribut; j++) {
                    mutasi[i][j] = input[rand][j];
                }
            }

        }

        System.out.println("Hasil Mutasi : ");
        for (int i = 0; i < jumlahMutasi; i++) {
            for (int j = 0; j < atribut; j++) {
                System.out.print(mutasi[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    public void seleksi() {
        int total = populasi + jumlahCross + jumlahMutasi;
        double[][] tampung = new double[total][2];
        System.out.println("individu : ");
        for (int i = 0; i < populasi; i++) {
            for (int j = 0; j < atribut + 1; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println("");
        }
        System.out.println("cross : ");
        for (int i = 0; i < jumlahCross; i++) {
            for (int j = 0; j < atribut + 1; j++) {
                System.out.print(crossover[i][j]);
            }
            System.out.println("");
        }
        System.out.println("mutasi : ");
        for (int i = 0; i < mutasi.length; i++) {
            for (int j = 0; j < atribut + 1; j++) {
                System.out.print(mutasi[i][j]);
            }
            System.out.println("");
        }
        int x = 0;
        for (int i = 0; i < input.length; i++) {
            tampung[x][0] = x;
            tampung[x][1] = input[i][10];
            x++;
        }
        for (int i = 0; i < jumlahCross; i++) {
            tampung[x][0] = x;
            tampung[x][1] = crossover[i][10];
            x++;
        }
        for (int i = 0; i < mutasi.length; i++) {
            tampung[x][0] = x;
            tampung[x][1] = mutasi[i][10];
            x++;
        }
        System.out.println(" Tampung : ");
        for (int i = 0; i < tampung.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(tampung[i][j]);
            }
            System.out.println("");
        }

        double swap;
        double swap2;
        for (int i = 0; i < tampung.length; i++) {
            for (int j = 0; j < tampung.length - 1; j++) {

                if (tampung[j][1] < tampung[j + 1][1]) {
                    swap = tampung[j][1];
                    tampung[j][1] = tampung[j + 1][1];
                    tampung[j + 1][1] = swap;
                    swap2 = tampung[j][0];
                    tampung[j][0] = tampung[j + 1][0];
                    tampung[j + 1][0] = swap2;

                }
            }
        }
        System.out.println(" Tampung : ");
        for (int i = 0; i < tampung.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(tampung[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < populasi; i++) {
            int index = (int) tampung[i][0];

            if (index < populasi) {
                for (int j = 0; j < atribut + 1; j++) {
                    input[i][j] = input[index][j];

                }

            } else {
                int popC = populasi + jumlahCross;
                if (index >= populasi || index < popC) {
                    for (int j = 0; j < atribut + 1; j++) {
                        input[i][j] = crossover[(index - populasi)][j];

                    }

                } else {
                    if (index >= popC) {
                        for (int j = 0; j < atribut + 1; j++) {
                            input[i][j] = mutasi[(index - popC)][j];

                        }

                    }
                }
            }

        }
    }

    public void algoritma() {

        ProjekAlev a = new ProjekAlev();
//        a.inisialisasi();
        //for (int i = 0; i < maxIterasi; i++) {
//            a.hitungFitness(input);
//            a.crossOver();
//            a.mutasi();
//            a.hitungFitness(crossover);
//            a.hitungFitness(mutasi);
//            for (int j = 0; j < input.length; j++) {
//                System.out.println((j + 1) + ". " + input[j][10]);
//            }
//            for (int j = 0; j < jumlahCross; j++) {
//                System.out.println((j + 1) + ". " + crossover[j][10]);
//            }
//            for (int j = 0; j < mutasi.length; j++) {
//                System.out.println((j + 1) + ". " + mutasi[j][10]);
//            }
//            a.seleksi();
        // }
        int iterasi = 1;
        while (iterasi <= maxIterasi) {
            a.inisialisasi();
            System.out.println("Populasi Awal  :");
            for (int i = 0; i < populasi; i++) {
                int z = i + 1;
                System.out.print(z + "\t");
                for (int j = 0; j < atribut; j++) {

                    System.out.print(input[i][j] + "\t");
                }

                System.out.println("");
            }
            a.hitungFitness(input);
            System.out.println("");

            a.crossOver();
            System.out.println("Fitnes crossover : ");
            a.hitungFitness(crossover);
            a.mutasi();
            System.out.println("Fitnes Mutasi : ");
            a.hitungFitness(mutasi);
            a.seleksi();
            a.inisialisasi();

            System.out.println("Individu Baru : ");
            for (int i = 0; i < populasi; i++) {
                int z = i + 1;
                System.out.print(z + "\t");
                for (int j = 0; j < atribut; j++) {

                    System.out.print(input[i][j] + "\t");
                }

                System.out.println("");
            }
            iterasi++;

        }
    }

    public static void main(String[] args) {
        ProjekAlev a = new ProjekAlev();
        a.algoritma();
//        a.inisialisasi();
//        System.out.println("Populasi Awal  :");
//        for (int i = 0; i < populasi; i++) {
//            int z = i + 1;
//            System.out.print(z + "\t");
//            for (int j = 0; j < atribut; j++) {
//
//                System.out.print(input[i][j] + "\t");
//            }
//
//            System.out.println("");
//        }
//        a.hitungFitness(input);
//        System.out.println("");
//
//        a.crossOver();
//        System.out.println("Fitnes crossover : ");
//        a.hitungFitness(crossover);
//        a.mutasi();
//        System.out.println("Fitnes Mutasi : ");
//        a.hitungFitness(mutasi);
//        a.seleksi();
//        a.inisialisasi();
//        
//        System.out.println("Individu Baru : ");
//        for (int i = 0; i < populasi; i++) {
//            int z = i + 1;
//            System.out.print(z + "\t");
//            for (int j = 0; j < atribut; j++) {
//
//                System.out.print(input[i][j] + "\t");
//            }
//
//            System.out.println("");
//        }
//
    }
}
