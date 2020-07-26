const Layer = synaptic.Layer;
const Network = synaptic.Network;
const Trainer = synaptic.Trainer;

var networkConfig = {
  rate: .001,
  maxIterations: 3000,
  acceptError: .001
};

function networkUnit(inputs, outputs) {
  this.input = inputs;
  this.output = outputs;
}

function resultTest(inputs, outputs, correctOutput, networkOutputs, activeOutput) {
  this.inputs = inputs;
  this.outputs = outputs;
  this.correctOutput = correctOutput;
  this.networkOutputs = networkOutputs;
  this.activeOutput = activeOutput;
  this.icon = this.correctOutput===this.activeOutput ? `<span class="icon has-text-success"> <i class="fas fa-check"></i> </span>` : `<span class="icon has-text-danger"> <i class="fas fa-times"></i> </span>`;
}

function indexToResult(i) {
  switch(i) {
    case 0:
      return "Hernia de disco";
      break;
    case 1:
      return "Espondilolistese";
      break;
    case 2:
      return "Normal";
      break;
    default:
      return "";
  }
}

function neuralNetwork(numberOfEntries, numberOfOutputs, hiddenAmount, numberOfTraningCases, inputs, outputs) {
  this.hiddenAmount = hiddenAmount;
  this.numberOfTraningCases = numberOfTraningCases;
  this.error = 0;
  this.iterations = 0;
  this.time = 0;
  this.hits = 0;
  this.mistakes = 0;
  this.results = [];
  this.trainingCases = [];
  this.testCases = [];
  this.rate = networkConfig.rate;
  this.maxIterations = networkConfig.maxIterations;
  this.acceptError = networkConfig.acceptError;

  var _self = this;

  var createSynapticNetwork = function() {
    var inputLayer = new Layer(numberOfEntries);
    var outputLayer = new Layer(numberOfOutputs);
    var hiddenLayer = new Layer(_self.hiddenAmount);

    inputLayer.project(hiddenLayer);
    hiddenLayer.project(outputLayer);

    return new Network({
      input: inputLayer,
      hidden: [hiddenLayer],
      output: outputLayer
    });
  };

  var trainNetwork = function() {
    var col = 0;
    var line = 0;
    var length = 0;
    var linesAmount = outputs.length;
    var columnAmount = inputs.length;

    while (length < _self.numberOfTraningCases) {
      if (outputs[line][col] === 1 && !outputs[line][numberOfOutputs]) {
        var output = outputs[line].slice(0,-1);
        _self.trainingCases.push(new networkUnit(inputs[line], output));
        length++;
        //visitada
        outputs[line][numberOfOutputs] = true;

        if (line < linesAmount-1) {
          line++;
        } else {
          line = 0
        }

        if (col < columnAmount-1) {
          col++;
        } else{
          col = 0;
        }
      } else {
        if (line < linesAmount-1) {
          line++;
        } else {
          line = 0;
          if (col < columnAmount-1) {
            col++;
          } else{
            col = 0;
          }
        }
      }
    }
  }

  var testNetwork = function() {
    var length = outputs.length;
    for (var line = 0; line < length; line++) {
      if (!outputs[line][numberOfOutputs]) {
        var output = outputs[line].slice(0,-1);
        _self.testCases.push(new networkUnit(inputs[line], output));
      }
    }
  }

  this.start = function() {
    var synapticNetwork = createSynapticNetwork();
    trainNetwork();
    testNetwork();

    const trainer = new Trainer(synapticNetwork);
    var train = trainer.train(_self.trainingCases, {
      rate: this.rate,
      iterations: this.maxIterations,
      error: this.acceptError,
      shuffle: true,
      log: 1,
      cost: Trainer.cost.CROSS_ENTROPY
    });

    this.error = train.error;
    this.iterations = train.iterations;
    this.time = train.time;

    var length = this.testCases.length;
    for (var i = 0; i < length; i++) {
      var test = this.testCases[i];
      var activeOutput = synapticNetwork.activate(test.input).map(function(e) {
        e = e.toFixed(5);
        return e;
      });
      var resultOutput = activeOutput.reduce((iMax, x, i, arr) => x > arr[iMax] ? i : iMax, 0);
      var testOutput = test.output.reduce((iMax, x, i, arr) => x > arr[iMax] ? i : iMax, 0);
      resultOutput===testOutput ? this.hits++ : this.mistakes++;
      this.results.push(new resultTest(test.input, test.output, indexToResult(testOutput), activeOutput, indexToResult(resultOutput)));
    }
  }

  this.recalculate = function(acceptError, maxIterations, hiddenAmount, rate) {
    this.acceptError = acceptError;
    this.maxIterations = maxIterations;
    this.hiddenAmount = hiddenAmount;
    this.rate = rate;
    this.trainingCases = [];
    this.testCases = [];
    this.error = 0;
    this.iterations = 0;
    this.time = 0;
    this.hits = 0;
    this.mistakes = 0;
    this.results = [];
    var length = outputs.length;
    for (var i = 0; i < length; i++) {
      outputs[i][numberOfOutputs] = false;
    }
    this.start();
  }
}
