# Jsp / Servlet Starter Template
## Java version: OpenJDK 11 
- pom.xml 설정
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.jsp</groupId>
    <artifactId>jsp-starter</artifactId>
    <version>1.0-SNAPSHOT</version>


    <!-- embedded tomcat 설정 -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <tomcat.version>9.0.39</tomcat.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-core</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jasper</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jasper-el</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jsp-api</artifactId>
            <version>${tomcat.version}</version>
        </dependency>

        <!-- servlet api -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
        </dependency>
    </dependencies>

    <build>
        <finalName>embeddedTomcatSample</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.1</version>
                <configuration>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.jsp.JspStarterMain</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

        </plugins>
    </build>
</project>
```


====================================================================================
## vscode jsp template

- vscode 좌측 하단에 톱니바퀴 모양 클릭
- 사용자 코드 조각 클릭 후 html입력
- html.json 파일에 기존내용 전부 지우고 아래 코드 붙여넣고 저장
- .jsp 파일 생성 후 !jsp 입력 시 아래 템플릿 적용가능

```
{
   "JSP template": {
      "prefix": "!jsp",
      "body": [
         "<%@ page language=\\"java\\" contentType=\\"text/html; charset=UTF-8\\" pageEncoding=\\"UTF-8\\"%>",
         "<%@ taglib prefix=\\"c\\" uri=\\"<http://java.sun.com/jsp/jstl/core\\>" %>",
         "<!DOCTYPE html>",
         "<html>",
         "<head>",
         "<meta charset=\\"UTF-8\\">",
         "<title>Insert title here</title>",
         "</head>",
         "<body>",
         "</body>",
         "</html>",
      ],
      "description": "make jsp template"
   }
}
```


