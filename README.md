

Practical task №7

_______________________

The task is defined as follows.  

1. Create an XML file (input.xml) and a corresponding XSD schema (input.xsd).  

2. When developing XSD, you are required to use: 

simple and compound types, enumerations, templates, and limit values.  

3. Create a Java class corresponding to this description.  

4. Create a Java application (name it ‘Main’) for parsing the XML document and initialization of the container of objects with information from the XML file. 

For parsing, use: SAX, StAX parsers, as well as the DOM analyzer (all three options).

5. Define methods that will sort container objects using the Comparator interface by some parameter or set of parameters 

(three parsers => three sorting options => three methods). 

6. Validate XML document against XSD (using a validating parser or validation API).

7. Define a method for saving information to the XML document from the container.

8. Demonstrate the operation of the application: 

a) read the XML document using each parser; 

b) receive the container of objects; 

c) sort the objects in the container (using one of three sorting options); 

d) save the sorted container to the XML document (to the file).

9. The application input data is the names of the two files: 

the XML document and the XSD document;

the output data is three XML files.

Set input file names with the command line parameters (two parameters or one, if the validation will occur against the scheme, defined inside the XML document).  

10. To demonstrate the operation of the application, create Demo class, that calls the Main.main method of your application with the appropriate parameters of the command line:


Demo.java

———————————————————————-

package com.epam.rd.java.basic.practice7;

 /**

  * Demo class to run project WO command line.

  */ 

class Demo {

     public static void main(String[] args) throws Exception {

         Main.main(new String[] { "input.xml" });

     }

 }

———————————————————————-

11. Top-level classes and non-trivial methods should be documented.  

12. Optional. Create an XSL document that converts an XML document into an HTML document.

_______________________

Naming convention

Name the root element of the XML document according to the name of the task or based on the fact that this is a container of elements of the same type whose name is specified in the task.

Example: if the task is called Testing, and the element is named Test, then the root element can be called either Testing or Tests.

Input and output files should have the following names.

Input files:

———————————————————————-

input.xml - An XML document, valid against input.xsd 

input.xsd - XSD document, schema for input.xml

———————————————————————-

Output files (the result)

———————————————————————-

output.dom.xml - the result of the DOM analyzer work and subsequent

sorting using one of the three sorting options. 

output.sax.xml - the result of the SAX parser work and subsequent sorting using one of the three sorting options. 

output.stax.xml - the result of the StAX parser work after sorting using one of the three sorting options. 

———————————————————————-

Note.

1. input.xsd should declare the target namespace (the targetNamespace attribute should be present). 

2. input.xml should be valid against input.xsd 

3. XML output documents output.dom.xml, output.sax.xml and output.stax.xml should be valid against the source XML schema input.xsd, if the declaration of the target namespace is excluded from it (see file input-no-targetNamespace.xsd in the sample project).  

(Note: XML output documents are not required to declare the noNamespaceSchemaLocation attribute)
