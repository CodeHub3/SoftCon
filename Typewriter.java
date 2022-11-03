public class Typewriter{
    public static void main(String string){
        for(int i=0; i<string.length();i++){
            System.out.print(string.charAt(i));
            try{
                Thread.sleep(50);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }


}