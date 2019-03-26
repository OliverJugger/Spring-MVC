$(document).ready( function () {
    $('#datatable').DataTable({  // Reinitialize data table
    	"processing": true,
    	"pageLength": 10,
    	"order": [ 0, 'desc' ],
        "responsive" : true,
        "columnDefs": [ {
	            "targets": 'no-sort',
	            "orderable": false,
	            "searchable": false
	      } ],
    	"language": {
    		"url": window.location.origin + "/json/fr_FR.json"
        }        
    });
});