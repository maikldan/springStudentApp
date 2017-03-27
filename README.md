# Spring Boot Student App
<ul>
<li>
What we need(software):
  <ul>
    <li>IntelliJ</li>
    <li>PostrgreSQL(pgAdmin 4)</li>
  </ul>
</li>
<li>
What we add(dependency):
  <ul>
    <li>PosgreSQL</li>
    <li>thymeleaf</li>
    <li>dev-tools</li>
    <li>spring-data-jpa</li>
    <li>comons-fileupload</li>
    <li>hibernate-validator</li>
  </ul>
</li>

<li>Create a postgre database, settings for that we will use after, like db:url, username, password</li>
<li>For DB connection we use application.proprietes file</li>
<li>Create all moddels for each entity and getters,setters fot them and generate db tables or we take existing db and generate models</li>
<li>DAO objects type now is repository, here we use spring jpa. We need to extends each repo  from CrudRepository(Object, Type of ID)</li>
<li>After creating DAO repo we need to create controllers for each model and initialize DAO objects there</li>
<li>Each controller have doGet and doPost methods that processed data</li>
<li>Create views for models that we'll need to process</li>
</ul>
