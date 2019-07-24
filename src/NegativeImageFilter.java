
/**
 * Write a description of class NegativeImageFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NegativeImageFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                Pixel temp = data[row][col];
                data[row][col] = new Pixel(255-temp.getRed(), 255-temp.getBlue(), 
                    255-temp.getGreen());        
            }
        }

        pi.setData(data);
    }
}
