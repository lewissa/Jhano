/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function redirectControladorProductoCliente()
{
    var strparametro = document.getElementsByName("txtBusquedaCliente")[0].value;
    
    location.href='../controladoresJhano/controladorInterfazIngresoFactura.jsp?accion=BuscarCliente&parametroCliente='+strparametro;
    
}

function finalFoco(campo){
	var explor = navigator.appName;         //Identificar el explorador
    //alert("Explorador: " + explor);

    if (explor == "Microsoft Internet Explorer")   //Codigo para MS Internet Explorer
    {
        var range = campo.createTextRange();
        range.collapse(false);
        range.select();
    }
    else if (explor == "Netscape")      //Codigo para Netscape: Chrome, Mozilla
    {
        with (campo) {
            selectionStart = selectionEnd = value.length;
            focus();
        }
    }
    else        //Si no es ninguno de los anteriores, uso el de IE
    {
        var range = campo.createTextRange();
        range.collapse(false);
        range.select();
    }
   }


function redirectControladorProductoProducto()
{

    var strparametro = document.getElementsByName("txtBusquedaProducto")[0].value;
    var strIdCliente = document.getElementById('cirucC').value;
    var strNombre = document.getElementById('nombreC').value;
    var strTelefono = document.getElementById('telefonoC').value;
    var strFecha = document.getElementById('fechaC').value;
    var strDireccion = document.getElementById('direccionC').value;
    var strIdFactura = document.getElementById('idFactura').value;
    location.href='../controladoresJhano/controladorInterfazIngresoFactura.jsp?accion=BuscarProducto&parametroProducto='
            +strparametro+'&cirucC='+strIdCliente+'&nombreC='+strNombre+'&direccionC='+strDireccion
            +'&telefonoC='+strTelefono+'&fechaC='+strFecha+'&idFactura='+strIdFactura;
    
}


function rellenarCiente(strid,strnombre,strdireccion,strtelefono)
{
        document.getElementById('nombreC').value=strnombre;
        document.getElementById('cirucC').value=strid;
        document.getElementById('direccionC').value=strdireccion;
        document.getElementById('telefonoC').value=strtelefono;
        

}

function cargaCliente()
{
    var id = document.getElementById('selectCliente')
}


function rellenarProducto(des,id,can,val)
{
    document.getElementById('descripcionP').value=des;
    document.getElementById('codigoEanP').value=id;
    document.getElementById('vUnitarioP').value=val;
    document.getElementById('cantidadP').value=can;
}



function sumar(par)
{
    alert(par+10);
    return true;
}

function agregarProducto()
{
    var des = document.getElementById('descripcionP').value
    var cod = document.getElementById('codigoEanP').value
    var vUn = document.getElementById('vUnitarioP').value
    var can = document.getElementById('cantidadP').value
    var tot = document.getElementById('totalF').value
    var strparametro = document.getElementsByName("txtBusquedaProducto")[0].value;
    var strIdCliente = document.getElementById('cirucC').value;
    var strNombre = document.getElementById('nombreC').value;
    var strTelefono = document.getElementById('telefonoC').value;
    var strFecha = document.getElementById('fechaC').value;
    var strDireccion = document.getElementById('direccionC').value;
    var strIdFactura = document.getElementById('idFactura').value; 
    location.href='../controladoresJhano/controladorInterfazIngresoFactura.jsp?accion=Agregar&descripcion='
            +des+'&codigoean='+cod+'&vunitario='+vUn+'&cantidad='+can+'&totalF='+tot+'&parametroProducto='
            +strparametro+'&cirucC='+strIdCliente+'&nombreC='+strNombre+'&direccionC='+strDireccion
            +'&telefonoC='+strTelefono+'&fechaC='+strFecha+'&idFactura='+strIdFactura;;
}


function sumarUnitarioTotal()
{
    vUnitario = document.getElementById('cantidadP').value;
    vUnitario= Number(vUnitario);
    
    vTotal = document.getElementById('vUnitarioP').value;
    vTotal = Number(vTotal);
    
    subTotal = document.getElementById('subtotal').value;
    subTotal = Number(subTotal);
    
    total = document.getElementById('totalF').value;
    total=Number(total);
    
    document.getElementById('vTotal').value=vUnitario*vTotal;
    document.getElementById('subtotal').value= subTotal+(vUnitario*vTotal);
    document.getElementById('iva').value=((vUnitario*vTotal)*0.12);
    document.getElementById('totalF').value=total + ((vUnitario*vTotal) + ((vUnitario*vTotal)*0.12));
    
    
    
}


function validarFactura()
{
    
}
