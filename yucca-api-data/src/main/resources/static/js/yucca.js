$(document).ready( function () {
    $('#datatable').DataTable({  // Reinitialize data table
    	"pageLength": 10,
    	"order": [ 0, 'desc' ],
        "responsive" : true,
    	"language": {
    		"sProcessing":     "Traitement en cours...",
    	    "sSearch":         "Rechercher :",
    	    "sLengthMenu":     "Afficher _MENU_ éléments",
    	    "sInfo":           "Affichage de l'élément _START_ à _END_ sur _TOTAL_ éléments",
    	    "sInfoEmpty":      "Affichage de l'élément 0 à 0 sur 0 élément",
    	    "sInfoFiltered":   "(filtré de _MAX_ éléments au total)",
    	    "sInfoPostFix":    "",
    	    "sLoadingRecords": "Chargement en cours...",
    	    "sZeroRecords":    "Aucun élément à afficher",
    	    "sEmptyTable":     "Aucune donnée disponible dans le tableau",
    	    "oPaginate": {
    	        "sFirst":      "Premier",
    	        "sPrevious":   "Précédent",
    	        "sNext":       "Suivant",
    	        "sLast":       "Dernier"
    	    },
    	    "oAria": {
    	        "sSortAscending":  ": activer pour trier la colonne par ordre croissant",
    	        "sSortDescending": ": activer pour trier la colonne par ordre décroissant"
    	    },
    	    "select": {
    	            "rows": {
    	                _: "%d lignes séléctionnées",
    	                0: "Aucune ligne séléctionnée",
    	                1: "1 ligne séléctionnée"
    	            } 
    	    }
        }        
    });
});