# login_demo
## This is simple login/signup java desktop application using Swing API and hibernate

- project was build with maven so if you want to build it fast and download all dependencies easily just download maven or use eclipse or vscode
- you can manually excute the command `mvn dependency:resolve` to download all dependencies(hibernate, junti4 amd mysql-connector-j) locate in pom.xml(current directory)
- records (credentials) is registered in mysql database so you must have it install on your machine to run the code well

## Signup interface

#### -as you can see below i implement a credentials validation for both fields, for instance username must not contain metacharacter, must start with alphanumeric characters and must be atleast 3 characters long to be valid

![signupDemo](https://user-images.githubusercontent.com/48497693/133979762-0ed33ce4-c168-4359-ac8e-e02a53f4d7dd.gif)

#### -the image above show that user credentials was sucessfully registered in database, you can also see that the password was hashed before be recorded

![realrecordinDB](https://user-images.githubusercontent.com/48497693/133983199-72d355a2-c3ad-40d3-a642-009d796b4dce.png)


