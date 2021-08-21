// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarUsuarios();
  $('#TableUsuarios').DataTable();
  actEmail();
});


async function cargarUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeader();
  });

  const us = await request.json();

  let listadoHTML = '';

  for (let usu of us){
        let btnEliminar = '<a href="#" onclick="eliminarusr('+usu.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let telefono = usu.telefono == null ? '-' : usu.telefono;
        let usuariosHTML = '<tr><td>'+usu.id+'</td><td>'+usu.nombre+' '+usu.apellido+'</td><td>'+usu.email+'</td><td>'
                        +telefono+'</td><td>'+btnEliminar+'</td></tr>';
        listadoHTML += usuariosHTML;
    }
    console.log(us);
document.querySelector('#TableUsuarios tbody').outerHTML = listadoHTML;
}
function getHeader(){
return {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
             'Authorization': localStorage.token
           };
}

async function eliminarusr(id){
if(!confirm("Desea eliminar este usuario?")){
return;}
const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: getHeader();
  });
  location.reload();
}
function actEmail(){
document.getElementById('txtemail-usr').outerHTML = localStorage.email;
}