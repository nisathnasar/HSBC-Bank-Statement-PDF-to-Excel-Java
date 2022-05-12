package org.example;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws IOException {

        PDFtoCSV pdftocsv = new PDFtoCSV();
        int numOfPagesToExtractFrom = 3;
        String readFilePath = "C:\\Users\\ASUS\\Documents\\bank statement output\\2021-08-26_Statement.pdf";
        File oldFile = new File(readFilePath);
        PDDocument document = PDDocument.load(oldFile);
        Splitter splitter = new Splitter();
        List<PDDocument> splitPages = splitter.split(document);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(splitPages.get(0));
        String[] lines = text.split("\\r?\\n");
        List<String> rows = pdftocsv.synthesiseList(lines);


        // Remove the first irrelevant lines
        for(int i=30; i > 1; i-- ){
            rows.remove(rows.remove(rows.size()-1));
        }

        // Remove the last useless lines
        for(int i=2; i > -1; i--){
            rows.remove(i);
        }

        rows = pdftocsv.processLines(rows);
        pdftocsv.printList(rows);

        FileWriter fw = new FileWriter("C:\\Users\\ASUS\\Documents\\bank statement output\\output.csv");

        //write header
        fw.write("Date, Type, Details, Pay Out, Pay In, Balance\n");

        //write to file
        for(String str : rows){
            fw.write(str+"\n");
        }

        //Page 2

        if(numOfPagesToExtractFrom>1){
            String text2 = stripper.getText(splitPages.get(1));
            String[] lines2 = text2.split("\\r?\\n");
            List<String> rows2 = pdftocsv.synthesiseList(lines2);

            /**
             * Remove the last irrelevant lines
             */
            for(int i=16; i > 1; i-- ){
                rows2.remove(rows2.remove(rows2.size()-1));
            }
            /**
             * Remove the first useless lines
             */
            for(int i=1; i > -1; i--){
                rows2.remove(i);
            }

            pdftocsv.processLines(rows2);
            pdftocsv.printList(rows2);

            //write to file
            for(String str : rows2){
                fw.write(str+"\n");
            }
        }

        //Page 3

        if(numOfPagesToExtractFrom>2){
            String text3 = stripper.getText(splitPages.get(2));
            String[] lines3 = text3.split("\\r?\\n");
            List<String> rows3 = pdftocsv.synthesiseList(lines3);

            /**
             * Remove the last irrelevant lines
             */
            for(int i=16; i > 1; i-- ){
                rows3.remove(rows3.remove(rows3.size()-1));
            }
            /**
             * Remove the first useless lines
             */
            for(int i=1; i > -1; i--){
                rows3.remove(i);
            }

            pdftocsv.processLines(rows3);
            pdftocsv.printList(rows3);

            //write to file
            for(String str : rows3){
                fw.write(str+"\n");
            }
        }

        //Page 3

        if(numOfPagesToExtractFrom>3){
            String text3 = stripper.getText(splitPages.get(3));
            String[] lines3 = text3.split("\\r?\\n");
            List<String> rows3 = pdftocsv.synthesiseList(lines3);

            /**
             * Remove the last irrelevant lines
             */
            for(int i=16; i > 1; i-- ){
                rows3.remove(rows3.remove(rows3.size()-1));
            }
            /**
             * Remove the first useless lines
             */
            for(int i=1; i > -1; i--){
                rows3.remove(i);
            }

            pdftocsv.processLines(rows3);
            pdftocsv.printList(rows3);

            //write to file
            for(String str : rows3){
                fw.write(str+"\n");
            }
        }

        document.close();
        fw.close();

        System.out.println(
        pdftocsv.endsWith1MoneyValue("27-Aug-21, CR, M Sirajudeen Sirajudeen 66.50 881.14"));

    }
}
