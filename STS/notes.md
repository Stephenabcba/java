# Setting up a Spring project
[Copy Paste](#copy-paste)
1. New-> Spring Starter Project
   - Part1:
      - Name: all lowercase, can have hyphens "-" ex: `my-project`
        - this is projectname
      - Type: `Maven Project`
      - Packaging: `War`
      - Java Version: `8`
      - Language: `Java`
      - Group: `com.something.projectname`
      - Artifact: `projectname`
      - Version: leave default
      - Description: give a description
      - Package: same as Group, `com.something.projectname`
    - Part2 (dependencies):
      - `Spring Web`
      - `Spring Boot DevTools` (to auto restart server on save)
2. Set up Dependencies
   - Put dependencies inside `pom.xml` in root directory
   - [Dependencies](#dependencies) to add: 
     - `jstl` (javax.servlet)
     - `tamcat-embed-jasper`
     - Bootstrap related (see [dependencies](#dependencies))
3. Set up for jsp templates
    - Create `WEB-INF` folder under `src/main/webapp`
    - [Paste this line](#jsp) in `application.properties` 
    - Create all .jsp files under `WEB-INF`
4. Set up static files (js and css)
    - Create `js` and `css` folders under `src/main/resources/static`
5. Controller & Routing
   - Create `controllers` package under `src/main/java`
     - ex: `com.example.projectname.controllers`
   - Create controller java class in `controllers`
     - ex: `ControllerXYZ.java`
   - [Sample Controller Formatting](#controllers)
6. Models
   - Create `models` package under `src/main/java`
     - ex: `com.example.projectname.models`
   - Models may or may not be related to an item in database
7. JSP MAGIC
   - [Using JSTL](#jsp-magic)
   - [Using java in jsp](#jsp-magic-2)




# Copy Paste
## Dependencies
   - put under `<dependencies>` in `pom.xml`
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
  - in `application.properties` under `src/main/resources`
     ```
     spring.mvc.view.prefix=/WEB-INF/
     ```
   - Sample .jsp file:
     - put local css and js files in `src/main/resources/static/css` and `src/main/resources/static/js`
       - the source calls start from `src/main/resources/static/`
         - ex: `href="/css/style.css"`
     - Bootstrap related functionality requires setting up dependencies
     ```html
     <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <!DOCTYPE html>
     <html lang="en">
     <head>
         <meta charset="UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
   - When missing import statements, use `Ctrl + Shift + o` to import all missing packages
     - we usually use `java.util.Date` for Date package (instead of the sql variant)
     - o as in oranges
     - for macOS: `Command + Shift + o`
   - `@RequestMapping("/apis")` on top of class is optional
     - having this annotation will append /api/ to all mapping/routes in this class
     - all route examples in this section assume the request mapping is added
   - `@RestController` annotation will only process text or JSON outputs as return
     - this means the page will display plain text instead of an entire html page
     - can have simple html tags
       - ex: `return "<h1> this will be an h1 </h1>";`
      ```java
      // all routes of name ROUTENAME under this controller will start with route of /api/ROUTNAME
      // the first method goes to /api
      @RestController
      @RequestMapping("/apis")
      public class ControllerText {
          @RequestMapping("")
          public String Welcome() {
              return "Welcome";
          }
      }
      ```
   - `@Controller` annotation will process JSP (Java Server Pages) files
     - .jsp files live under `WEB-INF`
     - in this case, index.jsp must exist
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
     - `RequestMapping` (default is GET)
     - `RequestMapping`, explicit definition of method
     - `GetMapping`
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
     - has question mark `?` in the route
     - by default, RequestParam has `required=true`
       - need to explicitly set `required=false` if the field is optional
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
     - name of `String varName` is the variable name used inside the method
     ```java
     // Path variables
     // route: /api/travel/Hawaii, where Hawaii is a variable name
     // datatype of parameter can be String, Integer, etc
     @RequestMapping("/travel/{location}") 
     public String travelTo(@PathVariable("location") String location) { 
         return "Congratulations! You will soon travel to " + location + "!";
     }
     ```

## JSP magic
   - AKA JSTL
   - done in HTML
   - forEach loop:
     - people is the array in this example
     - person is the variable that we set as the current item in the array
       - we could rename person to banana and this will still work
     - name (or person.name) is a member variable of the Object named person
       - name could be a private member variable
         - JSTL will use our getters and setters to get value of variable
           - THIS MEANS WE MUST MAKE OUR GETTER & SETTER METHODS
     ```HTML
     <c:forEach var="person" items="${people}">
         <c:out value="${person.name}"/>
     </c:forEach>
     ```

## JSP magic 2
  - Running java code in jsp files
  - for loop:
     ```html
     <% for(int i = 0; i < 5; i++) { %>
             <h1><%= i %></h1>
     <% } %>
     ```
   - running javacode with imports
     - in this example, we import Date and get current time in the body
       - we added `import="java.util.Date"` to top of the page
     ```html
     <!-- top of page -->
     <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date"%>

     <!-- within body -->
     <p>The time is: <%= new Date() %></p>
     ```
