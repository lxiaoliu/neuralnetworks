package com.github.neuralnetworks.neuronfunctions;

import com.github.neuralnetworks.architecture.Connections;
import com.github.neuralnetworks.architecture.Matrix;

public class AparapiWeightedSumByRows extends AparapiBaseFunction implements InputFunction {

    private static final long serialVersionUID = 8288998425211708411L;

    @Override
    public void run() {
	int id = getGlobalId();

	for (int i = 0; i < inputOutputColumns; i++) {
	    for (int j = 0; j < weightsColumns; j++) {
		output[outputIndex(id, i)] += input[inputIndex(j, i)] * weights[weightIndex(id, j)];
	    }

	    outputCalculated(id, i);
	}
    }

    /**
     * initialization before the actual calculation
     */
    @Override
    protected void init(Connections graph, Matrix inputMatrix, Matrix outputMatrix) {
	super.init(graph, inputMatrix, outputMatrix);

	if (inputMatrix.getColumns() != outputMatrix.getColumns() || outputMatrix.getRows() != graph.getConnectionGraph().getRows()) {
	    throw new IllegalArgumentException("matrices do not match");
	}
    }

    /**
     * @param outputIndex - index within the output array
     */
    protected void outputCalculated(int row, int column) {
    }
}