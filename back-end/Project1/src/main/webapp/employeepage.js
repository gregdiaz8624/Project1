const URL = 'http://localhost:8080/Project1/controller';
// temp author object
// let employee = {

//     "employeeId": 1,
//     "employeeUsername": "demi1",
//     "employeePassword": "123",
//     "employeeFirstName": "Demi",
//     "employeeLastName": "Bush",
//     "employeeType": "assistant",
//     "genre1": "Mystery",
//     "genre2": "Fantasy",
//     "genre3": "Horror",

//     "story1": {
//         "storyId": 1,
//         "title": "All The Devils",
//         "tagline": "Who killed Matt Ecelbarger?",
//         "description": "A novel depicting a justified murder of a mad man",
//         "completionDate": "2021-06-07",
//         "genre": "Mystery",
//         "weight": "Novella",
//         "status": {
//             "statusId": 3,
//             "status": "pending_approval",
//             "priority": false,
//             "statusDate": "2021-06-14",
//             "approval": {
//                 "approvalId": 1,
//                 "approvalStatus": "committee",
//                 "approvalInfo": "Fix this dumb draft u fool",
//                 "approvalNumber": 2
//             }
//         }
//     },
//     "story2": {
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
//     "story3": {
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
//     }
// };

const getStory = () => {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = recieveData;

    xhttp.open("GET", URL + "/employeepage", true);
    xhttp.send();

     function recieveData () {

        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
               let r = xhttp.response;
                rr = r.replace("employeelogin.html", "")
                employee = JSON.parse(rr);
                console.log(employee);
                populateData(employee);

            } else {
                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}

window.onload = getStory();


function populateData(em) {
    let prioExists = false;
    let storySection = document.getElementById("stories");
    let eType = em.employeeType;

    // Employee Welcome
    let authorWelcome = document.createElement('h2');
    authorWelcome.innerHTML = "Welcome editor: " + em.employeeFirstName + " " + em.employeeLastName;
    authorWelcome.setAttribute("class", "author-welcome") ;
    storySection.appendChild(authorWelcome);

    //Employee Genres
    let authorGenreBox = document.createElement('div');
    authorGenreBox.setAttribute("class", "author-box")
    storySection.appendChild(authorGenreBox);

    let genArr = []
    genArr.push(em.genre1, em.genre2, em.genre3);
    genArr.map(g => {
        let geEl = document.createElement('h4');
        geEl.innerHTML = g;
        geEl.setAttribute("class", "genre");
        authorGenreBox.appendChild(geEl);
    })


    // Stories Container
    let storiesContainer = document.createElement('div');
    storiesContainer.setAttribute("class", "sto-container");
    storySection.appendChild(storiesContainer);

    let mattArray = [];
    mattArray.push(em.story1)
    mattArray.push(em.story2)
    mattArray.push(em.story3)

    // finding if any statuses are high prio 
    mattArray.map(st => {
        if (st.status.priority) {
            prioExists = true;
        }
    })

    mattArray.map(st => {

        // Story Container
        let stoBox = document.createElement('div');
        stoBox.setAttribute("class", "sto-box");
        
        // Story Title
        let stoTitle = document.createElement('h3')
        stoTitle.innerHTML = st.title;
        stoTitle.setAttribute("class", "sto-title");
        stoBox.appendChild(stoTitle);

        // Story Tagline
        let stoTagline = document.createElement('h5')
        stoTagline.innerHTML = st.tagline;
        stoTagline.setAttribute("class", "sto-tagline");
        stoBox.appendChild(stoTagline);

        // Story description
        let stoDescription = document.createElement('p')
        stoDescription.innerHTML = st.description;
        stoDescription.setAttribute("class", "sto-description");
        stoBox.appendChild(stoDescription);

        // Story completionDate
        let stoCompletionDate = document.createElement('p')
        stoCompletionDate.innerHTML = "Completion Date: " + st.completionDate;
        stoCompletionDate.setAttribute("class", "sto-completion-date");
        stoBox.appendChild(stoCompletionDate);

        // Story genre
        let stoGenre = document.createElement('p')
        stoGenre.innerHTML = st.genre;
        stoGenre.setAttribute("class", "sto-genre");
        stoBox.appendChild(stoGenre);

        // Story weight
        let stoWeight = document.createElement('p')
        stoWeight.innerHTML = st.weight;
        stoWeight.setAttribute("class", "sto-genre");
        stoBox.appendChild(stoWeight);

        // -----------------------------------------
        // Status Object
        let sta = st.status;
        let staBox = document.createElement('div')
        staBox.setAttribute("class", "sta-box");

        // Status Header
        let staHeader = document.createElement('h3')
        staHeader.innerHTML = "STATUS";
        staBox.appendChild(staHeader);

        // Status
        let staStatus = document.createElement('h5')
        staStatus.innerHTML = sta.status;
        staStatus.setAttribute("class", "sto-tagline");
        staBox.appendChild(staStatus);

        // Priority
        let staPriority = document.createElement('h5')

        if (sta.priority) {
            staPriority.innerHTML = "High Priority";
            staPriority.setAttribute("class", "sta-priority-high");
        } else {
            staPriority.innerHTML = "Low Priority";
            staPriority.setAttribute("class", "sta-priority=low");
        }
        staBox.appendChild(staPriority);

        // Status Date
        let staDate = document.createElement('p')
        staDate.innerHTML = "Status Date: " + sta.statusDate;
        staDate.setAttribute("class", "sto-completion-date");
        staBox.appendChild(staDate);

        //Assistant Info
        if (sta.assistantInfo != null) {
            let staAssistantInfo = document.createElement('p')
            staAssistantInfo.innerHTML = sta.assistantInfo;
            staAssistantInfo.setAttribute("class", "sto-description");
            staBox.appendChild(staAssistantInfo);
        }

        //General Info
        if (sta.generalInfo != null) {
            let staGeneralInfo = document.createElement('p')
            staGeneralInfo.innerHTML = sta.generalInfo;
            staGeneralInfo.setAttribute("class", "sto-description");
            staBox.appendChild(staGeneralInfo);
        }

        //Senior Info
        if (sta.seniorInfo != null) {
            let staSeniorInfo = document.createElement('p')
            staSeniorInfo.innerHTML = sta.seniorInfo;
            staSeniorInfo.setAttribute("class", "sto-description");
            staBox.appendChild(staSeniorInfo);
        }

        // Status Approve Button
        let penBtn = document.getElementById("ustat-btn");
        penBtn.addEventListener('click',() => {
            updateStatus(sta)
        });

        let psta = sta.status;
        let pstaSelect = document.getElementById("ustat-sel")

        // Dynamically added priority
        if (prioExists) {
            if (sta.priority) {
                if (psta === "pending_senior" || psta === "pending_approval") {
                    if (eType === "senior") {
                        let opt1 = document.createElement('option')
                        opt1.innerHTML = st.storyId + ": " + st.title;
                        opt1.setAttribute("value", st.storyId);
                        pstaSelect.appendChild(opt1);
                    }
                } else {
                    let opt1 = document.createElement('option')
                    opt1.innerHTML = st.storyId + ": " + st.title;
                    opt1.setAttribute("value", st.storyId);
                    pstaSelect.appendChild(opt1);
                }
            }
        } else {
            if (psta === "pending_senior" || psta === "pending_approval") {
                if (eType === "senior") {
                    let opt1 = document.createElement('option')
                    opt1.innerHTML = st.storyId + ": " + st.title;
                    opt1.setAttribute("value", st.storyId);
                    pstaSelect.appendChild(opt1);
                }
            } else {
                let opt1 = document.createElement('option')
                opt1.innerHTML = st.storyId + ": " + st.title;
                opt1.setAttribute("value", st.storyId);
                pstaSelect.appendChild(opt1);
            }
        }


        //--------------------------------------
        // Approval Object
        
        if (sta.status == "pending_approval") {
            let app = sta.approval;
            // Approval Box
            let appBox = document.createElement('div')
            appBox.setAttribute("class", "app-box");

            // App Header
            let appHeader = document.createElement('h3')
            appHeader.innerHTML = "APPROVAL PROCESS";
            appBox.appendChild(appHeader);

            // Approval Status
            let appStatus = document.createElement('h5')
            appStatus.innerHTML = app.approvalStatus;
            appStatus.setAttribute("class", "sto-tagline");
            appBox.appendChild(appStatus);

            // Approval Info
            if (app.approvalInfo != null) {
                let appInfo = document.createElement('p')
                appInfo.innerHTML = app.approvalInfo;
                appInfo.setAttribute("class", "sto-description");
                appBox.appendChild(appInfo);
            }

            // Approval Number
            let appNumber = document.createElement('h5')
            appNumber.innerHTML = "Need 3 approval votes, currently at: " + app.approvalNumber;
            appNumber.setAttribute("class", "sto-genre");
            appBox.appendChild(appNumber);

            if (appNumber < 3) {
                let appBtn = document.createElement('button');
                appBtn.innerHTML = "Final Approval";
                appBtn.setAttribute("class", "app-btn");
                appBtn.addEventListener('click', () => {
                    updateApproval(st)
                });
            }
            staBox.appendChild(appBox);
        }
        // attach populated containers
        stoBox.appendChild(staBox);
        storySection.appendChild(stoBox);
    })

}

function updateStatus(sta) {
    let oldSta = sta.status
    let nSta = ""
    let uSta = sta;

    if (oldSta === "pending_assistant") {
        nSta = "pending_general"
    }
    if (oldSta === "pending_general") {
        nSta = "pending_senior"
    }
    if (oldSta === "pending_senior") {
        nSta = "pending_approval"
        console.log(uSta);
        uSta.status.approval[status] = "committee"
    }
    
    uSta[status] = nSta;

    jSta = JSON.stringify(uSta);

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = postStatus;
    xhttp.open("POST", URL + "/updatestatus", true);
    xhttp.send(jSta);

    function postStatus() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                location.reload();
            } else {
                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}

function updateApproval(st) {
    let sid = st.storyId;
    let author = {
        authorId: 0,
        authorPoints: 0
    }

    if (sid == 1) {
        author[authorId] = 3
        author[authorPoints] = 100
    }

    let oApp = st.status.approval;
    oApp[status] = "approved"

    jApp = JSON.stringify(oApp);

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = postApproval;
    xhttp.open("POST", URL + "/updateapproval", true);
    xhttp.send(jApp);

    function postApproval() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                updateAuthor(author)
                location.reload();
            } else {

                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}

function updateAuthor (at) {
    let author = {
        authorId: at.authorId,
        authorPoints: at.authorPoints
    }

    jAuthor = JSON.stringify(author);

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = postAuthor;
    xhttp.open("POST", URL + "/updateauthor", true);
    xhttp.send(jAuthor);

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
                window.location.href = "employeelogin.html";
            } else {
                // Ready state is done but status code is not "Ok"
            }
        } else {
            // error handling
        }
    }
}
