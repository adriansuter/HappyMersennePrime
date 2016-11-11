package hmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public class HappyMersennePrime {

    public static void main(String[] args) {
        int exponent = 57885161;
        String author = "Adrian Suter";
        String sourceUrl = "http://lcn2.github.io/mersenne-english-name/m57885161/huge-prime-c-e.html.gz";

        try {
            int i;
            int nrCharsRead;
            int lineLength = 97;
            int bufferSize = lineLength * 48;
            char[] buffer = new char[bufferSize];
            int page = 1;
            int[] squares = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
            int[] totalDigits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            FileInputStream mersenneFileInputStream = new FileInputStream(new File("mersennePrimes\\M" + exponent + ".txt.gz"));
            GZIPInputStream mersenneInputStream = new GZIPInputStream(mersenneFileInputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(mersenneInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("mersennePrimes\\M" + exponent + ".txt"));

            // Create the main tex-file.
            File file = new File("M" + exponent + ".tex");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Get a buffered writer to write into the main tex-file.
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write the tex-header.
            bw.write("\\documentclass{article}\n");
            bw.write("\\usepackage{geometry}\n");
            bw.write("\\geometry{a4paper, portrait, left=1.5cm, right=1.5cm, top=2.5cm, bottom=2cm}\n");
            bw.write("\\usepackage{fancyhdr}\n");
            bw.write("\\usepackage{multicol}\n");
            bw.write("\\usepackage{framed}\n");
            bw.write("\\usepackage{siunitx}\n");
            bw.write("\\sisetup{group-separator = \\text{\\,}}\n");
            bw.write("\\sisetup{group-minimum-digits = 3}\n");

            // Write the tex-document.
            bw.write("\\begin{document}\n");

            // Note: The file we instruct tex to include at this stage would be
            //       created afterwards.
            bw.write("\\include{M" + exponent + "FP}\n");

            while (-1 != (nrCharsRead = bufferedReader.read(buffer))) {
                int[] pageDigits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                if (page > 1) {
                    bw.write("\\newpage\n");
                }
                bw.write("\\pagestyle{fancy}\n");
                bw.write("\\fancyhf{}\n");
                bw.write("\\fancyhead[L]{M" + exponent + "}\n");
                bw.write("\\fancyhead[C]{}\n");
                bw.write("\\fancyhead[R]{Digits: \\num{" + ((page - 1) * bufferSize + 1) + "} -- \\num{" + ((page - 1) * bufferSize + nrCharsRead) + "}}\n");
                bw.write("\\fancyfoot[C]{" + page + " / \\tp}\n");
                bw.write("\\noindent\n");
                bw.write("\\texttt{");
                for (i = 0; i < nrCharsRead; ++i) {
                    if (i % lineLength == 0 && i > 0) {
                        bw.write("} \\\\\n\\texttt{");
                    }
                    switch (buffer[i]) {
                        case '0':
                            pageDigits[0]++;
                            totalDigits[0]++;
                            break;

                        case '1':
                            pageDigits[1]++;
                            totalDigits[1]++;
                            break;

                        case '2':
                            pageDigits[2]++;
                            totalDigits[2]++;
                            break;

                        case '3':
                            pageDigits[3]++;
                            totalDigits[3]++;
                            break;

                        case '4':
                            pageDigits[4]++;
                            totalDigits[4]++;
                            break;

                        case '5':
                            pageDigits[5]++;
                            totalDigits[5]++;
                            break;

                        case '6':
                            pageDigits[6]++;
                            totalDigits[6]++;
                            break;

                        case '7':
                            pageDigits[7]++;
                            totalDigits[7]++;
                            break;

                        case '8':
                            pageDigits[8]++;
                            totalDigits[8]++;
                            break;

                        case '9':
                            pageDigits[9]++;
                            totalDigits[9]++;
                            break;

                        default:
                            System.err.println("Unknown digit found: '" + buffer[i] + "'.");
                            bw.write("?");
                            continue;
                    }
                    bw.write(buffer[i]);
                }
                bw.write("}\n");
                bw.write("\\vspace{.2cm}\n");
                bw.write("\\begin{multicols}{2}\n");
                bw.write("\\begin{framed}\n");
                bw.write("\\begin{multicols}{2}\n");
                bw.write("\\noindent\n");
                bw.write(10);
                int pageSum = 0;
                for (int i2 = 0; i2 < 10; ++i2) {
                    pageSum += pageDigits[i2] * squares[i2];
                    bw.write("\\texttt{" + i2 + "}: \\num{" + pageDigits[i2] + "}");
                    if (i2 < 9) {
                        bw.write("\\\\");
                    }
                    bw.write("\n");
                }
                bw.write("\\end{multicols}\n");
                bw.write("\\begin{flushright}$P_{" + page + "} = \\sum_{i=0}^9 a_i \\cdot i^2 = $ \\num{" + pageSum + "}\\end{flushright}\n");
                bw.write("\\end{framed}\n");
                bw.write("\\begin{framed}\n");
                bw.write("\\begin{multicols}{2}\n");
                bw.write("\\noindent\n");
                bw.write(10);
                int totalSum = 0;
                for (int i3 = 0; i3 < 10; ++i3) {
                    totalSum += totalDigits[i3] * squares[i3];
                    bw.write("\\texttt{" + i3 + "}: \\num{" + totalDigits[i3] + "}");
                    if (i3 < 9) {
                        bw.write("\\\\");
                    }
                    bw.write("\n");
                }
                bw.write("\\end{multicols}\n");
                bw.write("\\begin{flushright}$T_{" + page + "} = \\sum_{i=1}^{" + page + "} P_i = \\num{" + totalSum + "}$\\end{flushright}\n");
                bw.write("\\end{framed}\n");
                bw.write("\\end{multicols}\n");
                ++page;
            }

            // Calculate the total sum.
            int totalSum = 0;
            for (i = 0; i < 10; ++i) {
                totalSum += totalDigits[i] * squares[i];
            }

            System.out.println("Total number of pages: " + (page - 1));
            System.out.println("Total Sum: " + totalSum);

            // Build the happy number sequence.
            ArrayList<Integer> sequence = new ArrayList<>();
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

            System.out.println("M" + exponent + " is " + (isHappy ? "" : "NOT ") + "happy!");
            if (isHappy) {
                System.out.println(":) :) :) :) :) :) :) :) :) :)");
            }
            bw.write("\\end{document}");
            bw.flush();
            bw.close();

            // Create the to-be-included tex-file.
            File frontPageFile = new File("M" + exponent + "FP.tex");
            if (!frontPageFile.exists()) {
                frontPageFile.createNewFile();
            }

            // Get a buffered writer to write into the to-be-included tex-file.
            FileWriter frontPageFileWriter = new FileWriter(frontPageFile.getAbsoluteFile());
            BufferedWriter frontPageBufferedWriter = new BufferedWriter(frontPageFileWriter);
            frontPageBufferedWriter.write("\\newcommand{\\tp}{" + (page - 1) + "}\n");
            frontPageBufferedWriter.write("\\begin{titlepage}\n");
            frontPageBufferedWriter.write("\\centering\n");
            frontPageBufferedWriter.write("{\\scshape\\LARGE Happy Mersenne Prime Project\\par}\n");
            frontPageBufferedWriter.write("\\vspace{1.5cm}\n");
            frontPageBufferedWriter.write("{\\huge\\bfseries M" + exponent + " is " + (!isHappy ? "not " : "") + "happy\\par}\n");
            frontPageBufferedWriter.write("\\vspace{2cm}\n");
            frontPageBufferedWriter.write("{\\Large M" + exponent);
            Iterator iterator = sequence.iterator();
            while (iterator.hasNext()) {
                frontPageBufferedWriter.write(" $\\Rightarrow$ \\num{" + iterator.next() + "}");
            }
            if (!isHappy) {
                frontPageBufferedWriter.write(" $\\Rightarrow$ \\ldots");
            }
            frontPageBufferedWriter.write("\\par}\n");
            frontPageBufferedWriter.write("\\vspace{2cm}\n");
            frontPageBufferedWriter.write("{\\Large\\itshape " + author + "\\par}\n");
            frontPageBufferedWriter.write("\\vspace{1.5cm}\n");
            frontPageBufferedWriter.write("{\\large \\today\\par}\n");
            frontPageBufferedWriter.write("\\vspace{1.5cm}\n");
            frontPageBufferedWriter.write("generated and calculated by\\par\n");
            frontPageBufferedWriter.write("https://github.com/adriansuter/HappyMersennePrime\\footnote{Mersenne prime number downloaded from " + sourceUrl + "}\\par\n");
            frontPageBufferedWriter.write("\\vfill\n");
            frontPageBufferedWriter.write("\\begin{flushleft}\n");
            frontPageBufferedWriter.write("\\textsc{Introduction}\n\n");
            frontPageBufferedWriter.write("Each of the following pages contains \\num{" + bufferSize + "} digits (except page " + (page - 1) + ") of M" + exponent + " as well as a brief statistical summary of the number of occurence of the digits. The left frame holds the statistics for the current page, the right frame the totals up to the current page. To calculate the sum of the squares of the digits we will use the formula $P_{k} = \\sum_{i=0}^9 a_i \\cdot i^2$ where $k$ is the page number and $a_i$ is the number of occurence of digit $i$.\n");
            frontPageBufferedWriter.write("\\end{flushleft}\n");
            frontPageBufferedWriter.write("\\end{titlepage}\n");
            frontPageBufferedWriter.flush();
            frontPageFileWriter.close();

            // Close the mersenne prime number reader streams.
            bufferedReader.close();
            inputStreamReader.close();
            mersenneInputStream.close();
            mersenneFileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(HappyMersennePrime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Calculates the sum of the squares of the digits for a given integer.
     *
     * @param input
     * @return
     */
    public static int squareOfDigits(int input) {
        int output = 0;
        String inputString = Integer.toString(input);
        for (int i = 0; i < inputString.length(); ++i) {
            output = (int) ((double) output + Math.pow(Integer.parseInt(inputString.substring(i, i + 1)), 2.0));
        }
        return output;
    }
}
