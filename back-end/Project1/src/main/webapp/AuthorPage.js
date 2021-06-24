const URL = 'http://localhost:8080/Project1/controller';

let getWeight = document.getElementById("weight")

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
  }

// temp author object
// let IamthebetterMatt = document.getElementById("weight")
// let author = {"authorId": 1,
// "authorUsername": "me",
// "authorPassword": "123",
// "authorFirstName": "me",
// "authorLastName": "t0o",
// "authorPoints": 10,
// "stories": [
//     {
//         "storyId": 3,
//         "title": "Murder in Heaven",
//         "tagline": "Who killed Santa Claus?",
//         "description": "A short story depicting a bloody end to Saint Nick",
//         "completionDate": "2021-06-07",
//         "genre": "Mystery",
//         "weight": "Novella",
//         "status": {
//             "statusId": 3,
//             "status": "pending_general",
//             "priority": false,
//             "statusDate": "2021-06-14"
//         }
//     },
//     {
//         "storyId": 4,
//         "title": "Lord of the Kings",
//         "tagline": "Who will sit on the copper throne?",
//         "description": "An epic article depicting love at first sight",
//         "completionDate": "2021-06-06",
//         "genre": "Fantasy",
//         "weight": "Short Story",
//         "status": {
//             "statusId": 4,
//             "status": "pending_senior",
//             "priority": false,
//             "statusDate": "2021-06-14"
//         }
//     },
//     {
//         "storyId": 5,
//         "title": "Gone Boy",
//         "tagline": "Where did that boy go?",
//         "description": "An article detailing the horrifying case of John Snow, The Woodland Killer.",
//         "completionDate": "2021-06-05",
//         "genre": "Horror",
//         "weight": "Short Story",
//         "status": {
//             "statusId": 5,
//             "status": "pending_senior",
//             "priority": false,
//             "statusDate": "2021-06-14"
//         }
//     }
// ]};

