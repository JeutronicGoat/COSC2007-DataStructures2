
public class lab9 {

	public static void main(String[] args) {
		
		System.out.println("The Word ALPHABET has a hash key value of " + hashKey("ALPHABET", 101));
		System.out.println("The Word HornersRule has a hash key value of " + hashKey("HornersRule", 1019));
		System.out.println("The Word modularization has a hash key value of " + hashKey("modularization", 523));
		System.out.println("The Word ChickenSoup has a hash key value of " + hashKey("ChickenSoup", 191));
		
		System.out.println();
		
		System.out.println("The Phone Number 519-399-2939 has a hash key value of " + hashKeyNum(5193992939l, 1019));
		System.out.println("The Phone Number 705-255-9493 has a hash key value of " + hashKeyNum(7052559493l, 101));
		System.out.println("The Phone Number 901-492-2092 has a hash key value of " + hashKeyNum(9014922092l, 523));
		
		System.out.println();
		
		System.out.println("The Word APPLE has a hash key value of " + hashKey("APPLE", 101));
		System.out.println("The Word COMPUTER has a hash key value of " + hashKey("COMPUTER", 101));
		System.out.println("The Word ALPHABET has a hash key value of " + hashKey("ALPHABET", 101));
	}
	
	public static int hashKeyNum(long phoneNum, int tableSize){
		return (int) (phoneNum % tableSize);
	}
	
	public static int hashKey(String s, int tableSize){
		int key = 0;
		s = s.toUpperCase();
		for(int i = 0; i < s.length(); i++) {
			char letterVal = (char) (s.charAt(i) - 'A'); 
			key = key % tableSize;
			key = key * 32;
			key = key + letterVal;
		}
		return key % tableSize;
	}
}
