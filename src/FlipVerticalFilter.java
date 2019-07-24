
public class FlipVerticalFilter implements Filter
{
 /**
 * Filter that flips the image vertically.
 */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < pi.getHeight() / 2; row++) {
            
                Pixel[] temp = data[row];
                data[row] = data[pi.getHeight()-row-1];
                data[pi.getHeight()-row-1] = temp;
            
        }

        pi.setData(data);
    }
}