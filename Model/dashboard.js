function displayForms(){
    document.getElementById('editForm').style.display = "block";
}

function submitMemberLocation(){
    //get member value
    var mySelectedMember = document.getElementById('whichMember');
    var indexOfMember = mySelectedMember.selectedIndex;
    var memberName = mySelectedMember.options[indexOfMember].text;

    //get room value
    var mySelectedRoom = document.getElementById('whichRoom');
    var indexOfRoom = mySelectedRoom.selectedIndex;
    var RoomName = mySelectedRoom.options[indexOfRoom].text;

    alert("You have put " + memberName + " into the " + RoomName + ".");

    //TODO decide where to store the member with the location
}

function submitObjectLocation(){
    //get x&y's values
    var xValue = document.getElementById('xaxis').value;
    var yValue = document.getElementById('yaxis').value;

    //validation
    if(xValue < 0 || yValue < 0){
        document.getElementById('xaxis').value = null;
        document.getElementById('yaxis').value = null;
        alert("invalid input, you need to enter to non-negative values.");
    }
    else{
        alert("You have put an object at the location (" + xValue + ", " + yValue + ").");
    }

    //TODO render the layout
    var temp_door = new door(10, 10, "green", xValue, yValue, "horizontal");
    temp_door.newPos();
    temp_door.update();

    //TODO add the object to the layout json file and render the layout again

}