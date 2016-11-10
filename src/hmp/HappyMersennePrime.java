package hmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HappyMersennePrime {

    public static void main(String[] args) {
        int exponent = 57885161;
        String sourceUrl = "http://lcn2.github.io/mersenne-english-name/m57885161/huge-prime-c-e.html.gz";

        try {
            int i;
            int nrCharsRead;
            File file = new File("M" + exponent + ".tex");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\\documentclass{article}");
            bw.write(10);
            bw.write("\\usepackage{geometry}");
            bw.write(10);
            bw.write("\\geometry{a4paper, portrait, left=1.5cm, right=1.5cm, top=2.5cm, bottom=2cm}");
            bw.write(10);
            bw.write("\\usepackage{fancyhdr}");
            bw.write(10);
            bw.write("\\usepackage{multicol}");
            bw.write(10);
            bw.write("\\usepackage{framed}");
            bw.write(10);
            bw.write("\\usepackage{siunitx}");
            bw.write(10);
            bw.write("\\sisetup{group-separator = \\text{\\,}}");
            bw.write(10);
            bw.write("\\sisetup{group-minimum-digits = 3}");
            bw.write(10);
            bw.write("\\begin{document}");
            bw.write(10);
            bw.write("\\include{M" + exponent + "FP}");
            bw.write(10);
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Adrian\\Documents\\SmartXML\\V1\\M" + exponent + ".txt"));
            int lineLength = 97;
            int bufferSize = lineLength * 48;
            char[] buffer = new char[bufferSize];
            int page = 1;
            int[] squares = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
            int[] totalDigits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            while ((nrCharsRead = bufferedReader.read(buffer)) > 0) {
                int[] pageDigits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                if (page > 1) {
                    bw.write("\\newpage");
                    bw.write(10);
                }
                bw.write("\\pagestyle{fancy}");
                bw.write(10);
                bw.write("\\fancyhf{}");
                bw.write(10);
                bw.write("\\fancyhead[L]{M" + exponent + "}");
                bw.write(10);
                bw.write("\\fancyhead[C]{}");
                bw.write(10);
                bw.write("\\fancyhead[R]{Digits: \\num{" + ((page - 1) * bufferSize + 1) + "} -- \\num{" + ((page - 1) * bufferSize + nrCharsRead) + "}}");
                bw.write(10);
                bw.write("\\fancyfoot[C]{" + page + " / \\tp}");
                bw.write(10);
                bw.write("\\noindent");
                bw.write(10);
                bw.write("\\texttt{");
                for (i = 0; i < nrCharsRead; ++i) {
                    if (i % lineLength == 0 && i > 0) {
                        bw.write("} \\\\ \\texttt{");
                    }
                    switch (buffer[i]) {
                        case '0': {
                            int[] arrn = pageDigits;
                            arrn[0] = arrn[0] + 1;
                            int[] arrn2 = totalDigits;
                            arrn2[0] = arrn2[0] + 1;
                            break;
                        }
                        case '1': {
                            int[] arrn = pageDigits;
                            arrn[1] = arrn[1] + 1;
                            int[] arrn3 = totalDigits;
                            arrn3[1] = arrn3[1] + 1;
                            break;
                        }
                        case '2': {
                            int[] arrn = pageDigits;
                            arrn[2] = arrn[2] + 1;
                            int[] arrn4 = totalDigits;
                            arrn4[2] = arrn4[2] + 1;
                            break;
                        }
                        case '3': {
                            int[] arrn = pageDigits;
                            arrn[3] = arrn[3] + 1;
                            int[] arrn5 = totalDigits;
                            arrn5[3] = arrn5[3] + 1;
                            break;
                        }
                        case '4': {
                            int[] arrn = pageDigits;
                            arrn[4] = arrn[4] + 1;
                            int[] arrn6 = totalDigits;
                            arrn6[4] = arrn6[4] + 1;
                            break;
                        }
                        case '5': {
                            int[] arrn = pageDigits;
                            arrn[5] = arrn[5] + 1;
                            int[] arrn7 = totalDigits;
                            arrn7[5] = arrn7[5] + 1;
                            break;
                        }
                        case '6': {
                            int[] arrn = pageDigits;
                            arrn[6] = arrn[6] + 1;
                            int[] arrn8 = totalDigits;
                            arrn8[6] = arrn8[6] + 1;
                            break;
                        }
                        case '7': {
                            int[] arrn = pageDigits;
                            arrn[7] = arrn[7] + 1;
                            int[] arrn9 = totalDigits;
                            arrn9[7] = arrn9[7] + 1;
                            break;
                        }
                        case '8': {
                            int[] arrn = pageDigits;
                            arrn[8] = arrn[8] + 1;
                            int[] arrn10 = totalDigits;
                            arrn10[8] = arrn10[8] + 1;
                            break;
                        }
                        case '9': {
                            int[] arrn = pageDigits;
                            arrn[9] = arrn[9] + 1;
                            int[] arrn11 = totalDigits;
                            arrn11[9] = arrn11[9] + 1;
                        }
                    }
                    bw.write(buffer[i]);
                }
                bw.write("}");
                bw.write(10);
                bw.write("\\vspace{.2cm}");
                bw.write(10);
                bw.write("\\begin{multicols}{2}");
                bw.write(10);
                bw.write("\\begin{framed}");
                bw.write(10);
                bw.write("\\begin{multicols}{2}");
                bw.write(10);
                bw.write("\\noindent");
                bw.write(10);
                int pageSum = 0;
                for (int i2 = 0; i2 < 10; ++i2) {
                    pageSum += pageDigits[i2] * squares[i2];
                    bw.write("\\texttt{" + i2 + "}: \\num{" + pageDigits[i2] + "}");
                    if (i2 < 9) {
                        bw.write("\\\\");
                    }
                    bw.write(10);
                }
                bw.write("\\end{multicols}");
                bw.write(10);
                bw.write("\\begin{flushright}$P_{" + page + "} = \\sum_{i=0}^9 a_i \\cdot i^2 = $ \\num{" + pageSum + "}\\end{flushright}");
                bw.write(10);
                bw.write("\\end{framed}");
                bw.write(10);
                bw.write("\\begin{framed}");
                bw.write(10);
                bw.write("\\begin{multicols}{2}");
                bw.write(10);
                bw.write("\\noindent");
                bw.write(10);
                int totalSum = 0;
                for (int i3 = 0; i3 < 10; ++i3) {
                    totalSum += totalDigits[i3] * squares[i3];
                    bw.write("\\texttt{" + i3 + "}: \\num{" + totalDigits[i3] + "}");
                    if (i3 < 9) {
                        bw.write("\\\\");
                    }
                    bw.write(10);
                }
                bw.write("\\end{multicols}");
                bw.write(10);
                bw.write("\\begin{flushright}$T_{" + page + "} = \\sum_{i=1}^{" + page + "} P_i = \\num{" + totalSum + "}$\\end{flushright}");
                bw.write(10);
                bw.write("\\end{framed}");
                bw.write(10);
                bw.write("\\end{multicols}");
                bw.write(10);
                ++page;
            }
            int totalSum = 0;
            for (i = 0; i < 10; ++i) {
                totalSum += totalDigits[i] * squares[i];
            }
            System.out.println("Number of pages: " + (page - 1));
            System.out.println("Total Sum: " + totalSum);
            ArrayList<Integer> sequence = new ArrayList<Integer>();
            sequence.add(totalSum);
            boolean isHappy = false;
            int nr = totalSum;
            do {
                if ((nr = HappyMersennePrime.squareOfDigits(nr)) == 1) {
                    isHappy = true;
                    break;
                }
                if (sequence.contains(nr)) {
                    sequence.add(nr);
                    break;
                }
                sequence.add(nr);
            } while (true);
            System.out.println("Is-Happy: " + isHappy);
            bw.write("\\end{document}");
            bw.flush();
            bw.close();
            File frontPageFile = new File("M" + exponent + "FP.tex");
            if (!frontPageFile.exists()) {
                frontPageFile.createNewFile();
            }
            FileWriter frontPageFileWriter = new FileWriter(frontPageFile.getAbsoluteFile());
            BufferedWriter frontPageBufferedWriter = new BufferedWriter(frontPageFileWriter);
            frontPageBufferedWriter.write("\\newcommand{\\tp}{" + (page - 1) + "}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\begin{titlepage}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\centering");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("{\\scshape\\LARGE Happy Mersenne Prime Project\\par}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\vspace{1.5cm}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("{\\huge\\bfseries M" + exponent + " is " + (!isHappy ? "not " : "") + "happy\\par}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\vspace{2cm}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("{\\Large M" + exponent);
            Iterator iterator = sequence.iterator();
            while (iterator.hasNext()) {
                frontPageBufferedWriter.write(" $\\Rightarrow$ " + iterator.next());
            }
            if (!isHappy) {
                frontPageBufferedWriter.write(" $\\Rightarrow$ \\ldots");
            }
            frontPageBufferedWriter.write("\\par}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\vspace{2cm}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("{\\Large\\itshape Adrian Suter\\par}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\vspace{1.5cm}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("{\\large \\today\\par}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\vspace{1.5cm}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("calculated by\\par");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("Adrian \\textsc{Suter}\\footnote{Mersenne prime number downloaded from " + sourceUrl + "}\\par");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("adrian@suter-wirz.ch\\par");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\vfill");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\begin{flushleft}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\textsc{Introduction}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("Each of the following pages contains \\num{" + bufferSize + "} digits (except page " + (page - 1) + ") of M" + exponent + " as well as a brief statistical summary of the number of occurence of the digits. The left frame holds the statistics for the current page, the right frame the totals up to the current page. To calculate the sum of the squares of the digits we will use the formula $P_{k} = \\sum_{i=0}^9 a_i \\cdot i^2$ where $k$ is the page number and $a_i$ is the number of occurence of digit $i$.");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\end{flushleft}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.write("\\end{titlepage}");
            frontPageBufferedWriter.write(10);
            frontPageBufferedWriter.flush();
            frontPageFileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(HappyMersennePrime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int squareOfDigits(int input) {
        int output = 0;
        String inputString = Integer.toString(input);
        for (int i = 0; i < inputString.length(); ++i) {
            output = (int) ((double) output + Math.pow(Integer.parseInt(inputString.substring(i, i + 1)), 2.0));
        }
        return output;
    }
}
