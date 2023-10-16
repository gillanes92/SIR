// Datatables

$( document ).ready(function() {

	$('#example').DataTable({
		responsive: true,
		ordering: false,
        info: true,
        searching: true,
		language: {
			url: 'https://cdn.datatables.net/plug-ins/1.11.5/i18n/es-ES.json'
		},
		dom: '<"top"Bfl<"clear">>t<"bottom"ip<"clear">>', 
        buttons: [
            'csv', 'excel'
        ]
    });

});