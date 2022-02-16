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
      - Database related dependencies
       - `JPA` (Java Persistence API) (Spring Boot Spring Data JPA Starter)
       - `MySQL` (Java Mysql Connector)
2. Set up Dependencies
   - Put dependencies inside `pom.xml` in root directory
   - [Dependencies](#dependencies) to add: 
     - `jstl` (javax.servlet)
     - `tamcat-embed-jasper`
     - Bootstrap related (see [dependencies](#dependencies))
     - Database related dependencies (if not done when making the project)
       - `JPA` (Java Persistence API) (Spring Boot Spring Data JPA Starter)
       - `MySQL` (Java Mysql Connector)
     - `spring-boot-starter-validations`
3. Set up for jsp templates
    - Create `WEB-INF` folder under `src/main/webapp`
    - [Paste this line](#jsp) in `application.properties` 
    - Create all .jsp files under `WEB-INF`
    - Sample .jsp file under [JSP](#jsp)
4. Set up static files (js and css)
    - Create `js` and `css` folders under `src/main/resources/static`
5. Controller & Routing
   - Create `controllers` package under `src/main/java`
     - ex: `com.example.projectname.controllers`
   - Create controller java class in `controllers` package
     - ex: `ControllerXYZ.java`
   - [Sample Controller Formatting](#controllers)
6. Models (**different** from `Model model` when passing data to .jsp files)
   - Create `models` package under `src/main/java`
     - ex: `com.example.projectname.models`
   - Create model java class in `models` package
     - ex: `ModelXYZ.java`
   - Models may or may not be related to an item in database
7. JSP MAGIC
   - [Using JSTL](#jsp-magic)
   - [Using java in .jsp files](#jsp-magic-2)
8. Passing Variables into .jsp Files
   - Use `Model model`, data added in [controller](#model_model)
   - `.jsp` file can handle the data using [JSTL](#jsp-magic)
9.  Session
    - Store data that **persists** through pages
    - Data in session stored as `Object` data type
    - See code [here](#session)
11. Forms (GET / POST method)
    - if a form is sent using a GET method, the form is sent through query params
      - could be good for a seach bar
      - many problems if used for login, including security and unwanted behavior
    - To use POST method, the form in jsp must have `method="post"`
    - How the controller should handle [this](#post_form)
      - The form is still received using query parameters
    - **NEVER** return a page on a POST method
      - the form gets processed again
      - redirect to a GET method instead
    - General form procedures
      1. Render the form (get request with form)
      2. Process the form (post request with redirect)
      3. Show the form (get request, redirected from #2)
12. Flash Data 
    - Only persists for **one** HTML request
    - Is a type of session data
    - Useful for *error messages* and *notifications*
    - Flash messages added in [controller](#flash)
    - The .jsp files handle flash messages using [JSTL](#jsp-magic)
13. We don't need to instantiate Model model, HttpSession session, etc explicitly
    - Inversion of Control (IoC)
      - inverted pattern from usual control flow
    - IoC container finds the dependencies and instantiates them as needed
      - handles Dependency Injection for us
14. Database Functionalities (see [Database](#database))
    - Persistence Layer (PL): manages application's data (DB interactions)
      - includes domain models and repositories
      - communication done with Object Relational Mapper (ORM)
    - Service Layer (SL): handles business logic
      - communicates with controllers and the persistence layer
    - 3 Parts:
      1. Domain model (details [here](#domain_model))
         - Lives in `com.example.projectname.models`
         - Provides models of our database tables
           - attributes are the columns of tables
      2. Data Repository (details [here](#repository))
         - Lives in `com.example.projectname.repositories`
         - Provides SQL queries in the form of method signatures
      3. Services
         - Lives in `com.example.projectname.services`
         - Business logic of our application
    - Utilizing our database functionality in the [controller api](#db_controller_api)
      - logic here is similar to our controllers before db implementation
    - We can also integrate our database functionalities into [normal webpages](#db_controller_render)

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
   - for database connection
      ``` xml
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <scope>runtime</scope>
      </dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>
      ```
   - data validation
      ```xml
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
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
   - `@Controller` annotation will process JSP (Java Server Pages) files in return statements
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
   - <a name="model_model">Model model</a>
     - Passing data to the jsp template
     - stored in key-value pairs
     - Can hold different types of data
      ``` Java
      @RequestMapping("/")
      public String user(Model model) {
          String strData = "This is a string data";
          Integer intData = 42;
          model.addAttribute("strData",strData);
          model.addAttribute("intData",intData);
          return "index.jsp";
      }
      ```
   - <a name="session">Session</a>
     - Data in session is stored as `Object` type
     - store data using `setAttribute`
       - can also be used to update data in session
     - Session data is accessible in .jsp files directly
       - Variable must exist in session
       - you do not even need to dependency inject in the controller
      ``` java
      public String page(HttpSession session) {
        session.setAttribute("count", 0);
        return "index.jsp";
      }
      ```
     - get data using `getAttribute`
       - if we want to store it as an integer, we will need to cast it from object
     ``` java
     public String showCount(HttpSession session, Model model) {
         Integer currentCount = (Integer) session.getAttribute("count");
         model.addAttribute("counttoShow", currentCount);
         return "showCount.jsp";
     }
     ```
     - Check if a variable is in session
      ``` java
      if(session.getAttribute("varName") == null) {
        //do something
      }
      ```
   - <a name="post_form"></a>Handling Forms and POST method
     - the method will redirect to /confirm
       - /cofirm could be a GET page that returns a jsp file
     - can process data as needed or store in session
     - can also use `PostMapping('/route')` as shorthand for RequestMapping with POST
     - Parsing HTML form date/time input requires `@DateTimeFormat`
       - formating similar to SimpleDateFormat class
     ``` java
     @RequestMapping(value="/process", method=RequestMethod.POST)
     public String process(
         @RequestParam(value="input1") String input1,
         @RequestParam(value="dateInput") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateInput) {
         System.out.println(input1 + " was received.");
         return "redirect:/confirm";
     }
     ```
   - <a name="flash">Flash</a>
     - adding a flash attribute to `RedirectAttribute` instance
     - flashed messages are handled the same ways as model attributes in jsp
       - disappears after shown once
     - In this example, we are adding a flash message with key of error
       - the value of message: "A test error!"
       - we then redirect to route `'/'`
       - the .jsp file rendered at `'/'` should handle the flashed message
      ``` java
      @RequestMapping("/createError")
      public String flashError(RedirectAttributes redirectAttributes) {
          redirectAttributes.addFlashAttribute("error", "A test error!");
          return "redirect:/";
      }
      ```

## JSP magic
   - AKA JSTL
   - done in .jsp (template file)
   - grabbing values passed from Model model
   - must include the following line
      ```JSP
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      ```
   - if we are just getting data from a variable, c:out is not required
      ```HTML
      <p><c:out value="${strData}"/></p>
      <p><c:out value="${intData}"/></p>
      <p>${strData}</p>
      ```
   - if statement
     - condition can be any condition in java syntax
      ```HTML
      <c:if test="${condition}">
        <p>do something if true</p>
      </c:if>
      ```
   - if-else
     - uses c:choose, c:when, c:otherwise
     - subsequent c:when becomes else if statements
     - c:choose denotes start and end of if block
      ```HTML
      <c:choose>
        <c:when test="${condition1}">
          <p>Display if condition is true</p>
        </c:when>
        <c:when test="${elseIfCondition}">
          <p>Display else if condition is true</p>
        </c:when>
        <c:otherwise>
          <p>Else run this</p>
        </c:otherwise>
      </c:choose>
      ```
   - forEach loop:
     - people is the array in this example
     - person is the variable that we set as the current item in the array
       - we could rename person to banana and this will still work
     - name (or person.name) is a member variable of the Object named person
       - name could be a private member variable
         - JSTL will use our getters and setters to get value of variable
           - THIS MEANS WE MUST MAKE OUR GETTER & SETTER METHODS
     ```JSP
     <c:forEach var="person" items="${people}">
         <c:out value="${person.name}"/>
     </c:forEach>
     ```
   - Handling flashed messages
     - functionally the same as showing other attributes from Model model
     - in this example, the flashed message has key of `error`
      ```HTML
      <p><c:out value="${error}"/></p>
      ```
   - Formating date in JSTL:
     - first one formats a date object into a date format
     - second one formats a date object into a date format
     - date is a variable either instantiated in jsp or from model, session, etc
       - it should be a Date object
      ``` jsp
      <!-- top of page -->
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

      <!-- in body -->
      <fmt:formatDate type="date" value="${date}">
      <fmt:formatDate type="time" value="${date}">
      ```
   - Data binding in jsp
     - new taglib with prefix "form"
       - almost all elements inside the form will have this prefix except the submit button
       - not all inputs will be called input type=xyz anymore
         - input type=password becomes form:password
       - for email, date, and range, you can still use form:input type="email" etc
     - input will now have a `path` attribute instead of `name`
       - the path names must match the attributes inside the model class
         - ex: `Books.java` in models package has attributes title, description, language, and numberOfPages
     - new `form:errors` tag
       - it will display errors in page if the input didn't pass input validations in the models file
         - ex: if title has `@NotNull` annotation, an error will be displayed in the error with path "title" if the field was empty
           - see [here](#data_binding) for details regarding custom error messages
         - you can style the error tags similar to regular html tags
           - class="text-danger" etc from bootstrap
      ```jsp
      <!-- top of page -->
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <!-- inside body -->
      <h1>New Book</h1>
      <form:form action="/books" method="post" modelAttribute="book">
          <p>
              <form:label path="title">Title</form:label>
              <form:errors path="title"/>
              <form:input path="title"/>
          </p>
          <p>
              <form:label path="description">Description</form:label>
              <form:errors path="description"/>
              <form:textarea path="description"/>
          </p>
          <p>
              <form:label path="language">Language</form:label>
              <form:errors path="language"/>
              <form:input path="language"/>
          </p>
          <p>
              <form:label path="numberOfPages">Pages</form:label>
              <form:errors path="numberOfPages"/>     
              <form:input type="number" path="numberOfPages"/>
          </p>    
          <input type="submit" value="Submit"/>
      </form:form>    
      ```
      - to allow for rendering on a post/put method
      ```jsp
      <!-- top of page -->
      <%@ page isErrorPage="true" %>
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

## Database
 - In `application.properties`
   - **Change** `schema name`, `dbuser`, and `dbpassword `
     - may need to change port number as needed
   - The webserver **WILL NOT** run unless the schema (database) exists and MySQL server has started
     - Tables inside the schema do not need to be created
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA>>
    spring.datasource.username=<<dbuser>>
    spring.datasource.password=<<dbpassword>>
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```
   - If the server has error recognizing PDT as a timezone, use the following instead for the first line
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA>>?serverTimezone=UTC
    ```
   - If a warning shows that `com.mysql.jdbc.Driver` is deprecated, the following line could be removed
    ```
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    ```
  - <a name="domain_model">Domain Model</a>
    - uses `javax.persistence.Entity` and `javax.persistence.Table` packages
    - domain model files should be in java bean format
      - getters and setters
      - constructor for no parameter
    - tableNames is the table name in the database (books, users, etc)
    - TableName is the table name (Book, User, etc)
    - Attributes are columns in the database table
      - **MUST** HAVE GETTERS AND SETTERS
    - Validation Annotations
      - `@Entity`: represents an entity model for our application
      - `@Table`: sets this as a table in the database
      - `@Id`: sets this as the primary key
      - `@GeneratedValue`: sets this as an auto-incrementing value
      - `@Size` adds validation that the column must be in the specified range
      - `@Min` adds validation that the column must be at least the specified value
      - `@NotNull` adds validation that the column must be null
      - `@PrePersist` runs the method right before the object is created
      - `@PreUpdate` runs a method when the object is modified
    - Spring will create the table in database when we run the server
    - Attribute names in Java should be in `camelCase`
      - JPA will automatically convert them to snake_case
    - `TableName.java` in `com.example.projectname.models`:
    ``` java
    @Entity
    @Table(name="tableNames")
    public class TableName {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        @Size(min = 5, max = 200)
        private String title;
        @NotNull
        @Size(min = 5, max = 200)
        private String description;
        @NotNull
        @Size(min = 3, max = 40)
        private String language;
        @NotNull
        @Min(100)
        private Integer numberOfPages;
        // This will not allow the createdAt column to be updated after creation
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date createdAt;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date updatedAt;
        
        public Book() {
        }
        public Book(String title, String description, String lang, int pages) {
            this.title = title;
            this.description = description;
            this.language = lang;
            this.numberOfPages = pages;
        }
        
        // other getters and setters removed for brevity
        // TODO: ADD GETTERS AND SETTERS
        @PrePersist
        protected void onCreate(){
            this.createdAt = new Date();
        }
        @PreUpdate
        protected void onUpdate(){
            this.updatedAt = new Date();
        }
    }
    ```
  - <a name="repository">Repository</a>
    - Spring will generate queries for us based on method signature in this `interface` file
      - we do not need to do anything beyond declaring these method signatures
    - `BookRepository` can be any name, but we usually call it model_name + Repository for clarity
    - all repository interfaces must extend `CrudRepository`, and the first data type is the name of our model (`Book` class) and the seond datatype is the primary key of our model (`Long` id)
    - CrudRepository has some built in methods that we can already utilize such as count, delete, save, etc.
    - `TableNameRepository.java` in `com.example.projectname.repositories`:
    ``` java
    // ...
    @Repository
    public interface BookRepository extends CrudRepository<Book, Long>{
        // this method retrieves all the books from the database
        List<Book> findAll();
        // this method finds books with descriptions containing the search string
        List<Book> findByDescriptionContaining(String search);
        // this method counts how many titles contain a certain string
        Long countByTitleContaining(String search);
        // this method deletes a book that starts with a specific title
        Long deleteByTitleStartingWith(String search);
    }
    ```
  - <a name="service">Service</a>
    - wraps our repository methods into methods that we will actually call in the controller
    - the variable name `bookRepository` is a name that we chose
      - we could rename it to `bookRepo` for short-hand notation
    - `TableNameService.java` in `com.example.projectname.services`:
    ``` java
    // ...
    @Service
    public class BookService {
        // adding the book repository as a dependency
        private final BookRepository bookRepository;
        
        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        // Option 2, can skip private final + constructor
        @Autowired
        private BookRepository bookRepository;

        // returns all the books
        public List<Book> allBooks() {
            return bookRepository.findAll();
        }
        // creates a book
        public Book createBook(Book b) {
            return bookRepository.save(b);
        }
        // retrieves a book
        public Book findBook(Long id) {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if(optionalBook.isPresent()) {
                return optionalBook.get();
            } else {
                return null;
            }
        }
        public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
      		Book updated_book = new Book(id,title,desc,lang,numOfPages);
      		Optional<Book> optionalBook = bookRepository.findById(id);
      		if (optionalBook.isPresent()) {
      			return bookRepository.save(updated_book);
      		} else {
      			return null;
      		}
	    }
      	public void deleteBook (Long id) {
      		bookRepository.deleteById(id);
      	}
    }
    ```
  - <a name="db_controller_api">Database Controller API</a>
    - We are only calling methods from [TableNameService class](#service)
      - our service class will handle calls to the repository
    - `final` on the Service instance ensures that we are using the same Service instance every time
    - `TableNameApi.java` in `com.example.projectname.controllers`:
    ``` java
    // ..
    @RestController
    public class BooksApi {
        private final BookService bookService;
        public BooksApi(BookService bookService){
            this.bookService = bookService;
        }
        // @Autowired also works here

        @RequestMapping("/api/books")
        public List<Book> index() {
            return bookService.allBooks();
        }
        
        @RequestMapping(value="/api/books", method=RequestMethod.POST)
        public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
            Book book = new Book(title, desc, lang, numOfPages);
            return bookService.createBook(book);
        }
        
        @RequestMapping("/api/books/{id}")
        public Book show(@PathVariable("id") Long id) {
            Book book = bookService.findBook(id);
            return book;
        }
        @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
      	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
      			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
      			@RequestParam(value = "pages") Integer numOfPages) {
      		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
      		return book;
      	}

      	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
      	public void destroy(@PathVariable("id") Long id) {
      		bookService.deleteBook(id);
      	}
    }
    ```
  - <a name="db_controller_render">Database Controller With Webpage rendering</a>
    - We will use `@Controller` annotation in our controller file
    - we will still use tableNameService to handle database interaction
    - Instead of returning the object, we put the object into Model model
      - We will display the data inside a jsp page, similar to before db was introduced
    - We return a jsp page to view
    - `BookController.java` in controllers package
    ``` java
    @Controller
    @RequestMapping("/books")
    public class BookController {
    	@Autowired
    	private BookService bookservice;
    	
    	@GetMapping("")
    	public String showAllBooks(Model model) {
    		List<Book> books = bookservice.allBooks();
    		model.addAttribute("books", books);
    		return "index.jsp";
    	}
    	
    	@GetMapping("/{bookId}")
    	public String showBook(Model model, @PathVariable("bookId") Long bookID) {
    		Book book = bookservice.findBook(bookID);
    		model.addAttribute("book", book);
    		return "show.jsp";
    	}
    }
    ```
  - <a name="data_binding">Data Binding</a>
    - Makes form data easier to process
    - We pass an empty instance of our model into the view
      - Using `@ModelAttribute` annotation in the route that renders the jsp with form
        - Utilizes Inversion of Control 
    - The submitted form returns a filled instance of our model to the POST method
    - New Classes & Annotations:
      - `@Valid`: we are running validations
      - `BindingResult result`: we can use it to check for errors
        - **Important**: The `BindingResult` parameter must be immediately following the annotated `@ModelAttribute` parameter.
    - After validations, it's ok to render on a POST method
      - the data is not actually sent to the database unless it was valid
      - the use does not lose the information that they have already entered
    - adding to `BookController.java` in controllers package
    ``` java
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }

    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    ```
    - adding custom error messages
      - add an argument to our model file
      - will need to specify the first argument is the value now
      - in `Book.java` in models package
    ``` java
    @NotNull(message="Must not be blank")
    @Min(value=100, message="A book must have at least 100 pages")
    private Integer numberOfPages;
    ```
    - Edit method looks almost exactly like add method, except now the method is PUT instead of POST
      - The method is still post in the HTML
      - Add a hidden input in the form
    ```html
    <input type="hidden" name="_method" value="put">
    ```
    - To allow for put method using hidden input:
      - put in `application.properties`
    ```
    spring.mvc.hiddenmethod.filter.enabled=true
    ```

# Useful Resources:
- [Baeldung](https://www.baeldung.com/)
- JavaTPoint
- Oracle Documentations
- Spring Documentations