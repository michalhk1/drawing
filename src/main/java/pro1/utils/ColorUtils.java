package pro1.utils;

import java.util.Random;

public class ColorUtils {
    static Random random = new Random();

    public static String randomColor(){
        String r = String.format("%02X", random.nextInt(256));
        String g = String.format("%02X", random.nextInt(256));
        String b = String.format("%02X", random.nextInt(256));
        return "#"+r+g+b;
    }

    public static String color(int rNew, int gNew, int bNew){
        String r = String.format("%02X", rNew);
        String g = String.format("%02X", gNew);
        String b = String.format("%02X", bNew);
        return "#"+r+g+b;
    }
}
