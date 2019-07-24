
/**
 * Write a description of class GreyScaleFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreyScaleFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                Pixel temp = data[row][col];
                int avg = (temp.getRed()+temp.getBlue()+temp.getGreen())/3;
                
                data[row][col] = new Pixel(avg,avg,avg);        
            }
        }

        pi.setData(data);
    }
}
