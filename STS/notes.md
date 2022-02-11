# Setting up a Spring project
[Copy Paste](#copy-paste)
1. New-> Spring Starter Project
   - part1:
      - name: all lowercase, can have hyphens "-" ex: my-project
        - this is projectname
      - Type: Maven Project
      - Packaging: War
      - Java Version: 8
      - Language: Java
      - Group: com.something.projectname
      - artifact: projectname
      - version:leave default
      - description: give a description
      - package: same as group
    - part2 (dependencies):
      - Spring Web
      - Spring Boot DevTools (to auto restart server on save)
2. Set up Dependencies
   - pom.xml in root directory
   - Dependencies to add: [Dependencies](#dependencies)
     - jstl (javax.servlet)
     - tamcat-embed-jasper
     - bootstrap related (see bottom)
3. Set up for jsp templates
    - Create ```WEB-INF``` folder under ```src/main/webapp```
    - In ```application.properties``` [paste](#jsp)
    - Create any .jsp files under ```WEB-INF```
4. Set up static files (js and css)
    - create ```js``` and ```css``` folders under ```src/main/resources/static```
5. Controller & Routing
   - create ```controllers``` package under ```src/main/java```
     - ex: ```com.example.projectname.controllers```
   - create java class in ```controllers```
     - ex: `ControllerXYZ.java`
   - [Sample Controller Formatting](#controllers)
6. 




# Copy Paste
## Dependencies
   - put in pom.xml under ```<dependencies>```
   - for java functionality in HTML
     ``` xml
     <dependency>
     	<groupId>org.apache.tomcat.embed</groupId>
     	<artifactId>tomcat-embed-jasper</artifactId>
     </dependency>
     <dependency>
     	<groupId>javax.servlet</groupId>
     	<artifactId>jstl</artifactId>
     </dependency>
     ```
   - for bootstrap
     ``` xml
     <!-- webjars locator dependency enables auto-detection of the version, so your .jsp 
     file links are version-agnostic in case you update the versions here in your pom later -->
     <dependency>
       	<groupId>org.webjars</groupId>
       	<artifactId>webjars-locator</artifactId>
       	<version>0.30</version>
     </dependency>
     <!-- BOOTSTRAP DEPENDENCIES -->
     <dependency>
     	<groupId>org.webjars</groupId>
     	<artifactId>bootstrap</artifactId>
     	<version>5.0.1</version>
     </dependency>
     <dependency>
     	<groupId>org.webjars</groupId>
     	<artifactId>jquery</artifactId>
     	<version>3.6.0</version>
     </dependency>
     ```

## JSP
  - in ```application.properties``` under ```src/main/resources```
     ```
     spring.mvc.view.prefix=/WEB-INF/
     ```
   - Sample .jsp file:
     - local css and js files live under ```src/main/resources/static/css``` and ```src/main/resources/static/js```
       - the source calls start from ```src/main/resources/static/```
     - Bootstrap related functionality requires setting up dependencies
     ```html
     <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <!DOCTYPE html>
     <html>
     <head>
     <meta charset="ISO-8859-1">
     <title>Hello World</title>
     <!-- for Bootstrap CSS -->
     <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
     <!-- for internal CSS -->
     <link rel="stylesheet" href="/css/style.css" />
     </head>
     <body>
     <div class="container pt-5">
        <h1>Hello World</h1>
     </div>

     <!-- For any Bootstrap that uses JS or jQuery-->
     <script src="/webjars/jquery/jquery.min.js"></script>
     <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
     <!-- internal script -->
     <script type="text/javascript" src="/js/script.js"></script>
     </body>
     </html>
     ```

## Controllers
   - `@RestController` annotation will only process text or JSON outputs as return, can have simple html tags
     - ex for returning HTML tag: `return "<h1> this will be an h1 </h1>";`
      ```java
      // all routes of name ROUTENAME under this controller will start with route of /api/ROUTNAME
      // the first method goes to /api
      @RestController
      @RequestMapping("/apis")
      public class ControllerText {
          @RequestMapping("")
          public String Welcome() {
              return "welcome";
          }
      }
      ```
   - `@Controller` mapping will process JSP (Java Server Pages) files
     - .jsp files live under ```WEB-INF```
      ```java
      // all routes of name ROUTENAME under this controller will start with route of /api/ROUTNAME
      // the first method goes to /api
      @Controller
      @RequestMapping("/apis") 
      public class ControllerText {
          @RequestMapping("") 
          public String Welcome() {
              return "index.jsp";
          }
      }
      ```
   - 3 Ways of getting mapping (different annotations)
     - RequestMapping (default is GET)
     - RequestMapping, explicit definition of method
     - GetMapping
     ```java
     // Get mapping option 1
     // route: /api/today
     @RequestMapping("/today") 
     public String todayFortune() {
       return "Today you will find luck in all your endeavors!";
     }

     // Get mapping option 2
     @RequestMapping(value="/requestOptionGet", method=RequestMethod.GET)
     public String requestOptionGet() {
       return "This is option 2 for get mapping";
     }

     // Get mapping option 3
     @GetMapping("/getMapping")
     public String getMapping() {
       return "This using the get Mapping annotation";
     }
     ```
   - Request Parameters
     - has question mark in the route
     - by default, RequestParam has required=true
       - need to explicitly set to false if the field is optional
     ```java
     // Request Parameters
     // route: /api/params?name=Mickey&last_name=Mouse
     @RequestMapping("/params") 
     public String index(
         @RequestParam(value="name", required=false) String name, 
         @RequestParam(value="last_name", required=false) String last_name, ) {
         return "Hello " + name + " " + last_name;
     }
     ```
   - Path Variables
     - only has slashes
     - name in {pathName} must match `@Pathvariable("pathName")` 
     - name in `String varName` is the name used inside the method
     ```java
     // Path variables
     // route: /api/travel/Hawaii, where Hawaii is a variable name
     // datatype of parameter can be String, Integer, etc
     @RequestMapping("/travel/{location}") 
     public String travelTo(@PathVariable("location") String location) { 
         return "Congratulations! You will soon travel to " + location + "!";
     }
     ```