const getStory = () => {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = recieveData;

    xhttp.open("GET", URL + "/authorpage", true);
    xhttp.send();

     function recieveData () {

        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
               let r = xhttp.response;
                rr = r.replace("authorlogin.html", "")
                author = JSON.parse(rr);
                console.log(author);
                populateData(author);

            } else {
                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}

window.onload = getStory();

function populateData (at) {
    let storySection = document.getElementById("stories");

    // Author Welcome
    let authorWelcome = document.createElement('h1');
    authorWelcome.innerHTML = "Welcome, " + at.authorFirstName + " " + at.authorLastName + "!";
    authorWelcome.setAttribute("class", "author-welcome") ;
    storySection.appendChild(authorWelcome);

    // Create a story button

    // Stories Container
    let storiesContainer = document.createElement('div');
    storiesContainer.setAttribute("class", "sto-container");
    storySection.appendChild(storiesContainer);

    at.stories.map(st => {
        // Story Container
        let stoBox = document.createElement('div');
        stoBox.setAttribute("class", "sto-box");
        
        // Story Title
        let stoTitle = document.createElement('p')
        stoTitle.innerHTML = "Story Title: " + st.title;
        stoTitle.setAttribute("class", "sto-title");
        stoBox.appendChild(stoTitle);

        // Story Tagline
        let stoTagline = document.createElement('p')
        stoTagline.innerHTML = "Tagline: " + st.tagline;
        stoTagline.setAttribute("class", "sto-tagline");
        stoBox.appendChild(stoTagline);

        // Story description
        let stoDescription = document.createElement('p')
        stoDescription.innerHTML = "Description: " + st.description;
        stoDescription.setAttribute("class", "sto-description");
        stoBox.appendChild(stoDescription);

        // Story completionDate
        let stoCompletionDate = document.createElement('p')
        stoCompletionDate.innerHTML = "Completion Date: " + st.completionDate;
        stoCompletionDate.setAttribute("class", "sto-completion-date");
        stoBox.appendChild(stoCompletionDate);

        // Story genre
        let stoGenre = document.createElement('p')
        stoGenre.innerHTML = "Genre: " + st.genre;
        stoGenre.setAttribute("class", "sto-genre");
        stoBox.appendChild(stoGenre);

        // Story weight
        let stoWeight = document.createElement('p')
        stoWeight.innerHTML = "Story Type Weight: " + st.weight;
        stoWeight.setAttribute("class", "sto-genre");
        stoBox.appendChild(stoWeight);

        // -----------------------------------------
        // Status Object
        let sta = st.status;
        let staBox = document.createElement('div')
        staBox.setAttribute("class", "sta-box");

        // Status
        let staStatus = document.createElement('p')
        staStatus.innerHTML = "Status: " + sta.status;
        staStatus.setAttribute("class", "sto-tagline");
        staBox.appendChild(staStatus);

        // Status Date
        let staDate = document.createElement('p')
        staDate.innerHTML = "Pending Approval Date: " + sta.statusDate;
        staDate.setAttribute("class", "sto-completion-date");
        staBox.appendChild(staDate);

        //Assistant Info
        if (sta.assistantInfo != null) {
            let staAssistantInfo = document.createElement('p')
            staAssistantInfo.innerHTML = "Assisstant information: " + sta.assistantInfo;
            staAssistantInfo.setAttribute("class", "sto-description");
            staBox.appendChild(staAssistantInfo);
        }

        //General Info
        if (sta.generalInfo != null) {
            let staGeneralInfo = document.createElement('p')
            staGeneralInfo.innerHTML = "General information: " + sta.generalInfo;
            staGeneralInfo.setAttribute("class", "sto-description");
            staBox.appendChild(staGeneralInfo);
        }

        //Senior Info
        if (sta.seniorInfo != null) {
            let staSeniorInfo = document.createElement('p')
            staSeniorInfo.innerHTML = "Senior Editor information: " + sta.seniorInfo;
            staSeniorInfo.setAttribute("class", "sto-description");
            staBox.appendChild(staSeniorInfo);
        }

        //--------------------------------------
        // Approval Object 
        if (sta.status == "pending approval") {
            let app = sta.approval;
            // Approval Box
            let appBox = document.createElement('div')
            appBox.setAttribute("class", "app-box");

            // Approval Status
            let appStatus = document.createElement('p')
            appStatus.innerHTML = "Approval Status: " + app.approvalStatus;
            appStatus.setAttribute("class", "sto-tagline");
            appBox.appendChild(appStatus);

            // Approval Info
            if (app.approvalInfo != null) {
                let appInfo = document.createElement('p')
                appInfo.innerHTML = "Approval Information: " + app.approvalInfo;
                appInfo.setAttribute("class", "sto-description");
                appBox.appendChild(appInfo);
            }

            // Approval Number
            let appNumber = document.createElement('p')
            appNumber.innerHTML = "Approvals needed: " + app.approvalNumber + "/3";
            appNumber.setAttribute("class", "sto-genre");
            appBox.appendChild(appNumber);

            staBox.appendChild(appBox);
        }



        // attach populated containers
        stoBox.appendChild(staBox);
        storySection.appendChild(stoBox);
    })


    // Current points
    let authorPoints = document.createElement('p'); // may need a diff name than author points
    authorPoints.innerHTML = "Current points: " + at.authorPoints;
    authorPoints.setAttribute("class", "author-points");
    storySection.appendChild(authorPoints);


}

document.getElementById("sololo").addEventListener('click', showAddStory);


function showAddStoryC() {
    showAddStory(author)
}

function showAddStory(at) {
    let apts = at.authorPoints;

    if(apts >= 50) {
        let novel = document.createElement('option')
        novel.innerHTML = "Novel";
        novel.setAttribute("value", "Novel");
        getWeight.appendChild(novel);
    }

    if(apts >= 25) {
        let novella = document.createElement('option')
        novella.innerHTML = "Novella";
        novella.setAttribute("value", "Novella");
       getWeight.appendChild(novella);
    }

    if(apts >= 10) {
        let shortstory = document.createElement('option')
        shortstory.innerHTML = "Short Story";
        shortstory.setAttribute("value", "Short Story");
        getWeight.appendChild(shortstory);
    }

    if(apts >= 0) {      
        let article = document.createElement('option')
        article.innerHTML = "Article";
        article.setAttribute("value", "Article");
        getWeight.appendChild(article);
    }
    showEls();
}

function showEls() {
    let elems = document.querySelectorAll(".hidden")
    for (let index = 0; index < elems.length; index++) {
        elems[index].classList.remove('hidden')
    }
}


document.getElementById("as-form").addEventListener('submit',(e) => {
    addStory(e);
});
function addStory(e) {
    e.preventDefault();
    let aSto = {
            title: e.target["title"].value,
            tagline: e.target["tagline"].value,
            description: e.target["description"].value,
            completionDate: e.target["date"].value,
            genre: e.target["genre"].value,
            weight: e.target["weight"].value,
            status: {
                status: "pending assistant approval",
                priority: false,
                statusDate: "2021-06-25",
                approval: {
                    approvalStatus: null,
                    approvalInfo: null,
                    approvalNumber: null,
                }
            }

    }
    console.log(aSto);

    let pts = 0;
    if(aSto.weight === "Novel") {
        pts = 50;
    }
    
    if(aSto.weight === "Novella") {
        pts = 25;
    }
    
    if(aSto.weight === "Short Story") {
        pts = 20;
    }
    
    if(aSto.weight === "Article") {
        pts = 10;
    }

    stoJson = JSON.stringify(aSto);

    console.log(stoJson);
    
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = postStory;
    xhttp.open("POST", URL + "/addstory", true);
    xhttp.send(stoJson);

    function postStory () {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                updateAuthor(author, pts)


            } else {

            }
        } else {
        }
    }
}

function updateAuthor (attt, pts) {
    attt["authorPoints"] = attt.authorPoints - pts;

    autJson = JSON.stringify(attt);

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = postAuthor;
    xhttp.open("POST", URL + "/updateauthor", true);
    xhttp.send(autJson);
    console.log("Author Sent to Back end: " + autJson);

    function postAuthor () {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
            } else {
                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}

// logout

let logoutbtn = document.getElementById("logout");
logoutbtn.addEventListener('click',() => {
    logout();
});


function logout() {
    // finish this on backend
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = logout;
    xhttp.open("GET", URL + "/logout", true);
    xhttp.send();

    function logout () {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                window.location.href = "authorlogin.html";
            } else {
                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}