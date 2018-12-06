$(document).ready(function() {
    // New Row
    $("#newTr").click(function(event) {
        var table = $("#table tbody");
        var rows = table.find('tr');
        var height = rows.length;
        var width = $("#table tbody tr:first td").length;

        var newRow = $("<tr><td>" + height + "</td></tr>");
        newRow.append('<td><input type="text" class="form-control altName" placeholder="Название"></td>');

        newRow.append('<td><input type="text" class="form-control score" placeholder="Оценка"></td>'.repeat(width - 2));
        table.append(newRow);
    });

    // New Column
    $("#newTd").click(function(event) {
        var table = $("#table");
        var alternativeInput = $('<td><input type="text" class="form-control score" placeholder="Оценка"></td>');
        var conditionInput = $('<td><input type="text" class="form-control condName" placeholder="Условие"></td>')

        table.find('tr').first().append(conditionInput);
        table.find('tr').first().nextAll().append(alternativeInput);
    });

    // Submit data
    $("#submit").click(function(event) {
        // 1: Get Data
        var inputData = {
            alternatives: [],
            conditions: [],
            criteriaType: 0
        };

        inputData.criteriaType = $("#algo").val();

        var table = $("#table");
        table.find('tr').first().find('td input.condName').each(function(index) {
            inputData.conditions.push($(this).val());
        });

        table.find('tr:nth-child(n+2)').each(function(index) {
            var alternative = {
                name: null,
                scores: [],
                serialNumber: null
            }

            alternative.name = $(this).find('td input.altName').val();
            alternative.serialNumber = $(this).find('td:first').text();
            $(this).find('td input.score').each(function(index) {
                alternative.scores.push($(this).val());
            });
            inputData.alternatives.push(alternative);
        });

        // 2: Send Data
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/rank",
            data: JSON.stringify(inputData),
            success: function(data) {
                populateTable(data);
            },
            dataType: "json",
            contentType: "application/json"
        });
    });
});

function populateTable(data) {
    $('#out tr').remove();
    $('hr').show();
    var table = $('#out tbody');


    table.append('<tr><td>№</td><td>Название Альтернативы</td></tr>');
    var firstRow = table.find('tr:first');
    data.conditions.forEach(function(item) {
        firstRow.append('<td>' + item + '</td>');
    });
    firstRow.append('<td>Критерий</td>');
    firstRow.append('<td>Ранг</td>');

    data.rankedAlternatives.forEach(function(alt) {
        var row = table.append("<tr>").children("tr:last-child");
        row.append('<td>' + alt.alternative.serialNumber + '</td>');
        row.append('<td>' + alt.alternative.name + '</td>');
        alt.alternative.scores.forEach(function(item) {
            row.append('<td>' + item + '</td>');
        })
        row.append('<td>' + alt.criteriaCounted + '</td>');
        row.append('<td>' + alt.rank + '</td>');
    });
}