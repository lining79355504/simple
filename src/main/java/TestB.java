/**
 * Created by mort on 04/05/2017.
 */
public class TestB {

    private String b ;

    TestB(String a){
        this.b=a;
    }

    public void changeB(){

        this.b = "change 了" ;
        System.out.println("change 了");
    }
}
