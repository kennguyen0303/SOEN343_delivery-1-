//Daniela functions
function addProfile(str) {
  var xhttp;
  alert(str);
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     alert("added successfully");
  };
  }
  var obj = { "role" : str};
  obj = JSON.stringify(obj);
  console.log(obj);
  xhttp.open("POST", "http://localhost:8080/api/user", true);
  xhttp.setRequestHeader("Content-type", "application/json");
  xhttp.send(obj);

}
//get the profile !
function getProfile() {
  var xhttp;
    window.alert("inside getProfile");
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("showProfile").innerHTML=this.responseText;
  };
  }
  xhttp.open("GET", "http://localhost:8080/api/user", true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send();

}


var loggedUserId;
var date = new Date();

function removeAllChildNodes(element) {
while(element.firstChild) {
element.removeChild(element.lastChild);
}
}

function getUserById(id) {
var xhttp;
var user;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    return user = JSON.parse(this.responseText);
}
};

xhttp.open("GET", "http://localhost:8080/api/user/userRetrieval/" + id, true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send();
}

function getUsers() {
var xhttp;
var userArray;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {

if (this.readyState == 4 && this.status == 200) {
userArray = JSON.parse(this.responseText);

var select = document.getElementById("currentUsersList")
removeAllChildNodes(select);

for( var i=0; i< userArray.length; i++) {
var option = document.createElement("option");
option.value = userArray[i].id;
option.innerHTML = userArray[i].role;

select.appendChild(option);
}

var item = document.getElementById("availableUsers");

removeAllChildNodes(item);
item.appendChild(select);
}
};

xhttp.open("GET", "http://localhost:8080/api/user/allUserRetrieval", true);
xhttp.send();
}

function onAddUserSubmit() {

var select = document.getElementById("roleSelect");
var role = select.options[select.selectedIndex].value;
addUser(role);
}

function addUser(str) {
var xhttp;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
getUsers();
}
};

var obj = { "role" : str};
obj = JSON.stringify(obj);
xhttp.open("POST", "http://localhost:8080/api/user/addUser", true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send(obj);
}

function onSubmitDeleteUser()
{
var select = document.getElementById("currentUsersList");
var userId = select.options[select.selectedIndex].value;

deleteUser(userId);
}

function deleteUser(id) {
var xhttp;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    getUsers();
}
};

xhttp.open("DELETE", "http://localhost:8080/api/user/userRemoval/" + id, true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send();
}

function onSubmitEditForm() {
var select = document.getElementById("currentUsersList");
var userId = select.options[select.selectedIndex].value;
var newRole = document.getElementById("newRole").value;
var currentRole = getUserById(userId);

editUser(newRole, userId);
}

function editUser(newRole, id) {
var xhttp;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    getUsers();
}
};

var obj = { "role" : newRole};
obj = JSON.stringify(obj);
xhttp.open("PUT", "http://localhost:8080/api/user/userUpdate/" + id, true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send(obj);
}

function onLoginSubmit()
{
var select = document.getElementById("currentUsersList");
var userId = select.options[select.selectedIndex].value;
var role = select.options[select.selectedIndex].innerHTML;

logIn(userId,role);
}

function logIn(id, role)
{
var xhttp;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    document.getElementById("userDisplay").innerHTML = role ;
}
};

xhttp.open("PUT", "http://localhost:8080/api/user/logIn/" + id, true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send();
}

//Nathan+Abdala function


function changeTabs(evt, SmartHomeTab) {
    // Declare all variables
    var i, tabcontent, tablinks;
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(SmartHomeTab).style.display = "block";
    evt.currentTarget.className += " active";
}

