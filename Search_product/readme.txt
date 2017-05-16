Manual for start

WAR file
1. mvn package (if WAR file is absent)
2. put WAR file in Tomcat 8/webapps folder

For convenience I use embed db H2 thus all initialization data base will be automatically when srarted TomCat 8  (create, insert and create EntityManagerFactory through ServletContextListener)