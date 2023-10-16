$(document).ready(function () {
	
	$.blockUI.defaults = {
			fadeIn: 200,
	        fadeOut: 400,
	};
	
	
	$("#registrar").click(function () {
		
		$.blockUI({message: $('.body-block-example-1')});
		var inputEmail = $("#email").val();
		var inputName = $("#name").val();
		var inputPassword = $("#password").val();
		var inputRepPassword = $("#passwordrep").val();
				
		if(inputEmail == ""  || inputName == "" || inputPassword == "" || inputRepPassword == "" ){
			document.getElementById('msgError').innerHTML= "Debe ingresar todos los campos";
		}else{
			
			inputPassword = sha512(inputPassword);
			inputRepPassword = sha512(inputRepPassword);
			
			if(inputPassword == inputRepPassword){
				
				var form = {
						metodo: 'registrarUsuario',
						email: inputEmail,
						name: inputName,
						password: inputPassword
				}
				
				$.ajax({ 
					type: 'POST',
					encoding:"UTF-8",
					url: 'servicio_login.htm',
					data: form,
					success: function (data) {
						
						var resp = jQuery.parseJSON(data)
						console.log(resp);
						
						if(resp[0].ncod_salida_out === "000"){
												
							document.getElementById("mensajeModal").textContent="Ya esta registrado en nuestro sistema, favor inicie sesi\u00F3n en Login!";
							document.getElementById("exampleModalLabel").textContent="Registrado";
							document.getElementById("mensajebtnok").textContent="Ir a Login";
							document.getElementById('mensajebtnok').style.display = 'block';
							document.getElementById('mensajebtner').style.display = 'none';
							
							
							
						}else{
							
							document.getElementById("mensajeModal").textContent="No se pudo realizar el registro, favor intente mas tarde!!";
							document.getElementById("exampleModalLabel").textContent="Error";
							document.getElementById("mensajebtner").textContent="Intentar Nuevamente";
							document.getElementById('mensajebtner').style.display = 'block';
							document.getElementById('mensajebtnok').style.display = 'none';
						}
						
						$.unblockUI();
						document.getElementById('modalRegister').style.display = 'block';
						
					},
					error: function(){
						$.unblockUI();
						console.log("error");
					},
					complete : function(){
						$.unblockUI();
						console.log("complete");
					}
				});
					
			}else{
					//document.getElementById('loadingloading').style.display = 'none';
				document.getElementById('msgPassTemporal').innerHTML = "Las contrase\u00F1as no coinciden";
					
			}
		}
	});
	
	$("#mensajebtner").click(function () {
		document.getElementById('modalRegister').style.display = 'none';
	});
	
	$("#cerrarModal").click(function () {
		document.getElementById('modalRegister').style.display = 'none';
	});
	
	
	
	$('.block-page-btn-example-1').click(function () {
        $.blockUI({message: $('.body-block-example-1')});
    });
	
	
});