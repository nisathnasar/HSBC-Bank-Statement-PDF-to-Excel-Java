# HSBC-Bank-Statement-PDF-to-Excel-Java
Java program that converts HSBC Bank Statement from PDF to Excel (in csv format). Only converts transaction information in table/ database like manner..

At the moment, there are no UI, or jar file, so you'd need a Intellij idea with jdk version 11 to import the project and run the program.

Steps to run the program:
1. Go to src>main>java>org.example>Launcher.java
2. Add your file path to the pdf 
`String readFilePath = "C:\\yourfilepathhere.pdf";`
3. check the number of pages in your pdf that contains transaction information and put it in after `=`
`int numbOfPagesToExtractFrom = ;`
4. Make a new .txt file in any location and change .txt to .csv
5. Add path to that file on
`FileWriter fw = new FileWriter("C:\\yourpath.csv");`
6. Run the program
