

$(document).ready(function() {
alert("success.................")
 $('#example').show();
    $('#example').DataTable( {
        dom: 'Bfrtip',
        scrollX: true,
         scrollY: '200px',
        scrollCollapse: true,
        pageLength: 4,
        pagingType: 'full_numbers',
        buttons: [
            'copy',
            'csv',
            'excel',
            'pdf',
            {
                extend: 'print',
                text: 'Print all (not just selected)',
                exportOptions: {
                    modifier: {
                        selected: null
                    }
                }
            }
        ],
        select: true
    } );
} );

