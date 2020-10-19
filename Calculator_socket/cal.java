class cal{
public double calculate(){ //calculate the postfix equation.
		double op1, op2;
		for (int i = 0; i < cnt; i++)
		{
			if (operator[i].equals("+")) { //operate previous two integer, when "+" appear.
				op1 = st2.peek();
				st2.pop();
				op2 = st2.peek();
				st2.pop();
				double temp = op1 + op2;
				st2.push(temp);
			}
			else if (operator[i].equals("-")) { //operate previous two integer, when "-" appear.
				op1 = st2.peek();
				st2.pop();
				op2 = st2.peek();
				st2.pop();
				double temp = op2 - op1;
				st2.push(temp);
			}
			else if (operator[i].equals("*")) {//operate previous two integer, when "*" appear.
				op1 = st2.peek();
				st2.pop();
				op2 = st2.peek();
				st2.pop();
				double temp = op1 * op2;
				st2.push(temp);
			}
			else if (operator[i].equals("/")) {//operate previous two integer, when "/" appear.
				op1 = st2.peek();
				st2.pop();
				op2 = st2.peek();
				st2.pop();
				if(op1==0){ //check exception when operand divided by 0.
					return 0;
				}
				else{
					double temp = op2 / op1;
					st2.push(temp);
					//a =1;
				}
			}
			else{
				st2.push(Double.parseDouble(operator[i])); //translate String to integer and complete the equation.
			}
		}
		return st2.pop();

}