<%--
  Created by IntelliJ IDEA.
  User: lizon
  Date: 15. 5. 2022
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="CodeHim">
    <title>Simple Bootstrap 5 To Do List Example</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <!-- Style CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Demo CSS (No need to include it into your project) -->
    <link rel="stylesheet" href="css/demo.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>


    <script src="js/exercise.js"></script>
</head>
<body>
<header class="intro">
    <h1>Simple Bootstrap 5 To Do List Example</h1>
    <p> A breif introduction to plugin.</p>

    <div class="action">
        <a href="https://www.codehim.com/bootstrap/bootstrap-text-input/simple-to-do-list-using-bootstrap-5/" title="Back to download and tutorial page" class="btn back">Back to Tutorial</a>
    </div>
</header>
<script type="text/javascript">
    let input = document.getElementById("inputText");
    let list= document.getElementById("list");
    let minimalValue = 3;
    let listNum = 0;
    addList=()=>{

        // get
        let inputText = filterList(input.value);
        // set
        if (inputText) {
            list.innerHTML +=  ` <li class=" my-3 py-3 shadow list-group-item " id="list${listNum}">
                <div class="row">
                <div class="col-1">
                <input class="" type="checkbox" id="check${listNum}" onclick="done(${listNum})">
                </div>
                <div class="col-6">
                    <span class=" h4" id="text${listNum}"> ${inputText} </span>
                </div>
                <div class="col-4">
                     <button class=" btn btn-dark" onclick="deleteList(${listNum})">Delete</button>
                     <button class=" btn btn-dark" onclick="editList(${listNum})">Edit</button>
                </div>
                 </div>
                </li> `;
            input.value=" ";
            listNum++;


        }
    }

</script>

<main>
    <!-- Start DEMO HTML (Use the following code into your project)-->
    <div class=" container rounded-3 border border-2 border-dark my-5 bg-white" style="height:auto;">
        <div>
            <h1 class=" h1">To Do List</h1>
            <div class="row">
                <div class=" col-8">
                    <input class=" py-3 form-control shadow" placeholder="input your task" type="text" id="inputText">
                </div>
                <div class="col-2">
                    <!-- <i onclick="addList()" class=" btn btn-dark rounded-pill fas fa-4x fa-plus-circle "></i> -->
                    <button onclick="addList()" class=" mt-2 btn btn-dark"> Add </button>
                </div>
            </div>
        </div>
        <hr>
        <div class="row rounded bg-white">
            <div class=" col-12">
                <ul class=" list-group" id="list"></ul>
            </div>
        </div>

    </div>
    <!-- END EDMO HTML (Happy Coding!)-->
</main>


<footer class="credit">Author: Yan Naing - Distributed By: <a title="Awesome web design code & scripts" href="https://www.codehim.com?source=demo-page" target="_blank">CodeHim</a></footer>

<!-- Bootstrap 5 JavaScript Bundle with Popper -->

</body>

</html>