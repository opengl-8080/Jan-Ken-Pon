$(function() {
    $('button').on('click', function() {
        var number = $(this).data('number');

        $.ajax({
            type: 'GET',
            url: '/janken',
            dataType: 'json',
            data: {handNumber: number}
        })
        .done(function(response) {
            $('#userMessage').text(response.userMessage);
            $('#computerMessage').text(response.computerMessage);
            $('#resultMessage').text(response.resultMessage);
        });
    });
});
