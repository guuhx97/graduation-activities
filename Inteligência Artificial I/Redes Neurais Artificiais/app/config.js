$(".acceptError").val(networkConfig.acceptError);
$(".maxIterations").val(networkConfig.maxIterations);
$(".rate").val(networkConfig.rate);

function refresh($sec, network) {
  $sec.find(".trainError").html(network.error);
  $sec.find(".time").html(network.time);
  $sec.find(".hiddenAmount").val(network.hiddenAmount);
  $sec.find(".iterations").html(network.iterations);
  $sec.find(".hits").html(network.hits+"("+((network.hits/network.testCases.length)*100)+"%)");
  $sec.find(".mistakes").html(network.mistakes+"("+((network.mistakes/network.testCases.length)*100)+"%)");

  var $table = $sec.find("table");
  $table.find("tbody").html("");
  network.results.forEach(function(result, index, array) {
    $table.find("tbody").append("<tr><td>"+ (index+1) +"</td><td>"+ result.inputs.join(", ") +"</td><td>"+ result.correctOutput+"("+result.outputs.join(", ")+")" +"</td><td>"+ result.activeOutput+"("+result.networkOutputs.join(", ")+")" +"</td><td>"+result.icon+"</td></tr>");
  });
}

var vertebralColumnConfig = {
    numberOfInputs: 6,
    numberOfOutputs: 3,
    hiddenAmount: 10,
    trainingCases: 120
};

var vertebralNetwork = new neuralNetwork(
    vertebralColumnConfig.numberOfInputs,
    vertebralColumnConfig.numberOfOutputs,
    vertebralColumnConfig.hiddenAmount,
    vertebralColumnConfig.trainingCases,
    inputColumn,
    outputColumn
);

vertebralNetwork.start();

var $vertebralSection = $(".vertebralColumn");
refresh($vertebralSection, vertebralNetwork);

$vertebralSection.find(".iterations").html(vertebralNetwork.iterations);

$vertebralSection.find(".recalcular").on("click", function() {
    var error = parseFloat($vertebralSection.find(".acceptError").val());
    var maxIterations = parseInt($vertebralSection.find(".maxIterations").val());
    var hiddenAmount = parseInt($vertebralSection.find(".hiddenAmount").val());
    var rate = parseFloat($vertebralSection.find(".rate").val());

    vertebralNetwork.recalculate(error, maxIterations, hiddenAmount, rate);
    refresh($vertebralSection, vertebralNetwork);
});
