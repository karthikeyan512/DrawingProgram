Assumptions:
(i) There is no upper size limit set for the Canvas.
(ii) Added Help command 'H' to provide commands syntax.
This command will also be triggered automatically when user makes any syntax error.

1. To run the program directly:
(i) Program is already built as jar file and placed in bin dir.
(ii) To run the pre-built jar, open command prompt in "bin" dir. Then run the following command.
    If Java 8 is configured in environment variables, then
        java -jar DrawingProgram.jar
    Else use full Java path.
        <<Path to Java 8 bin directory>>\java -jar DrawingProgram.jar

2. To build and run using maven:
(i) Run the following maven command.
    mvn clean compile assembly:single
(ii) Once the build is successful, run the following command in target directory.
    java -jar target\DrawingProgram-1.0-SNAPSHOT-jar-with-dependencies.jar

3. To review the code, the project can be imported into any IDE as Maven project.