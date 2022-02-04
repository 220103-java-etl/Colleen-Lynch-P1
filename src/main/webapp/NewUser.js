
let userUrl = "http://localhost:8080/Colleen-Lynch-P1_war/users";
let reimbursementUrl = "http://localhost:8080/Colleen-Lynch-P1_war/reimbursement";

function addUser() {
    // collect input
    let fName = document.getElementById('userFName').value;
    let lName = document.getElementById('userLName').value;

    // create a JS Object with those values
    let newUser = {
        firstName: fName,
        lastName: lName
    }
    console.log(newUser);
    // this will convert our JS Object into a string json format so we can send it
    // in the body of a request.
    let userJson = JSON.stringify(newUser);
    console.log(userJson);

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        // what to do when response is received.
        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);

        }
    }

    xhr.open('POST', userUrl, true); // async=true

    // because our POST request has a body, we need to tell our server
    // what type of body to expect
    // don't necessarily need to do this with a GET request.
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.send(userJson); // xhr.send(JSON.stringify(newUser));
}

async function addUserFetch() {

    let user = {
        firstName: document.getElementById('userFName').value,
        lastName: document.getElementById('userLName').value
    }

    let res = await fetch(userUrl, {
        method: "POST",
        body: JSON.stringify(user),
        header: { 'Content-Type': 'application/json'}
    });

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
        })
        .catch((error) => {
            console.log(error);
        });
    // Traditionally...
    // try {
    //     let result = await res.json();
    //     console.log(result);
    // } catch (Error) {
    //     console.log(error)
    // }


}

function getAllReimbursement() {

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let r = JSON.parse(this.responseText);
            console.log(r)
            populateReimbursement(r);
        }
    }

    xhr.open('GET', reimbursementUrl, true);

    xhr.send();



}

async function fetchAllReimbursement() {
    let res = await fetch(reimbursementUrl);
    let data = await res.json();

    if (res.status == 200) {
        console.log(data);
        populateReimbursement(data);
    } else {
        console.log("something went wrong");
    }

}

function populateReimbursement(data) {

    let reimbursementDiv = document.getElementById('reimbursement');
    reimbursementDiv.innerHTML = "";

    let reimbursementTable = document.createElement('table');
    reimbursementTable.setAttribute('class', 'table')

    let tHead = document.createElement('thead');

    let tableHeaderRow = document.createElement('tr');

    let tHeaders = ['RbId', 'Status', 'Author', 'Resolver', 'Amount'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.setAttribute('scope', 'col');
        th.innerHTML = h;
        tableHeaderRow.append(th);
    }
    tHead.append(tableHeaderRow)
    reimbursementTable.append(tHead);

    for (let reimbursement of data) { // for (String s : strArray)
        let tr = document.createElement('tr');
        tr.id = reimbursement.id;

        let tdID = document.createElement('td');
        tdID.innerHTML = reimbursement.id;
        tr.append(tdID);

        let tdStatus = document.createElement('td');
        tdStatus.innerHTML = reimbursement.status;
        tr.append(tdStatus);

        let tdAuthor = document.createElement('td');
        tdAuthor.innerHTML = reimbursement.author;
        tr.append(tdAuthor);

        let tdResolver = document.createElement('td');
        tdResolver.innerHTML = reimbursement.resolver;
        tr.append(tdResolver);

        let tdAmount = document.createElement('td');
        tdAmount.innerHTML = reimbursement.amount;
        tr.append(tdAmount);

        let tdUser = document.createElement('td');
        tdUser.id = reimbursement.user.id;
        tdUser.innerHTML = `${reimbursement.user.firstName} ${reimbursement.user.lastName}`;
        tr.append(tdUser);

        let tdButton = document.createElement('td');
        tdButton.innerHTML = `<button type="button" onclick="update(event)">Update</button>`;
        tr.append(tdButton);

        reimbursementTable.append(tr);
    }

    reimbursementDiv.append(reimbursementTable);


}

function update(event) {
    console.log(event);
    let reimbursementRow = event.path[2]; // this is the <tr> element

    let reimbursement = {
        id:Number(reimbursementRow.cells[0].innerHTML),
        status: "Updated Status",
        user: {
            id: reimbursementRow.cells[2].attributes.id.value
        }
    }

    console.log(reimbursement);

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    }

    xhr.open('PUT', `${reimbursementUrl}/${reimbursement.id}`, true);

    xhr.send(JSON.stringify(reimbursement));
}