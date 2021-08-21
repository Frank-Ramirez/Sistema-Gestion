// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registrarUsuarios(){
let datos = {};
datos.nombre = document.getElementById('txtnombre').value;
datos.apellido = document.getElementById('txtapellido').value;
datos.email = document.getElementById('txtemail').value;

datos.password = document.getElementById('txtPassword').value;

let RepPass = document.getElementById('txtRPassword').value;
console.log(RepPass);
console.log(datos.password);
if(RepPass != datos.password){
alert('La contraseña que escribiste es diferente');
return;
}

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json' },
      body: JSON.stringify(datos)
  });
  alert("La cuenta se creo con exito");
  window.location.hreg = "login.html";
}
