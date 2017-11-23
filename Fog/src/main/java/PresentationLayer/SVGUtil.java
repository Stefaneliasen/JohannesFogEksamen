package PresentationLayer;

public class SVGUtil {

    public static String svgRemme(int length, int width, int height) {
        return "<rect x=\"0\" y=\"30\" height=\"4.5\" width=\"" + length + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n"
                + "<rect x=\"0\" y=\"" + width + "\" height=\"4.5\" width=\"" + length + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\"/>";
    }

    public static String svgSpær(int length, int width, int height) {
        String res = "<rect x=\"" + (length - 1.5) + "\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"0.75\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        int amount = length / 55;
        int afstandSpær = length / (amount);
        System.out.println(afstandSpær);
        double xPos = afstandSpær;
        for (int i = 0; i <= amount - 2; i++) {
            res += "<rect x=\"" + xPos + "\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            xPos += afstandSpær;
        }
        return res;
    }

    public static String svgCarport(int length, int width, int height) {
        return svgRemme(length, width, height) + svgSpær(length, width, height);
    }
}
