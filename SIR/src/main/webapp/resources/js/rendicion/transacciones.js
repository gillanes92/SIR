
let files = [];
var date = "";
var idCon = "";

$(document).ready(function(){
	
	$("#descargar").on('click', function(e) {
		descargar();
	});
	
	$.blockUI.defaults = {
			fadeIn: 200,
	        fadeOut: 400,
	};
	
	$(".upload").on('change', function(e) {		
		files = e.target.files;						
	});
	
	$("#cargarArchivo").click(function () {
		
		idCon = document.getElementById("idConcen");
		
		var text = idCon.options[idCon.selectedIndex].text;
		
		date = $("#datepicker").val();
		
		if(date.length === 0){		
			
			document.getElementById("mensajeModal").textContent="Debe indicar la fecha de carga";
			document.getElementById("exampleModalLabel").textContent="Error";
			document.getElementById("cerrarModal").textContent="ACEPTAR";
			document.getElementById('modalPago').style.display = 'block';
			
			return;
		}
		
		if(files.length == 0){			
			document.getElementById("mensajeModal").textContent="Debe subir un archivo";
			document.getElementById("exampleModalLabel").textContent="Error";
			document.getElementById("cerrarModal").textContent="ACEPTAR";
			document.getElementById('modalPago').style.display = 'block';
			return;
		}
		
		document.getElementById("mensModalCon").textContent="Para proceder con la subida del archivo, \u00BFeste pertenece al comercio "+text+"?";
		document.getElementById('modalConcentrador').style.display = 'block';
		
		
	});
	
	
	$("#aceptarConc").click(function () {
		
		document.getElementById('modalConcentrador').style.display = 'none';
		
		var file = document.getElementById("inputfile").files[0];
		var formData = new FormData();
		formData.append("archivo",file);
		formData.append("metodo","pagoNuevo");
		formData.append("date",date);
		formData.append("idCon",idCon.value);
		
		$.ajax({ 
			type: 'POST',
			url: 'servicio_transacciones.htm',
			data: formData,
			async: false,
	        cache: false,
	        contentType: false,
	        enctype: 'multipart/form-data',
	        processData: false,
			success: function(resp){
				var res = jQuery.parseJSON(resp);
									
				$.unblockUI();
				
				$("#datepicker").val('');
				document.getElementById("inputfile").value='';
				
				document.getElementById("mensajeModal").textContent=res[0].mensaje;
								
				document.getElementById("exampleModalLabel").textContent="Informaci\u00F3n";
				
				document.getElementById("cerrarModal").textContent="OK";
				
				document.getElementById('modalPago').style.display = 'block';
			},	
			error: function(){
				console.log('error');
				$("#datepicker").val('');
				$.unblockUI();
			},
			complete : function(){
				console.log('complete');
				$("#datepicker").val('');
				$.unblockUI();
			}
		});
		
	});
	
	
	$("#cerrarConc").click(function () {
		document.getElementById('modalConcentrador').style.display = 'none';
	});
	
	$("#cerrarModal").click(function () {
		document.getElementById('modalPago').style.display = 'none';
		
		if(document.getElementById("cerrarModal").textContent === 'OK'){
			location.reload();
		}
	});
	
});

function ver(idPago){
	
	let formulario=document.createElement("form");
	formulario.setAttribute('method', "post");
	formulario.setAttribute('action', "detalleTransaccion.htm");
	
	let cajaTextNombres=document.createElement("input");
	cajaTextNombres.setAttribute('id', "idPago");
	cajaTextNombres.setAttribute('name', "idPago");
	cajaTextNombres.setAttribute('type', "text");
	cajaTextNombres.setAttribute('value', idPago);
	
	formulario.appendChild(cajaTextNombres);
	document.body.appendChild(formulario);
	formulario.submit();	
	
}

function eliminar(idRendicion){
	
	var form = {
			metodo: 'eliminarPago',
			idRend: idRendicion
	}
	
	$.ajax({ 
		type: 'POST',
		encoding:"UTF-8",
		url: 'servicio_transacciones.htm',
		data: form,
		success: function(resp){					
								
			$.unblockUI();
			
			document.getElementById('modalConciliacion').style.display = 'block';
		},	
		error: function(){
			console.log('error');
			$.unblockUI();
		},
		complete : function(){
			console.log('complete');
			$.unblockUI();
		}
	});
	
	
}


function descargar(){
		
	var miArrayDeObjetos = [
		{ IDENTIFICADOR: "", MONTO: "", FECHA_VENTA: "",TIPO_TARJETA: "", CODIGO_AUTORIZACION: "" }
	];
	arrayObjToCsv(miArrayDeObjetos);
	
}

function arrayObjToCsv(ar) {
	//comprobamos compatibilidad
	if(window.Blob && (window.URL || window.webkitURL)){
		var contenido = "",
			d = new Date(),
			blob,
			reader,
			save,
			clicEvent;
		//creamos contenido del archivo
		for (var i = 0; i < ar.length; i++) {
			//construimos cabecera del csv
			if (i == 0)
				contenido += Object.keys(ar[i]).join(";") + "\n";
			//resto del contenido
			contenido += Object.keys(ar[i]).map(function(key){
							return ar[i][key];
						}).join(";") + "\n";
		}
		//creamos el blob
		blob =  new Blob(["\ufeff", contenido], {type: 'text/csv'});
		//creamos el reader
		var reader = new FileReader();
		reader.onload = function (event) {
			//escuchamos su evento load y creamos un enlace en dom
			save = document.createElement('a');
			save.href = event.target.result;
			save.target = '_blank';
			//aquí le damos nombre al archivo
			save.download = "log_"+ d.getDate() + "_" + (d.getMonth()+1) + "_" + d.getFullYear() +".csv";
			try {
				//creamos un evento click
				clicEvent = new MouseEvent('click', {
					'view': window,
					'bubbles': true,
					'cancelable': true
				});
			} catch (e) {
				//si llega aquí es que probablemente implemente la forma antigua de crear un enlace
				clicEvent = document.createEvent("MouseEvent");
				clicEvent.initEvent('click', true, true);
			}
			//disparamos el evento
			save.dispatchEvent(clicEvent);
			//liberamos el objeto window.URL
			(window.URL || window.webkitURL).revokeObjectURL(save.href);
		}
		//leemos como url
		reader.readAsDataURL(blob);
	}else {
		//el navegador no admite esta opción
		alert("Su navegador no permite esta acción");
	}
};
