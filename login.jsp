<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!-- page language= "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" -->
<html>
     
    <link href="mysheet.css" rel="stylesheet" type="text/css" />
    <head>
      <header>
    	<div class="main">
        	
      </div>
        	<ul>
                        
                        <li><a href="login.jsp" >LOGIN</a></li>
                        <li><a href="registration.jsp" >SIGN UP</a></li>
                        <li><a href="aboutUs.jsp" >ABOUT US</a></li>
                        <li><a href="services.jsp">SERVICES</a></li>
            </ul>
            <div class="logo">
            
            
        </div>
        
        
        <div class="title">
        	<h1>Pharmaceutical Health Care</h1>
        </div>
            
            <div class="log">
    <h1>LOGIN</h1>
    <!-- From System: ${msgConfirmed}<br/>
          From Session: ${msgSession}<br/>
          From Context: ${msgAppContext}<br/>-->
    <form name="ps" action="Logincust" method="POST">
        
        
                <input id="User" type="text" name="usern" placeholder="Username"><br>
                <input id="Pass" type="password" name="passw" placeholder="Password"><br>
                <input id="Login" type="submit" name="submit" value="Sign In"><br><br>
        
    </form>
                
                <a href="admin.jsp" class="admin">login as ADMIN?</a>
        </div>      
        
    </header>
    </head>
    <body>
        
    </body>
</html>
