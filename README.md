# HSBC-Bank-Statement-PDF-to-Excel-Java
Java program that converts HSBC Bank Statement from PDF to Excel (in csv format). Only converts transaction information in table/ database like manner..

At the moment, there are no UI, or jar file, so you'd need a Intellij idea with jdk version 11 to import the project and run the program.

Steps to run the program:
1. Download PDFBox.jar
2. Run the program
3. In Source file path field, enter where your pdf is located in (using double backslash as a seperator `\\`) `C:\\yourfilepathhere.pdf`
4. Right click and make an empty txt file named output.txt in your file explorer somewhere and rename it to output.csv.
5. In Destination file path field, enter where your output.csv is located in (using double backslash as a seperator `\\`) `C:\\yourfilepathhere\\output.csvf`
6. Check the number of pages in your pdf that contains transaction information and enter. Your pdf may have 2 pages but transactions info may be in 1 page, so enter 1 in that case.
7. Click Generate
8. Check your output.csv file. 
