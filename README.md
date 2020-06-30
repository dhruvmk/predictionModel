# predictionModel
This mini-project focuses on finding a line/curve of best fit for a given dataset using a brute-force method
Instance Variables: x - our x-axis, y - our y-axis, quad - coefficient of x^2 term, slope - coefficient of x term, intercept - y-intercept
Constructor: Initializes values
fitToData[parameterized]: Main algorithm, seeks to minimize loss using brute force approach. Starting and ending values of a, b and c must be passed into method, 
along with appropriate increment values for each variable.
fitToData(): Similar to its parameterized counterpart, but this one uses default starting and ending values for a, b, c and default increment values
getCost(): Uses the sum of differences between predicted and actual value for each set of variables (a, b, c) to find accuracy
predict(): Should only be called after fitToData(). Uses values of quad, slope and intercept to output a value from an input 'i' in the form quad*i*i+slope*i+intercept
