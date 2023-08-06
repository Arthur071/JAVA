//Enums in java 
class Enum{
	public enum Season{SUMMER, WINTER, SPRING}

	public static void main(String agrs[]){
		Season s[]= Season.values();
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}

        Season k = Season.WINTER;
        switch(k){
            case SUMMER: 
                System.out.println("It is Summer, ");
            case WINTER:
                System.out.println("It is winter, ");
            case SPRING:
                System.out.println("it is spring, ");
        }
	}
}