//Ken function for layout
var door_array=[];//the array for doors !
   function renderLayout()//a function for rendering the layout of the house
   {
        var xmlhttp = new XMLHttpRequest();//creating a request for AJAX to load the layout
            xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {//when the layout file is successfully loaded, executes the below codes
                myObj = JSON.parse(this.responseText);//parse the JSON data to an JAvascript object
                var canvas = document.getElementById("myCanvas");//define the area to draw
                var ctx = canvas.getContext("2d");//a syntax concept, check the w3school
                //drawing starts here
                for (var key1 of Object.keys(myObj)) {//loop over each room in the JSON file, syntax here: loop over an object
                    for (var key2 of Object.keys(myObj[key1])) {//loop over each element of a room
                        //print room_name p/s: hardcode name position need to fix later
                        if(key2=="name"){//if the element is "name", need to print out
                            ctx.font = "15px Arial";//set the font
                            ctx.fillText(myObj[key1][key2][0],myObj[key1][key2][1],myObj[key1][key2][2]);//format: [0]=room name, [1]: width, [2]: height
                        }
                        //print the door
                        if(key1=="door"){
                            //each [key2] is an object of a door
                            var temp_door = new door(myObj[key1][key2][0], myObj[key1][key2][1], myObj[key1][key2][2], myObj[key1][key2][3], myObj[key1][key2][4],myObj[key1][key2][5]);
                            door_array.push(temp_door);
                            continue;
                        }
                        //draw the wall for a room
                        for(var i=0;i<myObj[key1][key2].length;i=i+4){
                            ctx.moveTo(myObj[key1][key2][i],myObj[key1][key2][i+1]);
                            ctx.lineTo(myObj[key1][key2][i+2],myObj[key1][key2][i+3]);
                            ctx.stroke();
                        }
                    };//finish rendering a room
                };
                startGame();//start the movement, challenge: Need to click to render door
            }
        };
        xmlhttp.open("GET", "layout.json", true);
        xmlhttp.send();
            
   }
   //try the game code from w3school with some modification, check w3school for more detials
  
   var option;
function startGame() {
    myGameArea.start();
}


//a constructor
function door(width, height, color, x, y,move_mode) {
    this.gamearea = document.getElementById("myCanvas");
    this.move_mode=move_mode;
    this.width = width;
    this.height = height;
    this.speedX = 0;
    this.speedY = 0;    
    this.x = x;
    this.y = y;
    if(this.move_mode=="horizontal"){//make a boundary for movement
        this.boundary=[this.x,(this.x+this.width)];//inital point + width
    }
    if(this.move_mode=="vertical"){//make a boundary for movement
        this.boundary=[this.y,(this.y+this.height)]
    }        
    this.update = function() {
        ctx = this.gamearea.getContext("2d")
        ctx.fillStyle = color;
        ctx.fillRect(this.x, this.y, this.width, this.height);
    }
    this.newPos = function() {
        this.x += this.speedX;
        this.y += this.speedY;        
    }
}

function updateGameArea() {
    myGameArea.clear(); 
    door_array.forEach(a_door => {
        a_door.speedX=0;
        a_door.speedY=0;
    });
    var option = document.getElementById("control_option").value - 1;//minus 1 since array start from 0
    if (myGameArea.key && myGameArea.key == 37) {//move left
        if(door_array[option].move_mode=="horizontal")
            if(door_array[option].x>door_array[option].boundary[0]) door_array[option].speedX = -1;
         }
    if (myGameArea.key && myGameArea.key == 38) {//move up
        if(door_array[option].move_mode=="vertical") 
        if(door_array[option].y>door_array[option].boundary[0]) door_array[option].speedY = -1;
        }  
    if (myGameArea.key && myGameArea.key == 39) {//move right
        if(door_array[option].move_mode=="horizontal") 
        if(door_array[option].x<door_array[option].boundary[1]) door_array[option].speedX = 1;
    }
    if (myGameArea.key && myGameArea.key == 40) {//move down
        if(door_array[option].move_mode=="vertical") 
        if(door_array[option].y<door_array[option].boundary[1]) door_array[option].speedY = 1;
    
    }
        
    //key in control is the update function
    //update the now position for every door, otherwise it will not be shown
    door_array.forEach(a_door => {
        a_door.newPos();    
        a_door.update();
    });
}

//alex functions
function showContext() {
    document.getElementById('SHSystem').style.display = 'none';
}

//************Function for Alex part prepared by Ken  */

function openForm() {
    document.getElementById("myForm").style.display = "block";
  }
  
  function closeForm() {
    document.getElementById("myForm").style.display = "none";
  }

  function onCoordinatesSubmit() {
    var x = document.getElementById('xAxis').value;
    var y = document.getElementById('yAxis').value;

    //validation
    if (x < 0 || y < 0) {
        alert("input error");
    }
    else {
        var temp_door = new door(10, 10, "green", x, y, "horizontal");
        temp_door.update();
    }

}

