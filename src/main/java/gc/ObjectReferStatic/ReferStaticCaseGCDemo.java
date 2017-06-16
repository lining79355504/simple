package gc.ObjectReferStatic;

/**
 * Created by mort on 16/06/2017.
 */
public class ReferStaticCaseGCDemo {

    public void referStaticCaseGCDemoFunction() {

        //这是一次彻底失败的实验
        for (int i = 0; i < 2000000; i++) {
            StaticCaseGCDemo staticCaseGCDemo = new StaticCaseGCDemo();
            staticCaseGCDemo.initList();
            System.out.println(" "+ i +" :  ["+ staticCaseGCDemo + "]");
        }


        

    }


}
