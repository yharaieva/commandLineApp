The application reads objects from CSV files and writes them to MySQL.

You should build the project in command line in the directory of the project
 with command:
 
 
 mvn clean install
 
 
And execute in command line .jar file with 4 parametrs:
 - userFile - path to user.csv;
 - cityFile - path to city.csv;
 - countryFile - path to country.csv;
 - dbUrl - URL to MySQL DB.


Whole command:

java -jar target/nameOfJarFile.jar -userFile /path/to/file/user.csv -cityFile /path/to/file/city.csv -countryFile /path/to/file/country.csv -dbUrl jdbc:mysql://userName:password@localhost:3306/public

