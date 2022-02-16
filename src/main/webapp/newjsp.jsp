<%-- 
    Document   : newjsp
    Created on : Feb 16, 2022, 11:50:44 AM
    Author     : shiv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <button onClick="create_user()">create user</button><br>
        <button onClick="delete_tweet()">delete tweet</button><br>
        <button onClick="read_tweet()">read tweet</button><br>
        <button onClick="add_tweet()">add tweet</button><br>
        <div id="demo"></div>
        <script>
            function create_user() {
                document.getElementById('demo').innerHTML="";
                var br = document.createElement("br");
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "Create_user");
                var label=document.createElement("Label");
                label.innerHTML="Create user : ";
                form.appendChild(label);
                form.appendChild(br.cloneNode());
                var un = document.createElement("input");
                un.setAttribute("type", "text");
                un.setAttribute("name", "username");
                un.setAttribute("placeholder", "Username");
                var s = document.createElement("input");
                s.setAttribute("type", "submit");
                s.setAttribute("value", "Submit");
                form.appendChild(un);
                form.appendChild(br.cloneNode());
                form.appendChild(s);
                document.getElementById("demo").appendChild(form);
                //document.getElementsByTagName("body")[0].appendChild(form);
				//document.getElementById('demo').removeChild(form);
            }
            function delete_tweet() {
                document.getElementById('demo').innerHTML="";
                var br = document.createElement("br");
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "Delete_tweets");
                var label=document.createElement("Label");
                label.innerHTML="Delete tweets :";
                form.appendChild(label);
                form.appendChild(br.cloneNode());
                var un = document.createElement("input");
                un.setAttribute("type", "text");
                un.setAttribute("name", "username");
                un.setAttribute("placeholder", "Username");
                var s = document.createElement("input");
                s.setAttribute("type", "submit");
                s.setAttribute("value", "Submit");
                form.appendChild(un);
                form.appendChild(br.cloneNode());
                form.appendChild(s);
                //document.getElementsByTagName("body")[0].appendChild(form);
                document.getElementById("demo").appendChild(form);
            }
            function add_tweet() {
		document.getElementById('demo').innerHTML="";
                var br = document.createElement("br");
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "Create_tweets");
                var label=document.createElement("Label");
                label.innerHTML="Add tweet :";
                form.appendChild(label);
                form.appendChild(br.cloneNode());
                var ui = document.createElement("input");
                ui.setAttribute("type", "text");
                ui.setAttribute("name", "user_id");
                ui.setAttribute("placeholder", "user_id");
                var tx = document.createElement("input");
                tx.setAttribute("type", "text");
                tx.setAttribute("name", "text");
                tx.setAttribute("placeholder", "text");
                
                var s = document.createElement("input");
                s.setAttribute("type", "submit");
                s.setAttribute("value", "Submit");
                form.appendChild(ui);
                form.appendChild(br.cloneNode());
                form.appendChild(tx);
                form.appendChild(br.cloneNode());
                form.appendChild(s);
                document.getElementById("demo").appendChild(form);
            }
            function read_tweet() {
		document.getElementById('demo').innerHTML="";
                var br = document.createElement("br");
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "Read_tweets");
                var label=document.createElement("Label");
                label.innerHTML="Read tweets :";
                form.appendChild(label);
                form.appendChild(br.cloneNode());
                var un = document.createElement("input");
                un.setAttribute("type", "text");
                un.setAttribute("name", "username");
                un.setAttribute("placeholder", "Username");
                var dt = document.createElement("input");
                dt.setAttribute("type", "text");
                dt.setAttribute("name", "date");
                dt.setAttribute("placeholder", "yyyy-mm-dd");
                
                var s = document.createElement("input");
                s.setAttribute("type", "submit");
                s.setAttribute("value", "Submit");
                form.appendChild(un);
                form.appendChild(br.cloneNode());
                form.appendChild(dt);
                form.appendChild(br.cloneNode());
                form.appendChild(s);
                document.getElementById("demo").appendChild(form);
            }
            
        </script>
        
    </body>
</html>
