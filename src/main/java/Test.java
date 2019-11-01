
import javafx.scene.layout.BackgroundImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;


/**
 * Created by mortli on 11/15/16.
 */
public class Test {


    static String b_a = new String("112312312");
    static int a_a = 0 ;


    public static void main(String[] args) throws Exception{


        System.out.println(b_a.getBytes());

        //QrCodeUtils.main();


        String url = "https://m.51ping.com/synthesis/qrcode?uuid=c03c6bb2c7731e07ids8guba";
        int width = 600;
        int height = 600;
        String s = "日式美甲甲山公园店中（中山公园店）";
//        BufferedImage tmpImg = createQrImgBuffer(url, width, height);
//        InputStream imageStream = Test.class.getResourceAsStream("/shopAvatar.png");
//        BufferedImage img = drawLogoAndStringToImg(tmpImg, width, height, s, "Serif", 30, 2, 1.02 , imageStream);
//        File file2 = new File("./");
//        ImageIO.write(img, "jpg", new File("./qrCode.jpg"));


//        for (int i = 0; i < 100000; i++) {
//            try {
//                Integer.parseInt(" ");
//            }catch (Exception e){
//                e.printStackTrace();
//
//            }
//        }



//
//        TestA testA = new TestA(a_a);
//        TestB testB = new TestB(b_a);
//        testB.changeB();
//        testA.changeB();
//        System.out.println("a_a is " + a_a );
//        System.out.println("b_a is " + b_a );
//
//
//        String b = new String("12");
//        Object a = null;
//
//        BigDecimal c = new BigDecimal(3);
//
//        BigDecimal d = new BigDecimal(2);
//
//        if(d.intValue() == 0){
//
//        }
//
//        if(a!=null && a.equals("1") ){     //&&  机制 从前往后执行 只要有一个出现错误就不执行后面的
//
//            System.out.println("asasa");
//
//
//
//        }
//
//        System.out.println("a ".trim()+1);





    }
}
