/**
 * Write a description of class GuassianBlurFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuassianBlurFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] blurred = pi.getData();

        for (int row = 1; row < pi.getHeight()-1; row++) {
            for (int col = 1; col < pi.getWidth()-1; col++) {
                blurred[row][col] = guassAvg(data, row, col);
            }
        }
        pi.setData(blurred);
    }

    private Pixel guassAvg(Pixel[][] data, int row, int col) {
        int[][] guassMask = {{1, 2, 1},
                             {2, 4, 2},
                             {1, 2, 1}};

        return applyMask(data, guassMask, 16, row, col);
    }

    private Pixel applyMask(Pixel[][] data, int[][] mask, int divFactor, int row, int col) {
        int redAvg = (data[row-1][col-1].getRed() * mask[0][0] +
                data[row-1][col].getRed() * mask[0][1] +
                data[row-1][col+1].getRed() * mask[0][2] +
                data[row][col-1].getRed() * mask[1][0] +
                data[row][col].getRed() * mask[1][1] +
                data[row][col+1].getRed() * mask[1][2] +
                data[row+1][col-1].getRed() * mask[2][0] +
                data[row+1][col].getRed() * mask[2][1] +
                data[row+1][col+1].getRed() * mask[2][2]) / divFactor;

        int greenAvg = (data[row-1][col-1].getGreen() * mask[0][0] +
                data[row-1][col].getGreen() * mask[0][1] +
                data[row-1][col+1].getGreen() * mask[0][2] +
                data[row][col-1].getGreen() * mask[1][0] +
                data[row][col].getGreen() * mask[1][1] +
                data[row][col+1].getGreen() * mask[1][2] +
                data[row+1][col-1].getGreen() * mask[2][0] +
                data[row+1][col].getGreen() * mask[2][1] +
                data[row+1][col+1].getGreen() * mask[2][2]) / divFactor;

        int blueAvg = (data[row-1][col-1].getBlue() * mask[0][0] +
                data[row-1][col].getBlue() * mask[0][1] +
                data[row-1][col+1].getBlue() * mask[0][2] +
                data[row][col-1].getBlue() * mask[1][0] +
                data[row][col].getBlue() * mask[1][1] +
                data[row][col+1].getBlue() * mask[1][2] +
                data[row+1][col-1].getBlue() * mask[2][0] +
                data[row+1][col].getBlue() * mask[2][1] +
                data[row+1][col+1].getBlue() * mask[2][2]) / divFactor;

        return new Pixel(redAvg, greenAvg, blueAvg);
    }
}

