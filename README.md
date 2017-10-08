**Simple Project Jsf PrimeFaces and Hibernate**
===================

### **Project ObjectsDataBaseLibrary**
<p>This project was created to implement the Javabeans and classes that handle processes with the database.
  Data modeling was designed using <b>UML</b> and <b>DER</b>, being implemented in this project. This implementation was
placed in the form of a Java library, to be reused in other test projects. The database used was the postgreSQL.</p>

------

### Installation

-----
This project was created using the <b>[IDE NetBeans 8.2](https://netbeans.org/)</b>. To import it follow the following steps:
1. Install the database server from the <b>postgreSQL</b> and the <b>pgAdmin (I used the version 4)</b>;
2. Create a database called <kbd>DBCRUDJsfPrimefacesHibernate</kbd> with username and password <kbd>postgres</kbd> and <kbd>rootnnnn</kbd> respectively;
3. Create a project Java Application, copy the file log4j.properties and the folder <kbd>com</kbd> to folder <kbd>src</kbd> from the project;
4. Add in the project the folder libraries <kbd>lib hibernate</kbd>;
5. Run the file <kbd>script_create.sql</kbd> to create the tables in the database;
6. The folder <kbd>test</kbd> contains the test files and can be used by adding it to the root folder of the created project. In addition, you will also need to include the library <b>JUnit</b>, the version used was the 4.12.

------

### **Project Jsf-PrimeFaces-Hibernate-simple-CRUD**
This project uses the frameworks <b>[JSF version 2.2](https://docs.oracle.com/cd/E13224_01/wlw/docs103/guide/webapplications/jsf/jsf-app-tutorial/Introduction.html)</b>, <b>[PrimeFaces version 5.0](https://www.primefaces.org/)</b> and <b>[Hibernate 4.2.21 (version of the file core) ](http://hibernate.org/)</b>. It contains the files ManagedBeans and pages .xhtml.
<p>The project is incomplete and presents only two research screens, however there is some complexity in the overall scope of the project. This project was developed only to place
in practice the tools cited at the learning level. The project will not work on older browsers such as IE 8.0.</p>
<p> The project also offers two languages: <b>English</b> and <b>Brazilian Portuguese</b>. To test this feature, change the language of your browser. On the Firefox 55.0.3, this option is in the path <kbd>Options -> Content</kbd>.</p>

-----

### Installation

-----
This project was created using the <b>[IDE NetBeans 8.2](https://netbeans.org/)</b>. To import it follow the following steps:
1. Create a project Java Web, use the server preferably <b>[GlassFish](https://javaee.github.io/glassfish/download)</b> or <b>[Jboss as 7](http://jbossas.jboss.org/downloads)</b> and enable the frameworks <b>Java Server Faces (version 2.2)</b> and <b>PrimeFaces (version 5.0)</b>;
2. Add folder <kbd>src/java/com</kbd> in the folder <kbd>src/java</kbd> from the project;
3. Run a Clean and Build on the project [ObjectsDataBaseLibrary](#projeto-objectsdatabaselibrary) and add the .jar design in the project libraries java web created;
4. Replace the folder <kbd>web</kbd> the project created by the <kbd>web</kbd> of this project.
<b>Note:</b> verify that there is only one file web.xml;
5. Add in the project the folder libraries <kbd>lib hibernate</kbd>;
6. Create an Employee and link it to a User to be created too (The script <kbd>insert_usuario.sql</kbd> perform this step);
7. Clean and Build the project and run the same;
8. Enter the username and password of the created User.

----

### **System Images**

----

|  Main screen  | 
 ----------------- | 
| <img src="/imagens/Tela_Principal.jpg" width="900" height="300" /> |  

|  Main screen (Menubar)  | 
| -------------------------- | 
| <img src="/imagens/Tela_Principal_MenuBar.jpg" width="900" height="300" /> |

| Employee Search | 
| ----------------- | 
| <img src="/imagens/Pesquisa_Funcionario.jpg" width="900" height="300" /> |

| Login | Employee Registration  |
| ----------------- | ------------------------ |
| <img src="/imagens/Login.jpg" width="450" height="300" /> | <img src="/imagens/Cadastro_Funcionario.jpg" width="450" height="300" /> |