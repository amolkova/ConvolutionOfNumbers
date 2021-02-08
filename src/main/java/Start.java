
public class Start {

	public static void main(String[] args) {
		convolutionOfNumbers("1,2,4,5,6,7,18,19,20,21,30,33");
		
	}
	
	public static void convolutionOfNumbers(String line){
		String result = "";
		String[] array = line.split(",");
		Integer[] numbers = new Integer[array.length];
		int i = 0;
		for (String oneValue : array) {
			numbers[i++] = Integer.parseInt(oneValue);
		}
		for (int j = 0; j < numbers.length; j++ ) {
			
			if(j + 1 == numbers.length ){
				result += "," +  numbers[j];
				break;
			}else if(j + 2 == numbers.length ){
				result += "," +  numbers[j] + "," + numbers[j+1];
				break;
			}else if(numbers[j] + 1 == numbers[j+1] && numbers[j+1] + 1 == numbers[j+2]){
				int lastPosition = getLastPosition(numbers, j);
				
				result += "," + numbers[j] + "-" + numbers[lastPosition];
				j = lastPosition;
			}else {
				result += "," + numbers[j];
			}
			
		}		
		
		if(result.startsWith(",")){
			result = result.replaceFirst(",", "");
		}
		
		System.out.println(result);
	}

	private static Integer getLastPosition(Integer[] numbers, int pointOfStart) {
		
		
		for (int i = pointOfStart; i < numbers.length; i++) {
			if(i + 1 == numbers.length){
				return i;
			}
			
			if(!(numbers[i] + 1 == numbers[i+1])){
				return i;
			}
						
		}
		
		return null;
		
	}
}
