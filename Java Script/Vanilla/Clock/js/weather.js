function onGeoOk(position) {
    const lat = position.coords.latitude;
    const long =position.coords.longitude;
    
    console.log("You live in",lat,long);
}
function onGeoError(){
    alert("Can't find you. No weather for you.");
}


navigator.geolocation.getCurrentPosition(onGeoOk,onGeoError) 
//argument가 2개 필요 1개는 잘 됐을떄, 하나는 에러가 났을 때 