
let files = [];
var date = "";
var idCon = "";

$(document).ready(function(){
	
	$.blockUI.defaults = {
			fadeIn: 200,
	        fadeOut: 400,
	};
	
	$(".upload").on('change', function(e) {					
		files = e.target.files;		
	});
	
	$("#cargarArchivo").click(function () {
				
		if(files.length == 0){			
			document.getElementById("mensajeModal").textContent="Debe subir un archivo";
			document.getElementById("exampleModalLabel").textContent="Error";
			document.getElementById("cerrarModal").textContent="ACEPTAR";
			document.getElementById('modalConciliacion').style.display = 'block';
			return;
		}
		
		document.getElementById("mensModalConf").textContent="Se proceder\u00e1 con la subida del archivo, \u00BFest\u00e1 de acuerdo?";
		document.getElementById('modalConfirmArchivo').style.display = 'block';
				
	
	});
	
	
	$("#aceptarConc").click(function () {
		
		document.getElementById('modalConcentrador').style.display = 'none';
		
		var file = document.getElementById("inputfile").files[0];
		date = $("#datepicker").val();
		var formData = new FormData();
		formData.append("archivo",file);
		formData.append("metodo","pagosMasivos");
		formData.append("date",date);
		
		$.ajax({ 
			type: 'POST',
			url: 'servicio_pagos_masivos.htm',
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
				
				document.getElementById('modalConciliacion').style.display = 'block';
				
				
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
		document.getElementById('modalConciliacion').style.display = 'none';
		
		if(document.getElementById("cerrarModal").textContent === 'OK'){
			location.reload();
		}
	});	
});


function ver(idRendicion){
	
	let formulario=document.createElement("form");
	formulario.setAttribute('method', "post");
	formulario.setAttribute('action', "detalleRendicion.htm");
	
	let cajaTextNombres=document.createElement("input");
	cajaTextNombres.setAttribute('id', "idRendicion");
	cajaTextNombres.setAttribute('name', "idRendicion");
	cajaTextNombres.setAttribute('type', "text");
	cajaTextNombres.setAttribute('value', idRendicion);
	
	formulario.appendChild(cajaTextNombres);
	document.body.appendChild(formulario);
	formulario.submit();	
	
}

function eliminar(idRendicion){
	
	var form = {
			metodo: 'eliminarRendicion',
			idRend: idRendicion
	}
	
	$.ajax({ 
		type: 'POST',
		encoding:"UTF-8",
		url: 'servicio_pagos_masivos.htm',
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
