
 function onLoginClick() {

    // collect input from fields

    let usernameInput = document.getElementById('username').value;
    let passwordInput = document.getElementById('password').value;

    console.log(usernameInput);
    console.log(passwordInput);

    // Create json object to send in request body

    let author = {
        user: usernameInput,
        pass: passwordInput
    }

    // Get employee by email and make sure password matches
    // Create request object
    let xhttp = new XMLHttpRequest();

    // we'll use a put request to send sensitive information in request body not url
    xhttp.open("POST", "http://localhost:8080/Project1/controller/AuthorLogin", true);

    // Set request header
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(author));

    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            // redirect to another page
           window.location.href="http://localhost:8080/Project1/AuthorPage.html";

            
        }
    }

}

// const URL = 'http://localhost:8080/Project1/servlets';

// // Add event listener
// document.getElementById('login-button').addEventListener('click', login);

// function login() {
//     console.log("button is clicked");

//     let authorCred = {
//         user: document.getElementById('username').value,
//         pass: document.getElementById('password').value
//     }

//     jsonCred = JSON.stringify(authorCred);
//     console.log(jsonCred);

//     let xhttp = new XMLHttpRequest();

//     xhttp.onreadystatechange = recieveData;

//     xhttp.open("POST", URL + "/author-login", true);
//     xhttp.send(jsonCred);

//      function recieveData () {

//         if (xhttp.readyState == 4) {
//             if (xhttp.status == 200) {
//                 console.log("success");
//                 console.log(xhttp.responseText);
//                  window.location.href = xhttp.responseText;

//             } else {
//                 // Ready state is done but status code is not "Ok"
//             }
//         } else {
//             // error handling
//         }
//     }


    // xhttp.setRequestHeader('Content-Type', 'application/json');

    // xhttp.send(JSON.stringify(employee));

    // xhttp.onreadystatechange = function() {

    //     if (this.readyState == 4 && this.status == 200) {
    //         // redirect to another page
    //        window.location.href="http://localhost:8080/Project1/AuthorPage.html";

            
    //     }
    // }
//}
