Adding JDK 25 to this project

This repository is a small Java demo. Below are concise steps to install JDK 25 and register it as an external SDK/JRE in common IDEs and build tools, plus verification commands.

1) Install JDK 25
- Download a JDK 25 build from a distributor (OpenJDK, Oracle, Azul, etc.).
- Install to a path such as: C:\Program Files\Java\jdk-25
- Set JAVA_HOME to that path and add %JAVA_HOME%\bin to PATH.
  - Windows (PowerShell):
    $Env:JAVA_HOME = 'C:\\Program Files\\Java\\jdk-25'
    $Env:PATH = $Env:JAVA_HOME + '\\bin;' + $Env:PATH

2) IntelliJ IDEA (add as Project SDK / External library)
- File > Project Structure... > Platform Settings > SDKs > + > JDK and select the JDK 25 installation folder.
- Project Settings > Project: set Project SDK to JDK 25 and Project language level to 25 or "SDK default".
- Modules > Dependencies: ensure Module SDK uses the new SDK.

3) Eclipse (add as Installed JRE)
- Window > Preferences > Java > Installed JREs > Add > Standard VM > Directory: point to JDK 25 folder.
- Project > Properties > Java Compiler: set "Compiler compliance level" to 25.

4) Maven
- In pom.xml set compiler properties or plugin release:
  <properties>
    <maven.compiler.source>25</maven.compiler.source>
    <maven.compiler.target>25</maven.compiler.target>
  </properties>
  OR
  <plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
      <release>25</release>
    </configuration>
  </plugin>

5) Gradle (Groovy)
- Use toolchain or compatibility:
  java {
    toolchain { languageVersion = JavaLanguageVersion.of(25) }
  }
  OR
  sourceCompatibility = '25'
  targetCompatibility = '25'

6) Verify installation and compile/run
- Open a PowerShell terminal and run:
  javac -version ; java -version
  javac src\\Main.java ; java -cp src Main

Notes
- If CI or other tools still use an older JDK, configure toolchains (Maven) or Gradle toolchain to ensure builds use JDK 25.
- Check licensing for specific JDK distributions.

