const URL = 'http://localhost:8080/Project1/controller';
let author = {};

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
  }

const getStory = () => {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = recieveData;

    xhttp.open("GET", URL + "/AuthorPage", true);
    xhttp.send();

     function recieveData () {

        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
               let r = xhttp.response;
                rr = r.replace("AuthorLogin.html", "")
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
    let authorWelcome = document.createElement('h2');
    authorWelcome.innerHTML = "Welcome, " + capitalizeFirstLetter(at.authorFirstName) + " " + capitalizeFirstLetter(at.authorLastName) + "!";
    authorWelcome.setAttribute("class", "author-welcome") ;
    storySection.appendChild(authorWelcome);

    // Current points
    let authorPoints = document.createElement('h3'); // may need a diff name than author points
    authorPoints.innerHTML = at.authorPoints;
    authorPoints.setAttribute("class", "author-points");
    storySection.appendChild(authorPoints);

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


        //--------------------------------------
        // Approval Object 
        if (sta.status == "pending_approval") {
            let app = sta.approval;
            // Approval Box
            let appBox = document.createElement('div')
            appBox.setAttribute("class", "app-box");

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
            appNumber.innerHTML = "Need 3, currently at: " + app.approvalNumber;
            appNumber.setAttribute("class", "sto-genre");
            appBox.appendChild(appNumber);

            staBox.appendChild(appBox);
        }

        // attach populated containers
        stoBox.appendChild(staBox);
        storySection.appendChild(stoBox);
    })

}